package d.a.h0.a.j2.f.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.h0.a.e0.w.d;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.k0.b.g;
import d.a.h0.a.z0.f;
/* loaded from: classes3.dex */
public class b implements View.OnTouchListener {
    public static final boolean m = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public String f43077e;

    /* renamed from: f  reason: collision with root package name */
    public String f43078f;

    /* renamed from: g  reason: collision with root package name */
    public String f43079g;
    public c j;
    public long k;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43080h = false;

    /* renamed from: i  reason: collision with root package name */
    public int[] f43081i = new int[2];
    public RunnableC0686b l = new RunnableC0686b();

    /* renamed from: d.a.h0.a.j2.f.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0686b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public MotionEvent f43082e;

        /* renamed from: f  reason: collision with root package name */
        public g f43083f;

        public RunnableC0686b() {
        }

        public final void b(MotionEvent motionEvent) {
            this.f43082e = motionEvent;
            this.f43083f = b.this.d(motionEvent, "longtap");
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.h(this.f43083f);
        }
    }

    /* loaded from: classes3.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public double f43085a;

        /* renamed from: b  reason: collision with root package name */
        public double f43086b;

        public c(b bVar, double d2, double d3) {
            this.f43085a = d2;
            this.f43086b = d3;
        }

        public double a(c cVar) {
            if (cVar == null) {
                return Double.MAX_VALUE;
            }
            double pow = Math.pow(cVar.f43085a - this.f43085a, 2.0d) + Math.pow(cVar.f43086b - this.f43086b, 2.0d);
            if (pow <= 0.0d) {
                return 0.0d;
            }
            return Math.sqrt(pow);
        }
    }

    public b(String str, String str2, String str3) {
        this.f43077e = str;
        this.f43078f = str2;
        this.f43079g = str3;
        i();
        j();
    }

    public static boolean f() {
        SwanCoreVersion T = d.L().T();
        long j = T != null ? T.swanCoreVersion : 0L;
        long h2 = d.a.h0.a.b2.b.h("1.12.0");
        if (m) {
            Log.d("SwanAppTouchListener", "targetSwanVersion =" + h2 + ";curSwanVersion: " + j);
        }
        return j >= h2;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject, T] */
    public final g c(MotionEvent motionEvent) {
        d.a.h0.a.j2.f.b.a aVar = new d.a.h0.a.j2.f.b.a(motionEvent);
        aVar.i(this.f43081i);
        g gVar = new g();
        gVar.f43119b = d.a.h0.a.j2.f.c.a.b(this.f43077e, this.f43078f, this.f43079g, aVar.e(), aVar.c());
        return gVar;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [org.json.JSONObject, T] */
    public final g d(MotionEvent motionEvent, String str) {
        d.a.h0.a.j2.f.b.a aVar = new d.a.h0.a.j2.f.b.a(motionEvent, str);
        aVar.i(this.f43081i);
        g gVar = new g();
        gVar.f43119b = d.a.h0.a.j2.f.c.a.b(this.f43077e, this.f43078f, this.f43079g, aVar.e(), aVar.c());
        return gVar;
    }

    public final void e(View view, MotionEvent motionEvent) {
        if (view != null && motionEvent != null && !TextUtils.isEmpty(this.f43077e) && !TextUtils.isEmpty(this.f43078f)) {
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
        d.a.h0.a.c0.c.b("SwanAppTouchListener", "params is null, slaveId = " + this.f43077e + " ; viewId = " + this.f43078f);
    }

    public final boolean g(c cVar) {
        c cVar2 = this.j;
        return cVar2 != null && cVar2.a(cVar) <= ((double) h0.f(10.0f));
    }

    public final void h(g gVar) {
        if (m) {
            Log.d("SwanAppTouchListener", "sendEventToWebView = " + gVar.f43119b);
        }
        if (!this.f43080h) {
            f.V().o(this.f43077e, gVar);
        } else {
            f.V().x(gVar);
        }
    }

    public final void i() {
        this.f43080h = !f() && TextUtils.equals("canvas", this.f43079g);
    }

    public final void j() {
        AbsoluteLayout m2 = k0.m(this.f43077e);
        if (m2 == null) {
            return;
        }
        m2.getLocationOnScreen(this.f43081i);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        e(view, motionEvent);
        return true;
    }
}
