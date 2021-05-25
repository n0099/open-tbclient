package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.sapi2.share.ShareCallPacking;
import com.vivo.push.b.ab;
import com.vivo.push.b.ac;
import com.vivo.push.b.ad;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f36654a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static volatile p f36655b;

    /* renamed from: i  reason: collision with root package name */
    public Context f36662i;
    public com.vivo.push.util.a k;
    public String l;
    public String m;
    public Boolean p;
    public Long q;
    public boolean r;
    public int t;

    /* renamed from: c  reason: collision with root package name */
    public long f36656c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f36657d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f36658e = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f36659f = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f36660g = -1;

    /* renamed from: h  reason: collision with root package name */
    public long f36661h = -1;
    public boolean j = true;
    public SparseArray<a> n = new SparseArray<>();
    public int o = 0;
    public IPushClientFactory s = new o();

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.m = null;
        this.k.c("APP_ALIAS");
    }

    private long u() {
        Context context = this.f36662i;
        if (context == null) {
            return -1L;
        }
        if (this.q == null) {
            this.q = Long.valueOf(com.vivo.push.util.z.b(context));
        }
        return this.q.longValue();
    }

    private boolean v() {
        if (this.p == null) {
            this.p = Boolean.valueOf(u() >= 1230 && com.vivo.push.util.z.e(this.f36662i));
        }
        return this.p.booleanValue();
    }

    public final boolean d() {
        if (this.f36662i == null) {
            com.vivo.push.util.p.d("PushClientManager", "support:context is null");
            return false;
        }
        Boolean valueOf = Boolean.valueOf(v());
        this.p = valueOf;
        return valueOf.booleanValue();
    }

    public final boolean e() {
        return this.r;
    }

    public final String f() {
        String a2 = this.k.a("APP_TOKEN");
        if (TextUtils.isEmpty(a2)) {
            return a2;
        }
        Context context = this.f36662i;
        if (com.vivo.push.util.z.a(context, context.getPackageName(), a2)) {
            this.k.a();
            return null;
        }
        return a2;
    }

    public final boolean g() {
        return this.j;
    }

    public final Context h() {
        return this.f36662i;
    }

    public final void i() {
        a(new com.vivo.push.b.f());
    }

    public final void j() {
        a(new ac());
    }

    public final void k() {
        this.k.a();
    }

    public final String l() {
        return this.m;
    }

    public final void m() {
        a(new com.vivo.push.b.d(true));
    }

    public final void n() {
        a(new com.vivo.push.b.d(false));
    }

    public final void o() {
        a(new com.vivo.push.b.y());
    }

    public final boolean p() {
        return this.f36662i.getPackageManager().getComponentEnabledSetting(new ComponentName(this.f36662i, "com.vivo.push.sdk.service.PushService")) != 2;
    }

    public final void q() {
        a(new com.vivo.push.b.i());
    }

    public final int r() {
        return this.t;
    }

    public final Map<String, String> s() {
        return com.vivo.push.util.z.f(this.f36662i);
    }

    public final List<String> c() {
        String a2 = this.k.a("APP_TAGS");
        ArrayList arrayList = new ArrayList();
        try {
        } catch (JSONException unused) {
            this.k.c("APP_TAGS");
            arrayList.clear();
            com.vivo.push.util.p.d("PushClientManager", "getTags error");
        }
        if (TextUtils.isEmpty(a2)) {
            return arrayList;
        }
        Iterator<String> keys = new JSONObject(a2).keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return arrayList;
    }

    public static p a() {
        if (f36655b == null) {
            synchronized (f36654a) {
                if (f36655b == null) {
                    f36655b = new p();
                }
            }
        }
        return f36655b;
    }

    public final void b() throws VivoPushException {
        Context context = this.f36662i;
        if (context != null) {
            com.vivo.push.util.z.c(context);
        }
    }

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public IPushActionListener f36663a;

        /* renamed from: b  reason: collision with root package name */
        public com.vivo.push.b.c f36664b;

        /* renamed from: c  reason: collision with root package name */
        public IPushActionListener f36665c;

        /* renamed from: d  reason: collision with root package name */
        public Runnable f36666d;

        /* renamed from: e  reason: collision with root package name */
        public Object[] f36667e;

        public a(com.vivo.push.b.c cVar, IPushActionListener iPushActionListener) {
            this.f36664b = cVar;
            this.f36663a = iPushActionListener;
        }

        public final void a(int i2, Object... objArr) {
            this.f36667e = objArr;
            IPushActionListener iPushActionListener = this.f36665c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i2);
            }
            IPushActionListener iPushActionListener2 = this.f36663a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i2);
            }
        }

        public final Object[] b() {
            return this.f36667e;
        }

        public final void a(Runnable runnable) {
            this.f36666d = runnable;
        }

        public final void a() {
            Runnable runnable = this.f36666d;
            if (runnable == null) {
                com.vivo.push.util.p.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            this.f36665c = iPushActionListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        w.a(new u(this, str));
    }

    public final void b(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String a2 = this.k.a("APP_TAGS");
            if (TextUtils.isEmpty(a2)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(a2);
            }
            for (String str : list) {
                jSONObject.remove(str);
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                this.k.c("APP_TAGS");
            } else {
                this.k.a("APP_TAGS", jSONObject2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.k.c("APP_TAGS");
        }
    }

    public final synchronized void a(Context context) {
        if (this.f36662i == null) {
            this.f36662i = context.getApplicationContext();
            this.r = com.vivo.push.util.s.b(context, context.getPackageName());
            com.vivo.push.util.w.b().a(this.f36662i);
            a(new com.vivo.push.b.h());
            com.vivo.push.util.a aVar = new com.vivo.push.util.a();
            this.k = aVar;
            aVar.a(context, "com.vivo.push_preferences.appconfig_v1");
            this.l = f();
            this.m = this.k.a("APP_ALIAS");
        }
    }

    public final void c(List<String> list) {
        if (list.contains(this.m)) {
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized a c(String str) {
        if (str != null) {
            try {
                int parseInt = Integer.parseInt(str);
                a aVar = this.n.get(parseInt);
                this.n.delete(parseInt);
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final void b(IPushActionListener iPushActionListener) {
        if (this.f36662i == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if ("".equals(this.l)) {
            iPushActionListener.onStateChanged(0);
        } else if (!a(this.f36657d)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.f36657d = SystemClock.elapsedRealtime();
            String packageName = this.f36662i.getPackageName();
            a aVar = null;
            if (this.f36662i != null) {
                com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, packageName);
                bVar.d();
                bVar.e();
                bVar.g();
                bVar.a(100);
                if (this.r) {
                    if (v()) {
                        aVar = new a(bVar, iPushActionListener);
                        String a2 = a(aVar);
                        bVar.b(a2);
                        aVar.a(new t(this, bVar, a2));
                    } else if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                    }
                } else {
                    a(bVar);
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(0);
                    }
                }
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
            if (aVar == null) {
                return;
            }
            aVar.a(new s(this));
            aVar.a();
        }
    }

    public final void c(int i2) {
        this.t = i2;
    }

    public final void a(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String a2 = this.k.a("APP_TAGS");
            if (TextUtils.isEmpty(a2)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(a2);
            }
            for (String str : list) {
                jSONObject.put(str, System.currentTimeMillis());
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                this.k.c("APP_TAGS");
            } else {
                this.k.a("APP_TAGS", jSONObject2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.k.c("APP_TAGS");
        }
    }

    public final void a(String str) {
        this.l = str;
        this.k.a("APP_TOKEN", str);
    }

    public final void a(boolean z) {
        this.j = z;
    }

    public final void a(IPushActionListener iPushActionListener) {
        if (this.f36662i == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        String f2 = f();
        this.l = f2;
        if (!TextUtils.isEmpty(f2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        } else if (!a(this.f36656c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.f36656c = SystemClock.elapsedRealtime();
            String packageName = this.f36662i.getPackageName();
            a aVar = null;
            if (this.f36662i != null) {
                com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
                bVar.g();
                bVar.d();
                bVar.e();
                bVar.a(100);
                if (this.r) {
                    if (v()) {
                        aVar = new a(bVar, iPushActionListener);
                        String a2 = a(aVar);
                        bVar.b(a2);
                        aVar.a(new r(this, bVar, a2));
                    } else if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                    }
                } else {
                    a(bVar);
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(0);
                    }
                }
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
            if (aVar == null) {
                return;
            }
            aVar.a(new q(this, aVar));
            aVar.a();
        }
    }

    public final void b(String str, String str2) {
        if (this.f36662i == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, str, this.f36662i.getPackageName(), arrayList);
        aVar.a(100);
        a(aVar);
    }

    public final void b(String str, IPushActionListener iPushActionListener) {
        if (this.f36662i == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if (TextUtils.isEmpty(this.m)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, null, this.f36662i.getPackageName(), arrayList);
            aVar.a(100);
            if (this.r) {
                if (!v()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (!a(this.f36659f)) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(1002);
                        return;
                    }
                    return;
                } else {
                    this.f36659f = SystemClock.elapsedRealtime();
                    String a2 = a(new a(aVar, iPushActionListener));
                    aVar.b(a2);
                    if (TextUtils.isEmpty(this.l)) {
                        a(a2, 30001);
                        return;
                    } else if (TextUtils.isEmpty(str)) {
                        a(a2, 30002);
                        return;
                    } else if (str.length() > 70) {
                        a(a2, 30003);
                        return;
                    } else {
                        a(aVar);
                        d(a2);
                        return;
                    }
                }
            }
            a(aVar);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        }
    }

    public final void a(String str, int i2, Object... objArr) {
        a c2 = c(str);
        if (c2 != null) {
            c2.a(i2, objArr);
        } else {
            com.vivo.push.util.p.d("PushClientManager", "notifyApp token is null");
        }
    }

    public final void a(String str, String str2) {
        if (this.f36662i == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, str, this.f36662i.getPackageName(), arrayList);
        aVar.a(100);
        a(aVar);
    }

    public final void a(String str, IPushActionListener iPushActionListener) {
        if (this.f36662i == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if (!TextUtils.isEmpty(this.m) && this.m.equals(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, null, this.f36662i.getPackageName(), arrayList);
            aVar.a(100);
            if (this.r) {
                if (!v()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (!a(this.f36658e)) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(1002);
                        return;
                    }
                    return;
                } else {
                    this.f36658e = SystemClock.elapsedRealtime();
                    String a2 = a(new a(aVar, iPushActionListener));
                    aVar.b(a2);
                    if (TextUtils.isEmpty(this.l)) {
                        a(a2, 30001);
                        return;
                    } else if (TextUtils.isEmpty(str)) {
                        a(a2, 30002);
                        return;
                    } else if (str.length() > 70) {
                        a(a2, 30003);
                        return;
                    } else {
                        a(aVar);
                        d(a2);
                        return;
                    }
                }
            }
            a(aVar);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        }
    }

    public final void b(String str) {
        this.m = str;
        this.k.a("APP_ALIAS", str);
    }

    public final void b(String str, ArrayList<String> arrayList) {
        Context context = this.f36662i;
        if (context == null) {
            return;
        }
        ad adVar = new ad(false, str, context.getPackageName(), arrayList);
        adVar.a(500);
        a(adVar);
    }

    public final void b(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Context context = this.f36662i;
        if (context == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        ad adVar = new ad(false, null, context.getPackageName(), arrayList);
        adVar.a(500);
        if (this.r) {
            if (!v()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (!a(this.f36661h)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            } else {
                this.f36661h = SystemClock.elapsedRealtime();
                String a2 = a(new a(adVar, iPushActionListener));
                adVar.b(a2);
                if (TextUtils.isEmpty(this.l)) {
                    a(a2, ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                    return;
                } else if (arrayList.size() < 0) {
                    a(a2, 20002);
                    return;
                } else if (arrayList.size() > 500) {
                    a(a2, 20004);
                    return;
                } else {
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().length() > 70) {
                            a(a2, 20003);
                            return;
                        }
                    }
                    a(adVar);
                    d(a2);
                    return;
                }
            }
        }
        a(adVar);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    public static boolean a(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return j == -1 || elapsedRealtime <= j || elapsedRealtime >= j + 2000;
    }

    public final void a(String str, int i2) {
        a c2 = c(str);
        if (c2 != null) {
            c2.a(i2, new Object[0]);
        } else {
            com.vivo.push.util.p.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    private synchronized String a(a aVar) {
        int i2;
        this.n.put(this.o, aVar);
        i2 = this.o;
        this.o = i2 + 1;
        return Integer.toString(i2);
    }

    public final void a(int i2) {
        if (!com.vivo.push.b.g.a(i2)) {
            com.vivo.push.util.p.d("PushClientManager", "切换环境失败，非法的环境：" + i2);
            Context context = this.f36662i;
            com.vivo.push.util.p.a(context, "切换环境失败，非法的环境：" + i2);
            return;
        }
        a(new ab());
        com.vivo.push.b.g gVar = new com.vivo.push.b.g();
        gVar.b(i2);
        a(gVar);
    }

    public final void b(boolean z) {
        com.vivo.push.util.p.a(z);
        com.vivo.push.b.z zVar = new com.vivo.push.b.z();
        zVar.a(z ? 1 : 0);
        a(zVar);
    }

    public final void b(int i2) {
        if (i2 >= 4 && u() < 1260) {
            com.vivo.push.util.p.b("PushClientManager", "current push version " + this.q + " is not support this mode");
            return;
        }
        com.vivo.push.util.p.a((i2 & 1) != 0);
        com.vivo.push.b.z zVar = new com.vivo.push.b.z();
        zVar.a(i2);
        a(zVar);
    }

    public final void a(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Context context = this.f36662i;
        if (context == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        ad adVar = new ad(true, null, context.getPackageName(), arrayList);
        adVar.a(500);
        if (this.r) {
            if (!v()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (!a(this.f36660g)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            } else {
                this.f36660g = SystemClock.elapsedRealtime();
                String a2 = a(new a(adVar, iPushActionListener));
                adVar.b(a2);
                if (TextUtils.isEmpty(this.l)) {
                    a(a2, ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                    return;
                } else if (arrayList.size() < 0) {
                    a(a2, 20002);
                    return;
                } else {
                    if (arrayList.size() + c().size() > 500) {
                        a(a2, 20004);
                        return;
                    }
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().length() > 70) {
                            a(a2, 20003);
                            return;
                        }
                    }
                    a(adVar);
                    d(a2);
                    return;
                }
            }
        }
        a(adVar);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    public final void a(String str, ArrayList<String> arrayList) {
        Context context = this.f36662i;
        if (context == null) {
            return;
        }
        ad adVar = new ad(true, str, context.getPackageName(), arrayList);
        adVar.a(500);
        a(adVar);
    }

    public final void a(Intent intent, PushMessageCallback pushMessageCallback) {
        y createReceiverCommand = this.s.createReceiverCommand(intent);
        Context context = a().f36662i;
        if (createReceiverCommand == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        com.vivo.push.c.ab createReceiveTask = this.s.createReceiveTask(createReceiverCommand);
        if (createReceiveTask == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = " + createReceiverCommand);
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令" + createReceiverCommand + "任务空！");
                return;
            }
            return;
        }
        if (context != null && !(createReceiverCommand instanceof com.vivo.push.b.p)) {
            com.vivo.push.util.p.a(context, "[接收指令]" + createReceiverCommand);
        }
        createReceiveTask.a(pushMessageCallback);
        w.a((v) createReceiveTask);
    }

    public final void a(y yVar) {
        Context context = a().f36662i;
        if (yVar == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        v createTask = this.s.createTask(yVar);
        if (createTask == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = " + yVar);
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令" + yVar + "任务空！");
                return;
            }
            return;
        }
        com.vivo.push.util.p.d("PushClientManager", "client--sendCommand, command = " + yVar);
        w.a(createTask);
    }
}
