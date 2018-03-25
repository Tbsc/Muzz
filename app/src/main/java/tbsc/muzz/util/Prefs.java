package tbsc.muzz.util;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.StringRes;

import tbsc.muzz.MuzzApplication;
import tbsc.muzz.R;

/**
 * Utility class for accessing shared preferences.
 *
 * Small note, I am suppressing the lint that warns about editing a preference without saving,
 * because it is done through {@link #savePrefs(SharedPreferences.Editor, boolean)} but lint
 * doesn't recognize that.
 *
 * @author tbsc on 26/03/2018
 */
@SuppressLint("CommitPrefEdits")
public class Prefs {

    /* START Internal */

    private static SharedPreferences prefs;

    /**
     * Assumes that it's called after the {@link MuzzApplication} was already constructed.
     * @return Default {@link SharedPreferences} from {@link PreferenceManager}, using {@link MuzzApplication#get()}
     */
    private static SharedPreferences init() {
        if (prefs == null) {
            prefs = PreferenceManager.getDefaultSharedPreferences(ctx());
        }
        return prefs;
    }

    private static MuzzApplication ctx() {
        return MuzzApplication.get();
    }

    /**
     * Preference setters allow saving to disk immediately, or when asynchronously.
     * This is a way for the specific methods to do that more concisely.
     * @param editor The editor instance returned by {@link #prefs} after putting the value.
     * @param now Whether to save immediately (true, commit()) or later (false, apply())
     */
    private static void savePrefs(SharedPreferences.Editor editor, boolean now) {
        if (now) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    /**
     * Utility method for getting string resources in a short and concise way.
     * @param res Resource ID for the string
     * @return String of the resource
     */
    private static String str(@StringRes int res) {
        return ctx().getString(res);
    }

    /**
     * Utility method for getting string resources as an int.
     * Doesn't perform any checks to see if the string is even a valid int, because if that error
     * ever happens then it's a programming error and should be fixed, not silently ignored.
     * @param res Resource ID of the string
     * @return the string of the resource {@link Integer#valueOf}-d
     */
    private static int asInt(@StringRes int res) {
        return Integer.valueOf(str(res));
    }

    /* END Internal */

    /* START Preferences */

    /**
     * Gets the order of the pages in the library activity.
     * @return Order of pages in library
     */
    public static String getLibraryPageOrder() {
        return init().getString(getLibraryPageOrderKey(), getLibraryPageOrderDefault());
    }

    /**
     * Key of the library page order preference
     * @return Preference string key
     */
    public static String getLibraryPageOrderKey() {
        return str(R.string.prefkey_library_page_order_string);
    }

    /**
     * Default value of the library page order preference
     * @return Default string value
     */
    public static String getLibraryPageOrderDefault() {
        return str(R.string.prefkey_library_page_order_string);
    }

    /**
     * Sets the value of the library page order preference.
     * @param order The string that will be written to preferences.
     * @param now Whether to save asynchronously or not (immediately)
     */
    public static void setLibraryPageOrder(String order, boolean now) {
        savePrefs(init().edit().putString(getLibraryPageOrderKey(), order), now);
    }

    /* END Preferences */

}
