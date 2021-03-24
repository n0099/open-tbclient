package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.kwai.video.player.PlayerProps;
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
    public static final Object f39492a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static volatile p f39493b;
    public Context i;
    public com.vivo.push.util.a k;
    public String l;
    public String m;
    public Boolean p;
    public Long q;
    public boolean r;
    public int t;

    /* renamed from: c  reason: collision with root package name */
    public long f39494c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f39495d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f39496e = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f39497f = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f39498g = -1;

    /* renamed from: h  reason: collision with root package name */
    public long f39499h = -1;
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
        Context context = this.i;
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
            this.p = Boolean.valueOf(u() >= 1230 && com.vivo.push.util.z.e(this.i));
        }
        return this.p.booleanValue();
    }

    public final boolean d() {
        if (this.i == null) {
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
        Context context = this.i;
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
        return this.i;
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
        return this.i.getPackageManager().getComponentEnabledSetting(new ComponentName(this.i, "com.vivo.push.sdk.service.PushService")) != 2;
    }

    public final void q() {
        a(new com.vivo.push.b.i());
    }

    public final int r() {
        return this.t;
    }

    public final Map<String, String> s() {
        return com.vivo.push.util.z.f(this.i);
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
        if (f39493b == null) {
            synchronized (f39492a) {
                if (f39493b == null) {
                    f39493b = new p();
                }
            }
        }
        return f39493b;
    }

    public final void b() throws VivoPushException {
        Context context = this.i;
        if (context != null) {
            com.vivo.push.util.z.c(context);
        }
    }

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public IPushActionListener f39500a;

        /* renamed from: b  reason: collision with root package name */
        public com.vivo.push.b.c f39501b;

        /* renamed from: c  reason: collision with root package name */
        public IPushActionListener f39502c;

        /* renamed from: d  reason: collision with root package name */
        public Runnable f39503d;

        /* renamed from: e  reason: collision with root package name */
        public Object[] f39504e;

        public a(com.vivo.push.b.c cVar, IPushActionListener iPushActionListener) {
            this.f39501b = cVar;
            this.f39500a = iPushActionListener;
        }

        public final void a(int i, Object... objArr) {
            this.f39504e = objArr;
            IPushActionListener iPushActionListener = this.f39502c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i);
            }
            IPushActionListener iPushActionListener2 = this.f39500a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i);
            }
        }

        public final Object[] b() {
            return this.f39504e;
        }

        public final void a(Runnable runnable) {
            this.f39503d = runnable;
        }

        public final void a() {
            Runnable runnable = this.f39503d;
            if (runnable == null) {
                com.vivo.push.util.p.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            this.f39502c = iPushActionListener;
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
        if (this.i == null) {
            this.i = context.getApplicationContext();
            this.r = com.vivo.push.util.s.b(context, context.getPackageName());
            com.vivo.push.util.w.b().a(this.i);
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
        if (this.i == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if ("".equals(this.l)) {
            iPushActionListener.onStateChanged(0);
        } else if (!a(this.f39495d)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.f39495d = SystemClock.elapsedRealtime();
            String packageName = this.i.getPackageName();
            a aVar = null;
            if (this.i != null) {
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

    public final void c(int i) {
        this.t = i;
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
        if (this.i == null) {
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
        } else if (!a(this.f39494c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.f39494c = SystemClock.elapsedRealtime();
            String packageName = this.i.getPackageName();
            a aVar = null;
            if (this.i != null) {
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
        if (this.i == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, str, this.i.getPackageName(), arrayList);
        aVar.a(100);
        a(aVar);
    }

    public final void b(String str, IPushActionListener iPushActionListener) {
        if (this.i == null) {
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
            com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, null, this.i.getPackageName(), arrayList);
            aVar.a(100);
            if (this.r) {
                if (!v()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (!a(this.f39497f)) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(1002);
                        return;
                    }
                    return;
                } else {
                    this.f39497f = SystemClock.elapsedRealtime();
                    String a2 = a(new a(aVar, iPushActionListener));
                    aVar.b(a2);
                    if (TextUtils.isEmpty(this.l)) {
                        a(a2, PlayerProps.FFP_PROP_FLOAT_MIN_AVDIFF_REALTIME);
                        return;
                    } else if (TextUtils.isEmpty(str)) {
                        a(a2, PlayerProps.FFP_PROP_INT64_CPU);
                        return;
                    } else if (str.length() > 70) {
                        a(a2, PlayerProps.FFP_PROP_INT64_MEMORY);
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

    public final void a(String str, int i, Object... objArr) {
        a c2 = c(str);
        if (c2 != null) {
            c2.a(i, objArr);
        } else {
            com.vivo.push.util.p.d("PushClientManager", "notifyApp token is null");
        }
    }

    public final void a(String str, String str2) {
        if (this.i == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, str, this.i.getPackageName(), arrayList);
        aVar.a(100);
        a(aVar);
    }

    public final void a(String str, IPushActionListener iPushActionListener) {
        if (this.i == null) {
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
            com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, null, this.i.getPackageName(), arrayList);
            aVar.a(100);
            if (this.r) {
                if (!v()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (!a(this.f39496e)) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(1002);
                        return;
                    }
                    return;
                } else {
                    this.f39496e = SystemClock.elapsedRealtime();
                    String a2 = a(new a(aVar, iPushActionListener));
                    aVar.b(a2);
                    if (TextUtils.isEmpty(this.l)) {
                        a(a2, PlayerProps.FFP_PROP_FLOAT_MIN_AVDIFF_REALTIME);
                        return;
                    } else if (TextUtils.isEmpty(str)) {
                        a(a2, PlayerProps.FFP_PROP_INT64_CPU);
                        return;
                    } else if (str.length() > 70) {
                        a(a2, PlayerProps.FFP_PROP_INT64_MEMORY);
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
        Context context = this.i;
        if (context == null) {
            return;
        }
        ad adVar = new ad(false, str, context.getPackageName(), arrayList);
        adVar.a(500);
        a(adVar);
    }

    public final void b(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Context context = this.i;
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
            } else if (!a(this.f39499h)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            } else {
                this.f39499h = SystemClock.elapsedRealtime();
                String a2 = a(new a(adVar, iPushActionListener));
                adVar.b(a2);
                if (TextUtils.isEmpty(this.l)) {
                    a(a2, 20001);
                    return;
                } else if (arrayList.size() < 0) {
                    a(a2, PlayerProps.FFP_PROP_INT64_SELECTED_AUDIO_STREAM);
                    return;
                } else if (arrayList.size() > 500) {
                    a(a2, PlayerProps.FFP_PROP_INT64_AUDIO_DECODER);
                    return;
                } else {
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().length() > 70) {
                            a(a2, PlayerProps.FFP_PROP_INT64_VIDEO_DECODER);
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

    public final void a(String str, int i) {
        a c2 = c(str);
        if (c2 != null) {
            c2.a(i, new Object[0]);
        } else {
            com.vivo.push.util.p.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    private synchronized String a(a aVar) {
        int i;
        this.n.put(this.o, aVar);
        i = this.o;
        this.o = i + 1;
        return Integer.toString(i);
    }

    public final void a(int i) {
        if (!com.vivo.push.b.g.a(i)) {
            com.vivo.push.util.p.d("PushClientManager", "切换环境失败，非法的环境：" + i);
            Context context = this.i;
            com.vivo.push.util.p.a(context, "切换环境失败，非法的环境：" + i);
            return;
        }
        a(new ab());
        com.vivo.push.b.g gVar = new com.vivo.push.b.g();
        gVar.b(i);
        a(gVar);
    }

    public final void b(boolean z) {
        com.vivo.push.util.p.a(z);
        com.vivo.push.b.z zVar = new com.vivo.push.b.z();
        zVar.a(z ? 1 : 0);
        a(zVar);
    }

    public final void b(int i) {
        if (i >= 4 && u() < 1260) {
            com.vivo.push.util.p.b("PushClientManager", "current push version " + this.q + " is not support this mode");
            return;
        }
        com.vivo.push.util.p.a((i & 1) != 0);
        com.vivo.push.b.z zVar = new com.vivo.push.b.z();
        zVar.a(i);
        a(zVar);
    }

    public final void a(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Context context = this.i;
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
            } else if (!a(this.f39498g)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            } else {
                this.f39498g = SystemClock.elapsedRealtime();
                String a2 = a(new a(adVar, iPushActionListener));
                adVar.b(a2);
                if (TextUtils.isEmpty(this.l)) {
                    a(a2, 20001);
                    return;
                } else if (arrayList.size() < 0) {
                    a(a2, PlayerProps.FFP_PROP_INT64_SELECTED_AUDIO_STREAM);
                    return;
                } else {
                    if (arrayList.size() + c().size() > 500) {
                        a(a2, PlayerProps.FFP_PROP_INT64_AUDIO_DECODER);
                        return;
                    }
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().length() > 70) {
                            a(a2, PlayerProps.FFP_PROP_INT64_VIDEO_DECODER);
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
        Context context = this.i;
        if (context == null) {
            return;
        }
        ad adVar = new ad(true, str, context.getPackageName(), arrayList);
        adVar.a(500);
        a(adVar);
    }

    public final void a(Intent intent, PushMessageCallback pushMessageCallback) {
        y createReceiverCommand = this.s.createReceiverCommand(intent);
        Context context = a().i;
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
        Context context = a().i;
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
