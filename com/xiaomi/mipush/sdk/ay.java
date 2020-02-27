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
/* loaded from: classes8.dex */
public class ay {
    private static ay a;

    /* renamed from: a  reason: collision with other field name */
    private Context f47a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f49a;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f50a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f54a;
    private static boolean b = false;

    /* renamed from: a  reason: collision with other field name */
    private static final ArrayList<a> f46a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f53a = new ArrayList();
    private boolean c = false;

    /* renamed from: a  reason: collision with other field name */
    private Intent f48a = null;

    /* renamed from: a  reason: collision with other field name */
    private Integer f51a = null;

    /* renamed from: a  reason: collision with other field name */
    private String f52a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a<T extends ir<T, ?>> {
        hg a;

        /* renamed from: a  reason: collision with other field name */
        T f55a;

        /* renamed from: a  reason: collision with other field name */
        boolean f56a;

        a() {
        }
    }

    private ay(Context context) {
        this.f54a = false;
        this.f49a = null;
        this.f47a = context.getApplicationContext();
        this.f54a = m71c();
        b = m72d();
        this.f49a = new az(this, Looper.getMainLooper());
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        return this.f47a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m66a() {
        return (!m76a() || "com.xiaomi.xmsf".equals(this.f47a.getPackageName())) ? e() : d();
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
    private String m69a() {
        return this.f47a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, bd bdVar, boolean z, HashMap<String, String> hashMap) {
        Cif cif;
        if (d.m85a(this.f47a).m92b() && com.xiaomi.push.as.b(this.f47a)) {
            Cif cif2 = new Cif();
            cif2.a(true);
            Intent m66a = m66a();
            if (TextUtils.isEmpty(str)) {
                str = com.xiaomi.push.service.aj.a();
                cif2.a(str);
                Cif cif3 = z ? new Cif(str, true) : null;
                synchronized (ao.class) {
                    ao.a(this.f47a).m62a(str);
                }
                cif = cif3;
            } else {
                cif2.a(str);
                cif = z ? new Cif(str, true) : null;
            }
            switch (bc.a[bdVar.ordinal()]) {
                case 1:
                    cif2.c(hq.DisablePushMessage.f490a);
                    cif.c(hq.DisablePushMessage.f490a);
                    if (hashMap != null) {
                        cif2.a(hashMap);
                        cif.a(hashMap);
                    }
                    m66a.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    cif2.c(hq.EnablePushMessage.f490a);
                    cif.c(hq.EnablePushMessage.f490a);
                    if (hashMap != null) {
                        cif2.a(hashMap);
                        cif.a(hashMap);
                    }
                    m66a.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    cif2.c(hq.ThirdPartyRegUpdate.f490a);
                    if (hashMap != null) {
                        cif2.a(hashMap);
                        break;
                    }
                    break;
            }
            cif2.b(d.m85a(this.f47a).m86a());
            cif2.d(this.f47a.getPackageName());
            a((ay) cif2, hg.Notification, false, (ht) null);
            if (z) {
                cif.b(d.m85a(this.f47a).m86a());
                cif.d(this.f47a.getPackageName());
                byte[] a2 = iq.a(ar.a(this.f47a, cif, hg.Notification, false, this.f47a.getPackageName(), d.m85a(this.f47a).m86a()));
                if (a2 != null) {
                    da.a(this.f47a.getPackageName(), this.f47a, cif, hg.Notification, a2.length);
                    m66a.putExtra("mipush_payload", a2);
                    m66a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m66a.putExtra("mipush_app_id", d.m85a(this.f47a).m86a());
                    m66a.putExtra("mipush_app_token", d.m85a(this.f47a).b());
                    c(m66a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = bdVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f49a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        if ("com.xiaomi.xmsf".equals(this.f47a.getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
            return e();
        }
        return c();
    }

    private void b(Intent intent) {
        try {
            if (com.xiaomi.push.l.m483a() || Build.VERSION.SDK_INT < 26) {
                this.f47a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private Intent c() {
        if (m76a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    private synchronized void c(int i) {
        this.f47a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private void c(Intent intent) {
        int a2 = com.xiaomi.push.service.ag.a(this.f47a).a(hl.ServiceBootMode.a(), hh.START.a());
        int a3 = a();
        boolean z = a2 == hh.BIND.a() && b;
        int a4 = z ? hh.BIND.a() : hh.START.a();
        if (a4 != a3) {
            m77a(a4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m71c() {
        try {
            PackageInfo packageInfo = this.f47a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
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
        String packageName = this.f47a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m69a());
        intent.putExtra("mipush_app_package", packageName);
        f();
        return intent;
    }

    private synchronized void d(Intent intent) {
        if (this.c) {
            Message a2 = a(intent);
            if (this.f53a.size() >= 50) {
                this.f53a.remove(0);
            }
            this.f53a.add(a2);
        } else if (this.f50a == null) {
            Context context = this.f47a;
            bb bbVar = new bb(this);
            Context context2 = this.f47a;
            context.bindService(intent, bbVar, 1);
            this.c = true;
            this.f53a.clear();
            this.f53a.add(a(intent));
        } else {
            try {
                this.f50a.send(a(intent));
            } catch (RemoteException e) {
                this.f50a = null;
                this.c = false;
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m72d() {
        if (m76a()) {
            try {
                return this.f47a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception e) {
                return true;
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f47a.getPackageName();
        g();
        intent.setComponent(new ComponentName(this.f47a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m73e() {
        String packageName = this.f47a.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.f47a.getApplicationInfo().flags & 1) != 0;
    }

    private void f() {
        try {
            PackageManager packageManager = this.f47a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f47a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable th) {
        }
    }

    private void g() {
        try {
            PackageManager packageManager = this.f47a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f47a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable th) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m74a() {
        b(m66a());
    }

    public void a(int i) {
        Intent m66a = m66a();
        m66a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m66a.putExtra(com.xiaomi.push.service.ap.z, this.f47a.getPackageName());
        m66a.putExtra(com.xiaomi.push.service.ap.A, i);
        c(m66a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, String str) {
        Intent m66a = m66a();
        m66a.setAction("com.xiaomi.mipush.thirdparty");
        m66a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        m66a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m66a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m75a(Intent intent) {
        intent.fillIn(m66a(), 24);
        c(intent);
    }

    public final void a(hk hkVar) {
        Intent m66a = m66a();
        byte[] a2 = iq.a(hkVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m47a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m66a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m66a.putExtra("mipush_payload", a2);
        b(m66a);
    }

    public final void a(ig igVar, boolean z) {
        ev.a(this.f47a.getApplicationContext()).a(this.f47a.getPackageName(), "E100003", igVar.a(), 6001, "construct a register message");
        this.f48a = null;
        d.m85a(this.f47a).f61a = igVar.a();
        Intent m66a = m66a();
        byte[] a2 = iq.a(ar.a(this.f47a, igVar, hg.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m47a("register fail, because msgBytes is null.");
            return;
        }
        m66a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m66a.putExtra("mipush_app_id", d.m85a(this.f47a).m86a());
        m66a.putExtra("mipush_payload", a2);
        m66a.putExtra("mipush_session", this.f52a);
        m66a.putExtra("mipush_env_chanage", z);
        m66a.putExtra("mipush_env_type", d.m85a(this.f47a).a());
        if (com.xiaomi.push.as.b(this.f47a) && m79b()) {
            c(m66a);
        } else {
            this.f48a = m66a;
        }
    }

    public final void a(im imVar) {
        byte[] a2 = iq.a(ar.a(this.f47a, imVar, hg.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m47a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m66a = m66a();
        m66a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m66a.putExtra("mipush_app_id", d.m85a(this.f47a).m86a());
        m66a.putExtra("mipush_payload", a2);
        c(m66a);
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, ht htVar) {
        a((ay) t, hgVar, !hgVar.equals(hg.Registration), htVar);
    }

    public <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z) {
        a aVar = new a();
        aVar.f55a = t;
        aVar.a = hgVar;
        aVar.f56a = z;
        synchronized (f46a) {
            f46a.add(aVar);
            if (f46a.size() > 10) {
                f46a.remove(0);
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
        a(t, hgVar, z, z2, htVar, z3, this.f47a.getPackageName(), d.m85a(this.f47a).m86a());
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z, boolean z2, ht htVar, boolean z3, String str, String str2) {
        if (!d.m85a(this.f47a).m94c()) {
            if (z2) {
                a((ay) t, hgVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m47a("drop the message before initialization.");
                return;
            }
        }
        ic a2 = ar.a(this.f47a, t, hgVar, z, str, str2);
        if (htVar != null) {
            a2.a(htVar);
        }
        byte[] a3 = iq.a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.m47a("send message fail, because msgBytes is null.");
            return;
        }
        da.a(this.f47a.getPackageName(), this.f47a, t, hgVar, a3.length);
        Intent m66a = m66a();
        m66a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m66a.putExtra("mipush_payload", a3);
        m66a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m66a);
    }

    public final void a(String str, bd bdVar, f fVar) {
        ao.a(this.f47a).a(bdVar, "syncing");
        a(str, bdVar, false, j.a(this.f47a, fVar));
    }

    public void a(String str, String str2) {
        Intent m66a = m66a();
        m66a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m66a.putExtra(com.xiaomi.push.service.ap.z, this.f47a.getPackageName());
        m66a.putExtra(com.xiaomi.push.service.ap.E, str);
        m66a.putExtra(com.xiaomi.push.service.ap.F, str2);
        c(m66a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        if (z) {
            ao.a(this.f47a).a(bd.DISABLE_PUSH, "syncing");
            ao.a(this.f47a).a(bd.ENABLE_PUSH, "");
            a(str, bd.DISABLE_PUSH, true, (HashMap<String, String>) null);
            return;
        }
        ao.a(this.f47a).a(bd.ENABLE_PUSH, "syncing");
        ao.a(this.f47a).a(bd.DISABLE_PUSH, "");
        a(str, bd.ENABLE_PUSH, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m76a() {
        return this.f54a && 1 == d.m85a(this.f47a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m77a(int i) {
        if (d.m85a(this.f47a).m92b()) {
            c(i);
            Cif cif = new Cif();
            cif.a(com.xiaomi.push.service.aj.a());
            cif.b(d.m85a(this.f47a).m86a());
            cif.d(this.f47a.getPackageName());
            cif.c(hq.ClientABTest.f490a);
            cif.f630a = new HashMap();
            cif.f630a.put("boot_mode", i + "");
            a(this.f47a).a((ay) cif, hg.Notification, false, (ht) null);
            return true;
        }
        return false;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m78b() {
        Intent m66a = m66a();
        m66a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(m66a);
    }

    public void b(int i) {
        Intent m66a = m66a();
        m66a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m66a.putExtra(com.xiaomi.push.service.ap.z, this.f47a.getPackageName());
        m66a.putExtra(com.xiaomi.push.service.ap.B, i);
        m66a.putExtra(com.xiaomi.push.service.ap.D, com.xiaomi.push.ax.b(this.f47a.getPackageName() + i));
        c(m66a);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m79b() {
        if (m76a() && m73e()) {
            if (this.f51a == null) {
                this.f51a = Integer.valueOf(com.xiaomi.push.service.as.a(this.f47a).a());
                if (this.f51a.intValue() == 0) {
                    this.f47a.getContentResolver().registerContentObserver(com.xiaomi.push.service.as.a(this.f47a).m519a(), false, new ba(this, new Handler(Looper.getMainLooper())));
                }
            }
            return this.f51a.intValue() != 0;
        }
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m80c() {
        if (this.f48a != null) {
            c(this.f48a);
            this.f48a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m81d() {
        synchronized (f46a) {
            Iterator<a> it = f46a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f55a, next.a, next.f56a, false, null, true);
            }
            f46a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m82e() {
        Intent m66a = m66a();
        m66a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m66a.putExtra(com.xiaomi.push.service.ap.z, this.f47a.getPackageName());
        m66a.putExtra(com.xiaomi.push.service.ap.D, com.xiaomi.push.ax.b(this.f47a.getPackageName()));
        c(m66a);
    }
}
