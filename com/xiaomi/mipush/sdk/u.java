package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.ao;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.af;
import com.xiaomi.xmpush.thrift.aq;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class u {
    private static u b;
    private static final ArrayList<a> e = new ArrayList<>();
    private boolean a;
    private Context c;
    private Handler f;
    private Intent g = null;
    private Integer h = null;
    private String d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T extends org.apache.thrift.a<T, ?>> {
        T a;
        com.xiaomi.xmpush.thrift.a b;
        boolean c;

        a() {
        }
    }

    private u(Context context) {
        this.a = false;
        this.f = null;
        this.c = context.getApplicationContext();
        this.a = h();
        this.f = new v(this, Looper.getMainLooper());
    }

    public static u a(Context context) {
        if (b == null) {
            b = new u(context);
        }
        return b;
    }

    private void a(Intent intent) {
        try {
            this.c.startService(intent);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, boolean z) {
        ae aeVar;
        if (com.xiaomi.mipush.sdk.a.a(this.c).b() && com.xiaomi.channel.commonutils.network.d.d(this.c)) {
            ae aeVar2 = new ae();
            Intent i = i();
            if (TextUtils.isEmpty(str)) {
                str = MiPushClient.generatePacketID();
                aeVar2.a(str);
                aeVar = new ae(str, true);
                synchronized (p.class) {
                    p.a(this.c).a(str);
                }
            } else {
                aeVar2.a(str);
                aeVar = new ae(str, true);
            }
            if (z) {
                aeVar2.c(com.xiaomi.xmpush.thrift.o.DisablePushMessage.N);
                aeVar.c(com.xiaomi.xmpush.thrift.o.DisablePushMessage.N);
                i.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
            } else {
                aeVar2.c(com.xiaomi.xmpush.thrift.o.EnablePushMessage.N);
                aeVar.c(com.xiaomi.xmpush.thrift.o.EnablePushMessage.N);
                i.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
            }
            aeVar2.b(com.xiaomi.mipush.sdk.a.a(this.c).c());
            aeVar2.d(this.c.getPackageName());
            a(aeVar2, com.xiaomi.xmpush.thrift.a.Notification, false, null);
            aeVar.b(com.xiaomi.mipush.sdk.a.a(this.c).c());
            aeVar.d(this.c.getPackageName());
            byte[] a2 = aq.a(q.a(this.c, aeVar, com.xiaomi.xmpush.thrift.a.Notification, false, this.c.getPackageName(), com.xiaomi.mipush.sdk.a.a(this.c).c()));
            if (a2 != null) {
                i.putExtra("mipush_payload", a2);
                i.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                i.putExtra("mipush_app_id", com.xiaomi.mipush.sdk.a.a(this.c).c());
                i.putExtra("mipush_app_token", com.xiaomi.mipush.sdk.a.a(this.c).d());
                a(i);
            }
            Message obtain = Message.obtain();
            int i2 = z ? 1 : 0;
            obtain.obj = str;
            obtain.arg1 = i2;
            this.f.sendMessageDelayed(obtain, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    private boolean h() {
        try {
            PackageInfo packageInfo = this.c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (Exception e2) {
            return false;
        }
    }

    private Intent i() {
        Intent intent = new Intent();
        String packageName = this.c.getPackageName();
        if (!c() || "com.xiaomi.xmsf".equals(packageName)) {
            l();
            intent.setComponent(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"));
            intent.putExtra("mipush_app_package", packageName);
        } else {
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", j());
            intent.putExtra("mipush_app_package", packageName);
            k();
        }
        return intent;
    }

    private String j() {
        return this.c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
    }

    private void k() {
        try {
            this.c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"), 2, 1);
        } catch (Throwable th) {
        }
    }

    private void l() {
        try {
            this.c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"), 1, 1);
        } catch (Throwable th) {
        }
    }

    private boolean m() {
        String packageName = this.c.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.c.getApplicationInfo().flags & 1) != 0;
    }

    public void a() {
        a(i());
    }

    public void a(int i) {
        Intent i2 = i();
        i2.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        i2.putExtra(am.y, this.c.getPackageName());
        i2.putExtra(am.z, i);
        a(i2);
    }

    public final void a(af afVar, boolean z) {
        this.g = null;
        Intent i = i();
        byte[] a2 = aq.a(q.a(this.c, afVar, com.xiaomi.xmpush.thrift.a.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.a("register fail, because msgBytes is null.");
            return;
        }
        i.setAction("com.xiaomi.mipush.REGISTER_APP");
        i.putExtra("mipush_app_id", com.xiaomi.mipush.sdk.a.a(this.c).c());
        i.putExtra("mipush_payload", a2);
        i.putExtra("mipush_session", this.d);
        i.putExtra("mipush_env_chanage", z);
        i.putExtra("mipush_env_type", com.xiaomi.mipush.sdk.a.a(this.c).m());
        if (com.xiaomi.channel.commonutils.network.d.d(this.c) && g()) {
            a(i);
        } else {
            this.g = i;
        }
    }

    public final void a(com.xiaomi.xmpush.thrift.am amVar) {
        Intent i = i();
        byte[] a2 = aq.a(q.a(this.c, amVar, com.xiaomi.xmpush.thrift.a.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.a("unregister fail, because msgBytes is null.");
            return;
        }
        i.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        i.putExtra("mipush_app_id", com.xiaomi.mipush.sdk.a.a(this.c).c());
        i.putExtra("mipush_payload", a2);
        a(i);
    }

    public void a(String str, String str2) {
        Intent i = i();
        i.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        i.putExtra(am.y, this.c.getPackageName());
        i.putExtra(am.D, str);
        i.putExtra(am.E, str2);
        a(i);
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, com.xiaomi.xmpush.thrift.r rVar) {
        a(t, aVar, !aVar.equals(com.xiaomi.xmpush.thrift.a.Registration), rVar);
    }

    public <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z) {
        a aVar2 = new a();
        aVar2.a = t;
        aVar2.b = aVar;
        aVar2.c = z;
        synchronized (e) {
            e.add(aVar2);
            if (e.size() > 10) {
                e.remove(0);
            }
        }
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, com.xiaomi.xmpush.thrift.r rVar) {
        a(t, aVar, z, true, rVar, true);
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, com.xiaomi.xmpush.thrift.r rVar, boolean z2) {
        a(t, aVar, z, true, rVar, z2);
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, boolean z2, com.xiaomi.xmpush.thrift.r rVar, boolean z3) {
        a(t, aVar, z, z2, rVar, z3, this.c.getPackageName(), com.xiaomi.mipush.sdk.a.a(this.c).c());
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, boolean z2, com.xiaomi.xmpush.thrift.r rVar, boolean z3, String str, String str2) {
        if (!com.xiaomi.mipush.sdk.a.a(this.c).i()) {
            if (z2) {
                a((u) t, aVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.a("drop the message before initialization.");
                return;
            }
        }
        Intent i = i();
        com.xiaomi.xmpush.thrift.ab a2 = q.a(this.c, t, aVar, z, str, str2);
        if (rVar != null) {
            a2.a(rVar);
        }
        byte[] a3 = aq.a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.a("send message fail, because msgBytes is null.");
            return;
        }
        i.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        i.putExtra("mipush_payload", a3);
        i.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        a(i);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        if (z) {
            p.a(this.c).f("disable_syncing");
        } else {
            p.a(this.c).f("enable_syncing");
        }
        a(str, z);
    }

    public final void b() {
        Intent i = i();
        i.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        a(i);
    }

    public void b(int i) {
        Intent i2 = i();
        i2.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        i2.putExtra(am.y, this.c.getPackageName());
        i2.putExtra(am.A, i);
        i2.putExtra(am.C, com.xiaomi.channel.commonutils.string.c.b(this.c.getPackageName() + i));
        a(i2);
    }

    public boolean c() {
        return this.a && 1 == com.xiaomi.mipush.sdk.a.a(this.c).m();
    }

    public void d() {
        if (this.g != null) {
            a(this.g);
            this.g = null;
        }
    }

    public void e() {
        synchronized (e) {
            Iterator<a> it = e.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.a, next.b, next.c, false, null, true);
            }
            e.clear();
        }
    }

    public void f() {
        Intent i = i();
        i.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        i.putExtra(am.y, this.c.getPackageName());
        i.putExtra(am.C, com.xiaomi.channel.commonutils.string.c.b(this.c.getPackageName()));
        a(i);
    }

    public boolean g() {
        if (c() && m()) {
            if (this.h == null) {
                this.h = Integer.valueOf(ao.a(this.c).b());
                if (this.h.intValue() == 0) {
                    this.c.getContentResolver().registerContentObserver(ao.a(this.c).c(), false, new w(this, new Handler(Looper.getMainLooper())));
                }
            }
            return this.h.intValue() != 0;
        }
        return true;
    }
}
