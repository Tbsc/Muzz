package tbsc.muzz;

import android.app.Application;

/**
 * @author tbsc on 26/03/2018
 */
public class MuzzApplication extends Application {

    private static MuzzApplication instance;

    public static MuzzApplication get() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}
