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
    private static aq f14109a;

    /* renamed from: a  reason: collision with other field name */
    private Context f130a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f132a;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f133a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f137a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f14110b = false;

    /* renamed from: a  reason: collision with other field name */
    private static final ArrayList<a> f129a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f136a = new ArrayList();
    private boolean c = false;

    /* renamed from: a  reason: collision with other field name */
    private Intent f131a = null;

    /* renamed from: a  reason: collision with other field name */
    private Integer f134a = null;

    /* renamed from: a  reason: collision with other field name */
    private String f135a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a<T extends ix<T, ?>> {

        /* renamed from: a  reason: collision with root package name */
        hm f14111a;

        /* renamed from: a  reason: collision with other field name */
        T f138a;

        /* renamed from: a  reason: collision with other field name */
        boolean f139a;

        a() {
        }
    }

    private aq(Context context) {
        this.f137a = false;
        this.f132a = null;
        this.f130a = context.getApplicationContext();
        this.f137a = m112c();
        f14110b = m113d();
        this.f132a = new ar(this, Looper.getMainLooper());
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        return this.f130a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m107a() {
        return (!m117a() || "com.xiaomi.xmsf".equals(this.f130a.getPackageName())) ? e() : d();
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
            if (f14109a == null) {
                f14109a = new aq(context);
            }
            aqVar = f14109a;
        }
        return aqVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m110a() {
        return this.f130a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, av avVar, boolean z, HashMap<String, String> hashMap) {
        il ilVar;
        if (b.m124a(this.f130a).m131b() && az.b(this.f130a)) {
            il ilVar2 = new il();
            ilVar2.a(true);
            Intent m107a = m107a();
            if (TextUtils.isEmpty(str)) {
                str = com.xiaomi.push.service.an.a();
                ilVar2.a(str);
                il ilVar3 = z ? new il(str, true) : null;
                synchronized (ag.class) {
                    ag.a(this.f130a).m103a(str);
                }
                ilVar = ilVar3;
            } else {
                ilVar2.a(str);
                ilVar = z ? new il(str, true) : null;
            }
            switch (au.f14115a[avVar.ordinal()]) {
                case 1:
                    ilVar2.c(hw.DisablePushMessage.f556a);
                    ilVar.c(hw.DisablePushMessage.f556a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        ilVar.a(hashMap);
                    }
                    m107a.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    ilVar2.c(hw.EnablePushMessage.f556a);
                    ilVar.c(hw.EnablePushMessage.f556a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        ilVar.a(hashMap);
                    }
                    m107a.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    ilVar2.c(hw.ThirdPartyRegUpdate.f556a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            ilVar2.b(b.m124a(this.f130a).m125a());
            ilVar2.d(this.f130a.getPackageName());
            a((aq) ilVar2, hm.Notification, false, (hz) null);
            if (z) {
                ilVar.b(b.m124a(this.f130a).m125a());
                ilVar.d(this.f130a.getPackageName());
                byte[] a2 = iw.a(aj.a(this.f130a, ilVar, hm.Notification, false, this.f130a.getPackageName(), b.m124a(this.f130a).m125a()));
                if (a2 != null) {
                    df.a(this.f130a.getPackageName(), this.f130a, ilVar, hm.Notification, a2.length);
                    m107a.putExtra("mipush_payload", a2);
                    m107a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m107a.putExtra("mipush_app_id", b.m124a(this.f130a).m125a());
                    m107a.putExtra("mipush_app_token", b.m124a(this.f130a).b());
                    c(m107a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = avVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f132a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        if ("com.xiaomi.xmsf".equals(this.f130a.getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
            return e();
        }
        return c();
    }

    private void b(Intent intent) {
        try {
            if (com.xiaomi.push.l.m530a() || Build.VERSION.SDK_INT < 26) {
                this.f130a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private Intent c() {
        if (m117a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    private synchronized void c(int i) {
        this.f130a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private void c(Intent intent) {
        int a2 = com.xiaomi.push.service.ak.a(this.f130a).a(hr.ServiceBootMode.a(), hn.START.a());
        int a3 = a();
        boolean z = a2 == hn.BIND.a() && f14110b;
        int a4 = z ? hn.BIND.a() : hn.START.a();
        if (a4 != a3) {
            m118a(a4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m112c() {
        try {
            PackageInfo packageInfo = this.f130a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
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
        String packageName = this.f130a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m110a());
        intent.putExtra("mipush_app_package", packageName);
        f();
        return intent;
    }

    private synchronized void d(Intent intent) {
        if (this.c) {
            Message a2 = a(intent);
            if (this.f136a.size() >= 50) {
                this.f136a.remove(0);
            }
            this.f136a.add(a2);
        } else if (this.f133a == null) {
            Context context = this.f130a;
            at atVar = new at(this);
            Context context2 = this.f130a;
            context.bindService(intent, atVar, 1);
            this.c = true;
            this.f136a.clear();
            this.f136a.add(a(intent));
        } else {
            try {
                this.f133a.send(a(intent));
            } catch (RemoteException e) {
                this.f133a = null;
                this.c = false;
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m113d() {
        if (m117a()) {
            try {
                return this.f130a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception e) {
                return true;
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f130a.getPackageName();
        g();
        intent.setComponent(new ComponentName(this.f130a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m114e() {
        String packageName = this.f130a.getPackageName();
        return packageName.contains("miui") || packageName.contains(RomUtils.MANUFACTURER_XIAOMI) || (this.f130a.getApplicationInfo().flags & 1) != 0;
    }

    private void f() {
        try {
            PackageManager packageManager = this.f130a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f130a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable th) {
        }
    }

    private void g() {
        try {
            PackageManager packageManager = this.f130a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f130a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable th) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m115a() {
        b(m107a());
    }

    public void a(int i) {
        Intent m107a = m107a();
        m107a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m107a.putExtra(com.xiaomi.push.service.at.z, this.f130a.getPackageName());
        m107a.putExtra(com.xiaomi.push.service.at.A, i);
        c(m107a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, String str) {
        Intent m107a = m107a();
        m107a.setAction("com.xiaomi.mipush.thirdparty");
        m107a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        m107a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m107a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m116a(Intent intent) {
        intent.fillIn(m107a(), 24);
        c(intent);
    }

    public final void a(hq hqVar) {
        Intent m107a = m107a();
        byte[] a2 = iw.a(hqVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m84a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m107a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m107a.putExtra("mipush_payload", a2);
        b(m107a);
    }

    public final void a(im imVar, boolean z) {
        fb.a(this.f130a.getApplicationContext()).a(this.f130a.getPackageName(), "E100003", imVar.a(), ARPMessageType.MSG_TYPE_MODEL_LOAD_PROGRESS, null);
        this.f131a = null;
        b.m124a(this.f130a).f144a = imVar.a();
        Intent m107a = m107a();
        byte[] a2 = iw.a(aj.a(this.f130a, imVar, hm.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m84a("register fail, because msgBytes is null.");
            return;
        }
        m107a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m107a.putExtra("mipush_app_id", b.m124a(this.f130a).m125a());
        m107a.putExtra("mipush_payload", a2);
        m107a.putExtra("mipush_session", this.f135a);
        m107a.putExtra("mipush_env_chanage", z);
        m107a.putExtra("mipush_env_type", b.m124a(this.f130a).a());
        if (az.b(this.f130a) && m120b()) {
            c(m107a);
        } else {
            this.f131a = m107a;
        }
    }

    public final void a(is isVar) {
        byte[] a2 = iw.a(aj.a(this.f130a, isVar, hm.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m84a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m107a = m107a();
        m107a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m107a.putExtra("mipush_app_id", b.m124a(this.f130a).m125a());
        m107a.putExtra("mipush_payload", a2);
        c(m107a);
    }

    public final <T extends ix<T, ?>> void a(T t, hm hmVar, hz hzVar) {
        a((aq) t, hmVar, !hmVar.equals(hm.Registration), hzVar);
    }

    public <T extends ix<T, ?>> void a(T t, hm hmVar, boolean z) {
        a aVar = new a();
        aVar.f138a = t;
        aVar.f14111a = hmVar;
        aVar.f139a = z;
        synchronized (f129a) {
            f129a.add(aVar);
            if (f129a.size() > 10) {
                f129a.remove(0);
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
        a(t, hmVar, z, z2, hzVar, z3, this.f130a.getPackageName(), b.m124a(this.f130a).m125a());
    }

    public final <T extends ix<T, ?>> void a(T t, hm hmVar, boolean z, boolean z2, hz hzVar, boolean z3, String str, String str2) {
        if (!b.m124a(this.f130a).m133c()) {
            if (z2) {
                a((aq) t, hmVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m84a("drop the message before initialization.");
                return;
            }
        }
        ii a2 = aj.a(this.f130a, t, hmVar, z, str, str2);
        if (hzVar != null) {
            a2.a(hzVar);
        }
        byte[] a3 = iw.a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.m84a("send message fail, because msgBytes is null.");
            return;
        }
        df.a(this.f130a.getPackageName(), this.f130a, t, hmVar, a3.length);
        Intent m107a = m107a();
        m107a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m107a.putExtra("mipush_payload", a3);
        m107a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m107a);
    }

    public final void a(String str, av avVar, d dVar) {
        ag.a(this.f130a).a(avVar, "syncing");
        a(str, avVar, false, h.a(this.f130a, dVar));
    }

    public void a(String str, String str2) {
        Intent m107a = m107a();
        m107a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m107a.putExtra(com.xiaomi.push.service.at.z, this.f130a.getPackageName());
        m107a.putExtra(com.xiaomi.push.service.at.E, str);
        m107a.putExtra(com.xiaomi.push.service.at.F, str2);
        c(m107a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        if (z) {
            ag.a(this.f130a).a(av.DISABLE_PUSH, "syncing");
            ag.a(this.f130a).a(av.ENABLE_PUSH, "");
            a(str, av.DISABLE_PUSH, true, (HashMap<String, String>) null);
            return;
        }
        ag.a(this.f130a).a(av.ENABLE_PUSH, "syncing");
        ag.a(this.f130a).a(av.DISABLE_PUSH, "");
        a(str, av.ENABLE_PUSH, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m117a() {
        return this.f137a && 1 == b.m124a(this.f130a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m118a(int i) {
        if (b.m124a(this.f130a).m131b()) {
            c(i);
            il ilVar = new il();
            ilVar.a(com.xiaomi.push.service.an.a());
            ilVar.b(b.m124a(this.f130a).m125a());
            ilVar.d(this.f130a.getPackageName());
            ilVar.c(hw.ClientABTest.f556a);
            ilVar.f697a = new HashMap();
            ilVar.f697a.put("boot_mode", i + "");
            a(this.f130a).a((aq) ilVar, hm.Notification, false, (hz) null);
            return true;
        }
        return false;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m119b() {
        Intent m107a = m107a();
        m107a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(m107a);
    }

    public void b(int i) {
        Intent m107a = m107a();
        m107a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m107a.putExtra(com.xiaomi.push.service.at.z, this.f130a.getPackageName());
        m107a.putExtra(com.xiaomi.push.service.at.B, i);
        m107a.putExtra(com.xiaomi.push.service.at.D, be.b(this.f130a.getPackageName() + i));
        c(m107a);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m120b() {
        if (m117a() && m114e()) {
            if (this.f134a == null) {
                this.f134a = Integer.valueOf(com.xiaomi.push.service.aw.a(this.f130a).a());
                if (this.f134a.intValue() == 0) {
                    this.f130a.getContentResolver().registerContentObserver(com.xiaomi.push.service.aw.a(this.f130a).m582a(), false, new as(this, new Handler(Looper.getMainLooper())));
                }
            }
            return this.f134a.intValue() != 0;
        }
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m121c() {
        if (this.f131a != null) {
            c(this.f131a);
            this.f131a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m122d() {
        synchronized (f129a) {
            Iterator<a> it = f129a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f138a, next.f14111a, next.f139a, false, null, true);
            }
            f129a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m123e() {
        Intent m107a = m107a();
        m107a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m107a.putExtra(com.xiaomi.push.service.at.z, this.f130a.getPackageName());
        m107a.putExtra(com.xiaomi.push.service.at.D, be.b(this.f130a.getPackageName()));
        c(m107a);
    }
}
