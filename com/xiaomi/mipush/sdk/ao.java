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
/* loaded from: classes10.dex */
public class ao {
    public static ao a;

    /* renamed from: a  reason: collision with other field name */
    public static final ArrayList<a> f52a = new ArrayList<>();
    public static boolean b;

    /* renamed from: a  reason: collision with other field name */
    public long f53a;

    /* renamed from: a  reason: collision with other field name */
    public Context f54a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f56a;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f57a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f61a;

    /* renamed from: a  reason: collision with other field name */
    public List<Message> f60a = new ArrayList();
    public boolean c = false;

    /* renamed from: a  reason: collision with other field name */
    public Intent f55a = null;

    /* renamed from: a  reason: collision with other field name */
    public Integer f58a = null;

    /* renamed from: a  reason: collision with other field name */
    public String f59a = null;

    /* loaded from: classes10.dex */
    public static class a<T extends is<T, ?>> {
        public hh a;

        /* renamed from: a  reason: collision with other field name */
        public T f62a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f63a;
    }

    public ao(Context context) {
        this.f61a = false;
        this.f56a = null;
        this.f54a = context.getApplicationContext();
        this.f61a = m220c();
        b = m221d();
        this.f56a = new ap(this, Looper.getMainLooper());
        if (com.xiaomi.push.j.m721a(context)) {
            com.xiaomi.push.service.i.a(new aq(this));
        }
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        return this.f54a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m215a() {
        return (!m227a() || "com.xiaomi.xmsf".equals(this.f54a.getPackageName())) ? e() : d();
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
    private String m218a() {
        try {
            return this.f54a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, au auVar, boolean z, HashMap<String, String> hashMap) {
        ig igVar;
        String str2;
        if (b.m234a(this.f54a).m241b() && bi.b(this.f54a)) {
            ig igVar2 = new ig();
            igVar2.a(true);
            Intent m215a = m215a();
            if (TextUtils.isEmpty(str)) {
                str = bd.a();
                igVar2.a(str);
                igVar = z ? new ig(str, true) : null;
                synchronized (af.class) {
                    af.a(this.f54a).m211a(str);
                }
            } else {
                igVar2.a(str);
                igVar = z ? new ig(str, true) : null;
            }
            switch (at.a[auVar.ordinal()]) {
                case 1:
                    igVar2.c(hr.DisablePushMessage.f504a);
                    igVar.c(hr.DisablePushMessage.f504a);
                    if (hashMap != null) {
                        igVar2.a(hashMap);
                        igVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    m215a.setAction(str2);
                    break;
                case 2:
                    igVar2.c(hr.EnablePushMessage.f504a);
                    igVar.c(hr.EnablePushMessage.f504a);
                    if (hashMap != null) {
                        igVar2.a(hashMap);
                        igVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    m215a.setAction(str2);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    igVar2.c(hr.ThirdPartyRegUpdate.f504a);
                    if (hashMap != null) {
                        igVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            com.xiaomi.channel.commonutils.logger.b.e("type:" + auVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + str);
            igVar2.b(b.m234a(this.f54a).m235a());
            igVar2.d(this.f54a.getPackageName());
            a((ao) igVar2, hh.Notification, false, (hu) null);
            if (z) {
                igVar.b(b.m234a(this.f54a).m235a());
                igVar.d(this.f54a.getPackageName());
                Context context = this.f54a;
                byte[] a2 = ir.a(ai.a(context, igVar, hh.Notification, false, context.getPackageName(), b.m234a(this.f54a).m235a()));
                if (a2 != null) {
                    da.a(this.f54a.getPackageName(), this.f54a, igVar, hh.Notification, a2.length);
                    m215a.putExtra("mipush_payload", a2);
                    m215a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m215a.putExtra("mipush_app_id", b.m234a(this.f54a).m235a());
                    m215a.putExtra("mipush_app_token", b.m234a(this.f54a).b());
                    c(m215a);
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
            this.f56a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        if ("com.xiaomi.xmsf".equals(this.f54a.getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
            return e();
        }
        return c();
    }

    private void b(Intent intent) {
        try {
            if (com.xiaomi.push.j.m720a() || Build.VERSION.SDK_INT < 26) {
                this.f54a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private Intent c() {
        if (m227a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    private synchronized void c(int i) {
        this.f54a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private void c(Intent intent) {
        int a2 = ba.a(this.f54a).a(hm.ServiceBootMode.a(), hi.START.a());
        int a3 = a();
        boolean z = a2 == hi.BIND.a() && b;
        int a4 = (z ? hi.BIND : hi.START).a();
        if (a4 != a3) {
            m228a(a4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m220c() {
        try {
            PackageInfo packageInfo = this.f54a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
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
        String packageName = this.f54a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m218a());
        intent.putExtra("mipush_app_package", packageName);
        h();
        return intent;
    }

    private synchronized void d(Intent intent) {
        if (this.c) {
            Message a2 = a(intent);
            if (this.f60a.size() >= 50) {
                this.f60a.remove(0);
            }
            this.f60a.add(a2);
            return;
        }
        if (this.f57a == null) {
            this.f54a.bindService(intent, new as(this), 1);
            this.c = true;
            this.f60a.clear();
            this.f60a.add(a(intent));
        } else {
            try {
                this.f57a.send(a(intent));
            } catch (RemoteException unused) {
                this.f57a = null;
                this.c = false;
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m221d() {
        if (m227a()) {
            try {
                return this.f54a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f54a.getPackageName();
        i();
        intent.setComponent(new ComponentName(this.f54a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m222e() {
        String packageName = this.f54a.getPackageName();
        return packageName.contains("miui") || packageName.contains(RomUtils.MANUFACTURER_XIAOMI) || (this.f54a.getApplicationInfo().flags & 1) != 0;
    }

    private void g() {
        this.f53a = SystemClock.elapsedRealtime();
    }

    private void h() {
        try {
            PackageManager packageManager = this.f54a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f54a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable unused) {
        }
    }

    private void i() {
        try {
            PackageManager packageManager = this.f54a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f54a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m223a() {
        return this.f53a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m224a() {
        b(m215a());
    }

    public void a(int i) {
        a(i, 0);
    }

    public void a(int i, int i2) {
        Intent m215a = m215a();
        m215a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m215a.putExtra(bk.B, this.f54a.getPackageName());
        m215a.putExtra(bk.C, i);
        m215a.putExtra(bk.D, i2);
        c(m215a);
    }

    public void a(int i, String str) {
        Intent m215a = m215a();
        m215a.setAction("com.xiaomi.mipush.thirdparty");
        m215a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        m215a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m215a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m225a(Context context) {
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
    public void m226a(Intent intent) {
        intent.fillIn(m215a(), 24);
        c(intent);
    }

    public final void a(hl hlVar) {
        Intent m215a = m215a();
        byte[] a2 = ir.a(hlVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m190a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m215a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m215a.putExtra("mipush_payload", a2);
        b(m215a);
    }

    public final void a(ih ihVar, boolean z) {
        en.a(this.f54a.getApplicationContext()).a(this.f54a.getPackageName(), "E100003", ihVar.a(), 6001, null);
        this.f55a = null;
        b.m234a(this.f54a).f68a = ihVar.a();
        Intent m215a = m215a();
        byte[] a2 = ir.a(ai.a(this.f54a, ihVar, hh.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m190a("register fail, because msgBytes is null.");
            return;
        }
        m215a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m215a.putExtra("mipush_app_id", b.m234a(this.f54a).m235a());
        m215a.putExtra("mipush_payload", a2);
        m215a.putExtra("mipush_session", this.f59a);
        m215a.putExtra("mipush_env_chanage", z);
        m215a.putExtra("mipush_env_type", b.m234a(this.f54a).a());
        if (!bi.b(this.f54a) || !m230b()) {
            this.f55a = m215a;
            return;
        }
        g();
        c(m215a);
    }

    public final void a(in inVar) {
        byte[] a2 = ir.a(ai.a(this.f54a, inVar, hh.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m190a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m215a = m215a();
        m215a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m215a.putExtra("mipush_app_id", b.m234a(this.f54a).m235a());
        m215a.putExtra("mipush_payload", a2);
        c(m215a);
    }

    public final <T extends is<T, ?>> void a(T t, hh hhVar, hu huVar) {
        a((ao) t, hhVar, !hhVar.equals(hh.Registration), huVar);
    }

    public <T extends is<T, ?>> void a(T t, hh hhVar, boolean z) {
        a aVar = new a();
        aVar.f62a = t;
        aVar.a = hhVar;
        aVar.f63a = z;
        synchronized (f52a) {
            f52a.add(aVar);
            if (f52a.size() > 10) {
                f52a.remove(0);
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
        a(t, hhVar, z, z2, huVar, z3, this.f54a.getPackageName(), b.m234a(this.f54a).m235a());
    }

    public final <T extends is<T, ?>> void a(T t, hh hhVar, boolean z, boolean z2, hu huVar, boolean z3, String str, String str2) {
        a(t, hhVar, z, z2, huVar, z3, str, str2, true);
    }

    public final <T extends is<T, ?>> void a(T t, hh hhVar, boolean z, boolean z2, hu huVar, boolean z3, String str, String str2, boolean z4) {
        a(t, hhVar, z, z2, huVar, z3, str, str2, z4, true);
    }

    public final <T extends is<T, ?>> void a(T t, hh hhVar, boolean z, boolean z2, hu huVar, boolean z3, String str, String str2, boolean z4, boolean z5) {
        if (z5 && !b.m234a(this.f54a).m243c()) {
            if (z2) {
                a((ao) t, hhVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m190a("drop the message before initialization.");
                return;
            }
        }
        id a2 = z4 ? ai.a(this.f54a, t, hhVar, z, str, str2) : ai.b(this.f54a, t, hhVar, z, str, str2);
        if (huVar != null) {
            a2.a(huVar);
        }
        byte[] a3 = ir.a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.m190a("send message fail, because msgBytes is null.");
            return;
        }
        da.a(this.f54a.getPackageName(), this.f54a, t, hhVar, a3.length);
        Intent m215a = m215a();
        m215a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m215a.putExtra("mipush_payload", a3);
        m215a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m215a);
    }

    public final void a(String str, au auVar, e eVar, String str2) {
        af.a(this.f54a).a(auVar, "syncing");
        HashMap<String, String> m253a = i.m253a(this.f54a, eVar);
        m253a.put("third_sync_reason", str2);
        a(str, auVar, false, m253a);
    }

    public void a(String str, String str2) {
        Intent m215a = m215a();
        m215a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m215a.putExtra(bk.B, this.f54a.getPackageName());
        m215a.putExtra(bk.H, str);
        m215a.putExtra(bk.I, str2);
        c(m215a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        au auVar;
        if (z) {
            af.a(this.f54a).a(au.DISABLE_PUSH, "syncing");
            af.a(this.f54a).a(au.ENABLE_PUSH, "");
            auVar = au.DISABLE_PUSH;
        } else {
            af.a(this.f54a).a(au.ENABLE_PUSH, "syncing");
            af.a(this.f54a).a(au.DISABLE_PUSH, "");
            auVar = au.ENABLE_PUSH;
        }
        a(str, auVar, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m227a() {
        return this.f61a && 1 == b.m234a(this.f54a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m228a(int i) {
        if (b.m234a(this.f54a).m241b()) {
            c(i);
            ig igVar = new ig();
            igVar.a(bd.a());
            igVar.b(b.m234a(this.f54a).m235a());
            igVar.d(this.f54a.getPackageName());
            igVar.c(hr.ClientABTest.f504a);
            HashMap hashMap = new HashMap();
            igVar.f646a = hashMap;
            hashMap.put("boot_mode", i + "");
            a(this.f54a).a((ao) igVar, hh.Notification, false, (hu) null);
            return true;
        }
        return false;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m229b() {
        Intent m215a = m215a();
        m215a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(m215a);
    }

    public void b(int i) {
        Intent m215a = m215a();
        m215a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m215a.putExtra(bk.B, this.f54a.getPackageName());
        m215a.putExtra(bk.E, i);
        String str = bk.G;
        m215a.putExtra(str, bn.b(this.f54a.getPackageName() + i));
        c(m215a);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m230b() {
        if (m227a() && m222e()) {
            if (this.f58a == null) {
                Integer valueOf = Integer.valueOf(com.xiaomi.push.service.bn.a(this.f54a).a());
                this.f58a = valueOf;
                if (valueOf.intValue() == 0) {
                    this.f54a.getContentResolver().registerContentObserver(com.xiaomi.push.service.bn.a(this.f54a).m810a(), false, new ar(this, new Handler(Looper.getMainLooper())));
                }
            }
            return this.f58a.intValue() != 0;
        }
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m231c() {
        if (this.f55a != null) {
            g();
            c(this.f55a);
            this.f55a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m232d() {
        synchronized (f52a) {
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<a> it = f52a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f62a, next.a, next.f63a, false, null, true);
                if (!z) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f52a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m233e() {
        Intent m215a = m215a();
        m215a.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
        Application application = (Application) bj.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        String packageName = (application == null || application.getApplicationContext() == null) ? null : application.getApplicationContext().getPackageName();
        String packageName2 = this.f54a.getPackageName();
        if (TextUtils.isEmpty(packageName) || packageName.equals(packageName2)) {
            packageName = packageName2;
        } else {
            com.xiaomi.channel.commonutils.logger.b.m190a("application package name: " + packageName + ", not equals context package name: " + packageName2);
        }
        m215a.putExtra(bk.B, packageName);
        c(m215a);
    }

    public void f() {
        Intent m215a = m215a();
        m215a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m215a.putExtra(bk.B, this.f54a.getPackageName());
        m215a.putExtra(bk.G, bn.b(this.f54a.getPackageName()));
        c(m215a);
    }
}
