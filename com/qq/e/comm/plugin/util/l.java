package com.qq.e.comm.plugin.util;

import android.content.SharedPreferences;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static volatile l f12884a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final String f12885b = SDKStatus.getSDKVersion() + "." + GDTADManager.getInstance().getPM().getPluginVersion();
    private static int c = GDTADManager.getInstance().getSM().getInteger("buglyRate", 0);
    private boolean d;

    private l(String str) {
        b(str);
    }

    public static l a(String str) {
        if (f12884a == null) {
            synchronized (l.class) {
                try {
                    if (f12884a == null) {
                        f12884a = new l(str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12884a;
    }

    private void b() {
        SharedPreferences.Editor edit = GDTADManager.getInstance().getAppContext().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.remove("2c39b77689");
        edit.apply();
    }

    private void b(String str) {
        try {
            if (m.a(str) || Math.abs(str.hashCode() % 100) >= c) {
                b();
                this.d = false;
            } else {
                c();
                this.d = true;
            }
        } catch (Exception e) {
            GDTLogger.d("Bugly Init encounter exception: " + e.getMessage());
        }
    }

    private void c() {
        SharedPreferences.Editor edit = GDTADManager.getInstance().getAppContext().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.putString("2c39b77689", f12885b);
        edit.apply();
    }

    public boolean a() {
        return this.d;
    }
}
