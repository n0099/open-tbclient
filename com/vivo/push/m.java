package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.vivo.push.b.aa;
import com.vivo.push.b.y;
import com.vivo.push.b.z;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayerLocal;
/* loaded from: classes3.dex */
public final class m {
    private static final Object a = new Object();
    private static volatile m b;
    private Context i;
    private com.vivo.push.util.a k;
    private String l;
    private String m;
    private boolean p;
    private long q;
    private boolean r;
    private long c = -1;
    private long d = -1;
    private long e = -1;
    private long f = -1;
    private long g = -1;
    private long h = -1;
    private boolean j = false;
    private SparseArray<a> n = new SparseArray<>();
    private int o = 0;
    private IPushClientFactory s = new l();

    private m() {
    }

    public static m a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new m();
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() throws VivoPushException {
        if (this.i != null) {
            com.vivo.push.util.w.c(this.i);
        }
    }

    public final void a(Context context) {
        if (this.i == null) {
            this.i = context.getApplicationContext();
            this.q = com.vivo.push.util.w.b(context);
            this.p = this.q >= 1200;
            this.r = com.vivo.push.util.p.b(context, context.getPackageName());
            com.vivo.push.util.t.b().a(this.i);
            a(new com.vivo.push.b.g());
            this.k = new com.vivo.push.util.a();
            this.k.a(context, "com.vivo.push_preferences.appconfig");
            this.l = this.k.a("APP_TOKEN");
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
            com.vivo.push.util.m.d("PushClientManager", "getTags error");
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
        return this.p;
    }

    public final void e() {
        this.m = null;
        this.k.c("APP_ALIAS");
    }

    public final boolean f() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String g() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(boolean z) {
        this.j = z;
    }

    public final boolean h() {
        return this.j;
    }

    public final Context i() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j() {
        a(new com.vivo.push.b.f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k() {
        a(new z());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(IPushActionListener iPushActionListener) {
        a aVar = null;
        if (this.i == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
        } else if (!TextUtils.isEmpty(this.l)) {
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
                    if (!this.p) {
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                        }
                    } else {
                        aVar = new a(bVar, iPushActionListener);
                        String a2 = a(aVar);
                        bVar.b(a2);
                        aVar.a(new o(this, bVar, a2));
                    }
                } else {
                    a(bVar);
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(0);
                    }
                }
            }
            if (aVar != null) {
                aVar.a(new n(this, aVar));
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
                    if (!this.p) {
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                        }
                    } else {
                        aVar = new a(bVar, iPushActionListener);
                        String a2 = a(aVar);
                        bVar.b(a2);
                        aVar.a(new q(this, bVar, a2));
                    }
                } else {
                    a(bVar);
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(0);
                    }
                }
            }
            if (aVar != null) {
                aVar.a(new p(this));
                aVar.a();
            }
        }
    }

    public final void a(String str, int i, Object... objArr) {
        a b2 = b(str);
        if (b2 != null) {
            b2.a(i, objArr);
        } else {
            com.vivo.push.util.m.d("PushClientManager", "notifyUnBindApp token is null");
        }
    }

    public final void l() {
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
                if (!this.p) {
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
                        c(a2);
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
                if (!this.p) {
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
                        c(a2);
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

    public final String m() {
        return this.m;
    }

    public final void a(String str) {
        this.m = str;
        this.k.a("APP_ALIAS", str);
    }

    public final void a(String str, int i) {
        a b2 = b(str);
        if (b2 != null) {
            b2.a(i, new Object[0]);
        } else {
            com.vivo.push.util.m.d("PushClientManager", "notifyStatusChanged token is null");
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
    public synchronized a b(String str) {
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
    public final void n() {
        a(new y());
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
        aa aaVar = new aa(true, null, this.i.getPackageName(), arrayList);
        aaVar.a(500);
        if (this.r) {
            if (!this.p) {
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
                String a2 = a(new a(aaVar, iPushActionListener));
                aaVar.b(a2);
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
                    a(aaVar);
                    c(a2);
                    return;
                }
            }
        }
        a(aaVar);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, ArrayList<String> arrayList) {
        if (this.i != null) {
            aa aaVar = new aa(true, str, this.i.getPackageName(), arrayList);
            aaVar.a(500);
            a(aaVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str, ArrayList<String> arrayList) {
        if (this.i != null) {
            aa aaVar = new aa(false, str, this.i.getPackageName(), arrayList);
            aaVar.a(500);
            a(aaVar);
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
        aa aaVar = new aa(false, null, this.i.getPackageName(), arrayList);
        aaVar.a(500);
        if (this.r) {
            if (!this.p) {
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
                String a2 = a(new a(aaVar, iPushActionListener));
                aaVar.b(a2);
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
                    a(aaVar);
                    c(a2);
                    return;
                }
            }
        }
        a(aaVar);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    public final void a(Intent intent, PushMessageCallback pushMessageCallback) {
        v createReceiverCommand = this.s.createReceiverCommand(intent);
        Context context = a().i;
        if (createReceiverCommand == null) {
            com.vivo.push.util.m.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.m.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        com.vivo.push.c.aa createReceiveTask = this.s.createReceiveTask(createReceiverCommand);
        if (createReceiveTask == null) {
            com.vivo.push.util.m.a("PushClientManager", "sendCommand, null command task! pushCommand = " + createReceiverCommand);
            if (context != null) {
                com.vivo.push.util.m.c(context, "[执行指令失败]指令" + createReceiverCommand + "任务空！");
                return;
            }
            return;
        }
        if (context != null && !(createReceiverCommand instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.m.a(context, "[接收指令]" + createReceiverCommand);
        }
        createReceiveTask.a(pushMessageCallback);
        t.a((s) createReceiveTask);
    }

    public final void a(v vVar) {
        Context context = a().i;
        if (vVar == null) {
            com.vivo.push.util.m.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.m.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        s createTask = this.s.createTask(vVar);
        if (createTask == null) {
            com.vivo.push.util.m.a("PushClientManager", "sendCommand, null command task! pushCommand = " + vVar);
            if (context != null) {
                com.vivo.push.util.m.c(context, "[执行指令失败]指令" + vVar + "任务空！");
                return;
            }
            return;
        }
        com.vivo.push.util.m.d("PushClientManager", "client--sendCommand, command = " + vVar);
        t.a(createTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        t.a(new r(this, str));
    }

    public final void o() {
        a(new com.vivo.push.b.d(true));
    }

    public final void p() {
        a(new com.vivo.push.b.d(false));
    }

    public final void b(boolean z) {
        com.vivo.push.util.m.a(z);
        com.vivo.push.b.w wVar = new com.vivo.push.b.w();
        wVar.a(z ? 1 : 0);
        a(wVar);
    }

    public final boolean q() {
        return this.i.getPackageManager().getComponentEnabledSetting(new ComponentName(this.i, "com.vivo.push.sdk.service.PushService")) != 2;
    }

    public final void r() {
        a(new com.vivo.push.b.h());
    }

    /* loaded from: classes3.dex */
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
                com.vivo.push.util.m.a("PushClientManager", "task is null");
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
