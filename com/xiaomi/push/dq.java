package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.aj;
/* loaded from: classes10.dex */
public class dq {
    public static volatile dq a;

    /* renamed from: a  reason: collision with other field name */
    public Context f233a;

    /* renamed from: a  reason: collision with other field name */
    public a f234a;

    /* loaded from: classes10.dex */
    public interface a {
        void a();
    }

    public dq(Context context) {
        this.f233a = context;
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
            du duVar = new du(this.f233a);
            if (z) {
                ajVar.a((aj.a) duVar, a(baVar.a(hm.UploadFrequency.a(), 86400)));
            } else {
                ajVar.m199a((aj.a) duVar);
            }
        }
    }

    private boolean a() {
        try {
            ((Application) (this.f233a instanceof Application ? this.f233a : this.f233a.getApplicationContext())).registerActivityLifecycleCallbacks(new dk(this.f233a, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a aVar;
        aj a2 = aj.a(this.f233a);
        com.xiaomi.push.service.ba a3 = com.xiaomi.push.service.ba.a(this.f233a);
        SharedPreferences sharedPreferences = this.f233a.getSharedPreferences("mipush_extra", 0);
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
            a2.a(new dt(this.f233a, a4), a4, 0);
        }
        if (j.m651a(this.f233a) && (aVar = this.f234a) != null) {
            aVar.a();
        }
        if (a3.a(hm.ActivityTSSwitch.a(), false)) {
            a();
        }
        a(a3, a2, true);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m304a() {
        aj.a(this.f233a).a(new dr(this));
    }
}
