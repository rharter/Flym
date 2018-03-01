package net.frju.flym

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import net.frju.flym.data.AppDatabase
import net.frju.flym.data.utils.PrefUtils


class App : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        @JvmStatic
        lateinit var context: Context
            private set

        @JvmStatic
        lateinit var db: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()

        context = applicationContext
        db = AppDatabase.createDatabase(context)

        PrefUtils.putBoolean(PrefUtils.IS_REFRESHING, false) // init
    }
}
