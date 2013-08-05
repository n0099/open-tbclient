package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants;
/* loaded from: classes.dex */
public final class MMApplicationContext {
    private static Context R = null;
    private static String aE = MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN;

    private MMApplicationContext() {
    }

    public static Context getContext() {
        return R;
    }

    public static String getDefaultPreferencePath() {
        return aE + "_preferences";
    }

    public static String getPackageName() {
        return aE;
    }

    public static void setContext(Context context) {
        R = context;
        aE = context.getPackageName();
        Log.d("MicroMsg.MMApplicationContext", "setup application context for package: " + aE);
    }
}
