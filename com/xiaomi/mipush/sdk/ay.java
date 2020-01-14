package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.da;
import com.xiaomi.push.ev;
import com.xiaomi.push.hg;
import com.xiaomi.push.hh;
import com.xiaomi.push.hk;
import com.xiaomi.push.hl;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
import com.xiaomi.push.ic;
import com.xiaomi.push.ig;
import com.xiaomi.push.im;
import com.xiaomi.push.iq;
import com.xiaomi.push.ir;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ay {
    private static ay a;

    /* renamed from: a  reason: collision with other field name */
    private Context f50a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f52a;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f53a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f57a;
    private static boolean b = false;

    /* renamed from: a  reason: collision with other field name */
    private static final ArrayList<a> f49a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f56a = new ArrayList();
    private boolean c = false;

    /* renamed from: a  reason: collision with other field name */
    private Intent f51a = null;

    /* renamed from: a  reason: collision with other field name */
    private Integer f54a = null;

    /* renamed from: a  reason: collision with other field name */
    private String f55a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a<T extends ir<T, ?>> {
        hg a;

        /* renamed from: a  reason: collision with other field name */
        T f58a;

        /* renamed from: a  reason: collision with other field name */
        boolean f59a;

        a() {
        }
    }

    private ay(Context context) {
        this.f57a = false;
        this.f52a = null;
        this.f50a = context.getApplicationContext();
        this.f57a = m66c();
        b = m67d();
        this.f52a = new az(this, Looper.getMainLooper());
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        return this.f50a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m61a() {
        return (!m71a() || "com.xiaomi.xmsf".equals(this.f50a.getPackageName())) ? e() : d();
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static synchronized ay a(Context context) {
        ay ayVar;
        synchronized (ay.class) {
            if (a == null) {
                a = new ay(context);
            }
            ayVar = a;
        }
        return ayVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m64a() {
        return this.f50a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, bd bdVar, boolean z, HashMap<String, String> hashMap) {
        Cif cif;
        if (d.m80a(this.f50a).m87b() && com.xiaomi.push.as.b(this.f50a)) {
            Cif cif2 = new Cif();
            cif2.a(true);
            Intent m61a = m61a();
            if (TextUtils.isEmpty(str)) {
                str = com.xiaomi.push.service.aj.a();
                cif2.a(str);
                Cif cif3 = z ? new Cif(str, true) : null;
                synchronized (ao.class) {
                    ao.a(this.f50a).m57a(str);
                }
                cif = cif3;
            } else {
                cif2.a(str);
                cif = z ? new Cif(str, true) : null;
            }
            switch (bc.a[bdVar.ordinal()]) {
                case 1:
                    cif2.c(hq.DisablePushMessage.f493a);
                    cif.c(hq.DisablePushMessage.f493a);
                    if (hashMap != null) {
                        cif2.a(hashMap);
                        cif.a(hashMap);
                    }
                    m61a.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    cif2.c(hq.EnablePushMessage.f493a);
                    cif.c(hq.EnablePushMessage.f493a);
                    if (hashMap != null) {
                        cif2.a(hashMap);
                        cif.a(hashMap);
                    }
                    m61a.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    cif2.c(hq.ThirdPartyRegUpdate.f493a);
                    if (hashMap != null) {
                        cif2.a(hashMap);
                        break;
                    }
                    break;
            }
            cif2.b(d.m80a(this.f50a).m81a());
            cif2.d(this.f50a.getPackageName());
            a((ay) cif2, hg.Notification, false, (ht) null);
            if (z) {
                cif.b(d.m80a(this.f50a).m81a());
                cif.d(this.f50a.getPackageName());
                byte[] a2 = iq.a(ar.a(this.f50a, cif, hg.Notification, false, this.f50a.getPackageName(), d.m80a(this.f50a).m81a()));
                if (a2 != null) {
                    da.a(this.f50a.getPackageName(), this.f50a, cif, hg.Notification, a2.length);
                    m61a.putExtra("mipush_payload", a2);
                    m61a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m61a.putExtra("mipush_app_id", d.m80a(this.f50a).m81a());
                    m61a.putExtra("mipush_app_token", d.m80a(this.f50a).b());
                    c(m61a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = bdVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f52a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        if ("com.xiaomi.xmsf".equals(this.f50a.getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
            return e();
        }
        return c();
    }

    private void b(Intent intent) {
        try {
            if (com.xiaomi.push.l.m478a() || Build.VERSION.SDK_INT < 26) {
                this.f50a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private Intent c() {
        if (m71a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    private synchronized void c(int i) {
        this.f50a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private void c(Intent intent) {
        int a2 = com.xiaomi.push.service.ag.a(this.f50a).a(hl.ServiceBootMode.a(), hh.START.a());
        int a3 = a();
        boolean z = a2 == hh.BIND.a() && b;
        int a4 = z ? hh.BIND.a() : hh.START.a();
        if (a4 != a3) {
            m72a(a4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m66c() {
        try {
            PackageInfo packageInfo = this.f50a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (Throwable th) {
            return false;
        }
    }

    private Intent d() {
        Intent intent = new Intent();
        String packageName = this.f50a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m64a());
        intent.putExtra("mipush_app_package", packageName);
        f();
        return intent;
    }

    private synchronized void d(Intent intent) {
        if (this.c) {
            Message a2 = a(intent);
            if (this.f56a.size() >= 50) {
                this.f56a.remove(0);
            }
            this.f56a.add(a2);
        } else if (this.f53a == null) {
            Context context = this.f50a;
            bb bbVar = new bb(this);
            Context context2 = this.f50a;
            context.bindService(intent, bbVar, 1);
            this.c = true;
            this.f56a.clear();
            this.f56a.add(a(intent));
        } else {
            try {
                this.f53a.send(a(intent));
            } catch (RemoteException e) {
                this.f53a = null;
                this.c = false;
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m67d() {
        if (m71a()) {
            try {
                return this.f50a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception e) {
                return true;
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f50a.getPackageName();
        g();
        intent.setComponent(new ComponentName(this.f50a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m68e() {
        String packageName = this.f50a.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.f50a.getApplicationInfo().flags & 1) != 0;
    }

    private void f() {
        try {
            PackageManager packageManager = this.f50a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f50a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable th) {
        }
    }

    private void g() {
        try {
            PackageManager packageManager = this.f50a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f50a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable th) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m69a() {
        b(m61a());
    }

    public void a(int i) {
        Intent m61a = m61a();
        m61a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m61a.putExtra(com.xiaomi.push.service.ap.z, this.f50a.getPackageName());
        m61a.putExtra(com.xiaomi.push.service.ap.A, i);
        c(m61a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, String str) {
        Intent m61a = m61a();
        m61a.setAction("com.xiaomi.mipush.thirdparty");
        m61a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        m61a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m61a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m70a(Intent intent) {
        intent.fillIn(m61a(), 24);
        c(intent);
    }

    public final void a(hk hkVar) {
        Intent m61a = m61a();
        byte[] a2 = iq.a(hkVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m42a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m61a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m61a.putExtra("mipush_payload", a2);
        b(m61a);
    }

    public final void a(ig igVar, boolean z) {
        ev.a(this.f50a.getApplicationContext()).a(this.f50a.getPackageName(), "E100003", igVar.a(), 6001, "construct a register message");
        this.f51a = null;
        d.m80a(this.f50a).f64a = igVar.a();
        Intent m61a = m61a();
        byte[] a2 = iq.a(ar.a(this.f50a, igVar, hg.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m42a("register fail, because msgBytes is null.");
            return;
        }
        m61a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m61a.putExtra("mipush_app_id", d.m80a(this.f50a).m81a());
        m61a.putExtra("mipush_payload", a2);
        m61a.putExtra("mipush_session", this.f55a);
        m61a.putExtra("mipush_env_chanage", z);
        m61a.putExtra("mipush_env_type", d.m80a(this.f50a).a());
        if (com.xiaomi.push.as.b(this.f50a) && m74b()) {
            c(m61a);
        } else {
            this.f51a = m61a;
        }
    }

    public final void a(im imVar) {
        byte[] a2 = iq.a(ar.a(this.f50a, imVar, hg.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m42a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m61a = m61a();
        m61a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m61a.putExtra("mipush_app_id", d.m80a(this.f50a).m81a());
        m61a.putExtra("mipush_payload", a2);
        c(m61a);
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, ht htVar) {
        a((ay) t, hgVar, !hgVar.equals(hg.Registration), htVar);
    }

    public <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z) {
        a aVar = new a();
        aVar.f58a = t;
        aVar.a = hgVar;
        aVar.f59a = z;
        synchronized (f49a) {
            f49a.add(aVar);
            if (f49a.size() > 10) {
                f49a.remove(0);
            }
        }
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z, ht htVar) {
        a(t, hgVar, z, true, htVar, true);
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z, ht htVar, boolean z2) {
        a(t, hgVar, z, true, htVar, z2);
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z, boolean z2, ht htVar, boolean z3) {
        a(t, hgVar, z, z2, htVar, z3, this.f50a.getPackageName(), d.m80a(this.f50a).m81a());
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z, boolean z2, ht htVar, boolean z3, String str, String str2) {
        if (!d.m80a(this.f50a).m89c()) {
            if (z2) {
                a((ay) t, hgVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m42a("drop the message before initialization.");
                return;
            }
        }
        ic a2 = ar.a(this.f50a, t, hgVar, z, str, str2);
        if (htVar != null) {
            a2.a(htVar);
        }
        byte[] a3 = iq.a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.m42a("send message fail, because msgBytes is null.");
            return;
        }
        da.a(this.f50a.getPackageName(), this.f50a, t, hgVar, a3.length);
        Intent m61a = m61a();
        m61a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m61a.putExtra("mipush_payload", a3);
        m61a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m61a);
    }

    public final void a(String str, bd bdVar, f fVar) {
        ao.a(this.f50a).a(bdVar, "syncing");
        a(str, bdVar, false, j.a(this.f50a, fVar));
    }

    public void a(String str, String str2) {
        Intent m61a = m61a();
        m61a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m61a.putExtra(com.xiaomi.push.service.ap.z, this.f50a.getPackageName());
        m61a.putExtra(com.xiaomi.push.service.ap.E, str);
        m61a.putExtra(com.xiaomi.push.service.ap.F, str2);
        c(m61a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        if (z) {
            ao.a(this.f50a).a(bd.DISABLE_PUSH, "syncing");
            ao.a(this.f50a).a(bd.ENABLE_PUSH, "");
            a(str, bd.DISABLE_PUSH, true, (HashMap<String, String>) null);
            return;
        }
        ao.a(this.f50a).a(bd.ENABLE_PUSH, "syncing");
        ao.a(this.f50a).a(bd.DISABLE_PUSH, "");
        a(str, bd.ENABLE_PUSH, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m71a() {
        return this.f57a && 1 == d.m80a(this.f50a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m72a(int i) {
        if (d.m80a(this.f50a).m87b()) {
            c(i);
            Cif cif = new Cif();
            cif.a(com.xiaomi.push.service.aj.a());
            cif.b(d.m80a(this.f50a).m81a());
            cif.d(this.f50a.getPackageName());
            cif.c(hq.ClientABTest.f493a);
            cif.f633a = new HashMap();
            cif.f633a.put("boot_mode", i + "");
            a(this.f50a).a((ay) cif, hg.Notification, false, (ht) null);
            return true;
        }
        return false;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m73b() {
        Intent m61a = m61a();
        m61a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(m61a);
    }

    public void b(int i) {
        Intent m61a = m61a();
        m61a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m61a.putExtra(com.xiaomi.push.service.ap.z, this.f50a.getPackageName());
        m61a.putExtra(com.xiaomi.push.service.ap.B, i);
        m61a.putExtra(com.xiaomi.push.service.ap.D, com.xiaomi.push.ax.b(this.f50a.getPackageName() + i));
        c(m61a);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m74b() {
        if (m71a() && m68e()) {
            if (this.f54a == null) {
                this.f54a = Integer.valueOf(com.xiaomi.push.service.as.a(this.f50a).a());
                if (this.f54a.intValue() == 0) {
                    this.f50a.getContentResolver().registerContentObserver(com.xiaomi.push.service.as.a(this.f50a).m514a(), false, new ba(this, new Handler(Looper.getMainLooper())));
                }
            }
            return this.f54a.intValue() != 0;
        }
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m75c() {
        if (this.f51a != null) {
            c(this.f51a);
            this.f51a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m76d() {
        synchronized (f49a) {
            Iterator<a> it = f49a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f58a, next.a, next.f59a, false, null, true);
            }
            f49a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m77e() {
        Intent m61a = m61a();
        m61a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m61a.putExtra(com.xiaomi.push.service.ap.z, this.f50a.getPackageName());
        m61a.putExtra(com.xiaomi.push.service.ap.D, com.xiaomi.push.ax.b(this.f50a.getPackageName()));
        c(m61a);
    }
}
