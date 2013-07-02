package org.acra;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
/* loaded from: classes.dex */
public class a {
    public static final String a = a.class.getSimpleName();
    public static org.acra.b.a b = new org.acra.b.b();
    public static final ReportField[] c = {ReportField.USER_COMMENT, ReportField.ANDROID_VERSION, ReportField.APP_VERSION_NAME, ReportField.BRAND, ReportField.PHONE_MODEL, ReportField.CUSTOM_DATA, ReportField.STACK_TRACE};
    public static final ReportField[] d = {ReportField.REPORT_ID, ReportField.APP_VERSION_CODE, ReportField.APP_VERSION_NAME, ReportField.PACKAGE_NAME, ReportField.FILE_PATH, ReportField.PHONE_MODEL, ReportField.BRAND, ReportField.PRODUCT, ReportField.ANDROID_VERSION, ReportField.BUILD, ReportField.TOTAL_MEM_SIZE, ReportField.AVAILABLE_MEM_SIZE, ReportField.CUSTOM_DATA, ReportField.IS_SILENT, ReportField.STACK_TRACE, ReportField.INITIAL_CONFIGURATION, ReportField.CRASH_CONFIGURATION, ReportField.DISPLAY, ReportField.USER_COMMENT, ReportField.USER_EMAIL, ReportField.USER_APP_START_DATE, ReportField.USER_CRASH_DATE, ReportField.DUMPSYS_MEMINFO, ReportField.LOGCAT, ReportField.INSTALLATION_ID, ReportField.DEVICE_FEATURES, ReportField.ENVIRONMENT, ReportField.SHARED_PREFERENCES, ReportField.SETTINGS_SYSTEM, ReportField.SETTINGS_SECURE};
    private static Application e;
    private static org.acra.a.a f;
    private static m g;
    private static SharedPreferences.OnSharedPreferenceChangeListener h;
    private static d i;

    public static void a(Application application) {
        if (e != null) {
            throw new IllegalStateException("ACRA#init called more than once");
        }
        e = application;
        f = (org.acra.a.a) e.getClass().getAnnotation(org.acra.a.a.class);
        if (f == null) {
            b.c(a, "ACRA#init called but no ReportsCrashes annotation on Application " + e.getPackageName());
            return;
        }
        SharedPreferences c2 = c();
        try {
            b();
            b.a(a, "ACRA is enabled for " + e.getPackageName() + ", intializing...");
            m mVar = new m(e.getApplicationContext(), c2, !b(c2));
            mVar.d();
            g = mVar;
        } catch (ACRAConfigurationException e2) {
            b.a(a, "Error : ", e2);
        }
        h = new b();
        c2.registerOnSharedPreferenceChangeListener(h);
    }

    public static m a() {
        if (g == null) {
            throw new IllegalStateException("Cannot access ErrorReporter before ACRA#init");
        }
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(SharedPreferences sharedPreferences) {
        try {
            return sharedPreferences.getBoolean("acra.disable", sharedPreferences.getBoolean("acra.enable", true) ? false : true);
        } catch (Exception e2) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        d d2 = d();
        switch (c.a[d2.q().ordinal()]) {
            case 1:
                if (d2.B() == 0) {
                    throw new ACRAConfigurationException("TOAST mode: you have to define the resToastText parameter in your application @ReportsCrashes() annotation.");
                }
                return;
            case 2:
                if (d2.z() == 0 || d2.A() == 0 || d2.y() == 0 || d2.v() == 0) {
                    throw new ACRAConfigurationException("NOTIFICATION mode: you have to define at least the resNotifTickerText, resNotifTitle, resNotifText, resDialogText parameters in your application @ReportsCrashes() annotation.");
                }
                return;
            case 3:
                if (d2.v() == 0) {
                    throw new ACRAConfigurationException("DIALOG mode: you have to define at least the resDialogText parameters in your application @ReportsCrashes() annotation.");
                }
                return;
            default:
                return;
        }
    }

    public static SharedPreferences c() {
        d d2 = d();
        return !"".equals(d2.D()) ? e.getSharedPreferences(d2.D(), d2.C()) : PreferenceManager.getDefaultSharedPreferences(e);
    }

    public static d d() {
        if (i == null) {
            if (e == null) {
                b.b(a, "Calling ACRA.getConfig() before ACRA.init() gives you an empty configuration instance. You might prefer calling ACRA.getNewDefaultConfig(Application) to get an instance with default values taken from a @ReportsCrashes annotation.");
            }
            i = b(e);
        }
        return i;
    }

    public static void a(d dVar) {
        i = dVar;
    }

    public static d b(Application application) {
        return application != null ? new d((org.acra.a.a) application.getClass().getAnnotation(org.acra.a.a.class)) : new d(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e() {
        try {
            return (e.getPackageManager().getApplicationInfo(e.getPackageName(), 0).flags & 2) > 0;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Application f() {
        return e;
    }
}
