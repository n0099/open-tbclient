package d.a.h0.a.f1;

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
import com.baidu.swan.apps.SwanAppActivity;
import d.a.h0.a.e0.f;
import d.a.h0.a.f1.h.a;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.p;
import d.a.h0.a.y0.e.b;
import d.a.h0.a.z1.h;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends HandlerThread implements d.a.h0.a.f1.a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f42427f = d.a.h0.a.r1.e.x;

    /* renamed from: e  reason: collision with root package name */
    public a f42428e;

    /* loaded from: classes3.dex */
    public class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public d f42429a;

        /* renamed from: b  reason: collision with root package name */
        public Deque<d> f42430b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f42431c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.h0.a.f1.h.a f42432d;

        /* renamed from: e  reason: collision with root package name */
        public int f42433e;

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, Integer> f42434f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.h0.a.f1.h.b f42435g;

        /* renamed from: d.a.h0.a.f1.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0657a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f42437e;

            public RunnableC0657a(d dVar) {
                this.f42437e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.q(this.f42437e.f42449a);
                Bitmap n = h0.n();
                if (n != null) {
                    Message.obtain(a.this, 8, new d.a.h0.a.f1.g.d(this.f42437e.f42449a, n)).sendToTarget();
                }
            }
        }

        /* renamed from: d.a.h0.a.f1.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0658b implements Runnable {

            /* renamed from: d.a.h0.a.f1.b$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0659a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Bitmap f42440e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f42441f;

                /* renamed from: d.a.h0.a.f1.b$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes3.dex */
                public class RunnableC0660a implements Runnable {
                    public RunnableC0660a() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.f42427f) {
                            Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                        }
                        RunnableC0659a.this.f42441f.finish();
                    }
                }

                public RunnableC0659a(Bitmap bitmap, SwanAppActivity swanAppActivity) {
                    this.f42440e = bitmap;
                    this.f42441f = swanAppActivity;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f42432d.a(this.f42440e, a.this.f42429a.f42456h)) {
                        a aVar = a.this;
                        aVar.e(aVar.f42429a, 33, false, null);
                        k0.T(new RunnableC0660a());
                    }
                }
            }

            public RunnableC0658b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
                if (activity == null || activity.isFinishing() || activity.isDestroyed() || a.this.f42429a == null) {
                    return;
                }
                p.f().execute(new RunnableC0659a(h0.n(), activity), "SwanPageMonitorRecheck");
            }
        }

        public a(Looper looper) {
            super(looper);
            this.f42430b = new ArrayDeque();
            this.f42431c = true;
            this.f42433e = 0;
            this.f42432d = a.C0662a.a("simple_parser");
            this.f42435g = (d.a.h0.a.f1.h.b) a.C0662a.a("hsv_parser");
        }

        public final void e(d dVar, int i2, boolean z, Bitmap bitmap) {
            if (b.f42427f) {
                Log.d("SwanAppPageMonitor", "errorReport: error report with error=" + i2);
            }
            JSONObject e2 = c.e();
            try {
                e2.put("page", dVar.f42450b);
                e2.put("firstPage", g());
                if (z && bitmap != null) {
                    e2.put("image", c.c(bitmap));
                }
            } catch (JSONException e3) {
                if (b.f42427f) {
                    e3.printStackTrace();
                }
            }
            String jSONObject = e2.toString();
            d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
            aVar.j(5L);
            aVar.h(i2);
            aVar.e(jSONObject);
            b.a L = d.a.h0.a.r1.e.h() != null ? d.a.h0.a.r1.e.h().L() : null;
            d.a.h0.a.z1.k.d dVar2 = new d.a.h0.a.z1.k.d();
            dVar2.p(aVar);
            dVar2.r(L);
            dVar2.q(h.n(d.a.h0.a.r1.d.e().j()));
            dVar2.m(d.a.h0.a.r1.e.T());
            dVar2.s(String.valueOf(this.f42430b.size()));
            dVar2.n(false);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("isH5Componet", dVar.f42455g == 0 ? "0" : "1");
                dVar2.e(jSONObject2);
            } catch (JSONException e4) {
                if (b.f42427f) {
                    e4.printStackTrace();
                }
            }
            if (g()) {
                dVar2.e(d.a.h0.a.y1.a.d().e());
                dVar2.e(d.a.h0.a.y1.a.d().g());
            }
            h.H(dVar2);
        }

        public final void f(d dVar) {
            if (dVar == null || !h(dVar.f42449a)) {
                return;
            }
            k0.X(new RunnableC0657a(dVar));
        }

        public final boolean g() {
            d dVar = this.f42429a;
            return dVar != null && dVar.f42457i;
        }

        public final boolean h(String str) {
            d dVar = this.f42429a;
            return (dVar == null || str == null || !TextUtils.equals(str, dVar.f42449a)) ? false : true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.f42427f) {
                Log.d("SwanAppPageMonitor", "get message " + message.what);
            }
            switch (message.what) {
                case 1:
                    removeMessages(9);
                    removeMessages(10);
                    m((d.a.h0.a.f1.g.c) message.obj);
                    return;
                case 2:
                    f((d) message.obj);
                    return;
                case 3:
                    removeMessages(2);
                    removeMessages(8);
                    return;
                case 4:
                    if (((d.a.h0.a.f1.g.b) message.obj).e()) {
                        i();
                        return;
                    } else {
                        j();
                        return;
                    }
                case 5:
                    d.a.h0.a.f1.g.a aVar = (d.a.h0.a.f1.g.a) message.obj;
                    if (aVar != null) {
                        if (aVar.e()) {
                            this.f42433e++;
                            return;
                        } else {
                            this.f42433e--;
                            return;
                        }
                    }
                    return;
                case 6:
                    n((d.a.h0.a.f1.g.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.f42430b.clear();
                    this.f42429a = null;
                    return;
                case 8:
                    o((d.a.h0.a.f1.g.d) message.obj);
                    return;
                case 9:
                    l((d.a.h0.a.f1.g.c) message.obj);
                    return;
                case 10:
                    k();
                    return;
                default:
                    return;
            }
        }

        public final void i() {
            this.f42431c = true;
            d dVar = this.f42429a;
            if (dVar == null) {
                return;
            }
            if (!dVar.c()) {
                if (b.this.f42428e != null) {
                    b.this.f42428e.removeMessages(2);
                }
                this.f42429a.d();
            } else if (this.f42429a.f42451c && g()) {
                p();
            }
        }

        public final void j() {
            this.f42431c = false;
            d dVar = this.f42429a;
            if (dVar == null || dVar.c()) {
                return;
            }
            this.f42429a.e();
            long b2 = this.f42429a.b();
            if (b2 >= 0) {
                b.this.f42428e.sendMessageDelayed(Message.obtain(b.this.f42428e, 2, this.f42429a), b2);
            }
        }

        public final void k() {
            View view;
            SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
            if (activity == null || activity.isFinishing() || activity.isDestroyed() || activity.getLoadingView() == null || activity.getLoadingView().f43035a == null) {
                return;
            }
            d.a.h0.a.j2.d loadingView = activity.getLoadingView();
            boolean z = (loadingView == null || (view = loadingView.f43035a) == null || view.getVisibility() != 0) ? false : true;
            if (b.f42427f) {
                Log.d("SwanAppPageMonitor", "Loading check result: " + z);
            }
            if (z) {
                d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
                aVar.j(5L);
                aVar.h(19L);
                aVar.e("loading=true");
                b.a L = d.a.h0.a.r1.e.h() != null ? d.a.h0.a.r1.e.h().L() : null;
                d.a.h0.a.z1.k.d dVar = new d.a.h0.a.z1.k.d();
                dVar.p(aVar);
                dVar.r(L);
                dVar.q(h.n(d.a.h0.a.r1.d.e().j()));
                dVar.m(d.a.h0.a.r1.d.e().getAppId());
                dVar.s(String.valueOf(this.f42430b.size()));
                dVar.n(false);
                h.H(dVar);
            }
        }

        public final void l(@NonNull d.a.h0.a.f1.g.c cVar) {
            if (cVar.c() >= 0) {
                d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
                if (W == null || W.k() <= 0) {
                    if (b.f42427f) {
                        Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.c());
                    }
                    b.this.f42428e.sendMessageDelayed(Message.obtain(b.this.f42428e, 10, cVar), cVar.c());
                }
            }
        }

        public final void m(d.a.h0.a.f1.g.c cVar) {
            d.a.h0.a.e0.l.e f2 = c.f();
            if (f2 != null) {
                String W2 = f2.W2();
                d.a.h0.a.p.d.b S2 = f2.S2();
                if (b.f42427f && S2 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + W2);
                }
                if (S2 == null || h(W2)) {
                    return;
                }
                d dVar = new d(W2, f2.Q2().f42392a, cVar.c(), cVar.a());
                this.f42430b.addLast(dVar);
                this.f42429a = dVar;
                S2.t(f.e());
                HashMap<String, Integer> hashMap = this.f42434f;
                if (hashMap != null && hashMap.containsKey(W2)) {
                    this.f42429a.f42455g = this.f42434f.remove(W2).intValue();
                }
                if (this.f42431c || dVar.b() < 0) {
                    return;
                }
                b.this.f42428e.sendMessageDelayed(Message.obtain(b.this.f42428e, 2, dVar), this.f42429a.b());
            }
        }

        public final void n(d.a.h0.a.f1.g.e eVar) {
            Integer num;
            if (eVar == null) {
                return;
            }
            String d2 = eVar.d();
            d dVar = null;
            Iterator<d> it = this.f42430b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (TextUtils.equals(next.f42449a, d2)) {
                    dVar = next;
                    break;
                }
            }
            if (eVar.e()) {
                if (dVar != null) {
                    dVar.f42455g++;
                    return;
                }
                if (this.f42434f == null) {
                    this.f42434f = new HashMap<>();
                }
                Integer num2 = this.f42434f.get(d2);
                this.f42434f.put(d2, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (dVar != null) {
                dVar.f42455g--;
            } else {
                HashMap<String, Integer> hashMap = this.f42434f;
                if (hashMap == null || (num = hashMap.get(d2)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f42434f.put(d2, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void o(d.a.h0.a.f1.g.d dVar) {
            if (dVar == null || !h(dVar.d())) {
                return;
            }
            Bitmap e2 = dVar.e();
            d.a.h0.a.e0.l.e f2 = c.f();
            AbsoluteLayout C = d.a.h0.a.z0.f.V().C(dVar.d());
            if (e2 == null || C == null || f2 == null) {
                return;
            }
            Rect b2 = c.b(e2, f2, C);
            this.f42432d.c(c.d(f2));
            this.f42429a.g();
            boolean g2 = g();
            if (!c.h() && this.f42433e <= 0) {
                this.f42429a.f42451c = this.f42432d.a(e2, b2);
                d dVar2 = this.f42429a;
                if (dVar2.f42451c) {
                    if (g2) {
                        dVar2.f(e2);
                        this.f42429a.f42456h = b2;
                    }
                    c.i(g2);
                    e(this.f42429a, 19, false, null);
                }
            } else {
                this.f42429a.f42451c = false;
            }
            this.f42429a.a();
            if (g2) {
                double d2 = this.f42435g.d(e2, b2);
                if (d2 >= 0.5d) {
                    e(this.f42429a, 28, r(), e2);
                }
                if (this.f42429a.f42451c) {
                    return;
                }
                if (c.g()) {
                    if (d2 >= f.b.f41896e) {
                        c.j("whiteScreen_L3", d.a.h0.a.e0.a.f41877c);
                    }
                } else if (this.f42433e != 0 || d2 < f.b.f41897f) {
                } else {
                    c.j("whiteScreen_L2", d.a.h0.a.e0.a.f41876b);
                }
            }
        }

        public final void p() {
            if (b.f42427f) {
                Log.d("SwanAppPageMonitor", "recheckAndExit");
            }
            k0.T(new RunnableC0658b());
        }

        public final void q(String str) {
            if (g()) {
                d.a.h0.a.z0.f.V().x(d.a.h0.a.y1.b.a(new d.a.h0.a.y1.b()));
                d.a.h0.a.z0.f.V().o(str, d.a.h0.a.y1.b.a(new d.a.h0.a.y1.b()));
                if (b.f42427f) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        public final boolean r() {
            String string = d.a.h0.a.a2.g.h.a().getString("screenshot_upload_switch", "1");
            if (b.f42427f) {
                Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }
    }

    public b() {
        super("SwanAppPageMonitor");
        d();
    }

    @Override // d.a.h0.a.f1.a
    public void a(d.a.h0.a.f1.g.c cVar) {
        if (!isAlive()) {
            if (f42427f) {
                Log.d("SwanAppPageMonitor", "thread is not alive");
            }
            try {
                d();
            } catch (Error | Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (cVar != null) {
            Message.obtain(this.f42428e, cVar.b(), cVar).sendToTarget();
        }
    }

    public final void d() {
        start();
        this.f42428e = new a(getLooper());
    }
}
