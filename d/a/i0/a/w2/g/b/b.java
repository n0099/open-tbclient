package d.a.i0.a.w2.g.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import d.a.i0.a.e0.d;
import d.a.i0.a.g1.f;
import d.a.i0.a.k;
import d.a.i0.a.o0.d.g;
import d.a.i0.a.v2.l0;
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.q0;
/* loaded from: classes3.dex */
public class b implements View.OnTouchListener {
    public static final boolean m = k.f43025a;

    /* renamed from: e  reason: collision with root package name */
    public String f45537e;

    /* renamed from: f  reason: collision with root package name */
    public String f45538f;

    /* renamed from: g  reason: collision with root package name */
    public String f45539g;
    public c j;
    public long k;

    /* renamed from: h  reason: collision with root package name */
    public boolean f45540h = false;

    /* renamed from: i  reason: collision with root package name */
    public int[] f45541i = new int[2];
    public RunnableC0889b l = new RunnableC0889b();

    /* renamed from: d.a.i0.a.w2.g.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0889b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public MotionEvent f45542e;

        /* renamed from: f  reason: collision with root package name */
        public g f45543f;

        public RunnableC0889b() {
        }

        public final void b(MotionEvent motionEvent) {
            this.f45542e = motionEvent;
            this.f45543f = b.this.d(motionEvent, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.g(this.f45543f);
        }
    }

    /* loaded from: classes3.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public double f45545a;

        /* renamed from: b  reason: collision with root package name */
        public double f45546b;

        public c(b bVar, double d2, double d3) {
            this.f45545a = d2;
            this.f45546b = d3;
        }

        public double a(c cVar) {
            if (cVar == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(cVar.f45545a - this.f45545a, 2.0d) + Math.pow(cVar.f45546b - this.f45546b, 2.0d);
            if (pow <= 0.0d) {
                return 0.0d;
            }
            return Math.sqrt(pow);
        }
    }

    public b(String str, String str2, String str3) {
        this.f45537e = str;
        this.f45538f = str2;
        this.f45539g = str3;
        h();
        i();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public final g c(MotionEvent motionEvent) {
        d.a.i0.a.w2.g.b.a aVar = new d.a.i0.a.w2.g.b.a(motionEvent);
        aVar.i(this.f45541i);
        g gVar = new g();
        gVar.f43750c = d.a.i0.a.w2.g.c.a.b(this.f45537e, this.f45538f, this.f45539g, aVar.e(), aVar.c());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [org.json.JSONObject, T] */
    public final g d(MotionEvent motionEvent, String str) {
        d.a.i0.a.w2.g.b.a aVar = new d.a.i0.a.w2.g.b.a(motionEvent, str);
        aVar.i(this.f45541i);
        g gVar = new g();
        gVar.f43750c = d.a.i0.a.w2.g.c.a.b(this.f45537e, this.f45538f, this.f45539g, aVar.e(), aVar.c());
        return gVar;
    }

    public final void e(View view, MotionEvent motionEvent) {
        if (view != null && motionEvent != null && !TextUtils.isEmpty(this.f45537e) && !TextUtils.isEmpty(this.f45538f)) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
                this.j = new c(this, motionEvent.getX(), motionEvent.getY());
                this.k = motionEvent.getEventTime();
                this.l.b(motionEvent);
                view.postDelayed(this.l, 350L);
                i();
            } else if (actionMasked == 1 || actionMasked == 3 || !f(new c(this, motionEvent.getX(), motionEvent.getY()))) {
                view.removeCallbacks(this.l);
            }
            g(c(motionEvent));
            if (actionMasked == 1 && f(new c(this, motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.k < 350) {
                g(d(motionEvent, "tap"));
                return;
            }
            return;
        }
        d.b("SwanAppTouchListener", "params is null, slaveId = " + this.f45537e + " ; viewId = " + this.f45538f);
    }

    public final boolean f(c cVar) {
        c cVar2 = this.j;
        return cVar2 != null && cVar2.a(cVar) <= ((double) n0.g(10.0f));
    }

    public final void g(g gVar) {
        if (m) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.f43750c);
        }
        if (!this.f45540h) {
            f.V().m(this.f45537e, gVar);
        } else {
            f.V().v(gVar);
        }
    }

    public final void h() {
        this.f45540h = l0.f("1.12.0") && TextUtils.equals("canvas", this.f45539g);
    }

    public final void i() {
        AbsoluteLayout m2 = q0.m(this.f45537e);
        if (m2 == null) {
            return;
        }
        m2.getLocationOnScreen(this.f45541i);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        e(view, motionEvent);
        return true;
    }
}
