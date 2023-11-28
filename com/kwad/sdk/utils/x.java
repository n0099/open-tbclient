package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.h;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class x {
    public static volatile boolean aND;
    public static AtomicInteger aNC = new AtomicInteger(0);
    public static volatile boolean aLH = false;

    public static int JQ() {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.e.c.w("Ks_UnionHelper", "sdkConfigProvider == null");
            return 0;
        }
        int yx = hVar.yx();
        com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "config mode:" + yx);
        return yx;
    }

    public static void JR() {
        if (aLH) {
            return;
        }
        aNC.set(JU());
        aND = bf.m("kssdk_kv_mode", "downgrade", false);
        aLH = true;
    }

    public static void JS() {
        if (JV() || JQ() == 0) {
            return;
        }
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.x.3
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.utils.b.a JT = x.JT();
                if (JT == null) {
                    return;
                }
                x.c(JT);
                com.kwad.sdk.utils.b.b bVar = (com.kwad.sdk.utils.b.b) ServiceProvider.get(com.kwad.sdk.utils.b.b.class);
                if (bVar != null) {
                    bVar.a(JT);
                }
            }
        });
    }

    public static int JU() {
        int b = bf.b("kssdk_kv_mode", "mode", 0);
        com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "local mode:" + b);
        return b;
    }

    public static boolean JV() {
        JR();
        if (aNC.get() == 0) {
            return true;
        }
        return false;
    }

    public static boolean JW() {
        if (Build.VERSION.SDK_INT > 23) {
            return true;
        }
        return false;
    }

    public static int JX() {
        int i;
        JR();
        if (!aND && JW()) {
            i = JQ();
        } else {
            i = 0;
        }
        com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "targetMode:" + i);
        return i;
    }

    public static void JY() {
        boolean z;
        JR();
        int i = aNC.get();
        int JX = JX();
        if (i != JX) {
            z = true;
        } else {
            z = false;
        }
        com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "needTransfer:" + z);
        if (z) {
            transfer(JX);
        }
    }

    public static void JZ() {
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.x.4
            @Override // java.lang.Runnable
            public final void run() {
                Context context;
                try {
                    context = y.getContext();
                } catch (Exception e) {
                    com.kwad.sdk.core.e.c.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
                if (context == null) {
                    return;
                }
                for (String str : h.a.akp) {
                    x.Q(context, str);
                }
                x.dB(0);
                x.aNC.set(0);
            }
        });
    }

    public static void Ka() {
        com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "transferToKv");
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.x.5
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Context context = y.getContext();
                    if (context != null) {
                        for (String str : h.a.akp) {
                            x.P(context, str);
                        }
                        x.dB(1);
                        x.aNC.set(1);
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.e.c.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
            }
        });
    }

    @WorkerThread
    public static com.kwad.sdk.utils.b.a JT() {
        Map<String, ?> all;
        com.kwad.sdk.utils.b.a aVar = new com.kwad.sdk.utils.b.a();
        SharedPreferences gg = bf.gg("ksadsdk_kv_perf");
        if (gg == null) {
            return null;
        }
        try {
            all = gg.getAll();
        } catch (Throwable unused) {
        }
        if (all == null) {
            return null;
        }
        int i = 0;
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            i += ((Integer) entry.getValue()).intValue();
        }
        aVar.aQF = i;
        SharedPreferences.Editor edit = gg.edit();
        for (Map.Entry<String, ?> entry2 : all.entrySet()) {
            edit.putInt(entry2.getKey(), 0);
        }
        edit.apply();
        d(aVar);
        e(aVar);
        return aVar;
    }

    public static void P(Context context, String str) {
        SharedPreferences gg;
        com.kwad.sdk.utils.a.c av = com.kwad.sdk.utils.a.e.av(context, str);
        if ("ksadsdk_splash_preload_id_list".equals(str) && (gg = bf.gg(str)) == null) {
            SharedPreferences.Editor edit = gg.edit();
            if (edit != null) {
                edit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
            }
        } else if (!av.contains("sp_to_kv_transfer_flag")) {
            SharedPreferences gg2 = bf.gg(str);
            if (gg2 == null) {
                av.putBoolean("sp_to_kv_transfer_flag", true);
                return;
            }
            av.putAll(gg2.getAll());
            av.putBoolean("sp_to_kv_transfer_flag", true);
            bf.as(str, "kv_to_sp_transfer_flag");
            a(str, av);
        }
    }

    public static void Q(Context context, String str) {
        SharedPreferences gg = bf.gg(str);
        if (gg == null) {
            return;
        }
        if ("ksadsdk_splash_preload_id_list".equals(str)) {
            SharedPreferences.Editor edit = gg.edit();
            if (edit != null) {
                edit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
            }
        } else if (!gg.contains("kv_to_sp_transfer_flag")) {
            com.kwad.sdk.utils.a.c av = com.kwad.sdk.utils.a.e.av(context, str);
            Map<String, Object> all = av.getAll();
            if (all.isEmpty()) {
                bf.l(str, "kv_to_sp_transfer_flag", true);
                return;
            }
            bf.a(str, all);
            bf.l(str, "kv_to_sp_transfer_flag", true);
            av.remove("sp_to_kv_transfer_flag");
            av.release();
        }
    }

    public static void a(String str, com.kwad.sdk.utils.a.c cVar) {
        if (!h.a.akq.contains(str)) {
            cVar.release();
        }
    }

    @WorkerThread
    public static void aq(final String str, final String str2) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.x.1
            @Override // java.lang.Runnable
            public final void run() {
                int b = bf.b("ksadsdk_kv_perf", str, 0);
                if (TextUtils.isEmpty(str2)) {
                    bf.as("ksadsdk_kv_perf", str);
                    return;
                }
                bf.a("ksadsdk_kv_perf", str, b + 1);
            }
        });
    }

    public static void ar(final String str, final String str2) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.utils.x.2
            @Override // java.lang.Runnable
            public final void run() {
                SharedPreferences gg = bf.gg("ksadsdk_kv_perf");
                if (gg != null && gg.contains(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        bf.a("ksadsdk_kv_perf_failed", str, bf.b("ksadsdk_kv_perf_failed", str, 0) + 1);
                        return;
                    }
                    bf.a("ksadsdk_kv_perf_success", str, bf.b("ksadsdk_kv_perf_success", str, 0) + 1);
                }
            }
        });
    }

    public static void c(@NonNull com.kwad.sdk.utils.b.a aVar) {
        int i = aVar.aQG;
        if (i / (i + aVar.aQH) > 0.10000000149011612d) {
            aND = true;
            com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "need downgrade");
            bf.l("kssdk_kv_mode", "downgrade", true);
        }
        if (aND) {
            JY();
        }
    }

    public static void dB(int i) {
        bf.a("kssdk_kv_mode", "mode", i);
    }

    public static void transfer(int i) {
        if (i == 0) {
            JZ();
        } else if (i == 1) {
            Ka();
        }
    }

    public static void d(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences gg = bf.gg("ksadsdk_kv_perf_failed");
        int i = 0;
        if (gg != null) {
            Map<String, ?> all = gg.getAll();
            if (all != null) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    i += ((Integer) entry.getValue()).intValue();
                }
            }
            aVar.aQG = i;
            SharedPreferences.Editor edit = gg.edit();
            edit.clear();
            edit.apply();
            return;
        }
        aVar.aQG = 0;
    }

    public static void e(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences gg = bf.gg("ksadsdk_kv_perf_success");
        int i = 0;
        if (gg != null) {
            Map<String, ?> all = gg.getAll();
            if (all != null) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    i += ((Integer) entry.getValue()).intValue();
                }
            }
            aVar.aQH = i;
            SharedPreferences.Editor edit = gg.edit();
            edit.clear();
            edit.apply();
            return;
        }
        aVar.aQH = 0;
    }
}
