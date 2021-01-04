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
import com.baidu.android.util.devices.RomUtils;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.xiaomi.push.az;
import com.xiaomi.push.be;
import com.xiaomi.push.df;
import com.xiaomi.push.fb;
import com.xiaomi.push.hm;
import com.xiaomi.push.hn;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.hw;
import com.xiaomi.push.hz;
import com.xiaomi.push.ii;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.is;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    private static aq f14108a;

    /* renamed from: a  reason: collision with other field name */
    private Context f129a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f131a;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f132a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f136a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f14109b = false;

    /* renamed from: a  reason: collision with other field name */
    private static final ArrayList<a> f128a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f135a = new ArrayList();
    private boolean c = false;

    /* renamed from: a  reason: collision with other field name */
    private Intent f130a = null;

    /* renamed from: a  reason: collision with other field name */
    private Integer f133a = null;

    /* renamed from: a  reason: collision with other field name */
    private String f134a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a<T extends ix<T, ?>> {

        /* renamed from: a  reason: collision with root package name */
        hm f14110a;

        /* renamed from: a  reason: collision with other field name */
        T f137a;

        /* renamed from: a  reason: collision with other field name */
        boolean f138a;

        a() {
        }
    }

    private aq(Context context) {
        this.f136a = false;
        this.f131a = null;
        this.f129a = context.getApplicationContext();
        this.f136a = m101c();
        f14109b = m102d();
        this.f131a = new ar(this, Looper.getMainLooper());
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        return this.f129a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m96a() {
        return (!m106a() || "com.xiaomi.xmsf".equals(this.f129a.getPackageName())) ? e() : d();
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static synchronized aq a(Context context) {
        aq aqVar;
        synchronized (aq.class) {
            if (f14108a == null) {
                f14108a = new aq(context);
            }
            aqVar = f14108a;
        }
        return aqVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m99a() {
        return this.f129a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, av avVar, boolean z, HashMap<String, String> hashMap) {
        il ilVar;
        if (b.m113a(this.f129a).m120b() && az.b(this.f129a)) {
            il ilVar2 = new il();
            ilVar2.a(true);
            Intent m96a = m96a();
            if (TextUtils.isEmpty(str)) {
                str = com.xiaomi.push.service.an.a();
                ilVar2.a(str);
                il ilVar3 = z ? new il(str, true) : null;
                synchronized (ag.class) {
                    ag.a(this.f129a).m92a(str);
                }
                ilVar = ilVar3;
            } else {
                ilVar2.a(str);
                ilVar = z ? new il(str, true) : null;
            }
            switch (au.f14114a[avVar.ordinal()]) {
                case 1:
                    ilVar2.c(hw.DisablePushMessage.f555a);
                    ilVar.c(hw.DisablePushMessage.f555a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        ilVar.a(hashMap);
                    }
                    m96a.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    ilVar2.c(hw.EnablePushMessage.f555a);
                    ilVar.c(hw.EnablePushMessage.f555a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        ilVar.a(hashMap);
                    }
                    m96a.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    ilVar2.c(hw.ThirdPartyRegUpdate.f555a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            ilVar2.b(b.m113a(this.f129a).m114a());
            ilVar2.d(this.f129a.getPackageName());
            a((aq) ilVar2, hm.Notification, false, (hz) null);
            if (z) {
                ilVar.b(b.m113a(this.f129a).m114a());
                ilVar.d(this.f129a.getPackageName());
                byte[] a2 = iw.a(aj.a(this.f129a, ilVar, hm.Notification, false, this.f129a.getPackageName(), b.m113a(this.f129a).m114a()));
                if (a2 != null) {
                    df.a(this.f129a.getPackageName(), this.f129a, ilVar, hm.Notification, a2.length);
                    m96a.putExtra("mipush_payload", a2);
                    m96a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m96a.putExtra("mipush_app_id", b.m113a(this.f129a).m114a());
                    m96a.putExtra("mipush_app_token", b.m113a(this.f129a).b());
                    c(m96a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = avVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f131a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        if ("com.xiaomi.xmsf".equals(this.f129a.getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
            return e();
        }
        return c();
    }

    private void b(Intent intent) {
        try {
            if (com.xiaomi.push.l.m519a() || Build.VERSION.SDK_INT < 26) {
                this.f129a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private Intent c() {
        if (m106a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    private synchronized void c(int i) {
        this.f129a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private void c(Intent intent) {
        int a2 = com.xiaomi.push.service.ak.a(this.f129a).a(hr.ServiceBootMode.a(), hn.START.a());
        int a3 = a();
        boolean z = a2 == hn.BIND.a() && f14109b;
        int a4 = z ? hn.BIND.a() : hn.START.a();
        if (a4 != a3) {
            m107a(a4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m101c() {
        try {
            PackageInfo packageInfo = this.f129a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
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
        String packageName = this.f129a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m99a());
        intent.putExtra("mipush_app_package", packageName);
        f();
        return intent;
    }

    private synchronized void d(Intent intent) {
        if (this.c) {
            Message a2 = a(intent);
            if (this.f135a.size() >= 50) {
                this.f135a.remove(0);
            }
            this.f135a.add(a2);
        } else if (this.f132a == null) {
            Context context = this.f129a;
            at atVar = new at(this);
            Context context2 = this.f129a;
            context.bindService(intent, atVar, 1);
            this.c = true;
            this.f135a.clear();
            this.f135a.add(a(intent));
        } else {
            try {
                this.f132a.send(a(intent));
            } catch (RemoteException e) {
                this.f132a = null;
                this.c = false;
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m102d() {
        if (m106a()) {
            try {
                return this.f129a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception e) {
                return true;
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f129a.getPackageName();
        g();
        intent.setComponent(new ComponentName(this.f129a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m103e() {
        String packageName = this.f129a.getPackageName();
        return packageName.contains("miui") || packageName.contains(RomUtils.MANUFACTURER_XIAOMI) || (this.f129a.getApplicationInfo().flags & 1) != 0;
    }

    private void f() {
        try {
            PackageManager packageManager = this.f129a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f129a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable th) {
        }
    }

    private void g() {
        try {
            PackageManager packageManager = this.f129a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f129a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable th) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m104a() {
        b(m96a());
    }

    public void a(int i) {
        Intent m96a = m96a();
        m96a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m96a.putExtra(com.xiaomi.push.service.at.z, this.f129a.getPackageName());
        m96a.putExtra(com.xiaomi.push.service.at.A, i);
        c(m96a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, String str) {
        Intent m96a = m96a();
        m96a.setAction("com.xiaomi.mipush.thirdparty");
        m96a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        m96a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m96a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m105a(Intent intent) {
        intent.fillIn(m96a(), 24);
        c(intent);
    }

    public final void a(hq hqVar) {
        Intent m96a = m96a();
        byte[] a2 = iw.a(hqVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m73a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m96a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m96a.putExtra("mipush_payload", a2);
        b(m96a);
    }

    public final void a(im imVar, boolean z) {
        fb.a(this.f129a.getApplicationContext()).a(this.f129a.getPackageName(), "E100003", imVar.a(), ARPMessageType.MSG_TYPE_MODEL_LOAD_PROGRESS, null);
        this.f130a = null;
        b.m113a(this.f129a).f143a = imVar.a();
        Intent m96a = m96a();
        byte[] a2 = iw.a(aj.a(this.f129a, imVar, hm.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m73a("register fail, because msgBytes is null.");
            return;
        }
        m96a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m96a.putExtra("mipush_app_id", b.m113a(this.f129a).m114a());
        m96a.putExtra("mipush_payload", a2);
        m96a.putExtra("mipush_session", this.f134a);
        m96a.putExtra("mipush_env_chanage", z);
        m96a.putExtra("mipush_env_type", b.m113a(this.f129a).a());
        if (az.b(this.f129a) && m109b()) {
            c(m96a);
        } else {
            this.f130a = m96a;
        }
    }

    public final void a(is isVar) {
        byte[] a2 = iw.a(aj.a(this.f129a, isVar, hm.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m73a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m96a = m96a();
        m96a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m96a.putExtra("mipush_app_id", b.m113a(this.f129a).m114a());
        m96a.putExtra("mipush_payload", a2);
        c(m96a);
    }

    public final <T extends ix<T, ?>> void a(T t, hm hmVar, hz hzVar) {
        a((aq) t, hmVar, !hmVar.equals(hm.Registration), hzVar);
    }

    public <T extends ix<T, ?>> void a(T t, hm hmVar, boolean z) {
        a aVar = new a();
        aVar.f137a = t;
        aVar.f14110a = hmVar;
        aVar.f138a = z;
        synchronized (f128a) {
            f128a.add(aVar);
            if (f128a.size() > 10) {
                f128a.remove(0);
            }
        }
    }

    public final <T extends ix<T, ?>> void a(T t, hm hmVar, boolean z, hz hzVar) {
        a(t, hmVar, z, true, hzVar, true);
    }

    public final <T extends ix<T, ?>> void a(T t, hm hmVar, boolean z, hz hzVar, boolean z2) {
        a(t, hmVar, z, true, hzVar, z2);
    }

    public final <T extends ix<T, ?>> void a(T t, hm hmVar, boolean z, boolean z2, hz hzVar, boolean z3) {
        a(t, hmVar, z, z2, hzVar, z3, this.f129a.getPackageName(), b.m113a(this.f129a).m114a());
    }

    public final <T extends ix<T, ?>> void a(T t, hm hmVar, boolean z, boolean z2, hz hzVar, boolean z3, String str, String str2) {
        if (!b.m113a(this.f129a).m122c()) {
            if (z2) {
                a((aq) t, hmVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m73a("drop the message before initialization.");
                return;
            }
        }
        ii a2 = aj.a(this.f129a, t, hmVar, z, str, str2);
        if (hzVar != null) {
            a2.a(hzVar);
        }
        byte[] a3 = iw.a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.m73a("send message fail, because msgBytes is null.");
            return;
        }
        df.a(this.f129a.getPackageName(), this.f129a, t, hmVar, a3.length);
        Intent m96a = m96a();
        m96a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m96a.putExtra("mipush_payload", a3);
        m96a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m96a);
    }

    public final void a(String str, av avVar, d dVar) {
        ag.a(this.f129a).a(avVar, "syncing");
        a(str, avVar, false, h.a(this.f129a, dVar));
    }

    public void a(String str, String str2) {
        Intent m96a = m96a();
        m96a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m96a.putExtra(com.xiaomi.push.service.at.z, this.f129a.getPackageName());
        m96a.putExtra(com.xiaomi.push.service.at.E, str);
        m96a.putExtra(com.xiaomi.push.service.at.F, str2);
        c(m96a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        if (z) {
            ag.a(this.f129a).a(av.DISABLE_PUSH, "syncing");
            ag.a(this.f129a).a(av.ENABLE_PUSH, "");
            a(str, av.DISABLE_PUSH, true, (HashMap<String, String>) null);
            return;
        }
        ag.a(this.f129a).a(av.ENABLE_PUSH, "syncing");
        ag.a(this.f129a).a(av.DISABLE_PUSH, "");
        a(str, av.ENABLE_PUSH, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m106a() {
        return this.f136a && 1 == b.m113a(this.f129a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m107a(int i) {
        if (b.m113a(this.f129a).m120b()) {
            c(i);
            il ilVar = new il();
            ilVar.a(com.xiaomi.push.service.an.a());
            ilVar.b(b.m113a(this.f129a).m114a());
            ilVar.d(this.f129a.getPackageName());
            ilVar.c(hw.ClientABTest.f555a);
            ilVar.f696a = new HashMap();
            ilVar.f696a.put("boot_mode", i + "");
            a(this.f129a).a((aq) ilVar, hm.Notification, false, (hz) null);
            return true;
        }
        return false;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m108b() {
        Intent m96a = m96a();
        m96a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(m96a);
    }

    public void b(int i) {
        Intent m96a = m96a();
        m96a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m96a.putExtra(com.xiaomi.push.service.at.z, this.f129a.getPackageName());
        m96a.putExtra(com.xiaomi.push.service.at.B, i);
        m96a.putExtra(com.xiaomi.push.service.at.D, be.b(this.f129a.getPackageName() + i));
        c(m96a);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m109b() {
        if (m106a() && m103e()) {
            if (this.f133a == null) {
                this.f133a = Integer.valueOf(com.xiaomi.push.service.aw.a(this.f129a).a());
                if (this.f133a.intValue() == 0) {
                    this.f129a.getContentResolver().registerContentObserver(com.xiaomi.push.service.aw.a(this.f129a).m571a(), false, new as(this, new Handler(Looper.getMainLooper())));
                }
            }
            return this.f133a.intValue() != 0;
        }
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m110c() {
        if (this.f130a != null) {
            c(this.f130a);
            this.f130a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m111d() {
        synchronized (f128a) {
            Iterator<a> it = f128a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f137a, next.f14110a, next.f138a, false, null, true);
            }
            f128a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m112e() {
        Intent m96a = m96a();
        m96a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m96a.putExtra(com.xiaomi.push.service.at.z, this.f129a.getPackageName());
        m96a.putExtra(com.xiaomi.push.service.at.D, be.b(this.f129a.getPackageName()));
        c(m96a);
    }
}
