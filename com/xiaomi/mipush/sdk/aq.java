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
/* loaded from: classes8.dex */
public class aq {
    private static aq a;

    /* renamed from: a  reason: collision with other field name */
    private Context f49a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f51a;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f52a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f56a;
    private static boolean b = false;

    /* renamed from: a  reason: collision with other field name */
    private static final ArrayList<a> f48a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f55a = new ArrayList();
    private boolean c = false;

    /* renamed from: a  reason: collision with other field name */
    private Intent f50a = null;

    /* renamed from: a  reason: collision with other field name */
    private Integer f53a = null;

    /* renamed from: a  reason: collision with other field name */
    private String f54a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a<T extends ix<T, ?>> {
        hm a;

        /* renamed from: a  reason: collision with other field name */
        T f57a;

        /* renamed from: a  reason: collision with other field name */
        boolean f58a;

        a() {
        }
    }

    private aq(Context context) {
        this.f56a = false;
        this.f51a = null;
        this.f49a = context.getApplicationContext();
        this.f56a = m78c();
        b = m79d();
        this.f51a = new ar(this, Looper.getMainLooper());
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        return this.f49a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m73a() {
        return (!m83a() || "com.xiaomi.xmsf".equals(this.f49a.getPackageName())) ? e() : d();
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
    private String m76a() {
        return this.f49a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, av avVar, boolean z, HashMap<String, String> hashMap) {
        il ilVar;
        if (b.m90a(this.f49a).m97b() && az.b(this.f49a)) {
            il ilVar2 = new il();
            ilVar2.a(true);
            Intent m73a = m73a();
            if (TextUtils.isEmpty(str)) {
                str = com.xiaomi.push.service.an.a();
                ilVar2.a(str);
                il ilVar3 = z ? new il(str, true) : null;
                synchronized (ag.class) {
                    ag.a(this.f49a).m69a(str);
                }
                ilVar = ilVar3;
            } else {
                ilVar2.a(str);
                ilVar = z ? new il(str, true) : null;
            }
            switch (au.a[avVar.ordinal()]) {
                case 1:
                    ilVar2.c(hw.DisablePushMessage.f475a);
                    ilVar.c(hw.DisablePushMessage.f475a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        ilVar.a(hashMap);
                    }
                    m73a.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    ilVar2.c(hw.EnablePushMessage.f475a);
                    ilVar.c(hw.EnablePushMessage.f475a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        ilVar.a(hashMap);
                    }
                    m73a.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    ilVar2.c(hw.ThirdPartyRegUpdate.f475a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            ilVar2.b(b.m90a(this.f49a).m91a());
            ilVar2.d(this.f49a.getPackageName());
            a((aq) ilVar2, hm.Notification, false, (hz) null);
            if (z) {
                ilVar.b(b.m90a(this.f49a).m91a());
                ilVar.d(this.f49a.getPackageName());
                byte[] a2 = iw.a(aj.a(this.f49a, ilVar, hm.Notification, false, this.f49a.getPackageName(), b.m90a(this.f49a).m91a()));
                if (a2 != null) {
                    df.a(this.f49a.getPackageName(), this.f49a, ilVar, hm.Notification, a2.length);
                    m73a.putExtra("mipush_payload", a2);
                    m73a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m73a.putExtra("mipush_app_id", b.m90a(this.f49a).m91a());
                    m73a.putExtra("mipush_app_token", b.m90a(this.f49a).b());
                    c(m73a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = avVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f51a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        if ("com.xiaomi.xmsf".equals(this.f49a.getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
            return e();
        }
        return c();
    }

    private void b(Intent intent) {
        try {
            if (com.xiaomi.push.l.m496a() || Build.VERSION.SDK_INT < 26) {
                this.f49a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private Intent c() {
        if (m83a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    private synchronized void c(int i) {
        this.f49a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private void c(Intent intent) {
        int a2 = com.xiaomi.push.service.ak.a(this.f49a).a(hr.ServiceBootMode.a(), hn.START.a());
        int a3 = a();
        boolean z = a2 == hn.BIND.a() && b;
        int a4 = z ? hn.BIND.a() : hn.START.a();
        if (a4 != a3) {
            m84a(a4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m78c() {
        try {
            PackageInfo packageInfo = this.f49a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
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
        String packageName = this.f49a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m76a());
        intent.putExtra("mipush_app_package", packageName);
        f();
        return intent;
    }

    private synchronized void d(Intent intent) {
        if (this.c) {
            Message a2 = a(intent);
            if (this.f55a.size() >= 50) {
                this.f55a.remove(0);
            }
            this.f55a.add(a2);
        } else if (this.f52a == null) {
            Context context = this.f49a;
            at atVar = new at(this);
            Context context2 = this.f49a;
            context.bindService(intent, atVar, 1);
            this.c = true;
            this.f55a.clear();
            this.f55a.add(a(intent));
        } else {
            try {
                this.f52a.send(a(intent));
            } catch (RemoteException e) {
                this.f52a = null;
                this.c = false;
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m79d() {
        if (m83a()) {
            try {
                return this.f49a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception e) {
                return true;
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f49a.getPackageName();
        g();
        intent.setComponent(new ComponentName(this.f49a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m80e() {
        String packageName = this.f49a.getPackageName();
        return packageName.contains("miui") || packageName.contains(RomUtils.MANUFACTURER_XIAOMI) || (this.f49a.getApplicationInfo().flags & 1) != 0;
    }

    private void f() {
        try {
            PackageManager packageManager = this.f49a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f49a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable th) {
        }
    }

    private void g() {
        try {
            PackageManager packageManager = this.f49a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f49a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable th) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m81a() {
        b(m73a());
    }

    public void a(int i) {
        Intent m73a = m73a();
        m73a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m73a.putExtra(com.xiaomi.push.service.at.z, this.f49a.getPackageName());
        m73a.putExtra(com.xiaomi.push.service.at.A, i);
        c(m73a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, String str) {
        Intent m73a = m73a();
        m73a.setAction("com.xiaomi.mipush.thirdparty");
        m73a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        m73a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m73a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m82a(Intent intent) {
        intent.fillIn(m73a(), 24);
        c(intent);
    }

    public final void a(hq hqVar) {
        Intent m73a = m73a();
        byte[] a2 = iw.a(hqVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m73a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m73a.putExtra("mipush_payload", a2);
        b(m73a);
    }

    public final void a(im imVar, boolean z) {
        fb.a(this.f49a.getApplicationContext()).a(this.f49a.getPackageName(), "E100003", imVar.a(), ARPMessageType.MSG_TYPE_MODEL_LOAD_PROGRESS, null);
        this.f50a = null;
        b.m90a(this.f49a).f63a = imVar.a();
        Intent m73a = m73a();
        byte[] a2 = iw.a(aj.a(this.f49a, imVar, hm.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("register fail, because msgBytes is null.");
            return;
        }
        m73a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m73a.putExtra("mipush_app_id", b.m90a(this.f49a).m91a());
        m73a.putExtra("mipush_payload", a2);
        m73a.putExtra("mipush_session", this.f54a);
        m73a.putExtra("mipush_env_chanage", z);
        m73a.putExtra("mipush_env_type", b.m90a(this.f49a).a());
        if (az.b(this.f49a) && m86b()) {
            c(m73a);
        } else {
            this.f50a = m73a;
        }
    }

    public final void a(is isVar) {
        byte[] a2 = iw.a(aj.a(this.f49a, isVar, hm.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m73a = m73a();
        m73a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m73a.putExtra("mipush_app_id", b.m90a(this.f49a).m91a());
        m73a.putExtra("mipush_payload", a2);
        c(m73a);
    }

    public final <T extends ix<T, ?>> void a(T t, hm hmVar, hz hzVar) {
        a((aq) t, hmVar, !hmVar.equals(hm.Registration), hzVar);
    }

    public <T extends ix<T, ?>> void a(T t, hm hmVar, boolean z) {
        a aVar = new a();
        aVar.f57a = t;
        aVar.a = hmVar;
        aVar.f58a = z;
        synchronized (f48a) {
            f48a.add(aVar);
            if (f48a.size() > 10) {
                f48a.remove(0);
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
        a(t, hmVar, z, z2, hzVar, z3, this.f49a.getPackageName(), b.m90a(this.f49a).m91a());
    }

    public final <T extends ix<T, ?>> void a(T t, hm hmVar, boolean z, boolean z2, hz hzVar, boolean z3, String str, String str2) {
        if (!b.m90a(this.f49a).m99c()) {
            if (z2) {
                a((aq) t, hmVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m50a("drop the message before initialization.");
                return;
            }
        }
        ii a2 = aj.a(this.f49a, t, hmVar, z, str, str2);
        if (hzVar != null) {
            a2.a(hzVar);
        }
        byte[] a3 = iw.a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("send message fail, because msgBytes is null.");
            return;
        }
        df.a(this.f49a.getPackageName(), this.f49a, t, hmVar, a3.length);
        Intent m73a = m73a();
        m73a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m73a.putExtra("mipush_payload", a3);
        m73a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m73a);
    }

    public final void a(String str, av avVar, d dVar) {
        ag.a(this.f49a).a(avVar, "syncing");
        a(str, avVar, false, h.a(this.f49a, dVar));
    }

    public void a(String str, String str2) {
        Intent m73a = m73a();
        m73a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m73a.putExtra(com.xiaomi.push.service.at.z, this.f49a.getPackageName());
        m73a.putExtra(com.xiaomi.push.service.at.E, str);
        m73a.putExtra(com.xiaomi.push.service.at.F, str2);
        c(m73a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        if (z) {
            ag.a(this.f49a).a(av.DISABLE_PUSH, "syncing");
            ag.a(this.f49a).a(av.ENABLE_PUSH, "");
            a(str, av.DISABLE_PUSH, true, (HashMap<String, String>) null);
            return;
        }
        ag.a(this.f49a).a(av.ENABLE_PUSH, "syncing");
        ag.a(this.f49a).a(av.DISABLE_PUSH, "");
        a(str, av.ENABLE_PUSH, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m83a() {
        return this.f56a && 1 == b.m90a(this.f49a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m84a(int i) {
        if (b.m90a(this.f49a).m97b()) {
            c(i);
            il ilVar = new il();
            ilVar.a(com.xiaomi.push.service.an.a());
            ilVar.b(b.m90a(this.f49a).m91a());
            ilVar.d(this.f49a.getPackageName());
            ilVar.c(hw.ClientABTest.f475a);
            ilVar.f616a = new HashMap();
            ilVar.f616a.put("boot_mode", i + "");
            a(this.f49a).a((aq) ilVar, hm.Notification, false, (hz) null);
            return true;
        }
        return false;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m85b() {
        Intent m73a = m73a();
        m73a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(m73a);
    }

    public void b(int i) {
        Intent m73a = m73a();
        m73a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m73a.putExtra(com.xiaomi.push.service.at.z, this.f49a.getPackageName());
        m73a.putExtra(com.xiaomi.push.service.at.B, i);
        m73a.putExtra(com.xiaomi.push.service.at.D, be.b(this.f49a.getPackageName() + i));
        c(m73a);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m86b() {
        if (m83a() && m80e()) {
            if (this.f53a == null) {
                this.f53a = Integer.valueOf(com.xiaomi.push.service.aw.a(this.f49a).a());
                if (this.f53a.intValue() == 0) {
                    this.f49a.getContentResolver().registerContentObserver(com.xiaomi.push.service.aw.a(this.f49a).m548a(), false, new as(this, new Handler(Looper.getMainLooper())));
                }
            }
            return this.f53a.intValue() != 0;
        }
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m87c() {
        if (this.f50a != null) {
            c(this.f50a);
            this.f50a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m88d() {
        synchronized (f48a) {
            Iterator<a> it = f48a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f57a, next.a, next.f58a, false, null, true);
            }
            f48a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m89e() {
        Intent m73a = m73a();
        m73a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m73a.putExtra(com.xiaomi.push.service.at.z, this.f49a.getPackageName());
        m73a.putExtra(com.xiaomi.push.service.at.D, be.b(this.f49a.getPackageName()));
        c(m73a);
    }
}
