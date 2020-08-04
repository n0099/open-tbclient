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
/* loaded from: classes9.dex */
public class aq {
    private static aq a;

    /* renamed from: a  reason: collision with other field name */
    private Context f55a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f57a;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f58a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f62a;
    private static boolean b = false;

    /* renamed from: a  reason: collision with other field name */
    private static final ArrayList<a> f54a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f61a = new ArrayList();
    private boolean c = false;

    /* renamed from: a  reason: collision with other field name */
    private Intent f56a = null;

    /* renamed from: a  reason: collision with other field name */
    private Integer f59a = null;

    /* renamed from: a  reason: collision with other field name */
    private String f60a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a<T extends ix<T, ?>> {
        hm a;

        /* renamed from: a  reason: collision with other field name */
        T f63a;

        /* renamed from: a  reason: collision with other field name */
        boolean f64a;

        a() {
        }
    }

    private aq(Context context) {
        this.f62a = false;
        this.f57a = null;
        this.f55a = context.getApplicationContext();
        this.f62a = m77c();
        b = m78d();
        this.f57a = new ar(this, Looper.getMainLooper());
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        return this.f55a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m72a() {
        return (!m82a() || "com.xiaomi.xmsf".equals(this.f55a.getPackageName())) ? e() : d();
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
            if (a == null) {
                a = new aq(context);
            }
            aqVar = a;
        }
        return aqVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m75a() {
        return this.f55a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, av avVar, boolean z, HashMap<String, String> hashMap) {
        il ilVar;
        if (b.m89a(this.f55a).m96b() && az.b(this.f55a)) {
            il ilVar2 = new il();
            ilVar2.a(true);
            Intent m72a = m72a();
            if (TextUtils.isEmpty(str)) {
                str = com.xiaomi.push.service.an.a();
                ilVar2.a(str);
                il ilVar3 = z ? new il(str, true) : null;
                synchronized (ag.class) {
                    ag.a(this.f55a).m68a(str);
                }
                ilVar = ilVar3;
            } else {
                ilVar2.a(str);
                ilVar = z ? new il(str, true) : null;
            }
            switch (au.a[avVar.ordinal()]) {
                case 1:
                    ilVar2.c(hw.DisablePushMessage.f481a);
                    ilVar.c(hw.DisablePushMessage.f481a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        ilVar.a(hashMap);
                    }
                    m72a.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    ilVar2.c(hw.EnablePushMessage.f481a);
                    ilVar.c(hw.EnablePushMessage.f481a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        ilVar.a(hashMap);
                    }
                    m72a.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    ilVar2.c(hw.ThirdPartyRegUpdate.f481a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            ilVar2.b(b.m89a(this.f55a).m90a());
            ilVar2.d(this.f55a.getPackageName());
            a((aq) ilVar2, hm.Notification, false, (hz) null);
            if (z) {
                ilVar.b(b.m89a(this.f55a).m90a());
                ilVar.d(this.f55a.getPackageName());
                byte[] a2 = iw.a(aj.a(this.f55a, ilVar, hm.Notification, false, this.f55a.getPackageName(), b.m89a(this.f55a).m90a()));
                if (a2 != null) {
                    df.a(this.f55a.getPackageName(), this.f55a, ilVar, hm.Notification, a2.length);
                    m72a.putExtra("mipush_payload", a2);
                    m72a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m72a.putExtra("mipush_app_id", b.m89a(this.f55a).m90a());
                    m72a.putExtra("mipush_app_token", b.m89a(this.f55a).b());
                    c(m72a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = avVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f57a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        if ("com.xiaomi.xmsf".equals(this.f55a.getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
            return e();
        }
        return c();
    }

    private void b(Intent intent) {
        try {
            if (com.xiaomi.push.l.m495a() || Build.VERSION.SDK_INT < 26) {
                this.f55a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private Intent c() {
        if (m82a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    private synchronized void c(int i) {
        this.f55a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private void c(Intent intent) {
        int a2 = com.xiaomi.push.service.ak.a(this.f55a).a(hr.ServiceBootMode.a(), hn.START.a());
        int a3 = a();
        boolean z = a2 == hn.BIND.a() && b;
        int a4 = z ? hn.BIND.a() : hn.START.a();
        if (a4 != a3) {
            m83a(a4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m77c() {
        try {
            PackageInfo packageInfo = this.f55a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
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
        String packageName = this.f55a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m75a());
        intent.putExtra("mipush_app_package", packageName);
        f();
        return intent;
    }

    private synchronized void d(Intent intent) {
        if (this.c) {
            Message a2 = a(intent);
            if (this.f61a.size() >= 50) {
                this.f61a.remove(0);
            }
            this.f61a.add(a2);
        } else if (this.f58a == null) {
            Context context = this.f55a;
            at atVar = new at(this);
            Context context2 = this.f55a;
            context.bindService(intent, atVar, 1);
            this.c = true;
            this.f61a.clear();
            this.f61a.add(a(intent));
        } else {
            try {
                this.f58a.send(a(intent));
            } catch (RemoteException e) {
                this.f58a = null;
                this.c = false;
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m78d() {
        if (m82a()) {
            try {
                return this.f55a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception e) {
                return true;
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f55a.getPackageName();
        g();
        intent.setComponent(new ComponentName(this.f55a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m79e() {
        String packageName = this.f55a.getPackageName();
        return packageName.contains("miui") || packageName.contains(RomUtils.MANUFACTURER_XIAOMI) || (this.f55a.getApplicationInfo().flags & 1) != 0;
    }

    private void f() {
        try {
            PackageManager packageManager = this.f55a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f55a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable th) {
        }
    }

    private void g() {
        try {
            PackageManager packageManager = this.f55a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f55a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable th) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m80a() {
        b(m72a());
    }

    public void a(int i) {
        Intent m72a = m72a();
        m72a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m72a.putExtra(com.xiaomi.push.service.at.z, this.f55a.getPackageName());
        m72a.putExtra(com.xiaomi.push.service.at.A, i);
        c(m72a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, String str) {
        Intent m72a = m72a();
        m72a.setAction("com.xiaomi.mipush.thirdparty");
        m72a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        m72a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m72a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m81a(Intent intent) {
        intent.fillIn(m72a(), 24);
        c(intent);
    }

    public final void a(hq hqVar) {
        Intent m72a = m72a();
        byte[] a2 = iw.a(hqVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m49a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m72a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m72a.putExtra("mipush_payload", a2);
        b(m72a);
    }

    public final void a(im imVar, boolean z) {
        fb.a(this.f55a.getApplicationContext()).a(this.f55a.getPackageName(), "E100003", imVar.a(), ARPMessageType.MSG_TYPE_MODEL_LOAD_PROGRESS, null);
        this.f56a = null;
        b.m89a(this.f55a).f69a = imVar.a();
        Intent m72a = m72a();
        byte[] a2 = iw.a(aj.a(this.f55a, imVar, hm.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m49a("register fail, because msgBytes is null.");
            return;
        }
        m72a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m72a.putExtra("mipush_app_id", b.m89a(this.f55a).m90a());
        m72a.putExtra("mipush_payload", a2);
        m72a.putExtra("mipush_session", this.f60a);
        m72a.putExtra("mipush_env_chanage", z);
        m72a.putExtra("mipush_env_type", b.m89a(this.f55a).a());
        if (az.b(this.f55a) && m85b()) {
            c(m72a);
        } else {
            this.f56a = m72a;
        }
    }

    public final void a(is isVar) {
        byte[] a2 = iw.a(aj.a(this.f55a, isVar, hm.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m49a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m72a = m72a();
        m72a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m72a.putExtra("mipush_app_id", b.m89a(this.f55a).m90a());
        m72a.putExtra("mipush_payload", a2);
        c(m72a);
    }

    public final <T extends ix<T, ?>> void a(T t, hm hmVar, hz hzVar) {
        a((aq) t, hmVar, !hmVar.equals(hm.Registration), hzVar);
    }

    public <T extends ix<T, ?>> void a(T t, hm hmVar, boolean z) {
        a aVar = new a();
        aVar.f63a = t;
        aVar.a = hmVar;
        aVar.f64a = z;
        synchronized (f54a) {
            f54a.add(aVar);
            if (f54a.size() > 10) {
                f54a.remove(0);
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
        a(t, hmVar, z, z2, hzVar, z3, this.f55a.getPackageName(), b.m89a(this.f55a).m90a());
    }

    public final <T extends ix<T, ?>> void a(T t, hm hmVar, boolean z, boolean z2, hz hzVar, boolean z3, String str, String str2) {
        if (!b.m89a(this.f55a).m98c()) {
            if (z2) {
                a((aq) t, hmVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m49a("drop the message before initialization.");
                return;
            }
        }
        ii a2 = aj.a(this.f55a, t, hmVar, z, str, str2);
        if (hzVar != null) {
            a2.a(hzVar);
        }
        byte[] a3 = iw.a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.m49a("send message fail, because msgBytes is null.");
            return;
        }
        df.a(this.f55a.getPackageName(), this.f55a, t, hmVar, a3.length);
        Intent m72a = m72a();
        m72a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m72a.putExtra("mipush_payload", a3);
        m72a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m72a);
    }

    public final void a(String str, av avVar, d dVar) {
        ag.a(this.f55a).a(avVar, "syncing");
        a(str, avVar, false, h.a(this.f55a, dVar));
    }

    public void a(String str, String str2) {
        Intent m72a = m72a();
        m72a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m72a.putExtra(com.xiaomi.push.service.at.z, this.f55a.getPackageName());
        m72a.putExtra(com.xiaomi.push.service.at.E, str);
        m72a.putExtra(com.xiaomi.push.service.at.F, str2);
        c(m72a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        if (z) {
            ag.a(this.f55a).a(av.DISABLE_PUSH, "syncing");
            ag.a(this.f55a).a(av.ENABLE_PUSH, "");
            a(str, av.DISABLE_PUSH, true, (HashMap<String, String>) null);
            return;
        }
        ag.a(this.f55a).a(av.ENABLE_PUSH, "syncing");
        ag.a(this.f55a).a(av.DISABLE_PUSH, "");
        a(str, av.ENABLE_PUSH, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m82a() {
        return this.f62a && 1 == b.m89a(this.f55a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m83a(int i) {
        if (b.m89a(this.f55a).m96b()) {
            c(i);
            il ilVar = new il();
            ilVar.a(com.xiaomi.push.service.an.a());
            ilVar.b(b.m89a(this.f55a).m90a());
            ilVar.d(this.f55a.getPackageName());
            ilVar.c(hw.ClientABTest.f481a);
            ilVar.f622a = new HashMap();
            ilVar.f622a.put("boot_mode", i + "");
            a(this.f55a).a((aq) ilVar, hm.Notification, false, (hz) null);
            return true;
        }
        return false;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m84b() {
        Intent m72a = m72a();
        m72a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(m72a);
    }

    public void b(int i) {
        Intent m72a = m72a();
        m72a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m72a.putExtra(com.xiaomi.push.service.at.z, this.f55a.getPackageName());
        m72a.putExtra(com.xiaomi.push.service.at.B, i);
        m72a.putExtra(com.xiaomi.push.service.at.D, be.b(this.f55a.getPackageName() + i));
        c(m72a);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m85b() {
        if (m82a() && m79e()) {
            if (this.f59a == null) {
                this.f59a = Integer.valueOf(com.xiaomi.push.service.aw.a(this.f55a).a());
                if (this.f59a.intValue() == 0) {
                    this.f55a.getContentResolver().registerContentObserver(com.xiaomi.push.service.aw.a(this.f55a).m547a(), false, new as(this, new Handler(Looper.getMainLooper())));
                }
            }
            return this.f59a.intValue() != 0;
        }
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m86c() {
        if (this.f56a != null) {
            c(this.f56a);
            this.f56a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m87d() {
        synchronized (f54a) {
            Iterator<a> it = f54a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f63a, next.a, next.f64a, false, null, true);
            }
            f54a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m88e() {
        Intent m72a = m72a();
        m72a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m72a.putExtra(com.xiaomi.push.service.at.z, this.f55a.getPackageName());
        m72a.putExtra(com.xiaomi.push.service.at.D, be.b(this.f55a.getPackageName()));
        c(m72a);
    }
}
