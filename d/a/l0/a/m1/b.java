package d.a.l0.a.m1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.h0.i.i;
import d.a.l0.a.j2.h;
import d.a.l0.a.j2.k;
import d.a.l0.a.m1.i.a;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q;
import d.a.l0.a.v2.q0;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes3.dex */
public class b extends HandlerThread implements d.a.l0.a.m1.a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47113f = d.a.l0.a.a2.e.y;

    /* renamed from: e  reason: collision with root package name */
    public a f47114e;

    /* loaded from: classes3.dex */
    public class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public d f47115a;

        /* renamed from: b  reason: collision with root package name */
        public Deque<d> f47116b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f47117c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.l0.a.m1.i.a f47118d;

        /* renamed from: e  reason: collision with root package name */
        public int f47119e;

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, Integer> f47120f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.l0.a.m1.i.b f47121g;

        /* renamed from: d.a.l0.a.m1.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0794a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f47123e;

            public RunnableC0794a(d dVar) {
                this.f47123e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.w(this.f47123e.f47135a);
                Bitmap p = n0.p();
                if (p != null) {
                    d dVar = this.f47123e;
                    Message.obtain(a.this, 8, new d.a.l0.a.m1.h.d(dVar.f47135a, p, dVar.f47143i)).sendToTarget();
                }
            }
        }

        /* renamed from: d.a.l0.a.m1.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0795b implements Runnable {

            /* renamed from: d.a.l0.a.m1.b$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0796a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Bitmap f47126e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f47127f;

                /* renamed from: d.a.l0.a.m1.b$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes3.dex */
                public class RunnableC0797a implements Runnable {

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ SwanAppActivity f47129e;

                    public RunnableC0797a(RunnableC0796a runnableC0796a, SwanAppActivity swanAppActivity) {
                        this.f47129e = swanAppActivity;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.f47113f) {
                            Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                        }
                        this.f47129e.finish();
                    }
                }

                public RunnableC0796a(Bitmap bitmap, SwanAppActivity swanAppActivity) {
                    this.f47126e = bitmap;
                    this.f47127f = swanAppActivity;
                }

                public final void a(SwanAppActivity swanAppActivity) {
                    q0.X(new RunnableC0797a(this, swanAppActivity));
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f47118d.a(this.f47126e, a.this.f47115a.f47142h)) {
                        e.c(a.this.f47115a, 33, false, a.this.f47116b.size());
                        d.a.l0.a.h0.i.f.a("exit_whiteScreen_L1");
                        a(this.f47127f);
                        return;
                    }
                    double d2 = a.this.f47121g.d(this.f47126e, a.this.f47115a.f47142h);
                    if (d2 >= 0.7d && a.this.f47119e == 0) {
                        d.a.l0.a.h0.i.f.a("exit_whiteScreen_L2");
                        a(this.f47127f);
                    } else if (d2 < 0.5d || !c.g()) {
                    } else {
                        d.a.l0.a.h0.i.f.a("exit_whiteScreen_L3");
                        a(this.f47127f);
                    }
                }
            }

            public RunnableC0795b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity = d.a.l0.a.g1.f.V().getActivity();
                if (activity == null || activity.isFinishing() || activity.isDestroyed() || a.this.f47115a == null) {
                    return;
                }
                q.e().execute(new RunnableC0796a(n0.p(), activity), "SwanPageMonitorRecheck");
            }
        }

        public a(Looper looper) {
            super(looper);
            this.f47116b = new ArrayDeque();
            this.f47117c = true;
            this.f47119e = 0;
            this.f47118d = a.C0799a.a("simple_parser");
            this.f47121g = (d.a.l0.a.m1.i.b) a.C0799a.a("hsv_parser");
        }

        public final void g(d dVar) {
            if (dVar == null || !j(dVar.f47135a)) {
                return;
            }
            q0.b0(new RunnableC0794a(dVar));
        }

        public int h() {
            return this.f47119e;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.f47113f) {
                Log.d("SwanAppPageMonitor", "get message " + message.what);
            }
            switch (message.what) {
                case 1:
                    removeMessages(9);
                    removeMessages(10);
                    if (h.f46805e) {
                        r((d.a.l0.a.m1.h.c) message.obj);
                        return;
                    } else {
                        q((d.a.l0.a.m1.h.c) message.obj);
                        return;
                    }
                case 2:
                    g((d) message.obj);
                    return;
                case 3:
                    removeMessages(2);
                    removeMessages(8);
                    return;
                case 4:
                    if (((d.a.l0.a.m1.h.b) message.obj).e()) {
                        k();
                        return;
                    } else {
                        n();
                        return;
                    }
                case 5:
                    d.a.l0.a.m1.h.a aVar = (d.a.l0.a.m1.h.a) message.obj;
                    if (aVar != null) {
                        if (aVar.e()) {
                            this.f47119e++;
                            return;
                        } else {
                            this.f47119e--;
                            return;
                        }
                    }
                    return;
                case 6:
                    s((d.a.l0.a.m1.h.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    v();
                    return;
                case 8:
                    t((d.a.l0.a.m1.h.d) message.obj);
                    return;
                case 9:
                    p((d.a.l0.a.m1.h.c) message.obj);
                    return;
                case 10:
                    o();
                    return;
                case 11:
                    m();
                    return;
                case 12:
                    l((d.a.l0.a.m1.h.c) message.obj);
                    return;
                case 13:
                    r((d.a.l0.a.m1.h.c) message.obj);
                    return;
                default:
                    return;
            }
        }

        public final boolean i() {
            d dVar = this.f47115a;
            return dVar != null && dVar.f47143i;
        }

        public final boolean j(String str) {
            d dVar = this.f47115a;
            return (dVar == null || str == null || !TextUtils.equals(str, dVar.f47135a)) ? false : true;
        }

        public final void k() {
            this.f47117c = true;
            d dVar = this.f47115a;
            if (dVar == null || dVar.c()) {
                return;
            }
            if (b.this.f47114e != null) {
                b.this.f47114e.removeMessages(2);
            }
            this.f47115a.d();
            if (b.f47113f) {
                Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.f47115a.f47143i);
            }
        }

        public final void l(d.a.l0.a.m1.h.c cVar) {
            b.this.f47114e.removeMessages(2);
            d dVar = this.f47115a;
            String str = dVar != null ? dVar.f47135a : StringUtil.NULL_STRING;
            if (b.f47113f) {
                Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + cVar.a());
            }
        }

        public final void m() {
            d dVar = this.f47115a;
            if (dVar != null && dVar.c() && this.f47115a.f47137c && i()) {
                u();
            }
            if (i()) {
                i.c();
            }
        }

        public final void n() {
            this.f47117c = false;
            d dVar = this.f47115a;
            if (dVar == null || !dVar.f47143i || dVar.c()) {
                return;
            }
            this.f47115a.e();
            long b2 = this.f47115a.b();
            if (b2 >= 0) {
                b.this.f47114e.sendMessageDelayed(Message.obtain(b.this.f47114e, 2, this.f47115a), b2);
            }
            if (b.f47113f) {
                Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.f47115a.f47143i);
            }
        }

        public final void o() {
            View view;
            SwanAppActivity activity = d.a.l0.a.g1.f.V().getActivity();
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            d.a.l0.a.w2.e loadingView = activity.getLoadingView();
            boolean z = (loadingView == null || (view = loadingView.f49341a) == null || view.getVisibility() != 0) ? false : true;
            if (b.f47113f) {
                Log.d("SwanAppPageMonitor", "Loading check result: " + z);
            }
            if (z) {
                d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
                aVar.j(5L);
                aVar.h(19L);
                aVar.e("loading=true");
                b.a N = d.a.l0.a.a2.e.i() != null ? d.a.l0.a.a2.e.i().N() : null;
                d.a.l0.a.j2.p.d dVar = new d.a.l0.a.j2.p.d();
                dVar.p(aVar);
                dVar.r(N);
                dVar.q(k.m(d.a.l0.a.a2.d.g().l()));
                dVar.m(d.a.l0.a.a2.d.g().getAppId());
                dVar.s(String.valueOf(this.f47116b.size()));
                dVar.n(false);
                k.L(dVar);
            }
        }

        public final void p(@NonNull d.a.l0.a.m1.h.c cVar) {
            if (cVar.c() >= 0) {
                d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
                if (W == null || W.k() <= 0) {
                    if (b.f47113f) {
                        Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.c());
                    }
                    b.this.f47114e.sendMessageDelayed(Message.obtain(b.this.f47114e, 10, cVar), cVar.c());
                }
            }
        }

        public final void q(d.a.l0.a.m1.h.c cVar) {
            d.a.l0.a.h0.g.f f2 = c.f();
            if (f2 != null) {
                String g3 = f2.g3();
                d.a.l0.a.p.e.b b3 = f2.b3();
                if (b.f47113f && b3 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + g3);
                }
                if (b3 == null || j(g3)) {
                    return;
                }
                d dVar = new d(g3, f2.Z2().f47033e, cVar.c(), cVar.a());
                this.f47116b.addLast(dVar);
                this.f47115a = dVar;
                b3.v(g.f());
                HashMap<String, Integer> hashMap = this.f47120f;
                if (hashMap != null && hashMap.containsKey(g3)) {
                    this.f47115a.f47141g = this.f47120f.remove(g3).intValue();
                }
                if (this.f47117c || dVar.b() < 0) {
                    return;
                }
                b.this.f47114e.sendMessageDelayed(Message.obtain(b.this.f47114e, 2, dVar), this.f47115a.b());
            }
        }

        public final void r(d.a.l0.a.m1.h.c cVar) {
            d.a.l0.a.p.e.b b3;
            d.a.l0.a.h0.g.f f2 = c.f();
            if (f2 == null || (b3 = f2.b3()) == null) {
                return;
            }
            String g3 = f2.g3();
            d dVar = new d(g3, f2.Z2().f47033e, cVar.c(), cVar.a());
            if (!j(g3)) {
                this.f47116b.addLast(dVar);
                b3.v(g.f());
            }
            this.f47115a = dVar;
            HashMap<String, Integer> hashMap = this.f47120f;
            if (hashMap != null && hashMap.containsKey(g3)) {
                this.f47115a.f47141g = this.f47120f.get(g3).intValue();
            }
            if (this.f47117c || dVar.b() < 0) {
                return;
            }
            b.this.f47114e.sendMessageDelayed(Message.obtain(b.this.f47114e, 2, dVar), this.f47115a.b());
            if (b.f47113f) {
                Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + g3 + " time=" + this.f47115a.b() + " isNewLaunch=" + this.f47115a.f47143i);
            }
        }

        public final void s(d.a.l0.a.m1.h.e eVar) {
            Integer num;
            if (eVar == null) {
                return;
            }
            String d2 = eVar.d();
            d dVar = null;
            Iterator<d> it = this.f47116b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (TextUtils.equals(next.f47135a, d2)) {
                    dVar = next;
                    break;
                }
            }
            if (eVar.e()) {
                if (dVar != null) {
                    dVar.f47141g++;
                    return;
                }
                if (this.f47120f == null) {
                    this.f47120f = new HashMap<>();
                }
                Integer num2 = this.f47120f.get(d2);
                this.f47120f.put(d2, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (dVar != null) {
                dVar.f47141g--;
            } else {
                HashMap<String, Integer> hashMap = this.f47120f;
                if (hashMap == null || (num = hashMap.get(d2)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f47120f.put(d2, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void t(d.a.l0.a.m1.h.d dVar) {
            if (dVar == null || !j(dVar.d())) {
                return;
            }
            Bitmap e2 = dVar.e();
            d.a.l0.a.h0.g.f f2 = c.f();
            AbsoluteLayout C = d.a.l0.a.g1.f.V().C(dVar.d());
            if (e2 == null || C == null || f2 == null) {
                return;
            }
            Rect b2 = c.b(e2, f2, C);
            this.f47118d.c(c.d(f2));
            this.f47115a.g();
            boolean a2 = dVar.a();
            if (!c.h() && this.f47119e <= 0) {
                this.f47115a.f47137c = this.f47118d.a(e2, b2);
                d dVar2 = this.f47115a;
                if (dVar2.f47137c) {
                    if (a2) {
                        dVar2.f(e2);
                        this.f47115a.f47142h = b2;
                    }
                    c.i(a2);
                    int i2 = 19;
                    if (h.f46805e && !a2) {
                        i2 = 55;
                    }
                    e.c(this.f47115a, i2, a2, this.f47116b.size());
                }
            } else {
                this.f47115a.f47137c = false;
            }
            this.f47115a.a();
            if (b.f47113f) {
                Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + dVar.d() + " isWhite=" + this.f47115a.f47137c + " isNewLaunch=" + a2);
            }
            if (this.f47115a.f47137c) {
                return;
            }
            double d2 = this.f47121g.d(e2, b2);
            int i3 = (d2 > 0.5d ? 1 : (d2 == 0.5d ? 0 : -1));
            if (i3 >= 0) {
                int i4 = 28;
                if (h.f46805e && !a2) {
                    i4 = 56;
                }
                e.d(this.f47115a, i4, x(), e2, a2, this.f47116b.size());
            }
            if (a2) {
                if (c.g()) {
                    if (i3 >= 0) {
                        c.j("whiteScreen_L3", d.a.l0.a.h0.i.c.f45840c);
                        this.f47115a.f47137c = true;
                    }
                } else if (this.f47119e != 0 || d2 < 0.7d) {
                } else {
                    c.j("whiteScreen_L2", d.a.l0.a.h0.i.c.f45839b);
                    this.f47115a.f47137c = true;
                }
            }
        }

        public final void u() {
            if (b.f47113f) {
                Log.d("SwanAppPageMonitor", "recheckAndExit");
            }
            q0.X(new RunnableC0795b());
        }

        public final void v() {
            this.f47116b.clear();
            HashMap<String, Integer> hashMap = this.f47120f;
            if (hashMap != null) {
                hashMap.clear();
            }
            this.f47115a = null;
        }

        public final void w(String str) {
            if (i()) {
                d.a.l0.a.g1.f.V().v(d.a.l0.a.i2.b.a(new d.a.l0.a.i2.b()));
                d.a.l0.a.g1.f.V().m(str, d.a.l0.a.i2.b.a(new d.a.l0.a.i2.b()));
                if (b.f47113f) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        public final boolean x() {
            String string = d.a.l0.a.k2.g.h.a().getString("screenshot_upload_switch", "1");
            if (b.f47113f) {
                Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }
    }

    public b() {
        super("SwanAppPageMonitor");
        e();
    }

    @Override // d.a.l0.a.m1.a
    public void a(d.a.l0.a.m1.h.c cVar) {
        if (!isAlive()) {
            if (f47113f) {
                Log.d("SwanAppPageMonitor", "thread is not alive");
            }
            try {
                e();
            } catch (Error | Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (cVar != null) {
            Message.obtain(this.f47114e, cVar.b(), cVar).sendToTarget();
        }
    }

    public int d() {
        a aVar = this.f47114e;
        if (aVar != null) {
            return aVar.h();
        }
        return 0;
    }

    public final void e() {
        start();
        this.f47114e = new a(getLooper());
    }
}
