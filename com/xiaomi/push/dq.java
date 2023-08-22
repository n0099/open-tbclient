package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.aj;
/* loaded from: classes10.dex */
public class dq {
    public static volatile dq a;

    /* renamed from: a  reason: collision with other field name */
    public Context f234a;

    /* renamed from: a  reason: collision with other field name */
    public a f235a;

    /* loaded from: classes10.dex */
    public interface a {
        void a();
    }

    public dq(Context context) {
        this.f234a = context;
    }

    public static int a(int i) {
        return Math.max(60, i);
    }

    public static dq a(Context context) {
        if (a == null) {
            synchronized (dq.class) {
                if (a == null) {
                    a = new dq(context);
                }
            }
        }
        return a;
    }

    private void a(com.xiaomi.push.service.ba baVar, aj ajVar, boolean z) {
        if (baVar.a(hm.UploadSwitch.a(), true)) {
            du duVar = new du(this.f234a);
            if (z) {
                ajVar.a((aj.a) duVar, a(baVar.a(hm.UploadFrequency.a(), 86400)));
            } else {
                ajVar.m259a((aj.a) duVar);
            }
        }
    }

    private boolean a() {
        try {
            ((Application) (this.f234a instanceof Application ? this.f234a : this.f234a.getApplicationContext())).registerActivityLifecycleCallbacks(new dk(this.f234a, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a aVar;
        aj a2 = aj.a(this.f234a);
        com.xiaomi.push.service.ba a3 = com.xiaomi.push.service.ba.a(this.f234a);
        SharedPreferences sharedPreferences = this.f234a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j) < 172800000) {
            return;
        }
        a(a3, a2, false);
        if (a3.a(hm.StorageCollectionSwitch.a(), true)) {
            int a4 = a(a3.a(hm.StorageCollectionFrequency.a(), 86400));
            a2.a(new dt(this.f234a, a4), a4, 0);
        }
        if (j.m711a(this.f234a) && (aVar = this.f235a) != null) {
            aVar.a();
        }
        if (a3.a(hm.ActivityTSSwitch.a(), false)) {
            a();
        }
        a(a3, a2, true);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m364a() {
        aj.a(this.f234a).a(new dr(this));
    }
}
