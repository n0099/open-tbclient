package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;
/* loaded from: classes8.dex */
public final class av {
    public static boolean Ar() {
        return w.i("ksadsdk_pref", "config_data_transfer", false);
    }

    public static void As() {
        w.h("ksadsdk_pref", "config_data_transfer", true);
    }

    public static void At() {
        w.h("ksadsdk_pref", "splash_daily_transfer", true);
    }

    public static boolean Au() {
        return w.i("ksadsdk_pref", "splash_daily_transfer", false);
    }

    public static void Av() {
        w.h("ksadsdk_pref", "reward_auto_transfer", true);
    }

    public static boolean Aw() {
        return w.i("ksadsdk_pref", "reward_auto_transfer", false);
    }

    public static void Ax() {
        w.h("ksadsdk_pref", "interstitial_aggregate_transfer", true);
    }

    public static boolean Ay() {
        return w.i("ksadsdk_pref", "interstitial_aggregate_transfer", false);
    }

    @Nullable
    @WorkerThread
    public static String ac(Context context, String str) {
        File file = new File(context.getFilesDir(), str);
        if (file.exists()) {
            try {
                String F = com.kwad.sdk.crash.utils.g.F(file);
                return TextUtils.isEmpty(F) ? "" : F;
            } catch (Throwable unused) {
                return "";
            }
        }
        return "";
    }

    public static void h(final Context context, final String str, final String str2) {
        com.kwad.sdk.core.threads.b.vq().execute(new Runnable() { // from class: com.kwad.sdk.utils.av.1
            @Override // java.lang.Runnable
            public final void run() {
                av.i(context, str, str2);
            }
        });
    }

    public static void i(Context context, String str, String str2) {
        com.kwad.sdk.crash.utils.g.g(new File(context.getFilesDir(), str).getAbsolutePath(), str2, false);
        As();
    }
}
