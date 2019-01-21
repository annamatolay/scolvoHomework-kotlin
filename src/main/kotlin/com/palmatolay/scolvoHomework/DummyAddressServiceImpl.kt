package com.palmatolay.scolvoHomework

/**
 * Represent dummy implementation of AddressService.
 */
class DummyAddressServiceImpl : AddressService{
    override fun getStingAddressData(adr: Address): String {
        /*
        If there's no value of address key in the HashMap of data attribute,
        then write empty string after city. Otherwise write value with coma separated.
         */
        return if (validateAddressData(adr))
            "${adr.data["PostalCode"]} ${adr.data["City"]}" +
                    (if (adr.data["Address"] == null) "" else ", ${adr.data["Address"]}")
        else ""
    }

    override fun validateAddressData(adr: Address): Boolean {
        val pCodeKey = "PostalCode"
        val pCode = adr.data[pCodeKey]
        val cityKey = "City"
        val city = adr.data[cityKey]
        when {
            // if any mandatory keys missing, throw an error correspondingly to the key
            pCode == null -> throw MissingArgument(pCodeKey)
            pCode.isEmpty() -> throw InvalidArgument(pCodeKey)
            city == null -> throw MissingArgument(cityKey)
            city.isEmpty() -> throw InvalidArgument(cityKey)
            else -> {
                // if it can convert to int, return true, otherwise false
                try {
                    pCode.toInt()
                } catch (e: NumberFormatException) {
                    return false
                }
                // More validation can be placed here.
                // E.g.: check the address is exist in the real world, inside Hungary, Budapest, etc...
                // (Validations can happen with database or API resource.)
                return true
            }
        }
    }
}