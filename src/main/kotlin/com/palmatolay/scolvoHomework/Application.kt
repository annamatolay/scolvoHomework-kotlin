package com.palmatolay.scolvoHomework

/**
 * Responsible for validate and retrieve Address model.
 */
interface AddressService {

    /**
     * Retrieve Address object data attribute as string.
     * Or return empty string if data is invalid.
     */
    fun getStingAddressData(adr: Address): String

    /**
     * Validate the data attribute content of an Address object
     *  @param adr: Address object
     *  @return Boolean true if valid, otherwise false
     */
    fun validateAddressData(adr: Address): Boolean
}

/**
 * Represent Address model based on the exercise description.
 * @param data is valid if contains values with PostalCode (what can be converted to Int)
 * and City keys. Neither them aren't be empty (or null).
 * (An instance of this class is a POJO, because of the 'data' keyword in class header)
 */
data class Address(var client: HashMap<String, Array<Int>>, var data: HashMap<String, String>)
