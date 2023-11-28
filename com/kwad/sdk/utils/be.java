package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;
/* loaded from: classes10.dex */
public final class be {
    public static boolean Lg() {
        return y.m("ksadsdk_pref", "config_data_transfer", false);
    }

    public static void Lh() {
        y.l("ksadsdk_pref", "config_data_transfer", true);
    }

    public static void Li() {
        y.l("ksadsdk_pref", "splash_daily_transfer", true);
    }

    public static boolean Lj() {
        return y.m("ksadsdk_pref", "splash_daily_transfer", false);
    }

    public static void Lk() {
        y.l("ksadsdk_pref", "reward_auto_transfer", true);
    }

    public static boolean Ll() {
        return y.m("ksadsdk_pref", "reward_auto_transfer", false);
    }

    public static void Lm() {
        y.l("ksadsdk_pref", "interstitial_aggregate_transfer", true);
    }

    public static boolean Ln() {
        return y.m("ksadsdk_pref", "interstitial_aggregate_transfer", false);
    }

    @Nullable
    @WorkerThread
    public static String au(Context context, String str) {
        if (context == null) {
            return "";
        }
        File file = new File(context.getFilesDir(), str);
        if (!file.exists()) {
            return "";
        }
        try {
            String I = com.kwad.sdk.crash.utils.h.I(file);
            if (TextUtils.isEmpty(I)) {
                return "";
            }
            return I;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void i(final Context context, final String str, final String str2) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.be.1
            @Override // java.lang.Runnable
            public final void run() {
                be.j(context, str, str2);
            }
        });
    }

    public static void j(Context context, String str, String str2) {
        com.kwad.sdk.crash.utils.h.k(new File(context.getFilesDir(), str).getAbsolutePath(), str2, false);
        Lh();
    }
}
