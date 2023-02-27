package com.xiaomi.mipush.sdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.xiaomi.push.bi;
import com.xiaomi.push.bj;
import com.xiaomi.push.bn;
import com.xiaomi.push.da;
import com.xiaomi.push.en;
import com.xiaomi.push.hh;
import com.xiaomi.push.hi;
import com.xiaomi.push.hl;
import com.xiaomi.push.hm;
import com.xiaomi.push.hr;
import com.xiaomi.push.hu;
import com.xiaomi.push.id;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import com.xiaomi.push.in;
import com.xiaomi.push.ir;
import com.xiaomi.push.is;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.bk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class ao {
    public static ao a;

    /* renamed from: a  reason: collision with other field name */
    public static final ArrayList<a> f56a = new ArrayList<>();
    public static boolean b;

    /* renamed from: a  reason: collision with other field name */
    public long f57a;

    /* renamed from: a  reason: collision with other field name */
    public Context f58a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f60a;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f61a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f65a;

    /* renamed from: a  reason: collision with other field name */
    public List<Message> f64a = new ArrayList();
    public boolean c = false;

    /* renamed from: a  reason: collision with other field name */
    public Intent f59a = null;

    /* renamed from: a  reason: collision with other field name */
    public Integer f62a = null;

    /* renamed from: a  reason: collision with other field name */
    public String f63a = null;

    /* loaded from: classes8.dex */
    public static class a<T extends is<T, ?>> {
        public hh a;

        /* renamed from: a  reason: collision with other field name */
        public T f66a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f67a;
    }

    public ao(Context context) {
        this.f65a = false;
        this.f60a = null;
        this.f58a = context.getApplicationContext();
        this.f65a = m127c();
        b = m128d();
        this.f60a = new ap(this, Looper.getMainLooper());
        if (com.xiaomi.push.j.m628a(context)) {
            com.xiaomi.push.service.i.a(new aq(this));
        }
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        return this.f58a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m122a() {
        return (!m134a() || "com.xiaomi.xmsf".equals(this.f58a.getPackageName())) ? e() : d();
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static synchronized ao a(Context context) {
        ao aoVar;
        synchronized (ao.class) {
            if (a == null) {
                a = new ao(context);
            }
            aoVar = a;
        }
        return aoVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m125a() {
        try {
            return this.f58a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, au auVar, boolean z, HashMap<String, String> hashMap) {
        ig igVar;
        String str2;
        if (b.m141a(this.f58a).m148b() && bi.b(this.f58a)) {
            ig igVar2 = new ig();
            igVar2.a(true);
            Intent m122a = m122a();
            if (TextUtils.isEmpty(str)) {
                str = bd.a();
                igVar2.a(str);
                igVar = z ? new ig(str, true) : null;
                synchronized (af.class) {
                    af.a(this.f58a).m118a(str);
                }
            } else {
                igVar2.a(str);
                igVar = z ? new ig(str, true) : null;
            }
            switch (at.a[auVar.ordinal()]) {
                case 1:
                    igVar2.c(hr.DisablePushMessage.f508a);
                    igVar.c(hr.DisablePushMessage.f508a);
                    if (hashMap != null) {
                        igVar2.a(hashMap);
                        igVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    m122a.setAction(str2);
                    break;
                case 2:
                    igVar2.c(hr.EnablePushMessage.f508a);
                    igVar.c(hr.EnablePushMessage.f508a);
                    if (hashMap != null) {
                        igVar2.a(hashMap);
                        igVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    m122a.setAction(str2);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    igVar2.c(hr.ThirdPartyRegUpdate.f508a);
                    if (hashMap != null) {
                        igVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            com.xiaomi.channel.commonutils.logger.b.e("type:" + auVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + str);
            igVar2.b(b.m141a(this.f58a).m142a());
            igVar2.d(this.f58a.getPackageName());
            a((ao) igVar2, hh.Notification, false, (hu) null);
            if (z) {
                igVar.b(b.m141a(this.f58a).m142a());
                igVar.d(this.f58a.getPackageName());
                Context context = this.f58a;
                byte[] a2 = ir.a(ai.a(context, igVar, hh.Notification, false, context.getPackageName(), b.m141a(this.f58a).m142a()));
                if (a2 != null) {
                    da.a(this.f58a.getPackageName(), this.f58a, igVar, hh.Notification, a2.length);
                    m122a.putExtra("mipush_payload", a2);
                    m122a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m122a.putExtra("mipush_app_id", b.m141a(this.f58a).m142a());
                    m122a.putExtra("mipush_app_token", b.m141a(this.f58a).b());
                    c(m122a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = auVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            if (hashMap != null && hashMap.get("third_sync_reason") != null) {
                Bundle bundle = new Bundle();
                bundle.putString("third_sync_reason", hashMap.get("third_sync_reason"));
                obtain.setData(bundle);
            }
            this.f60a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        if ("com.xiaomi.xmsf".equals(this.f58a.getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
            return e();
        }
        return c();
    }

    private void b(Intent intent) {
        try {
            if (com.xiaomi.push.j.m627a() || Build.VERSION.SDK_INT < 26) {
                this.f58a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private Intent c() {
        if (m134a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    private synchronized void c(int i) {
        this.f58a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private void c(Intent intent) {
        int a2 = ba.a(this.f58a).a(hm.ServiceBootMode.a(), hi.START.a());
        int a3 = a();
        boolean z = a2 == hi.BIND.a() && b;
        int a4 = (z ? hi.BIND : hi.START).a();
        if (a4 != a3) {
            m135a(a4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m127c() {
        try {
            PackageInfo packageInfo = this.f58a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
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
        String packageName = this.f58a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m125a());
        intent.putExtra("mipush_app_package", packageName);
        h();
        return intent;
    }

    private synchronized void d(Intent intent) {
        if (this.c) {
            Message a2 = a(intent);
            if (this.f64a.size() >= 50) {
                this.f64a.remove(0);
            }
            this.f64a.add(a2);
            return;
        }
        if (this.f61a == null) {
            this.f58a.bindService(intent, new as(this), 1);
            this.c = true;
            this.f64a.clear();
            this.f64a.add(a(intent));
        } else {
            try {
                this.f61a.send(a(intent));
            } catch (RemoteException unused) {
                this.f61a = null;
                this.c = false;
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m128d() {
        if (m134a()) {
            try {
                return this.f58a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f58a.getPackageName();
        i();
        intent.setComponent(new ComponentName(this.f58a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m129e() {
        String packageName = this.f58a.getPackageName();
        return packageName.contains("miui") || packageName.contains(RomUtils.MANUFACTURER_XIAOMI) || (this.f58a.getApplicationInfo().flags & 1) != 0;
    }

    private void g() {
        this.f57a = SystemClock.elapsedRealtime();
    }

    private void h() {
        try {
            PackageManager packageManager = this.f58a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f58a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable unused) {
        }
    }

    private void i() {
        try {
            PackageManager packageManager = this.f58a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f58a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m130a() {
        return this.f57a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m131a() {
        b(m122a());
    }

    public void a(int i) {
        a(i, 0);
    }

    public void a(int i, int i2) {
        Intent m122a = m122a();
        m122a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m122a.putExtra(bk.B, this.f58a.getPackageName());
        m122a.putExtra(bk.C, i);
        m122a.putExtra(bk.D, i2);
        c(m122a);
    }

    public void a(int i, String str) {
        Intent m122a = m122a();
        m122a.setAction("com.xiaomi.mipush.thirdparty");
        m122a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        m122a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m122a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m132a(Context context) {
        ag a2 = n.a(context);
        if (ag.HUAWEI.equals(a2)) {
            a((String) null, au.UPLOAD_HUAWEI_TOKEN, e.ASSEMBLE_PUSH_HUAWEI, StickerDataChangeType.UPDATE);
        }
        if (ag.OPPO.equals(a2)) {
            a((String) null, au.UPLOAD_COS_TOKEN, e.ASSEMBLE_PUSH_COS, StickerDataChangeType.UPDATE);
        }
        if (ag.VIVO.equals(a2)) {
            a((String) null, au.UPLOAD_FTOS_TOKEN, e.ASSEMBLE_PUSH_FTOS, StickerDataChangeType.UPDATE);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m133a(Intent intent) {
        intent.fillIn(m122a(), 24);
        c(intent);
    }

    public final void a(hl hlVar) {
        Intent m122a = m122a();
        byte[] a2 = ir.a(hlVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m97a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m122a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m122a.putExtra("mipush_payload", a2);
        b(m122a);
    }

    public final void a(ih ihVar, boolean z) {
        en.a(this.f58a.getApplicationContext()).a(this.f58a.getPackageName(), "E100003", ihVar.a(), 6001, null);
        this.f59a = null;
        b.m141a(this.f58a).f72a = ihVar.a();
        Intent m122a = m122a();
        byte[] a2 = ir.a(ai.a(this.f58a, ihVar, hh.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m97a("register fail, because msgBytes is null.");
            return;
        }
        m122a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m122a.putExtra("mipush_app_id", b.m141a(this.f58a).m142a());
        m122a.putExtra("mipush_payload", a2);
        m122a.putExtra("mipush_session", this.f63a);
        m122a.putExtra("mipush_env_chanage", z);
        m122a.putExtra("mipush_env_type", b.m141a(this.f58a).a());
        if (!bi.b(this.f58a) || !m137b()) {
            this.f59a = m122a;
            return;
        }
        g();
        c(m122a);
    }

    public final void a(in inVar) {
        byte[] a2 = ir.a(ai.a(this.f58a, inVar, hh.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m97a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m122a = m122a();
        m122a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m122a.putExtra("mipush_app_id", b.m141a(this.f58a).m142a());
        m122a.putExtra("mipush_payload", a2);
        c(m122a);
    }

    public final <T extends is<T, ?>> void a(T t, hh hhVar, hu huVar) {
        a((ao) t, hhVar, !hhVar.equals(hh.Registration), huVar);
    }

    public <T extends is<T, ?>> void a(T t, hh hhVar, boolean z) {
        a aVar = new a();
        aVar.f66a = t;
        aVar.a = hhVar;
        aVar.f67a = z;
        synchronized (f56a) {
            f56a.add(aVar);
            if (f56a.size() > 10) {
                f56a.remove(0);
            }
        }
    }

    public final <T extends is<T, ?>> void a(T t, hh hhVar, boolean z, hu huVar) {
        a(t, hhVar, z, true, huVar, true);
    }

    public final <T extends is<T, ?>> void a(T t, hh hhVar, boolean z, hu huVar, boolean z2) {
        a(t, hhVar, z, true, huVar, z2);
    }

    public final <T extends is<T, ?>> void a(T t, hh hhVar, boolean z, boolean z2, hu huVar, boolean z3) {
        a(t, hhVar, z, z2, huVar, z3, this.f58a.getPackageName(), b.m141a(this.f58a).m142a());
    }

    public final <T extends is<T, ?>> void a(T t, hh hhVar, boolean z, boolean z2, hu huVar, boolean z3, String str, String str2) {
        a(t, hhVar, z, z2, huVar, z3, str, str2, true);
    }

    public final <T extends is<T, ?>> void a(T t, hh hhVar, boolean z, boolean z2, hu huVar, boolean z3, String str, String str2, boolean z4) {
        a(t, hhVar, z, z2, huVar, z3, str, str2, z4, true);
    }

    public final <T extends is<T, ?>> void a(T t, hh hhVar, boolean z, boolean z2, hu huVar, boolean z3, String str, String str2, boolean z4, boolean z5) {
        if (z5 && !b.m141a(this.f58a).m150c()) {
            if (z2) {
                a((ao) t, hhVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m97a("drop the message before initialization.");
                return;
            }
        }
        id a2 = z4 ? ai.a(this.f58a, t, hhVar, z, str, str2) : ai.b(this.f58a, t, hhVar, z, str, str2);
        if (huVar != null) {
            a2.a(huVar);
        }
        byte[] a3 = ir.a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.m97a("send message fail, because msgBytes is null.");
            return;
        }
        da.a(this.f58a.getPackageName(), this.f58a, t, hhVar, a3.length);
        Intent m122a = m122a();
        m122a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m122a.putExtra("mipush_payload", a3);
        m122a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m122a);
    }

    public final void a(String str, au auVar, e eVar, String str2) {
        af.a(this.f58a).a(auVar, "syncing");
        HashMap<String, String> m160a = i.m160a(this.f58a, eVar);
        m160a.put("third_sync_reason", str2);
        a(str, auVar, false, m160a);
    }

    public void a(String str, String str2) {
        Intent m122a = m122a();
        m122a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m122a.putExtra(bk.B, this.f58a.getPackageName());
        m122a.putExtra(bk.H, str);
        m122a.putExtra(bk.I, str2);
        c(m122a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        au auVar;
        if (z) {
            af.a(this.f58a).a(au.DISABLE_PUSH, "syncing");
            af.a(this.f58a).a(au.ENABLE_PUSH, "");
            auVar = au.DISABLE_PUSH;
        } else {
            af.a(this.f58a).a(au.ENABLE_PUSH, "syncing");
            af.a(this.f58a).a(au.DISABLE_PUSH, "");
            auVar = au.ENABLE_PUSH;
        }
        a(str, auVar, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m134a() {
        return this.f65a && 1 == b.m141a(this.f58a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m135a(int i) {
        if (b.m141a(this.f58a).m148b()) {
            c(i);
            ig igVar = new ig();
            igVar.a(bd.a());
            igVar.b(b.m141a(this.f58a).m142a());
            igVar.d(this.f58a.getPackageName());
            igVar.c(hr.ClientABTest.f508a);
            HashMap hashMap = new HashMap();
            igVar.f650a = hashMap;
            hashMap.put("boot_mode", i + "");
            a(this.f58a).a((ao) igVar, hh.Notification, false, (hu) null);
            return true;
        }
        return false;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m136b() {
        Intent m122a = m122a();
        m122a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(m122a);
    }

    public void b(int i) {
        Intent m122a = m122a();
        m122a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m122a.putExtra(bk.B, this.f58a.getPackageName());
        m122a.putExtra(bk.E, i);
        String str = bk.G;
        m122a.putExtra(str, bn.b(this.f58a.getPackageName() + i));
        c(m122a);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m137b() {
        if (m134a() && m129e()) {
            if (this.f62a == null) {
                Integer valueOf = Integer.valueOf(com.xiaomi.push.service.bn.a(this.f58a).a());
                this.f62a = valueOf;
                if (valueOf.intValue() == 0) {
                    this.f58a.getContentResolver().registerContentObserver(com.xiaomi.push.service.bn.a(this.f58a).m717a(), false, new ar(this, new Handler(Looper.getMainLooper())));
                }
            }
            return this.f62a.intValue() != 0;
        }
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m138c() {
        if (this.f59a != null) {
            g();
            c(this.f59a);
            this.f59a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m139d() {
        synchronized (f56a) {
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<a> it = f56a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f66a, next.a, next.f67a, false, null, true);
                if (!z) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f56a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m140e() {
        Intent m122a = m122a();
        m122a.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
        Application application = (Application) bj.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        String packageName = (application == null || application.getApplicationContext() == null) ? null : application.getApplicationContext().getPackageName();
        String packageName2 = this.f58a.getPackageName();
        if (TextUtils.isEmpty(packageName) || packageName.equals(packageName2)) {
            packageName = packageName2;
        } else {
            com.xiaomi.channel.commonutils.logger.b.m97a("application package name: " + packageName + ", not equals context package name: " + packageName2);
        }
        m122a.putExtra(bk.B, packageName);
        c(m122a);
    }

    public void f() {
        Intent m122a = m122a();
        m122a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m122a.putExtra(bk.B, this.f58a.getPackageName());
        m122a.putExtra(bk.G, bn.b(this.f58a.getPackageName()));
        c(m122a);
    }
}
