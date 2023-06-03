package org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Process;
import android.preference.PreferenceManager;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;
@JNINamespace("base::android")
/* loaded from: classes2.dex */
public class ContextUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TAG = "ContextUtils";
    public static Context sApplicationContext;

    /* loaded from: classes2.dex */
    public static class Holder {
        public static SharedPreferences sSharedPreferences = ContextUtils.access$000();
    }

    public static /* synthetic */ SharedPreferences access$000() {
        return fetchAppSharedPreferences();
    }

    public static SharedPreferences fetchAppSharedPreferences() {
        StrictModeContext allowDiskWrites = StrictModeContext.allowDiskWrites();
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(sApplicationContext);
            if (allowDiskWrites != null) {
                allowDiskWrites.close();
            }
            return defaultSharedPreferences;
        } catch (Throwable th) {
            if (allowDiskWrites != null) {
                try {
                    allowDiskWrites.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static SharedPreferences getAppSharedPreferences() {
        return Holder.sSharedPreferences;
    }

    public static AssetManager getApplicationAssets() {
        Context applicationContext = getApplicationContext();
        while (applicationContext instanceof ContextWrapper) {
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        return applicationContext.getAssets();
    }

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static String getProcessName() {
        return ApiCompatibilityUtils.getProcessName();
    }

    public static boolean isIsolatedProcess() {
        return Process.isIsolated();
    }

    @Nullable
    public static Activity activityFromContext(@Nullable Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    @MainDex
    public static void initApplicationContext(Context context) {
        initJavaSideApplicationContext(context);
    }

    @VisibleForTesting
    public static void initApplicationContextForTests(Context context) {
        initJavaSideApplicationContext(context);
        SharedPreferences unused = Holder.sSharedPreferences = fetchAppSharedPreferences();
    }

    public static void initJavaSideApplicationContext(Context context) {
        if (BuildConfig.DCHECK_IS_ON && (context instanceof Application)) {
            context = new ContextWrapper(context);
        }
        sApplicationContext = context;
    }
}
