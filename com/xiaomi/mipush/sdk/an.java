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
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.devices.RomUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bg;
import com.xiaomi.push.bl;
import com.xiaomi.push.cy;
import com.xiaomi.push.el;
import com.xiaomi.push.hf;
import com.xiaomi.push.hg;
import com.xiaomi.push.hj;
import com.xiaomi.push.hk;
import com.xiaomi.push.hp;
import com.xiaomi.push.hs;
import com.xiaomi.push.ib;
import com.xiaomi.push.ie;
import com.xiaomi.push.il;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import com.xiaomi.push.service.az;
import com.xiaomi.push.service.bc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class an {

    /* renamed from: a  reason: collision with root package name */
    public static an f41019a = null;

    /* renamed from: a  reason: collision with other field name */
    public static final ArrayList<a> f63a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f41020b = false;

    /* renamed from: a  reason: collision with other field name */
    public Context f64a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f66a;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f67a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f71a;

    /* renamed from: a  reason: collision with other field name */
    public List<Message> f70a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f41021c = false;

    /* renamed from: a  reason: collision with other field name */
    public Intent f65a = null;

    /* renamed from: a  reason: collision with other field name */
    public Integer f68a = null;

    /* renamed from: a  reason: collision with other field name */
    public String f69a = null;

    /* loaded from: classes7.dex */
    public static class a<T extends iq<T, ?>> {

        /* renamed from: a  reason: collision with root package name */
        public hf f41022a;

        /* renamed from: a  reason: collision with other field name */
        public T f72a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f73a;
    }

    public an(Context context) {
        this.f71a = false;
        this.f66a = null;
        this.f64a = context.getApplicationContext();
        this.f71a = m85c();
        f41020b = m86d();
        this.f66a = new ao(this, Looper.getMainLooper());
        if (com.xiaomi.push.l.m522a(context)) {
            com.xiaomi.push.service.d.a(new ap(this));
        }
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        return this.f64a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m80a() {
        return (!m90a() || "com.xiaomi.xmsf".equals(this.f64a.getPackageName())) ? e() : d();
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static synchronized an a(Context context) {
        an anVar;
        synchronized (an.class) {
            if (f41019a == null) {
                f41019a = new an(context);
            }
            anVar = f41019a;
        }
        return anVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m83a() {
        try {
            return this.f64a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, at atVar, boolean z, HashMap<String, String> hashMap) {
        ie ieVar;
        String str2;
        if (b.m97a(this.f64a).m104b() && bg.b(this.f64a)) {
            ie ieVar2 = new ie();
            ieVar2.a(true);
            Intent m80a = m80a();
            if (TextUtils.isEmpty(str)) {
                str = com.xiaomi.push.service.at.a();
                ieVar2.a(str);
                ieVar = z ? new ie(str, true) : null;
                synchronized (ae.class) {
                    ae.a(this.f64a).m76a(str);
                }
            } else {
                ieVar2.a(str);
                ieVar = z ? new ie(str, true) : null;
            }
            switch (as.f41027a[atVar.ordinal()]) {
                case 1:
                    ieVar2.c(hp.DisablePushMessage.f506a);
                    ieVar.c(hp.DisablePushMessage.f506a);
                    if (hashMap != null) {
                        ieVar2.a(hashMap);
                        ieVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    m80a.setAction(str2);
                    break;
                case 2:
                    ieVar2.c(hp.EnablePushMessage.f506a);
                    ieVar.c(hp.EnablePushMessage.f506a);
                    if (hashMap != null) {
                        ieVar2.a(hashMap);
                        ieVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    m80a.setAction(str2);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    ieVar2.c(hp.ThirdPartyRegUpdate.f506a);
                    if (hashMap != null) {
                        ieVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            com.xiaomi.channel.commonutils.logger.b.e("type:" + atVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + str);
            ieVar2.b(b.m97a(this.f64a).m98a());
            ieVar2.d(this.f64a.getPackageName());
            a((an) ieVar2, hf.Notification, false, (hs) null);
            if (z) {
                ieVar.b(b.m97a(this.f64a).m98a());
                ieVar.d(this.f64a.getPackageName());
                Context context = this.f64a;
                byte[] a2 = ip.a(ah.a(context, ieVar, hf.Notification, false, context.getPackageName(), b.m97a(this.f64a).m98a()));
                if (a2 != null) {
                    cy.a(this.f64a.getPackageName(), this.f64a, ieVar, hf.Notification, a2.length);
                    m80a.putExtra("mipush_payload", a2);
                    m80a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m80a.putExtra("mipush_app_id", b.m97a(this.f64a).m98a());
                    m80a.putExtra("mipush_app_token", b.m97a(this.f64a).b());
                    c(m80a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = atVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f66a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        if ("com.xiaomi.xmsf".equals(this.f64a.getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
            return e();
        }
        return c();
    }

    private void b(Intent intent) {
        try {
            if (com.xiaomi.push.l.m521a() || Build.VERSION.SDK_INT < 26) {
                this.f64a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private Intent c() {
        if (m90a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    private synchronized void c(int i2) {
        this.f64a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i2).commit();
    }

    private void c(Intent intent) {
        int a2 = com.xiaomi.push.service.aq.a(this.f64a).a(hk.ServiceBootMode.a(), hg.START.a());
        int a3 = a();
        boolean z = a2 == hg.BIND.a() && f41020b;
        int a4 = (z ? hg.BIND : hg.START).a();
        if (a4 != a3) {
            m91a(a4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m85c() {
        try {
            PackageInfo packageInfo = this.f64a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    private Intent d() {
        Intent intent = new Intent();
        String packageName = this.f64a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m83a());
        intent.putExtra("mipush_app_package", packageName);
        f();
        return intent;
    }

    private synchronized void d(Intent intent) {
        if (this.f41021c) {
            Message a2 = a(intent);
            if (this.f70a.size() >= 50) {
                this.f70a.remove(0);
            }
            this.f70a.add(a2);
            return;
        }
        if (this.f67a == null) {
            this.f64a.bindService(intent, new ar(this), 1);
            this.f41021c = true;
            this.f70a.clear();
            this.f70a.add(a(intent));
        } else {
            try {
                this.f67a.send(a(intent));
            } catch (RemoteException unused) {
                this.f67a = null;
                this.f41021c = false;
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m86d() {
        if (m90a()) {
            try {
                return this.f64a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f64a.getPackageName();
        g();
        intent.setComponent(new ComponentName(this.f64a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m87e() {
        String packageName = this.f64a.getPackageName();
        return packageName.contains("miui") || packageName.contains(RomUtils.MANUFACTURER_XIAOMI) || (this.f64a.getApplicationInfo().flags & 1) != 0;
    }

    private void f() {
        try {
            PackageManager packageManager = this.f64a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f64a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable unused) {
        }
    }

    private void g() {
        try {
            PackageManager packageManager = this.f64a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f64a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m88a() {
        b(m80a());
    }

    public void a(int i2) {
        Intent m80a = m80a();
        m80a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m80a.putExtra(az.A, this.f64a.getPackageName());
        m80a.putExtra(az.B, i2);
        c(m80a);
    }

    public void a(int i2, String str) {
        Intent m80a = m80a();
        m80a.setAction("com.xiaomi.mipush.thirdparty");
        m80a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i2);
        m80a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m80a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m89a(Intent intent) {
        intent.fillIn(m80a(), 24);
        c(intent);
    }

    public final void a(hj hjVar) {
        Intent m80a = m80a();
        byte[] a2 = ip.a(hjVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m56a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m80a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m80a.putExtra("mipush_payload", a2);
        b(m80a);
    }

    public final void a(Cif cif, boolean z) {
        el.a(this.f64a.getApplicationContext()).a(this.f64a.getPackageName(), "E100003", cif.a(), 6001, null);
        this.f65a = null;
        b.m97a(this.f64a).f78a = cif.a();
        Intent m80a = m80a();
        byte[] a2 = ip.a(ah.a(this.f64a, cif, hf.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m56a("register fail, because msgBytes is null.");
            return;
        }
        m80a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m80a.putExtra("mipush_app_id", b.m97a(this.f64a).m98a());
        m80a.putExtra("mipush_payload", a2);
        m80a.putExtra("mipush_session", this.f69a);
        m80a.putExtra("mipush_env_chanage", z);
        m80a.putExtra("mipush_env_type", b.m97a(this.f64a).a());
        if (bg.b(this.f64a) && m93b()) {
            c(m80a);
        } else {
            this.f65a = m80a;
        }
    }

    public final void a(il ilVar) {
        byte[] a2 = ip.a(ah.a(this.f64a, ilVar, hf.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m56a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m80a = m80a();
        m80a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m80a.putExtra("mipush_app_id", b.m97a(this.f64a).m98a());
        m80a.putExtra("mipush_payload", a2);
        c(m80a);
    }

    public final <T extends iq<T, ?>> void a(T t, hf hfVar, hs hsVar) {
        a((an) t, hfVar, !hfVar.equals(hf.Registration), hsVar);
    }

    public <T extends iq<T, ?>> void a(T t, hf hfVar, boolean z) {
        a aVar = new a();
        aVar.f72a = t;
        aVar.f41022a = hfVar;
        aVar.f73a = z;
        synchronized (f63a) {
            f63a.add(aVar);
            if (f63a.size() > 10) {
                f63a.remove(0);
            }
        }
    }

    public final <T extends iq<T, ?>> void a(T t, hf hfVar, boolean z, hs hsVar) {
        a(t, hfVar, z, true, hsVar, true);
    }

    public final <T extends iq<T, ?>> void a(T t, hf hfVar, boolean z, hs hsVar, boolean z2) {
        a(t, hfVar, z, true, hsVar, z2);
    }

    public final <T extends iq<T, ?>> void a(T t, hf hfVar, boolean z, boolean z2, hs hsVar, boolean z3) {
        a(t, hfVar, z, z2, hsVar, z3, this.f64a.getPackageName(), b.m97a(this.f64a).m98a());
    }

    public final <T extends iq<T, ?>> void a(T t, hf hfVar, boolean z, boolean z2, hs hsVar, boolean z3, String str, String str2) {
        a(t, hfVar, z, z2, hsVar, z3, str, str2, true);
    }

    public final <T extends iq<T, ?>> void a(T t, hf hfVar, boolean z, boolean z2, hs hsVar, boolean z3, String str, String str2, boolean z4) {
        if (!b.m97a(this.f64a).m106c()) {
            if (z2) {
                a((an) t, hfVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m56a("drop the message before initialization.");
                return;
            }
        }
        Context context = this.f64a;
        ib a2 = z4 ? ah.a(context, t, hfVar, z, str, str2) : ah.b(context, t, hfVar, z, str, str2);
        if (hsVar != null) {
            a2.a(hsVar);
        }
        byte[] a3 = ip.a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.m56a("send message fail, because msgBytes is null.");
            return;
        }
        cy.a(this.f64a.getPackageName(), this.f64a, t, hfVar, a3.length);
        Intent m80a = m80a();
        m80a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m80a.putExtra("mipush_payload", a3);
        m80a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m80a);
    }

    public final void a(String str, at atVar, e eVar) {
        ae.a(this.f64a).a(atVar, "syncing");
        a(str, atVar, false, i.a(this.f64a, eVar));
    }

    public void a(String str, String str2) {
        Intent m80a = m80a();
        m80a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m80a.putExtra(az.A, this.f64a.getPackageName());
        m80a.putExtra(az.F, str);
        m80a.putExtra(az.G, str2);
        c(m80a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        at atVar;
        if (z) {
            ae.a(this.f64a).a(at.DISABLE_PUSH, "syncing");
            ae.a(this.f64a).a(at.ENABLE_PUSH, "");
            atVar = at.DISABLE_PUSH;
        } else {
            ae.a(this.f64a).a(at.ENABLE_PUSH, "syncing");
            ae.a(this.f64a).a(at.DISABLE_PUSH, "");
            atVar = at.ENABLE_PUSH;
        }
        a(str, atVar, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m90a() {
        return this.f71a && 1 == b.m97a(this.f64a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m91a(int i2) {
        if (b.m97a(this.f64a).m104b()) {
            c(i2);
            ie ieVar = new ie();
            ieVar.a(com.xiaomi.push.service.at.a());
            ieVar.b(b.m97a(this.f64a).m98a());
            ieVar.d(this.f64a.getPackageName());
            ieVar.c(hp.ClientABTest.f506a);
            HashMap hashMap = new HashMap();
            ieVar.f647a = hashMap;
            hashMap.put("boot_mode", i2 + "");
            a(this.f64a).a((an) ieVar, hf.Notification, false, (hs) null);
            return true;
        }
        return false;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m92b() {
        Intent m80a = m80a();
        m80a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(m80a);
    }

    public void b(int i2) {
        Intent m80a = m80a();
        m80a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m80a.putExtra(az.A, this.f64a.getPackageName());
        m80a.putExtra(az.C, i2);
        String str = az.E;
        m80a.putExtra(str, bl.b(this.f64a.getPackageName() + i2));
        c(m80a);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m93b() {
        if (m90a() && m87e()) {
            if (this.f68a == null) {
                Integer valueOf = Integer.valueOf(bc.a(this.f64a).a());
                this.f68a = valueOf;
                if (valueOf.intValue() == 0) {
                    this.f64a.getContentResolver().registerContentObserver(bc.a(this.f64a).m594a(), false, new aq(this, new Handler(Looper.getMainLooper())));
                }
            }
            return this.f68a.intValue() != 0;
        }
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m94c() {
        Intent intent = this.f65a;
        if (intent != null) {
            c(intent);
            this.f65a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m95d() {
        synchronized (f63a) {
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<a> it = f63a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f72a, next.f41022a, next.f73a, false, null, true);
                if (!z) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f63a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m96e() {
        Intent m80a = m80a();
        m80a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m80a.putExtra(az.A, this.f64a.getPackageName());
        m80a.putExtra(az.E, bl.b(this.f64a.getPackageName()));
        c(m80a);
    }
}
