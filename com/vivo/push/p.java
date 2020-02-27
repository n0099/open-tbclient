package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.vivo.push.b.ab;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayerLocal;
/* loaded from: classes8.dex */
public final class p {
    private static final Object a = new Object();
    private static volatile p b;
    private Context i;
    private com.vivo.push.util.a k;
    private String l;
    private String m;
    private Boolean p;
    private Long q;
    private boolean r;
    private int t;
    private long c = -1;
    private long d = -1;
    private long e = -1;
    private long f = -1;
    private long g = -1;
    private long h = -1;
    private boolean j = true;
    private SparseArray<a> n = new SparseArray<>();
    private int o = 0;
    private IPushClientFactory s = new o();

    private p() {
    }

    public static p a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new p();
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() throws VivoPushException {
        if (this.i != null) {
            com.vivo.push.util.z.c(this.i);
        }
    }

    public final synchronized void a(Context context) {
        if (this.i == null) {
            this.i = context.getApplicationContext();
            this.r = com.vivo.push.util.s.b(context, context.getPackageName());
            com.vivo.push.util.w.b().a(this.i);
            a(new com.vivo.push.b.g());
            this.k = new com.vivo.push.util.a();
            this.k.a(context, "com.vivo.push_preferences.appconfig_v1");
            this.l = f();
            this.m = this.k.a("APP_ALIAS");
        }
    }

