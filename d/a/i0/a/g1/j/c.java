package d.a.i0.a.g1.j;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import d.a.i0.a.v2.q0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements d.a.i0.a.g1.j.a {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f41757a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.i0.a.g1.j.a> f41758b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f41759c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d.a.i0.a.g1.j.a aVar : c.this.f41758b) {
                aVar.onPause();
            }
            c.this.f41757a = true;
            c.this.f41759c = null;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f41757a) {
                if (c.this.f41759c != null) {
                    q0.a0(c.this.f41759c);
                    c.this.f41759c = null;
                }
                for (d.a.i0.a.g1.j.a aVar : c.this.f41758b) {
                    aVar.onResume();
                }
                c.this.f41757a = false;
            }
        }
    }

    /* renamed from: d.a.i0.a.g1.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0632c {

        /* renamed from: a  reason: collision with root package name */
        public static int f41762a = -2;

        /* renamed from: b  reason: collision with root package name */
        public static int f41763b = -2;

        public static boolean a() {
            if (f41763b == -2) {
                d.a.i0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                f41763b = 3;
            }
            return (f41763b & 2) == 2;
        }

        public static boolean b() {
            if (f41763b == -2) {
                d.a.i0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                f41763b = 3;
            }
            return (f41763b & 1) == 1;
        }

        public static boolean c() {
            if (f41762a == -2) {
                d.a.i0.a.c1.a.Z().getSwitch("swan_webview_backstage_optimize", -1);
                f41762a = -1;
            }
            return f41762a > -1;
        }

        public static int d() {
            return f41762a;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f41764a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static d.a.i0.a.g1.j.a f() {
        return d.f41764a;
    }

    @Override // d.a.i0.a.g1.j.a
    @AnyThread
    public void onPause() {
        if (C0632c.c()) {
            this.f41759c = new a();
            q0.Y(this.f41759c, C0632c.d() * 1000);
        }
    }

    @Override // d.a.i0.a.g1.j.a
    @AnyThread
    public void onResume() {
        if (C0632c.c()) {
            q0.b0(new b());
        }
    }

    public c() {
        this.f41757a = false;
        this.f41758b = new ArrayList();
        if (C0632c.c()) {
            if (C0632c.b()) {
                this.f41758b.add(new d.a.i0.a.g1.j.d());
            }
            if (C0632c.a()) {
                this.f41758b.add(new d.a.i0.a.g1.j.b());
            }
        }
    }
}
