package com.kwad.sdk.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.c;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class v {
    public static AtomicInteger anB = new AtomicInteger(0);
    public static volatile boolean anC = false;

    @WorkerThread
    public static void P(final String str, final String str2) {
        com.kwad.sdk.core.threads.b.vq().execute(new Runnable() { // from class: com.kwad.sdk.utils.v.1
            @Override // java.lang.Runnable
            public final void run() {
                int c = aw.c("ksadsdk_kv_perf", str, 0);
                if (TextUtils.isEmpty(str2)) {
                    aw.U("ksadsdk_kv_perf", str);
                    return;
                }
                aw.b("ksadsdk_kv_perf", str, c + 1);
            }
        });
    }

    public static void Q(final String str, final String str2) {
        com.kwad.sdk.core.threads.b.vq().execute(new Runnable() { // from class: com.kwad.sdk.utils.v.2
            @Override // java.lang.Runnable
            public final void run() {
                if (aw.dS("ksadsdk_kv_perf").contains(str) && TextUtils.isEmpty(str2)) {
                    aw.b("ksadsdk_kv_perf_failed", str, aw.c("ksadsdk_kv_perf_failed", str, 0) + 1);
                }
            }
        });
    }

    public static void a(String str, com.kwad.sdk.utils.kwai.c cVar) {
        if (c.a.QS.contains(str)) {
            return;
        }
        cVar.release();
    }

    public static void bB(int i) {
        aw.b("kssdk_kv_mode", "mode", i);
    }

    public static void dE(String str) {
        com.kwad.sdk.utils.kwai.c ej = com.kwad.sdk.utils.kwai.e.ej(str);
        if (ej.contains("sp_to_kv_transfer_flag")) {
            return;
        }
        SharedPreferences dS = aw.dS(str);
        if (dS == null) {
            ej.putBoolean("sp_to_kv_transfer_flag", true);
            return;
        }
        ej.putAll(dS.getAll());
        ej.putBoolean("sp_to_kv_transfer_flag", true);
        aw.U(str, "kv_to_sp_transfer_flag");
        a(str, ej);
    }

    public static void dF(String str) {
        SharedPreferences dS = aw.dS(str);
        if (dS == null || dS.contains("kv_to_sp_transfer_flag")) {
            return;
        }
        com.kwad.sdk.utils.kwai.c ej = com.kwad.sdk.utils.kwai.e.ej(str);
        Map<String, Object> all = ej.getAll();
        if (all.isEmpty()) {
            aw.h(str, "kv_to_sp_transfer_flag", true);
            return;
        }
        aw.a(str, all);
        aw.h(str, "kv_to_sp_transfer_flag", true);
        ej.remove("sp_to_kv_transfer_flag");
        ej.release();
    }

    public static void transfer(int i) {
        if (i == 0) {
            zv();
        } else if (i == 1) {
            zw();
        }
    }

    public static int zn() {
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar == null) {
            com.kwad.sdk.core.e.b.w("Ks_UnionHelper", "sdkConfigProvider == null");
            return 0;
        }
        int lN = fVar.lN();
        com.kwad.sdk.core.e.b.d("Ks_UnionHelper", "config mode:" + lN);
        return lN;
    }

    public static void zo() {
        if (anC) {
            return;
        }
        anB.set(zs());
        anC = true;
    }

    public static void zp() {
        if (zt() || zn() == 0) {
            return;
        }
        com.kwad.sdk.core.threads.b.vq().execute(new Runnable() { // from class: com.kwad.sdk.utils.v.3
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.utils.a.b bVar;
                com.kwad.sdk.utils.a.a zq = v.zq();
                if (zq == null || (bVar = (com.kwad.sdk.utils.a.b) ServiceProvider.get(com.kwad.sdk.utils.a.b.class)) == null) {
                    return;
                }
                bVar.a(zq);
            }
        });
    }

    @WorkerThread
    public static com.kwad.sdk.utils.a.a zq() {
        Map<String, ?> all;
        com.kwad.sdk.utils.a.a aVar = new com.kwad.sdk.utils.a.a();
        SharedPreferences dS = aw.dS("ksadsdk_kv_perf");
        if (dS == null) {
            return null;
        }
        SharedPreferences dS2 = aw.dS("ksadsdk_kv_perf_failed");
        try {
            all = dS.getAll();
        } catch (Throwable unused) {
        }
        if (all == null) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            i2 += ((Integer) entry.getValue()).intValue();
        }
        aVar.aqu = i2;
        SharedPreferences.Editor edit = dS.edit();
        for (Map.Entry<String, ?> entry2 : all.entrySet()) {
            edit.putInt(entry2.getKey(), 0);
        }
        edit.apply();
        if (dS2 != null) {
            Map<String, ?> all2 = dS2.getAll();
            if (all2 != null) {
                for (Map.Entry<String, ?> entry3 : all2.entrySet()) {
                    i += ((Integer) entry3.getValue()).intValue();
                }
            }
            aVar.aqv = i;
            SharedPreferences.Editor edit2 = dS2.edit();
            edit2.clear();
            edit2.apply();
        } else {
            aVar.aqv = 0;
        }
        aVar.Yr = zr();
        return aVar;
    }

    public static int zr() {
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar != null) {
            float lO = fVar.lO();
            if (lO != 0.0f && lO <= 1.0f) {
                return (int) (1.0f / lO);
            }
            com.kwad.sdk.core.e.b.e("Ks_UnionHelper", "success rate invalid rate is :" + lO);
        }
        return 100;
    }

    public static int zs() {
        int c = aw.c("kssdk_kv_mode", "mode", 0);
        com.kwad.sdk.core.e.b.d("Ks_UnionHelper", "local mode:" + c);
        return c;
    }

    public static boolean zt() {
        zo();
        return anB.get() == 0;
    }

    public static void zu() {
        int i = anB.get();
        int zn = zn();
        boolean z = i != zn;
        com.kwad.sdk.core.e.b.d("Ks_UnionHelper", "needTransfer:" + z);
        if (z) {
            transfer(zn);
        }
    }

    public static void zv() {
        com.kwad.sdk.core.threads.b.vq().execute(new Runnable() { // from class: com.kwad.sdk.utils.v.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    for (String str : c.a.QR) {
                        v.dF(str);
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.e.b.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
                v.bB(0);
                v.anB.set(0);
            }
        });
    }

    public static void zw() {
        com.kwad.sdk.core.e.b.d("Ks_UnionHelper", "transferToKv");
        com.kwad.sdk.core.threads.b.vq().execute(new Runnable() { // from class: com.kwad.sdk.utils.v.5
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    for (String str : c.a.QR) {
                        v.dE(str);
                    }
                    v.bB(1);
                    v.anB.set(1);
                } catch (Exception e) {
                    com.kwad.sdk.core.e.b.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
            }
        });
    }
}
