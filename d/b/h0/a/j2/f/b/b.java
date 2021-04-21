package d.b.h0.a.j2.f.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.b.h0.a.e0.w.d;
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.a.k0.b.g;
import d.b.h0.a.z0.f;
/* loaded from: classes3.dex */
public class b implements View.OnTouchListener {
    public static final boolean m = k.f45772a;

    /* renamed from: e  reason: collision with root package name */
    public String f45749e;

    /* renamed from: f  reason: collision with root package name */
    public String f45750f;

    /* renamed from: g  reason: collision with root package name */
    public String f45751g;
    public c j;
    public long k;

    /* renamed from: h  reason: collision with root package name */
    public boolean f45752h = false;
    public int[] i = new int[2];
    public RunnableC0747b l = new RunnableC0747b();

    /* renamed from: d.b.h0.a.j2.f.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0747b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public MotionEvent f45753e;

        /* renamed from: f  reason: collision with root package name */
        public g f45754f;

        public RunnableC0747b() {
        }

        public final void b(MotionEvent motionEvent) {
            this.f45753e = motionEvent;
            this.f45754f = b.this.d(motionEvent, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.h(this.f45754f);
        }
    }

    /* loaded from: classes3.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public double f45756a;

        /* renamed from: b  reason: collision with root package name */
        public double f45757b;

        public c(b bVar, double d2, double d3) {
            this.f45756a = d2;
            this.f45757b = d3;
        }

        public double a(c cVar) {
            if (cVar == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(cVar.f45756a - this.f45756a, 2.0d) + Math.pow(cVar.f45757b - this.f45757b, 2.0d);
            if (pow <= 0.0d) {
                return 0.0d;
            }
            return Math.sqrt(pow);
        }
    }

    public b(String str, String str2, String str3) {
        this.f45749e = str;
        this.f45750f = str2;
        this.f45751g = str3;
        i();
        j();
    }

    public static boolean f() {
        SwanCoreVersion T = d.L().T();
        long j = T != null ? T.swanCoreVersion : 0L;
        long h2 = d.b.h0.a.b2.b.h("1.12.0");
        if (m) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + h2 + ";curSwanVersion: " + j);
        }
        return j >= h2;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public final g c(MotionEvent motionEvent) {
        d.b.h0.a.j2.f.b.a aVar = new d.b.h0.a.j2.f.b.a(motionEvent);
        aVar.i(this.i);
        g gVar = new g();
        gVar.f45790b = d.b.h0.a.j2.f.c.a.b(this.f45749e, this.f45750f, this.f45751g, aVar.e(), aVar.c());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [org.json.JSONObject, T] */
    public final g d(MotionEvent motionEvent, String str) {
        d.b.h0.a.j2.f.b.a aVar = new d.b.h0.a.j2.f.b.a(motionEvent, str);
        aVar.i(this.i);
        g gVar = new g();
        gVar.f45790b = d.b.h0.a.j2.f.c.a.b(this.f45749e, this.f45750f, this.f45751g, aVar.e(), aVar.c());
        return gVar;
    }

    public final void e(View view, MotionEvent motionEvent) {
        if (view != null && motionEvent != null && !TextUtils.isEmpty(this.f45749e) && !TextUtils.isEmpty(this.f45750f)) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
                this.j = new c(this, motionEvent.getX(), motionEvent.getY());
                this.k = motionEvent.getEventTime();
                this.l.b(motionEvent);
                view.postDelayed(this.l, 350L);
                j();
            } else if (actionMasked == 1 || actionMasked == 3 || !g(new c(this, motionEvent.getX(), motionEvent.getY()))) {
                view.removeCallbacks(this.l);
            }
            h(c(motionEvent));
            if (actionMasked == 1 && g(new c(this, motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.k < 350) {
                h(d(motionEvent, "tap"));
                return;
            }
            return;
        }
        d.b.h0.a.c0.c.b("SwanAppTouchListener", "params is null, slaveId = " + this.f45749e + " ; viewId = " + this.f45750f);
    }

    public final boolean g(c cVar) {
        c cVar2 = this.j;
        return cVar2 != null && cVar2.a(cVar) <= ((double) h0.f(10.0f));
    }

    public final void h(g gVar) {
        if (m) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.f45790b);
        }
        if (!this.f45752h) {
            f.V().z(this.f45749e, gVar);
        } else {
            f.V().N(gVar);
        }
    }

    public final void i() {
        this.f45752h = !f() && TextUtils.equals("canvas", this.f45751g);
    }

    public final void j() {
        AbsoluteLayout m2 = k0.m(this.f45749e);
        if (m2 == null) {
            return;
        }
        m2.getLocationOnScreen(this.i);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        e(view, motionEvent);
        return true;
    }
}
