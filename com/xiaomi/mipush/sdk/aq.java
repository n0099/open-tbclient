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
/* loaded from: classes18.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    private static aq f4754a;

    /* renamed from: a  reason: collision with other field name */
    private Context f53a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f55a;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f56a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f60a;
    private static boolean b = false;

    /* renamed from: a  reason: collision with other field name */
    private static final ArrayList<a> f52a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f59a = new ArrayList();
    private boolean c = false;

    /* renamed from: a  reason: collision with other field name */
    private Intent f54a = null;

    /* renamed from: a  reason: collision with other field name */
    private Integer f57a = null;

    /* renamed from: a  reason: collision with other field name */
    private String f58a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class a<T extends ix<T, ?>> {

        /* renamed from: a  reason: collision with root package name */
        hm f4755a;

        /* renamed from: a  reason: collision with other field name */
        T f61a;

        /* renamed from: a  reason: collision with other field name */
        boolean f62a;

        a() {
        }
    }

    private aq(Context context) {
        this.f60a = false;
        this.f55a = null;
        this.f53a = context.getApplicationContext();
        this.f60a = m85c();
        b = m86d();
        this.f55a = new ar(this, Looper.getMainLooper());
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        return this.f53a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m80a() {
        return (!m90a() || "com.xiaomi.xmsf".equals(this.f53a.getPackageName())) ? e() : d();
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
            if (f4754a == null) {
                f4754a = new aq(context);
            }
            aqVar = f4754a;
        }
        return aqVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m83a() {
        return this.f53a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, av avVar, boolean z, HashMap<String, String> hashMap) {
        il ilVar;
        if (b.m97a(this.f53a).m104b() && az.b(this.f53a)) {
            il ilVar2 = new il();
            ilVar2.a(true);
            Intent m80a = m80a();
            if (TextUtils.isEmpty(str)) {
                str = com.xiaomi.push.service.an.a();
                ilVar2.a(str);
                il ilVar3 = z ? new il(str, true) : null;
                synchronized (ag.class) {
                    ag.a(this.f53a).m76a(str);
                }
                ilVar = ilVar3;
            } else {
                ilVar2.a(str);
                ilVar = z ? new il(str, true) : null;
            }
            switch (au.f4759a[avVar.ordinal()]) {
                case 1:
                    ilVar2.c(hw.DisablePushMessage.f479a);
                    ilVar.c(hw.DisablePushMessage.f479a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        ilVar.a(hashMap);
                    }
                    m80a.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    ilVar2.c(hw.EnablePushMessage.f479a);
                    ilVar.c(hw.EnablePushMessage.f479a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        ilVar.a(hashMap);
                    }
                    m80a.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    ilVar2.c(hw.ThirdPartyRegUpdate.f479a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            ilVar2.b(b.m97a(this.f53a).m98a());
            ilVar2.d(this.f53a.getPackageName());
            a((aq) ilVar2, hm.Notification, false, (hz) null);
            if (z) {
                ilVar.b(b.m97a(this.f53a).m98a());
                ilVar.d(this.f53a.getPackageName());
                byte[] a2 = iw.a(aj.a(this.f53a, ilVar, hm.Notification, false, this.f53a.getPackageName(), b.m97a(this.f53a).m98a()));
                if (a2 != null) {
                    df.a(this.f53a.getPackageName(), this.f53a, ilVar, hm.Notification, a2.length);
                    m80a.putExtra("mipush_payload", a2);
                    m80a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m80a.putExtra("mipush_app_id", b.m97a(this.f53a).m98a());
                    m80a.putExtra("mipush_app_token", b.m97a(this.f53a).b());
                    c(m80a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = avVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f55a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        if ("com.xiaomi.xmsf".equals(this.f53a.getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
            return e();
        }
        return c();
    }

    private void b(Intent intent) {
        try {
            if (com.xiaomi.push.l.m503a() || Build.VERSION.SDK_INT < 26) {
                this.f53a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
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

    private synchronized void c(int i) {
        this.f53a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private void c(Intent intent) {
        int a2 = com.xiaomi.push.service.ak.a(this.f53a).a(hr.ServiceBootMode.a(), hn.START.a());
        int a3 = a();
        boolean z = a2 == hn.BIND.a() && b;
        int a4 = z ? hn.BIND.a() : hn.START.a();
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
            PackageInfo packageInfo = this.f53a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
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
        String packageName = this.f53a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m83a());
        intent.putExtra("mipush_app_package", packageName);
        f();
        return intent;
    }

    private synchronized void d(Intent intent) {
        if (this.c) {
            Message a2 = a(intent);
            if (this.f59a.size() >= 50) {
                this.f59a.remove(0);
            }
            this.f59a.add(a2);
        } else if (this.f56a == null) {
            Context context = this.f53a;
            at atVar = new at(this);
            Context context2 = this.f53a;
            context.bindService(intent, atVar, 1);
            this.c = true;
            this.f59a.clear();
            this.f59a.add(a(intent));
        } else {
            try {
                this.f56a.send(a(intent));
            } catch (RemoteException e) {
                this.f56a = null;
                this.c = false;
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m86d() {
        if (m90a()) {
            try {
                return this.f53a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception e) {
                return true;
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f53a.getPackageName();
        g();
        intent.setComponent(new ComponentName(this.f53a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m87e() {
        String packageName = this.f53a.getPackageName();
        return packageName.contains("miui") || packageName.contains(RomUtils.MANUFACTURER_XIAOMI) || (this.f53a.getApplicationInfo().flags & 1) != 0;
    }

    private void f() {
        try {
            PackageManager packageManager = this.f53a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f53a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable th) {
        }
    }

    private void g() {
        try {
            PackageManager packageManager = this.f53a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f53a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable th) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m88a() {
        b(m80a());
    }

    public void a(int i) {
        Intent m80a = m80a();
        m80a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m80a.putExtra(com.xiaomi.push.service.at.z, this.f53a.getPackageName());
        m80a.putExtra(com.xiaomi.push.service.at.A, i);
        c(m80a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, String str) {
        Intent m80a = m80a();
        m80a.setAction("com.xiaomi.mipush.thirdparty");
        m80a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        m80a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m80a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m89a(Intent intent) {
        intent.fillIn(m80a(), 24);
        c(intent);
    }

    public final void a(hq hqVar) {
        Intent m80a = m80a();
        byte[] a2 = iw.a(hqVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m57a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m80a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m80a.putExtra("mipush_payload", a2);
        b(m80a);
    }

    public final void a(im imVar, boolean z) {
        fb.a(this.f53a.getApplicationContext()).a(this.f53a.getPackageName(), "E100003", imVar.a(), ARPMessageType.MSG_TYPE_MODEL_LOAD_PROGRESS, null);
        this.f54a = null;
        b.m97a(this.f53a).f67a = imVar.a();
        Intent m80a = m80a();
        byte[] a2 = iw.a(aj.a(this.f53a, imVar, hm.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m57a("register fail, because msgBytes is null.");
            return;
        }
        m80a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m80a.putExtra("mipush_app_id", b.m97a(this.f53a).m98a());
        m80a.putExtra("mipush_payload", a2);
        m80a.putExtra("mipush_session", this.f58a);
        m80a.putExtra("mipush_env_chanage", z);
        m80a.putExtra("mipush_env_type", b.m97a(this.f53a).a());
        if (az.b(this.f53a) && m93b()) {
            c(m80a);
        } else {
            this.f54a = m80a;
        }
    }

    public final void a(is isVar) {
        byte[] a2 = iw.a(aj.a(this.f53a, isVar, hm.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m57a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m80a = m80a();
        m80a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m80a.putExtra("mipush_app_id", b.m97a(this.f53a).m98a());
        m80a.putExtra("mipush_payload", a2);
        c(m80a);
    }

    public final <T extends ix<T, ?>> void a(T t, hm hmVar, hz hzVar) {
        a((aq) t, hmVar, !hmVar.equals(hm.Registration), hzVar);
    }

    public <T extends ix<T, ?>> void a(T t, hm hmVar, boolean z) {
        a aVar = new a();
        aVar.f61a = t;
        aVar.f4755a = hmVar;
        aVar.f62a = z;
        synchronized (f52a) {
            f52a.add(aVar);
            if (f52a.size() > 10) {
                f52a.remove(0);
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
        a(t, hmVar, z, z2, hzVar, z3, this.f53a.getPackageName(), b.m97a(this.f53a).m98a());
    }

    public final <T extends ix<T, ?>> void a(T t, hm hmVar, boolean z, boolean z2, hz hzVar, boolean z3, String str, String str2) {
        if (!b.m97a(this.f53a).m106c()) {
            if (z2) {
                a((aq) t, hmVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m57a("drop the message before initialization.");
                return;
            }
        }
        ii a2 = aj.a(this.f53a, t, hmVar, z, str, str2);
        if (hzVar != null) {
            a2.a(hzVar);
        }
        byte[] a3 = iw.a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.m57a("send message fail, because msgBytes is null.");
            return;
        }
        df.a(this.f53a.getPackageName(), this.f53a, t, hmVar, a3.length);
        Intent m80a = m80a();
        m80a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m80a.putExtra("mipush_payload", a3);
        m80a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m80a);
    }

    public final void a(String str, av avVar, d dVar) {
        ag.a(this.f53a).a(avVar, "syncing");
        a(str, avVar, false, h.a(this.f53a, dVar));
    }

    public void a(String str, String str2) {
        Intent m80a = m80a();
        m80a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m80a.putExtra(com.xiaomi.push.service.at.z, this.f53a.getPackageName());
        m80a.putExtra(com.xiaomi.push.service.at.E, str);
        m80a.putExtra(com.xiaomi.push.service.at.F, str2);
        c(m80a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        if (z) {
            ag.a(this.f53a).a(av.DISABLE_PUSH, "syncing");
            ag.a(this.f53a).a(av.ENABLE_PUSH, "");
            a(str, av.DISABLE_PUSH, true, (HashMap<String, String>) null);
            return;
        }
        ag.a(this.f53a).a(av.ENABLE_PUSH, "syncing");
        ag.a(this.f53a).a(av.DISABLE_PUSH, "");
        a(str, av.ENABLE_PUSH, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m90a() {
        return this.f60a && 1 == b.m97a(this.f53a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m91a(int i) {
        if (b.m97a(this.f53a).m104b()) {
            c(i);
            il ilVar = new il();
            ilVar.a(com.xiaomi.push.service.an.a());
            ilVar.b(b.m97a(this.f53a).m98a());
            ilVar.d(this.f53a.getPackageName());
            ilVar.c(hw.ClientABTest.f479a);
            ilVar.f620a = new HashMap();
            ilVar.f620a.put("boot_mode", i + "");
            a(this.f53a).a((aq) ilVar, hm.Notification, false, (hz) null);
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

    public void b(int i) {
        Intent m80a = m80a();
        m80a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m80a.putExtra(com.xiaomi.push.service.at.z, this.f53a.getPackageName());
        m80a.putExtra(com.xiaomi.push.service.at.B, i);
        m80a.putExtra(com.xiaomi.push.service.at.D, be.b(this.f53a.getPackageName() + i));
        c(m80a);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m93b() {
        if (m90a() && m87e()) {
            if (this.f57a == null) {
                this.f57a = Integer.valueOf(com.xiaomi.push.service.aw.a(this.f53a).a());
                if (this.f57a.intValue() == 0) {
                    this.f53a.getContentResolver().registerContentObserver(com.xiaomi.push.service.aw.a(this.f53a).m555a(), false, new as(this, new Handler(Looper.getMainLooper())));
                }
            }
            return this.f57a.intValue() != 0;
        }
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m94c() {
        if (this.f54a != null) {
            c(this.f54a);
            this.f54a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m95d() {
        synchronized (f52a) {
            Iterator<a> it = f52a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f61a, next.f4755a, next.f62a, false, null, true);
            }
            f52a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m96e() {
        Intent m80a = m80a();
        m80a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m80a.putExtra(com.xiaomi.push.service.at.z, this.f53a.getPackageName());
        m80a.putExtra(com.xiaomi.push.service.at.D, be.b(this.f53a.getPackageName()));
        c(m80a);
    }
}
