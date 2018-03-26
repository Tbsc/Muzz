package tbsc.muzz

import android.app.Application

/**
 * @author tbsc on 26/03/2018
 */
class MuzzApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {

        private var instance: MuzzApplication? = null

        fun get(): MuzzApplication {
            return instance!!
        }
    }

}
