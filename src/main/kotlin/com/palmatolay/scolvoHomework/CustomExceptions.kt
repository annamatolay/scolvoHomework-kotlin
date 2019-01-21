package com.palmatolay.scolvoHomework

import java.lang.Exception

/**
 * Custom implementation of the Exception class.
 * @param key is mandatory when a new instance created
 * @param message isn't mandatory
 */
class InvalidArgument(key: String, message: String = "$key is an empty string!"): Exception(message)

/**
 * Custom implementation of the Exception class.
 * @param key is mandatory when a new instance created
 * @param message isn't mandatory
 */
class MissingArgument(key: String, message: String = "Missing $key from the address!"): Exception(message)