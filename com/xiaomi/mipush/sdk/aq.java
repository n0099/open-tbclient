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
/* loaded from: classes7.dex */
public class aq {
    private static aq a;

    /* renamed from: a  reason: collision with other field name */
    private Context f51a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f53a;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f54a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f58a;
    private static boolean b = false;

    /* renamed from: a  reason: collision with other field name */
    private static final ArrayList<a> f50a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f57a = new ArrayList();
    private boolean c = false;

    /* renamed from: a  reason: collision with other field name */
    private Intent f52a = null;

    /* renamed from: a  reason: collision with other field name */
    private Integer f55a = null;

    /* renamed from: a  reason: collision with other field name */
    private String f56a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a<T extends ix<T, ?>> {
        hm a;

        /* renamed from: a  reason: collision with other field name */
        T f59a;

        /* renamed from: a  reason: collision with other field name */
        boolean f60a;

        a() {
        }
    }

    private aq(Context context) {
        this.f58a = false;
        this.f53a = null;
        this.f51a = context.getApplicationContext();
        this.f58a = m82c();
        b = m83d();
        this.f53a = new ar(this, Looper.getMainLooper());
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        return this.f51a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m77a() {
        return (!m87a() || "com.xiaomi.xmsf".equals(this.f51a.getPackageName())) ? e() : d();
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
    private String m80a() {
        return this.f51a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, av avVar, boolean z, HashMap<String, String> hashMap) {
        il ilVar;
        if (b.m94a(this.f51a).m101b() && az.b(this.f51a)) {
            il ilVar2 = new il();
            ilVar2.a(true);
            Intent m77a = m77a();
            if (TextUtils.isEmpty(str)) {
                str = com.xiaomi.push.service.an.a();
                ilVar2.a(str);
                il ilVar3 = z ? new il(str, true) : null;
                synchronized (ag.class) {
                    ag.a(this.f51a).m73a(str);
                }
                ilVar = ilVar3;
            } else {
                ilVar2.a(str);
                ilVar = z ? new il(str, true) : null;
            }
            switch (au.a[avVar.ordinal()]) {
                case 1:
                    ilVar2.c(hw.DisablePushMessage.f477a);
                    ilVar.c(hw.DisablePushMessage.f477a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        ilVar.a(hashMap);
                    }
                    m77a.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    ilVar2.c(hw.EnablePushMessage.f477a);
                    ilVar.c(hw.EnablePushMessage.f477a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        ilVar.a(hashMap);
                    }
                    m77a.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    ilVar2.c(hw.ThirdPartyRegUpdate.f477a);
                    if (hashMap != null) {
                        ilVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            ilVar2.b(b.m94a(this.f51a).m95a());
            ilVar2.d(this.f51a.getPackageName());
            a((aq) ilVar2, hm.Notification, false, (hz) null);
            if (z) {
                ilVar.b(b.m94a(this.f51a).m95a());
                ilVar.d(this.f51a.getPackageName());
                byte[] a2 = iw.a(aj.a(this.f51a, ilVar, hm.Notification, false, this.f51a.getPackageName(), b.m94a(this.f51a).m95a()));
                if (a2 != null) {
                    df.a(this.f51a.getPackageName(), this.f51a, ilVar, hm.Notification, a2.length);
                    m77a.putExtra("mipush_payload", a2);
                    m77a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m77a.putExtra("mipush_app_id", b.m94a(this.f51a).m95a());
                    m77a.putExtra("mipush_app_token", b.m94a(this.f51a).b());
                    c(m77a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = avVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f53a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        if ("com.xiaomi.xmsf".equals(this.f51a.getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
            return e();
        }
        return c();
    }

    private void b(Intent intent) {
        try {
            if (com.xiaomi.push.l.m500a() || Build.VERSION.SDK_INT < 26) {
                this.f51a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private Intent c() {
        if (m87a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    private synchronized void c(int i) {
        this.f51a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private void c(Intent intent) {
        int a2 = com.xiaomi.push.service.ak.a(this.f51a).a(hr.ServiceBootMode.a(), hn.START.a());
        int a3 = a();
        boolean z = a2 == hn.BIND.a() && b;
        int a4 = z ? hn.BIND.a() : hn.START.a();
        if (a4 != a3) {
            m88a(a4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m82c() {
        try {
            PackageInfo packageInfo = this.f51a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
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
        String packageName = this.f51a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m80a());
        intent.putExtra("mipush_app_package", packageName);
        f();
        return intent;
    }

    private synchronized void d(Intent intent) {
        if (this.c) {
            Message a2 = a(intent);
            if (this.f57a.size() >= 50) {
                this.f57a.remove(0);
            }
            this.f57a.add(a2);
        } else if (this.f54a == null) {
            Context context = this.f51a;
            at atVar = new at(this);
            Context context2 = this.f51a;
            context.bindService(intent, atVar, 1);
            this.c = true;
            this.f57a.clear();
            this.f57a.add(a(intent));
        } else {
            try {
                this.f54a.send(a(intent));
            } catch (RemoteException e) {
                this.f54a = null;
                this.c = false;
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m83d() {
        if (m87a()) {
            try {
                return this.f51a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception e) {
                return true;
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f51a.getPackageName();
        g();
        intent.setComponent(new ComponentName(this.f51a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m84e() {
        String packageName = this.f51a.getPackageName();
        return packageName.contains("miui") || packageName.contains(RomUtils.MANUFACTURER_XIAOMI) || (this.f51a.getApplicationInfo().flags & 1) != 0;
    }

    private void f() {
        try {
            PackageManager packageManager = this.f51a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f51a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable th) {
        }
    }

    private void g() {
        try {
            PackageManager packageManager = this.f51a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f51a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable th) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m85a() {
        b(m77a());
    }

    public void a(int i) {
        Intent m77a = m77a();
        m77a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m77a.putExtra(com.xiaomi.push.service.at.z, this.f51a.getPackageName());
        m77a.putExtra(com.xiaomi.push.service.at.A, i);
        c(m77a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, String str) {
        Intent m77a = m77a();
        m77a.setAction("com.xiaomi.mipush.thirdparty");
        m77a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        m77a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m77a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m86a(Intent intent) {
        intent.fillIn(m77a(), 24);
        c(intent);
    }

    public final void a(hq hqVar) {
        Intent m77a = m77a();
        byte[] a2 = iw.a(hqVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m77a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m77a.putExtra("mipush_payload", a2);
        b(m77a);
    }

    public final void a(im imVar, boolean z) {
        fb.a(this.f51a.getApplicationContext()).a(this.f51a.getPackageName(), "E100003", imVar.a(), ARPMessageType.MSG_TYPE_MODEL_LOAD_PROGRESS, null);
        this.f52a = null;
        b.m94a(this.f51a).f65a = imVar.a();
        Intent m77a = m77a();
        byte[] a2 = iw.a(aj.a(this.f51a, imVar, hm.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("register fail, because msgBytes is null.");
            return;
        }
        m77a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m77a.putExtra("mipush_app_id", b.m94a(this.f51a).m95a());
        m77a.putExtra("mipush_payload", a2);
        m77a.putExtra("mipush_session", this.f56a);
        m77a.putExtra("mipush_env_chanage", z);
        m77a.putExtra("mipush_env_type", b.m94a(this.f51a).a());
        if (az.b(this.f51a) && m90b()) {
            c(m77a);
        } else {
            this.f52a = m77a;
        }
    }

    public final void a(is isVar) {
        byte[] a2 = iw.a(aj.a(this.f51a, isVar, hm.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m77a = m77a();
        m77a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m77a.putExtra("mipush_app_id", b.m94a(this.f51a).m95a());
        m77a.putExtra("mipush_payload", a2);
        c(m77a);
    }

    public final <T extends ix<T, ?>> void a(T t, hm hmVar, hz hzVar) {
        a((aq) t, hmVar, !hmVar.equals(hm.Registration), hzVar);
    }

    public <T extends ix<T, ?>> void a(T t, hm hmVar, boolean z) {
        a aVar = new a();
        aVar.f59a = t;
        aVar.a = hmVar;
        aVar.f60a = z;
        synchronized (f50a) {
            f50a.add(aVar);
            if (f50a.size() > 10) {
                f50a.remove(0);
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
        a(t, hmVar, z, z2, hzVar, z3, this.f51a.getPackageName(), b.m94a(this.f51a).m95a());
    }

    public final <T extends ix<T, ?>> void a(T t, hm hmVar, boolean z, boolean z2, hz hzVar, boolean z3, String str, String str2) {
        if (!b.m94a(this.f51a).m103c()) {
            if (z2) {
                a((aq) t, hmVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m54a("drop the message before initialization.");
                return;
            }
        }
        ii a2 = aj.a(this.f51a, t, hmVar, z, str, str2);
        if (hzVar != null) {
            a2.a(hzVar);
        }
        byte[] a3 = iw.a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("send message fail, because msgBytes is null.");
            return;
        }
        df.a(this.f51a.getPackageName(), this.f51a, t, hmVar, a3.length);
        Intent m77a = m77a();
        m77a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m77a.putExtra("mipush_payload", a3);
        m77a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m77a);
    }

    public final void a(String str, av avVar, d dVar) {
        ag.a(this.f51a).a(avVar, "syncing");
        a(str, avVar, false, h.a(this.f51a, dVar));
    }

    public void a(String str, String str2) {
        Intent m77a = m77a();
        m77a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m77a.putExtra(com.xiaomi.push.service.at.z, this.f51a.getPackageName());
        m77a.putExtra(com.xiaomi.push.service.at.E, str);
        m77a.putExtra(com.xiaomi.push.service.at.F, str2);
        c(m77a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        if (z) {
            ag.a(this.f51a).a(av.DISABLE_PUSH, "syncing");
            ag.a(this.f51a).a(av.ENABLE_PUSH, "");
            a(str, av.DISABLE_PUSH, true, (HashMap<String, String>) null);
            return;
        }
        ag.a(this.f51a).a(av.ENABLE_PUSH, "syncing");
        ag.a(this.f51a).a(av.DISABLE_PUSH, "");
        a(str, av.ENABLE_PUSH, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m87a() {
        return this.f58a && 1 == b.m94a(this.f51a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m88a(int i) {
        if (b.m94a(this.f51a).m101b()) {
            c(i);
            il ilVar = new il();
            ilVar.a(com.xiaomi.push.service.an.a());
            ilVar.b(b.m94a(this.f51a).m95a());
            ilVar.d(this.f51a.getPackageName());
            ilVar.c(hw.ClientABTest.f477a);
            ilVar.f618a = new HashMap();
            ilVar.f618a.put("boot_mode", i + "");
            a(this.f51a).a((aq) ilVar, hm.Notification, false, (hz) null);
            return true;
        }
        return false;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m89b() {
        Intent m77a = m77a();
        m77a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(m77a);
    }

    public void b(int i) {
        Intent m77a = m77a();
        m77a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m77a.putExtra(com.xiaomi.push.service.at.z, this.f51a.getPackageName());
        m77a.putExtra(com.xiaomi.push.service.at.B, i);
        m77a.putExtra(com.xiaomi.push.service.at.D, be.b(this.f51a.getPackageName() + i));
        c(m77a);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m90b() {
        if (m87a() && m84e()) {
            if (this.f55a == null) {
                this.f55a = Integer.valueOf(com.xiaomi.push.service.aw.a(this.f51a).a());
                if (this.f55a.intValue() == 0) {
                    this.f51a.getContentResolver().registerContentObserver(com.xiaomi.push.service.aw.a(this.f51a).m552a(), false, new as(this, new Handler(Looper.getMainLooper())));
                }
            }
            return this.f55a.intValue() != 0;
        }
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m91c() {
        if (this.f52a != null) {
            c(this.f52a);
            this.f52a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m92d() {
        synchronized (f50a) {
            Iterator<a> it = f50a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f59a, next.a, next.f60a, false, null, true);
            }
            f50a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m93e() {
        Intent m77a = m77a();
        m77a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m77a.putExtra(com.xiaomi.push.service.at.z, this.f51a.getPackageName());
        m77a.putExtra(com.xiaomi.push.service.at.D, be.b(this.f51a.getPackageName()));
        c(m77a);
    }
}
