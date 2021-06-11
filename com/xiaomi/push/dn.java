package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.push.ai;
/* loaded from: classes7.dex */
public class dn {

    /* renamed from: a  reason: collision with root package name */
    public static volatile dn f41122a;

    /* renamed from: a  reason: collision with other field name */
    public Context f237a;

    public dn(Context context) {
        this.f237a = context;
    }

    private int a(int i2) {
        return Math.max(60, i2);
    }

    public static dn a(Context context) {
        if (f41122a == null) {
            synchronized (dn.class) {
                if (f41122a == null) {
                    f41122a = new dn(context);
                }
            }
        }
        return f41122a;
    }

    private void a(com.xiaomi.push.service.aq aqVar, ai aiVar, boolean z) {
        if (aqVar.a(hk.UploadSwitch.a(), true)) {
            ds dsVar = new ds(this.f237a);
            if (z) {
                aiVar.a((ai.a) dsVar, a(aqVar.a(hk.UploadFrequency.a(), 86400)));
            } else {
                aiVar.m128a((ai.a) dsVar);
            }
        }
    }

    private boolean a() {
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                ((Application) (this.f237a instanceof Application ? this.f237a : this.f237a.getApplicationContext())).registerActivityLifecycleCallbacks(new dh(this.f237a, String.valueOf(System.currentTimeMillis() / 1000)));
                return true;
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ai a2 = ai.a(this.f237a);
        com.xiaomi.push.service.aq a3 = com.xiaomi.push.service.aq.a(this.f237a);
        SharedPreferences sharedPreferences = this.f237a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j) < 172800000) {
            return;
        }
        a(a3, a2, false);
        if (a3.a(hk.StorageCollectionSwitch.a(), true)) {
            int a4 = a(a3.a(hk.StorageCollectionFrequency.a(), 86400));
            a2.a(new dr(this.f237a, a4), a4, 0);
        }
        boolean a5 = a3.a(hk.AppIsInstalledCollectionSwitch.a(), false);
        String a6 = a3.a(hk.AppIsInstalledList.a(), (String) null);
        if (a5 && !TextUtils.isEmpty(a6)) {
            int a7 = a(a3.a(hk.AppIsInstalledCollectionFrequency.a(), 86400));
            a2.a(new dp(this.f237a, a7, a6), a7, 0);
        }
        if (a3.a(hk.ActivityTSSwitch.a(), false)) {
            a();
        }
        a(a3, a2, true);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m233a() {
        ai.a(this.f237a).a(new Cdo(this));
    }
}