    public final List<String> c() {
        String a2 = this.k.a("APP_TAGS");
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(a2)) {
                Iterator<String> keys = new JSONObject(a2).keys();
                while (keys.hasNext()) {
                    arrayList.add(keys.next());
                }
            }
        } catch (JSONException e) {
            this.k.c("APP_TAGS");
            arrayList.clear();
            com.vivo.push.util.p.d("PushClientManager", "getTags error");
        }
        return arrayList;
    }

    public final void a(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() > 0) {
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
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.k.c("APP_TAGS");
        }
    }

    public final void b(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() > 0) {
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
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.k.c("APP_TAGS");
        }
    }

    public final boolean d() {
        if (this.i == null) {
            com.vivo.push.util.p.d("PushClientManager", "support:context is null");
            return false;
        }
        this.p = Boolean.valueOf(w());
        return this.p.booleanValue();
    }

    public final void c(List<String> list) {
        if (list.contains(this.m)) {
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.m = null;
        this.k.c("APP_ALIAS");
    }

    public final boolean e() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String f() {
        String a2 = this.k.a("APP_TOKEN");
        if (TextUtils.isEmpty(a2) || !com.vivo.push.util.z.a(this.i, this.i.getPackageName(), a2)) {
            return a2;
        }
        this.k.a();
        return null;
    }

    public final void a(String str) {
        this.l = str;
        this.k.a("APP_TOKEN", this.l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(boolean z) {
        this.j = z;
    }

    public final boolean g() {
        return this.j;
    }

    public final Context h() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i() {
        a(new com.vivo.push.b.f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j() {
        a(new com.vivo.push.b.aa());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(IPushActionListener iPushActionListener) {
        a aVar = null;
        if (this.i == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        this.l = f();
        if (!TextUtils.isEmpty(this.l)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        } else if (!a(this.c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.c = SystemClock.elapsedRealtime();
            String packageName = this.i.getPackageName();
            if (this.i == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                }
            } else {
                com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
                bVar.g();
                bVar.d();
                bVar.e();
                bVar.a(100);
                if (this.r) {
                    if (!w()) {
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                        }
                    } else {
                        aVar = new a(bVar, iPushActionListener);
                        String a2 = a(aVar);
                        bVar.b(a2);
                        aVar.a(new r(this, bVar, a2));
                    }
                } else {
                    a(bVar);
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(0);
                    }
                }
            }
            if (aVar != null) {
                aVar.a(new q(this, aVar));
                aVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(IPushActionListener iPushActionListener) {
        a aVar = null;
        if (this.i == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if ("".equals(this.l)) {
            iPushActionListener.onStateChanged(0);
        } else if (!a(this.d)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.d = SystemClock.elapsedRealtime();
            String packageName = this.i.getPackageName();
            if (this.i == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                }
            } else {
                com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, packageName);
                bVar.d();
                bVar.e();
                bVar.g();
                bVar.a(100);
                if (this.r) {
                    if (!w()) {
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                        }
                    } else {
                        aVar = new a(bVar, iPushActionListener);
                        String a2 = a(aVar);
                        bVar.b(a2);
                        aVar.a(new t(this, bVar, a2));
                    }
                } else {
                    a(bVar);
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(0);
                    }
                }
            }
            if (aVar != null) {
                aVar.a(new s(this));
                aVar.a();
            }
        }
    }

    public final void a(String str, int i, Object... objArr) {
        a c = c(str);
        if (c != null) {
            c.a(i, objArr);
        } else {
            com.vivo.push.util.p.d("PushClientManager", "notifyApp token is null");
        }
    }

    public final void k() {
        this.k.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, String str2) {
        if (this.i != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, str, this.i.getPackageName(), arrayList);
            aVar.a(100);
            a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
                if (!w()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (!a(this.e)) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(1002);
                        return;
                    }
                    return;
                } else {
                    this.e = SystemClock.elapsedRealtime();
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

    private static boolean a(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return j == -1 || elapsedRealtime <= j || elapsedRealtime >= 2000 + j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str, String str2) {
        if (this.i != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, str, this.i.getPackageName(), arrayList);
            aVar.a(100);
            a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
                if (!w()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (!a(this.f)) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(1002);
                        return;
                    }
                    return;
                } else {
                    this.f = SystemClock.elapsedRealtime();
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

    public final String l() {
        return this.m;
    }

    public final void b(String str) {
        this.m = str;
        this.k.a("APP_ALIAS", str);
    }

    public final void a(String str, int i) {
        a c = c(str);
        if (c != null) {
            c.a(i, new Object[0]);
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

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized a c(String str) {
        a aVar;
        if (str != null) {
            try {
                int parseInt = Integer.parseInt(str);
                aVar = this.n.get(parseInt);
                this.n.delete(parseInt);
            } catch (Exception e) {
            }
        }
        aVar = null;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m() {
        a(new com.vivo.push.b.z());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        if (this.i == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        ab abVar = new ab(true, null, this.i.getPackageName(), arrayList);
        abVar.a(500);
        if (this.r) {
            if (!w()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (!a(this.g)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            } else {
                this.g = SystemClock.elapsedRealtime();
                String a2 = a(new a(abVar, iPushActionListener));
                abVar.b(a2);
                if (TextUtils.isEmpty(this.l)) {
                    a(a2, 20001);
                    return;
                } else if (arrayList.size() < 0) {
                    a(a2, IjkMediaPlayerLocal.FFP_PROP_INT64_SELECTED_AUDIO_STREAM);
                    return;
                } else if (c().size() + arrayList.size() > 500) {
                    a(a2, IjkMediaPlayerLocal.FFP_PROP_INT64_AUDIO_DECODER);
                    return;
                } else {
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().length() > 70) {
                            a(a2, IjkMediaPlayerLocal.FFP_PROP_INT64_VIDEO_DECODER);
                            return;
                        }
                    }
                    a(abVar);
                    d(a2);
                    return;
                }
            }
        }
        a(abVar);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, ArrayList<String> arrayList) {
        if (this.i != null) {
            ab abVar = new ab(true, str, this.i.getPackageName(), arrayList);
            abVar.a(500);
            a(abVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str, ArrayList<String> arrayList) {
        if (this.i != null) {
            ab abVar = new ab(false, str, this.i.getPackageName(), arrayList);
            abVar.a(500);
            a(abVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        if (this.i == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        ab abVar = new ab(false, null, this.i.getPackageName(), arrayList);
        abVar.a(500);
        if (this.r) {
            if (!w()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (!a(this.h)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            } else {
                this.h = SystemClock.elapsedRealtime();
                String a2 = a(new a(abVar, iPushActionListener));
                abVar.b(a2);
                if (TextUtils.isEmpty(this.l)) {
                    a(a2, 20001);
                    return;
                } else if (arrayList.size() < 0) {
                    a(a2, IjkMediaPlayerLocal.FFP_PROP_INT64_SELECTED_AUDIO_STREAM);
                    return;
                } else if (arrayList.size() > 500) {
                    a(a2, IjkMediaPlayerLocal.FFP_PROP_INT64_AUDIO_DECODER);
                    return;
                } else {
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().length() > 70) {
                            a(a2, IjkMediaPlayerLocal.FFP_PROP_INT64_VIDEO_DECODER);
                            return;
                        }
                    }
                    a(abVar);
                    d(a2);
                    return;
                }
            }
        }
        a(abVar);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
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
        com.vivo.push.c.aa createReceiveTask = this.s.createReceiveTask(createReceiverCommand);
        if (createReceiveTask == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = " + createReceiverCommand);
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令" + createReceiverCommand + "任务空！");
                return;
            }
            return;
        }
        if (context != null && !(createReceiverCommand instanceof com.vivo.push.b.n)) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        w.a(new u(this, str));
    }

    public final void n() {
        a(new com.vivo.push.b.d(true));
    }

    public final void o() {
        a(new com.vivo.push.b.d(false));
    }

    public final void b(boolean z) {
        com.vivo.push.util.p.a(z);
        com.vivo.push.b.x xVar = new com.vivo.push.b.x();
        xVar.a(z ? 1 : 0);
        a(xVar);
    }

    public final void a(int i) {
        if (i >= 4 && v() < 1260) {
            com.vivo.push.util.p.b("PushClientManager", "current push version " + this.q + " is not support this mode");
            return;
        }
        com.vivo.push.util.p.a((i & 1) != 0);
        com.vivo.push.b.x xVar = new com.vivo.push.b.x();
        xVar.a(i);
        a(xVar);
    }

    public final void p() {
        a(new com.vivo.push.b.w());
    }

    public final boolean q() {
        return this.i.getPackageManager().getComponentEnabledSetting(new ComponentName(this.i, "com.vivo.push.sdk.service.PushService")) != 2;
    }

    public final void r() {
        a(new com.vivo.push.b.h());
    }

    public final int s() {
        return this.t;
    }

    public final void b(int i) {
        this.t = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> t() {
        return com.vivo.push.util.z.f(this.i);
    }

    private long v() {
        if (this.i == null) {
            return -1L;
        }
        if (this.q == null) {
            this.q = Long.valueOf(com.vivo.push.util.z.b(this.i));
        }
        return this.q.longValue();
    }

    private boolean w() {
        if (this.p == null) {
            this.p = Boolean.valueOf(v() >= 1230 && com.vivo.push.util.z.e(this.i));
        }
        return this.p.booleanValue();
    }

    /* loaded from: classes8.dex */
    public static class a {
        private IPushActionListener a;
        private com.vivo.push.b.c b;
        private IPushActionListener c;
        private Runnable d;
        private Object[] e;

        public a(com.vivo.push.b.c cVar, IPushActionListener iPushActionListener) {
            this.b = cVar;
            this.a = iPushActionListener;
        }

        public final void a(int i, Object... objArr) {
            this.e = objArr;
            if (this.c != null) {
                this.c.onStateChanged(i);
            }
            if (this.a != null) {
                this.a.onStateChanged(i);
            }
        }

        public final void a(Runnable runnable) {
            this.d = runnable;
        }

        public final void a() {
            if (this.d == null) {
                com.vivo.push.util.p.a("PushClientManager", "task is null");
            } else {
                this.d.run();
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            this.c = iPushActionListener;
        }

        public final Object[] b() {
            return this.e;
        }
    }
}
