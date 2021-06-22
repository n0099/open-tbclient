package d.a.m0.a.g1.j;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import d.a.m0.a.v2.q0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements d.a.m0.a.g1.j.a {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f45715a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.m0.a.g1.j.a> f45716b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f45717c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d.a.m0.a.g1.j.a aVar : c.this.f45716b) {
                aVar.onPause();
            }
            c.this.f45715a = true;
            c.this.f45717c = null;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f45715a) {
                if (c.this.f45717c != null) {
                    q0.a0(c.this.f45717c);
                    c.this.f45717c = null;
                }
                for (d.a.m0.a.g1.j.a aVar : c.this.f45716b) {
                    aVar.onResume();
                }
                c.this.f45715a = false;
            }
        }
    }

    /* renamed from: d.a.m0.a.g1.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0702c {

        /* renamed from: a  reason: collision with root package name */
        public static int f45720a = -2;

        /* renamed from: b  reason: collision with root package name */
        public static int f45721b = -2;

        public static boolean a() {
            if (f45721b == -2) {
                d.a.m0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                f45721b = 3;
            }
            return (f45721b & 2) == 2;
        }

        public static boolean b() {
            if (f45721b == -2) {
                d.a.m0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                f45721b = 3;
            }
            return (f45721b & 1) == 1;
        }

        public static boolean c() {
            if (f45720a == -2) {
                d.a.m0.a.c1.a.Z().getSwitch("swan_webview_backstage_optimize", -1);
                f45720a = -1;
            }
            return f45720a > -1;
        }

        public static int d() {
            return f45720a;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f45722a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static d.a.m0.a.g1.j.a f() {
        return d.f45722a;
    }

    @Override // d.a.m0.a.g1.j.a
    @AnyThread
    public void onPause() {
        if (C0702c.c()) {
            this.f45717c = new a();
            q0.Y(this.f45717c, C0702c.d() * 1000);
        }
    }

    @Override // d.a.m0.a.g1.j.a
    @AnyThread
    public void onResume() {
        if (C0702c.c()) {
            q0.b0(new b());
        }
    }

    public c() {
        this.f45715a = false;
        this.f45716b = new ArrayList();
        if (C0702c.c()) {
            if (C0702c.b()) {
                this.f45716b.add(new d.a.m0.a.g1.j.d());
            }
            if (C0702c.a()) {
                this.f45716b.add(new d.a.m0.a.g1.j.b());
            }
        }
    }
}
