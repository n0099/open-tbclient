package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class az {
    private static az b;
    private static boolean f = false;
    private static final ArrayList<a> g = new ArrayList<>();
    private boolean a;
    private Context c;
    private Messenger e;
    private Handler h;
    private List<Message> i = new ArrayList();
    private boolean j = false;
    private Intent k = null;
    private Integer l = null;
    private String d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a<T extends org.apache.thrift.a<T, ?>> {
        T a;
        com.xiaomi.xmpush.thrift.a b;
        boolean c;

        a() {
        }
    }

    private az(Context context) {
        this.a = false;
        this.h = null;
        this.c = context.getApplicationContext();
        this.a = i();
        f = r();
        this.h = new ba(this, Looper.getMainLooper());
        Intent k = k();
        if (k != null) {
            b(k);
        }
    }

    public static synchronized az a(Context context) {
        az azVar;
        synchronized (az.class) {
            if (b == null) {
                b = new az(context);
            }
            azVar = b;
        }
        return azVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, be beVar, boolean z, HashMap<String, String> hashMap) {
        com.xiaomi.xmpush.thrift.ai aiVar;
        if (d.a(this.c).b() && com.xiaomi.channel.commonutils.network.d.c(this.c)) {
            com.xiaomi.xmpush.thrift.ai aiVar2 = new com.xiaomi.xmpush.thrift.ai();
            aiVar2.a(true);
            Intent j = j();
            if (TextUtils.isEmpty(str)) {
                str = com.xiaomi.push.service.aq.a();
                aiVar2.a(str);
                com.xiaomi.xmpush.thrift.ai aiVar3 = z ? new com.xiaomi.xmpush.thrift.ai(str, true) : null;
                synchronized (ap.class) {
                    ap.a(this.c).a(str);
                }
                aiVar = aiVar3;
            } else {
                aiVar2.a(str);
                aiVar = z ? new com.xiaomi.xmpush.thrift.ai(str, true) : null;
            }
            switch (bd.a[beVar.ordinal()]) {
                case 1:
                    aiVar2.c(com.xiaomi.xmpush.thrift.r.DisablePushMessage.aa);
                    aiVar.c(com.xiaomi.xmpush.thrift.r.DisablePushMessage.aa);
                    if (hashMap != null) {
                        aiVar2.a(hashMap);
                        aiVar.a(hashMap);
                    }
                    j.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    aiVar2.c(com.xiaomi.xmpush.thrift.r.EnablePushMessage.aa);
                    aiVar.c(com.xiaomi.xmpush.thrift.r.EnablePushMessage.aa);
                    if (hashMap != null) {
                        aiVar2.a(hashMap);
                        aiVar.a(hashMap);
                    }
                    j.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                    aiVar2.c(com.xiaomi.xmpush.thrift.r.ThirdPartyRegUpdate.aa);
                    if (hashMap != null) {
                        aiVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            aiVar2.b(d.a(this.c).c());
            aiVar2.d(this.c.getPackageName());
            a((az) aiVar2, com.xiaomi.xmpush.thrift.a.Notification, false, (com.xiaomi.xmpush.thrift.u) null);
            if (z) {
                aiVar.b(d.a(this.c).c());
                aiVar.d(this.c.getPackageName());
                byte[] a2 = com.xiaomi.xmpush.thrift.at.a(as.a(this.c, aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, this.c.getPackageName(), d.a(this.c).c()));
                if (a2 != null) {
                    com.xiaomi.push.clientreport.a.a(this.c, aiVar, com.xiaomi.xmpush.thrift.a.Notification, a2.length);
                    j.putExtra("mipush_payload", a2);
                    j.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    j.putExtra("mipush_app_id", d.a(this.c).c());
                    j.putExtra("mipush_app_token", d.a(this.c).d());
                    c(j);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = beVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.h.sendMessageDelayed(obtain, 5000L);
        }
    }

    private void b(Intent intent) {
        try {
            if (com.xiaomi.channel.commonutils.android.f.a() || Build.VERSION.SDK_INT < 26) {
                this.c.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private void c(Intent intent) {
        int a2 = com.xiaomi.push.service.an.a(this.c).a(com.xiaomi.xmpush.thrift.g.ServiceBootMode.a(), com.xiaomi.xmpush.thrift.b.START.a());
        int h = h();
        boolean z = a2 == com.xiaomi.xmpush.thrift.b.BIND.a() && f;
        int a3 = z ? com.xiaomi.xmpush.thrift.b.BIND.a() : com.xiaomi.xmpush.thrift.b.START.a();
        if (a3 != h) {
            c(a3);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    private synchronized void d(int i) {
        this.c.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private synchronized void d(Intent intent) {
        if (this.j) {
            Message e = e(intent);
            if (this.i.size() >= 50) {
                this.i.remove(0);
            }
            this.i.add(e);
        } else if (this.e == null) {
            Context context = this.c;
            bc bcVar = new bc(this);
            Context context2 = this.c;
            context.bindService(intent, bcVar, 1);
            this.j = true;
            this.i.clear();
            this.i.add(e(intent));
        } else {
            try {
                this.e.send(e(intent));
            } catch (RemoteException e2) {
                this.e = null;
                this.j = false;
            }
        }
    }

    private Message e(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    private synchronized int h() {
        return this.c.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    private boolean i() {
        try {
            PackageInfo packageInfo = this.c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (Throwable th) {
            return false;
        }
    }

    private Intent j() {
        return (!c() || "com.xiaomi.xmsf".equals(this.c.getPackageName())) ? n() : m();
    }

    private Intent k() {
        if ("com.xiaomi.xmsf".equals(this.c.getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
            return n();
        }
        return l();
    }

    private Intent l() {
        if (c()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return m();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return n();
    }

    private Intent m() {
        Intent intent = new Intent();
        String packageName = this.c.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", o());
        intent.putExtra("mipush_app_package", packageName);
        p();
        return intent;
    }

    private Intent n() {
        Intent intent = new Intent();
        String packageName = this.c.getPackageName();
        q();
        intent.setComponent(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    private String o() {
        return this.c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
    }

    private void p() {
        try {
            this.c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"), 2, 1);
        } catch (Throwable th) {
        }
    }

    private void q() {
        try {
            this.c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"), 1, 1);
        } catch (Throwable th) {
        }
    }

    private boolean r() {
        if (c()) {
            try {
                return this.c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception e) {
                return true;
            }
        }
        return true;
    }

    private boolean s() {
        String packageName = this.c.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.c.getApplicationInfo().flags & 1) != 0;
    }

    public void a() {
        b(j());
    }

    public void a(int i) {
        Intent j = j();
        j.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        j.putExtra(com.xiaomi.push.service.aw.z, this.c.getPackageName());
        j.putExtra(com.xiaomi.push.service.aw.A, i);
        c(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Intent intent) {
        intent.fillIn(j(), 24);
        c(intent);
    }

    public final void a(com.xiaomi.xmpush.thrift.aj ajVar, boolean z) {
        this.k = null;
        d.a(this.c).a = ajVar.c();
        Intent j = j();
        byte[] a2 = com.xiaomi.xmpush.thrift.at.a(as.a(this.c, ajVar, com.xiaomi.xmpush.thrift.a.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.a("register fail, because msgBytes is null.");
            return;
        }
        j.setAction("com.xiaomi.mipush.REGISTER_APP");
        j.putExtra("mipush_app_id", d.a(this.c).c());
        j.putExtra("mipush_payload", a2);
        j.putExtra("mipush_session", this.d);
        j.putExtra("mipush_env_chanage", z);
        j.putExtra("mipush_env_type", d.a(this.c).m());
        if (com.xiaomi.channel.commonutils.network.d.c(this.c) && g()) {
            c(j);
        } else {
            this.k = j;
        }
    }

    public final void a(com.xiaomi.xmpush.thrift.ap apVar) {
        byte[] a2 = com.xiaomi.xmpush.thrift.at.a(as.a(this.c, apVar, com.xiaomi.xmpush.thrift.a.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent j = j();
        j.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        j.putExtra("mipush_app_id", d.a(this.c).c());
        j.putExtra("mipush_payload", a2);
        c(j);
    }

    public final void a(com.xiaomi.xmpush.thrift.f fVar) {
        Intent j = j();
        byte[] a2 = com.xiaomi.xmpush.thrift.at.a(fVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        j.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        j.putExtra("mipush_payload", a2);
        b(j);
    }

    public final void a(String str, be beVar, f fVar) {
        ap.a(this.c).a(beVar, "syncing");
        a(str, beVar, false, i.c(this.c, fVar));
    }

    public void a(String str, String str2) {
        Intent j = j();
        j.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        j.putExtra(com.xiaomi.push.service.aw.z, this.c.getPackageName());
        j.putExtra(com.xiaomi.push.service.aw.E, str);
        j.putExtra(com.xiaomi.push.service.aw.F, str2);
        c(j);
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, com.xiaomi.xmpush.thrift.u uVar) {
        a((az) t, aVar, !aVar.equals(com.xiaomi.xmpush.thrift.a.Registration), uVar);
    }

    public <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z) {
        a aVar2 = new a();
        aVar2.a = t;
        aVar2.b = aVar;
        aVar2.c = z;
        synchronized (g) {
            g.add(aVar2);
            if (g.size() > 10) {
                g.remove(0);
            }
        }
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, com.xiaomi.xmpush.thrift.u uVar) {
        a(t, aVar, z, true, uVar, true);
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, com.xiaomi.xmpush.thrift.u uVar, boolean z2) {
        a(t, aVar, z, true, uVar, z2);
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, boolean z2, com.xiaomi.xmpush.thrift.u uVar, boolean z3) {
        a(t, aVar, z, z2, uVar, z3, this.c.getPackageName(), d.a(this.c).c());
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, boolean z2, com.xiaomi.xmpush.thrift.u uVar, boolean z3, String str, String str2) {
        if (!d.a(this.c).j()) {
            if (z2) {
                a((az) t, aVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.a("drop the message before initialization.");
                return;
            }
        }
        com.xiaomi.xmpush.thrift.af a2 = as.a(this.c, t, aVar, z, str, str2);
        if (uVar != null) {
            a2.a(uVar);
        }
        byte[] a3 = com.xiaomi.xmpush.thrift.at.a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.a("send message fail, because msgBytes is null.");
            return;
        }
        com.xiaomi.push.clientreport.a.a(this.c, t, aVar, a3.length);
        Intent j = j();
        j.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        j.putExtra("mipush_payload", a3);
        j.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(j);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        if (z) {
            ap.a(this.c).a(be.DISABLE_PUSH, "syncing");
            ap.a(this.c).a(be.ENABLE_PUSH, "");
            a(str, be.DISABLE_PUSH, true, (HashMap<String, String>) null);
            return;
        }
        ap.a(this.c).a(be.ENABLE_PUSH, "syncing");
        ap.a(this.c).a(be.DISABLE_PUSH, "");
        a(str, be.ENABLE_PUSH, true, (HashMap<String, String>) null);
    }

    public final void b() {
        Intent j = j();
        j.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(j);
    }

    public void b(int i) {
        Intent j = j();
        j.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        j.putExtra(com.xiaomi.push.service.aw.z, this.c.getPackageName());
        j.putExtra(com.xiaomi.push.service.aw.B, i);
        j.putExtra(com.xiaomi.push.service.aw.D, com.xiaomi.channel.commonutils.string.c.b(this.c.getPackageName() + i));
        c(j);
    }

    public boolean c() {
        return this.a && 1 == d.a(this.c).m();
    }

    public boolean c(int i) {
        if (d.a(this.c).b()) {
            d(i);
            com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
            aiVar.a(com.xiaomi.push.service.aq.a());
            aiVar.b(d.a(this.c).c());
            aiVar.d(this.c.getPackageName());
            aiVar.c(com.xiaomi.xmpush.thrift.r.ClientABTest.aa);
            aiVar.h = new HashMap();
            aiVar.h.put("boot_mode", i + "");
            a(this.c).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, (com.xiaomi.xmpush.thrift.u) null);
            return true;
        }
        return false;
    }

    public void d() {
        if (this.k != null) {
            c(this.k);
            this.k = null;
        }
    }

    public void e() {
        synchronized (g) {
            Iterator<a> it = g.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.a, next.b, next.c, false, null, true);
            }
            g.clear();
        }
    }

    public void f() {
        Intent j = j();
        j.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        j.putExtra(com.xiaomi.push.service.aw.z, this.c.getPackageName());
        j.putExtra(com.xiaomi.push.service.aw.D, com.xiaomi.channel.commonutils.string.c.b(this.c.getPackageName()));
        c(j);
    }

    public boolean g() {
        if (c() && s()) {
            if (this.l == null) {
                this.l = Integer.valueOf(com.xiaomi.push.service.az.a(this.c).b());
                if (this.l.intValue() == 0) {
                    this.c.getContentResolver().registerContentObserver(com.xiaomi.push.service.az.a(this.c).c(), false, new bb(this, new Handler(Looper.getMainLooper())));
                }
            }
            return this.l.intValue() != 0;
        }
        return true;
    }
}
