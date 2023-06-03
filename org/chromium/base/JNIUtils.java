package org.chromium.base;

import android.content.Context;
import android.text.TextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.MainDex;
@MainDex
/* loaded from: classes2.dex */
public class JNIUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static ClassLoader sJniClassLoader;
    public static Boolean sSelectiveJniRegistrationEnabled;

    public static void enableSelectiveJniRegistration() {
        sSelectiveJniRegistrationEnabled = Boolean.TRUE;
    }

    public static ClassLoader getClassLoader() {
        ClassLoader classLoader = sJniClassLoader;
        if (classLoader == null) {
            return JNIUtils.class.getClassLoader();
        }
        return classLoader;
    }

    @CalledByNative
    public static boolean isSelectiveJniRegistrationEnabled() {
        if (sSelectiveJniRegistrationEnabled == null) {
            sSelectiveJniRegistrationEnabled = Boolean.FALSE;
        }
        return sSelectiveJniRegistrationEnabled.booleanValue();
    }

    @CalledByNative
    public static ClassLoader getSplitClassLoader(String str) {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (!TextUtils.isEmpty(str) && BundleUtils.isIsolatedSplitInstalled(applicationContext, str)) {
            return BundleUtils.createIsolatedSplitContext(applicationContext, str).getClassLoader();
        }
        return getClassLoader();
    }

    public static void setClassLoader(ClassLoader classLoader) {
        sJniClassLoader = classLoader;
    }
}
