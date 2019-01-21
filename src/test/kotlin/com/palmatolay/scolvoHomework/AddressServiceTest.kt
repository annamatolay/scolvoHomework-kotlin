package com.palmatolay.scolvoHomework

import org.junit.Assert.*
import org.junit.Test

class AddressServiceTest {
    private val addressService: AddressService = DummyAddressServiceImpl()
    private var address = Address(
        hashMapOf("addressIds" to arrayOf(100, 200)),
        hashMapOf(
            "PostalCode" to "1000",
            "City" to "Bp",
            "Address" to "Géza utca 5"))

    @Test
    fun getStringAddress_whenDataIsRight() {
        assertEquals(addressService.getStingAddressData(address), "1000 Bp, Géza utca 5")
    }

    @Test
    fun getStringAddress_whenAddressMissing() {
        address.data = hashMapOf(
            "PostalCode" to "1000",
            "City" to "Bp")
        assertEquals(addressService.getStingAddressData(address), "1000 Bp")
    }

    @Test
    fun getStringAddress_whenPostalCodeIsInvalid() {
        address.data["PostalCode"] = "asd"
        assertEquals(addressService.getStingAddressData(address), "")
    }

    @Test
    fun validateAddress_whenDataIsRight() {
        assertTrue(addressService.validateAddressData(address))
    }

    @Test(expected = MissingArgument::class)
    fun validateAddress_whenPostalCodeNotExist(){
        triggerValidateError("PostalCode", false)
    }

    @Test(expected = InvalidArgument::class)
    fun validateAddress_whenPostalCodeEmpty() {
        triggerValidateError("PostalCode")
    }

    @Test
    fun validateAddress_whenPostalCodeInvalid() {
        address.data["PostalCode"] = "asd"
        assertFalse(addressService.validateAddressData(address))
    }

    @Test(expected = MissingArgument::class)
    fun validateAddress_whenCityNotExist(){
        triggerValidateError("City", false)
    }

    @Test(expected = InvalidArgument::class)
    fun validateAddress_whenCityEmpty() {
        triggerValidateError("City")
    }

    /**
     * Responsible for manipulate address object and assert exception message (then re-throw it).
     * @param dataKey should be the key in Address data HashMap what would be tested
     * @param dataKeyShouldBeInAddress is a Boolean true by default,
     * if true it will change the value of dataKey for an empty string.
     * Otherwise modify Address data attribute that dataKey won't be present in the HashMap.
     */
    private fun triggerValidateError(dataKey: String, dataKeyShouldBeInAddress: Boolean = true) {
        prepareData(dataKey, dataKeyShouldBeInAddress)
        simulateError(dataKey)
    }

    private fun prepareData(dataKey: String, dataKeyShouldBeInAddress: Boolean = true) {
        if (dataKeyShouldBeInAddress) address.data[dataKey] = ""
        else {
            if (dataKey == "PostalCode") address.data = hashMapOf("City" to "Bp")
            if (dataKey == "City") address.data = hashMapOf("PostalCode" to "1000")
        }
    }

    private fun simulateError(dataKey: String) {
        try {
            addressService.validateAddressData(address)
        } catch (e : Exception) {
            when(e) {
                // assert based on the type of exception
                is InvalidArgument -> assertEquals("$dataKey is an empty string!", e.message)
                is MissingArgument -> assertEquals("Missing $dataKey from the address!", e.message)
            }
            // exception message checked first, therefore it's need to re-throw for fulfill the test case expectation
            // (without any data change!)
            addressService.validateAddressData(address)
        }
    }
}