package d.b.g0.a.f1;

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
import d.b.g0.a.e0.f;
import d.b.g0.a.f1.h.a;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.p;
import d.b.g0.a.y0.e.b;
import d.b.g0.a.z1.h;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends HandlerThread implements d.b.g0.a.f1.a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f44788f = d.b.g0.a.r1.e.x;

    /* renamed from: e  reason: collision with root package name */
    public a f44789e;

    /* loaded from: classes2.dex */
    public class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public d f44790a;

        /* renamed from: b  reason: collision with root package name */
        public Deque<d> f44791b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f44792c;

        /* renamed from: d  reason: collision with root package name */
        public d.b.g0.a.f1.h.a f44793d;

        /* renamed from: e  reason: collision with root package name */
        public int f44794e;

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, Integer> f44795f;

        /* renamed from: g  reason: collision with root package name */
        public d.b.g0.a.f1.h.b f44796g;

        /* renamed from: d.b.g0.a.f1.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0698a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f44798e;

            public RunnableC0698a(d dVar) {
                this.f44798e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.q(this.f44798e.f44810a);
                Bitmap n = h0.n();
                if (n != null) {
                    Message.obtain(a.this, 8, new d.b.g0.a.f1.g.d(this.f44798e.f44810a, n)).sendToTarget();
                }
            }
        }

        /* renamed from: d.b.g0.a.f1.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0699b implements Runnable {

            /* renamed from: d.b.g0.a.f1.b$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC0700a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Bitmap f44801e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f44802f;

                /* renamed from: d.b.g0.a.f1.b$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes2.dex */
                public class RunnableC0701a implements Runnable {
                    public RunnableC0701a() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.f44788f) {
                            Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                        }
                        RunnableC0700a.this.f44802f.finish();
                    }
                }

                public RunnableC0700a(Bitmap bitmap, SwanAppActivity swanAppActivity) {
                    this.f44801e = bitmap;
                    this.f44802f = swanAppActivity;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f44793d.a(this.f44801e, a.this.f44790a.f44817h)) {
                        a aVar = a.this;
                        aVar.e(aVar.f44790a, 33, false, null);
                        k0.T(new RunnableC0701a());
                    }
                }
            }

            public RunnableC0699b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
                if (activity == null || activity.isFinishing() || activity.isDestroyed() || a.this.f44790a == null) {
                    return;
                }
                p.f().execute(new RunnableC0700a(h0.n(), activity), "SwanPageMonitorRecheck");
            }
        }

        public a(Looper looper) {
            super(looper);
            this.f44791b = new ArrayDeque();
            this.f44792c = true;
            this.f44794e = 0;
            this.f44793d = a.C0703a.a("simple_parser");
            this.f44796g = (d.b.g0.a.f1.h.b) a.C0703a.a("hsv_parser");
        }

        public final void e(d dVar, int i, boolean z, Bitmap bitmap) {
            if (b.f44788f) {
                Log.d("SwanAppPageMonitor", "errorReport: error report with error=" + i);
            }
            JSONObject e2 = c.e();
            try {
                e2.put("page", dVar.f44811b);
                e2.put("firstPage", g());
                if (z && bitmap != null) {
                    e2.put("image", c.c(bitmap));
                }
            } catch (JSONException e3) {
                if (b.f44788f) {
                    e3.printStackTrace();
                }
            }
            String jSONObject = e2.toString();
            d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
            aVar.j(5L);
            aVar.h(i);
            aVar.e(jSONObject);
            b.a L = d.b.g0.a.r1.e.y() != null ? d.b.g0.a.r1.e.y().L() : null;
            d.b.g0.a.z1.k.d dVar2 = new d.b.g0.a.z1.k.d();
            dVar2.p(aVar);
            dVar2.r(L);
            dVar2.q(h.n(d.b.g0.a.r1.d.e().h()));
            dVar2.m(d.b.g0.a.r1.e.T());
            dVar2.s(String.valueOf(this.f44791b.size()));
            dVar2.n(false);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("isH5Componet", dVar.f44816g == 0 ? "0" : "1");
                dVar2.e(jSONObject2);
            } catch (JSONException e4) {
                if (b.f44788f) {
                    e4.printStackTrace();
                }
            }
            if (g()) {
                dVar2.e(d.b.g0.a.y1.a.d().e());
                dVar2.e(d.b.g0.a.y1.a.d().g());
            }
            h.H(dVar2);
        }

        public final void f(d dVar) {
            if (dVar == null || !h(dVar.f44810a)) {
                return;
            }
            k0.X(new RunnableC0698a(dVar));
        }

        public final boolean g() {
            d dVar = this.f44790a;
            return dVar != null && dVar.i;
        }

        public final boolean h(String str) {
            d dVar = this.f44790a;
            return (dVar == null || str == null || !TextUtils.equals(str, dVar.f44810a)) ? false : true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.f44788f) {
                Log.d("SwanAppPageMonitor", "get message " + message.what);
            }
            switch (message.what) {
                case 1:
                    removeMessages(9);
                    removeMessages(10);
                    m((d.b.g0.a.f1.g.c) message.obj);
                    return;
                case 2:
                    f((d) message.obj);
                    return;
                case 3:
                    removeMessages(2);
                    removeMessages(8);
                    return;
                case 4:
                    if (((d.b.g0.a.f1.g.b) message.obj).e()) {
                        i();
                        return;
                    } else {
                        j();
                        return;
                    }
                case 5:
                    d.b.g0.a.f1.g.a aVar = (d.b.g0.a.f1.g.a) message.obj;
                    if (aVar != null) {
                        if (aVar.e()) {
                            this.f44794e++;
                            return;
                        } else {
                            this.f44794e--;
                            return;
                        }
                    }
                    return;
                case 6:
                    n((d.b.g0.a.f1.g.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.f44791b.clear();
                    this.f44790a = null;
                    return;
                case 8:
                    o((d.b.g0.a.f1.g.d) message.obj);
                    return;
                case 9:
                    l((d.b.g0.a.f1.g.c) message.obj);
                    return;
                case 10:
                    k();
                    return;
                default:
                    return;
            }
        }

        public final void i() {
            this.f44792c = true;
            d dVar = this.f44790a;
            if (dVar == null) {
                return;
            }
            if (!dVar.c()) {
                if (b.this.f44789e != null) {
                    b.this.f44789e.removeMessages(2);
                }
                this.f44790a.d();
            } else if (this.f44790a.f44812c && g()) {
                p();
            }
        }

        public final void j() {
            this.f44792c = false;
            d dVar = this.f44790a;
            if (dVar == null || dVar.c()) {
                return;
            }
            this.f44790a.e();
            long b2 = this.f44790a.b();
            if (b2 >= 0) {
                b.this.f44789e.sendMessageDelayed(Message.obtain(b.this.f44789e, 2, this.f44790a), b2);
            }
        }

        public final void k() {
            View view;
            SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
            if (activity == null || activity.isFinishing() || activity.isDestroyed() || activity.getLoadingView() == null || activity.getLoadingView().f45380a == null) {
                return;
            }
            d.b.g0.a.j2.d loadingView = activity.getLoadingView();
            boolean z = (loadingView == null || (view = loadingView.f45380a) == null || view.getVisibility() != 0) ? false : true;
            if (b.f44788f) {
                Log.d("SwanAppPageMonitor", "Loading check result: " + z);
            }
            if (z) {
                d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
                aVar.j(5L);
                aVar.h(19L);
                aVar.e("loading=true");
                b.a L = d.b.g0.a.r1.e.y() != null ? d.b.g0.a.r1.e.y().L() : null;
                d.b.g0.a.z1.k.d dVar = new d.b.g0.a.z1.k.d();
                dVar.p(aVar);
                dVar.r(L);
                dVar.q(h.n(d.b.g0.a.r1.d.e().h()));
                dVar.m(d.b.g0.a.r1.d.e().getAppId());
                dVar.s(String.valueOf(this.f44791b.size()));
                dVar.n(false);
                h.H(dVar);
            }
        }

        public final void l(@NonNull d.b.g0.a.f1.g.c cVar) {
            if (cVar.c() >= 0) {
                d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
                if (W == null || W.k() <= 0) {
                    if (b.f44788f) {
                        Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cVar.c());
                    }
                    b.this.f44789e.sendMessageDelayed(Message.obtain(b.this.f44789e, 10, cVar), cVar.c());
                }
            }
        }

        public final void m(d.b.g0.a.f1.g.c cVar) {
            d.b.g0.a.e0.l.e f2 = c.f();
            if (f2 != null) {
                String X2 = f2.X2();
                d.b.g0.a.p.d.b T2 = f2.T2();
                if (b.f44788f && T2 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + X2);
                }
                if (T2 == null || h(X2)) {
                    return;
                }
                d dVar = new d(X2, f2.R2().f44754a, cVar.c(), cVar.a());
                this.f44791b.addLast(dVar);
                this.f44790a = dVar;
                T2.G(f.e());
                HashMap<String, Integer> hashMap = this.f44795f;
                if (hashMap != null && hashMap.containsKey(X2)) {
                    this.f44790a.f44816g = this.f44795f.remove(X2).intValue();
                }
                if (this.f44792c || dVar.b() < 0) {
                    return;
                }
                b.this.f44789e.sendMessageDelayed(Message.obtain(b.this.f44789e, 2, dVar), this.f44790a.b());
            }
        }

        public final void n(d.b.g0.a.f1.g.e eVar) {
            Integer num;
            if (eVar == null) {
                return;
            }
            String d2 = eVar.d();
            d dVar = null;
            Iterator<d> it = this.f44791b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (TextUtils.equals(next.f44810a, d2)) {
                    dVar = next;
                    break;
                }
            }
            if (eVar.e()) {
                if (dVar != null) {
                    dVar.f44816g++;
                    return;
                }
                if (this.f44795f == null) {
                    this.f44795f = new HashMap<>();
                }
                Integer num2 = this.f44795f.get(d2);
                this.f44795f.put(d2, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (dVar != null) {
                dVar.f44816g--;
            } else {
                HashMap<String, Integer> hashMap = this.f44795f;
                if (hashMap == null || (num = hashMap.get(d2)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f44795f.put(d2, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void o(d.b.g0.a.f1.g.d dVar) {
            if (dVar == null || !h(dVar.d())) {
                return;
            }
            Bitmap e2 = dVar.e();
            d.b.g0.a.e0.l.e f2 = c.f();
            AbsoluteLayout m = d.b.g0.a.z0.f.V().m(dVar.d());
            if (e2 == null || m == null || f2 == null) {
                return;
            }
            Rect b2 = c.b(e2, f2, m);
            this.f44793d.c(c.d(f2));
            this.f44790a.g();
            boolean g2 = g();
            if (!c.h() && this.f44794e <= 0) {
                this.f44790a.f44812c = this.f44793d.a(e2, b2);
                d dVar2 = this.f44790a;
                if (dVar2.f44812c) {
                    if (g2) {
                        dVar2.f(e2);
                        this.f44790a.f44817h = b2;
                    }
                    c.i(g2);
                    e(this.f44790a, 19, false, null);
                }
            } else {
                this.f44790a.f44812c = false;
            }
            this.f44790a.a();
            if (g2) {
                double d2 = this.f44796g.d(e2, b2);
                if (d2 >= 0.5d) {
                    e(this.f44790a, 28, r(), e2);
                }
                if (this.f44790a.f44812c) {
                    return;
                }
                if (c.g()) {
                    if (d2 >= f.b.f44271e) {
                        c.j("whiteScreen_L3", d.b.g0.a.e0.a.f44252c);
                    }
                } else if (this.f44794e != 0 || d2 < f.b.f44272f) {
                } else {
                    c.j("whiteScreen_L2", d.b.g0.a.e0.a.f44251b);
                }
            }
        }

        public final void p() {
            if (b.f44788f) {
                Log.d("SwanAppPageMonitor", "recheckAndExit");
            }
            k0.T(new RunnableC0699b());
        }

        public final void q(String str) {
            if (g()) {
                d.b.g0.a.z0.f.V().N(d.b.g0.a.y1.b.a(new d.b.g0.a.y1.b()));
                d.b.g0.a.z0.f.V().z(str, d.b.g0.a.y1.b.a(new d.b.g0.a.y1.b()));
                if (b.f44788f) {
                    Log.d("SwanAppPageMonitor", "Send master/slave white screen event to fe, done");
                }
            }
        }

        public final boolean r() {
            String string = d.b.g0.a.a2.g.h.a().getString("screenshot_upload_switch", "1");
            if (b.f44788f) {
                Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }
    }

    public b() {
        super("SwanAppPageMonitor");
        d();
    }

    @Override // d.b.g0.a.f1.a
    public void a(d.b.g0.a.f1.g.c cVar) {
        if (!isAlive()) {
            if (f44788f) {
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
            Message.obtain(this.f44789e, cVar.b(), cVar).sendToTarget();
        }
    }

    public final void d() {
        start();
        this.f44789e = new a(getLooper());
    }
}
