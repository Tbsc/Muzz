package tbsc.muzz.util

import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.support.annotation.StringRes

import tbsc.muzz.MuzzApplication
import tbsc.muzz.R

/**
 * Utility class for accessing shared preferences.
 * @author tbsc on 26/03/2018
 */
object Prefs {

    /* START Internal */

    private var prefs: SharedPreferences? = null

    /**
     * Assumes that it's called after the [MuzzApplication] was already constructed.
     * @return Default [SharedPreferences] from [PreferenceManager], using [MuzzApplication.get]
     */
    private fun init(): SharedPreferences {
        if (prefs == null) {
            prefs = PreferenceManager.getDefaultSharedPreferences(ctx())
        }
        return prefs!!
    }

    private fun ctx(): MuzzApplication {
        return MuzzApplication.get()
    }

    /**
     * Utility method for getting string resources in a short and concise way.
     * @param res Resource ID for the string
     * @return String of the resource
     */
    private fun str(@StringRes res: Int): String {
        return ctx().getString(res)
    }

    /**
     * Utility method for getting string resources as an int.
     * Doesn't perform any checks to see if the string is even a valid int, because if that error
     * ever happens then it's a programming error and should be fixed, not silently ignored.
     * @param res Resource ID of the string
     * @return the string of the resource [Integer.valueOf]-d
     */
    private fun asInt(@StringRes res: Int): Int {
        return Integer.valueOf(str(res))!!
    }

    /* END Internal */

    /* START Preferences */

    /**
     * Property for the library page order preference.
     * Setting this property will [SharedPreferences.Editor.apply] to preferences file.
     */
    var libraryPageOrder: String
        get() = init().getString(libraryPageOrderKey, libraryPageOrderDefault)
        set(value) = init().edit().putString(libraryPageOrderKey, value).apply()

    /**
     * Key of the library page order preference
     */
    val libraryPageOrderKey: String
        get() = str(R.string.prefkey_library_page_order_string)

    /**
     * Default value of the library page order preference
     */
    val libraryPageOrderDefault: String
        get() = str(R.string.prefdef_library_page_order_string)

    /* END Preferences */

}

