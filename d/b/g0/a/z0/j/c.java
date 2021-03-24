package d.b.g0.a.z0.j;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import d.b.g0.a.i2.k0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements d.b.g0.a.z0.j.a {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f47177a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final List<d.b.g0.a.z0.j.a> f47178b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f47179c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d.b.g0.a.z0.j.a aVar : c.this.f47178b) {
                aVar.onPause();
            }
            c.this.f47177a = true;
            c.this.f47179c = null;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f47177a) {
                if (c.this.f47179c != null) {
                    k0.W(c.this.f47179c);
                    c.this.f47179c = null;
                }
                for (d.b.g0.a.z0.j.a aVar : c.this.f47178b) {
                    aVar.onResume();
                }
                c.this.f47177a = false;
            }
        }
    }

    /* renamed from: d.b.g0.a.z0.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0893c {

        /* renamed from: a  reason: collision with root package name */
        public static int f47182a = -2;

        /* renamed from: b  reason: collision with root package name */
        public static int f47183b = -2;

        public static boolean a() {
            if (f47183b == -2) {
                d.b.g0.a.w0.a.N().getSwitch("swan_webview_pause_control", 3);
                f47183b = 3;
            }
            return (f47183b & 2) == 2;
        }

        public static boolean b() {
            if (f47183b == -2) {
                d.b.g0.a.w0.a.N().getSwitch("swan_webview_pause_control", 3);
                f47183b = 3;
            }
            return (f47183b & 1) == 1;
        }

        public static boolean c() {
            if (f47182a == -2) {
                d.b.g0.a.w0.a.N().getSwitch("swan_webview_backstage_optimize", -1);
                f47182a = -1;
            }
            return f47182a > -1;
        }

        public static int d() {
            return f47182a;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f47184a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static d.b.g0.a.z0.j.a f() {
        return d.f47184a;
    }

    @Override // d.b.g0.a.z0.j.a
    @AnyThread
    public void onPause() {
        if (C0893c.c()) {
            this.f47179c = new a();
            k0.U(this.f47179c, C0893c.d() * 1000);
        }
    }

    @Override // d.b.g0.a.z0.j.a
    @AnyThread
    public void onResume() {
        if (C0893c.c()) {
            k0.X(new b());
        }
    }

    public c() {
        this.f47177a = false;
        this.f47178b = new ArrayList();
        if (C0893c.c()) {
            if (C0893c.b()) {
                this.f47178b.add(new d.b.g0.a.z0.j.d());
            }
            if (C0893c.a()) {
                this.f47178b.add(new d.b.g0.a.z0.j.b());
            }
        }
    }
}
