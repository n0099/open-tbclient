package d.b.g0.a.z0.j;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import d.b.g0.a.i2.k0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements d.b.g0.a.z0.j.a {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f47178a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final List<d.b.g0.a.z0.j.a> f47179b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f47180c;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d.b.g0.a.z0.j.a aVar : c.this.f47179b) {
                aVar.onPause();
            }
            c.this.f47178a = true;
            c.this.f47180c = null;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f47178a) {
                if (c.this.f47180c != null) {
                    k0.W(c.this.f47180c);
                    c.this.f47180c = null;
                }
                for (d.b.g0.a.z0.j.a aVar : c.this.f47179b) {
                    aVar.onResume();
                }
                c.this.f47178a = false;
            }
        }
    }

    /* renamed from: d.b.g0.a.z0.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0894c {

        /* renamed from: a  reason: collision with root package name */
        public static int f47183a = -2;

        /* renamed from: b  reason: collision with root package name */
        public static int f47184b = -2;

        public static boolean a() {
            if (f47184b == -2) {
                d.b.g0.a.w0.a.N().getSwitch("swan_webview_pause_control", 3);
                f47184b = 3;
            }
            return (f47184b & 2) == 2;
        }

        public static boolean b() {
            if (f47184b == -2) {
                d.b.g0.a.w0.a.N().getSwitch("swan_webview_pause_control", 3);
                f47184b = 3;
            }
            return (f47184b & 1) == 1;
        }

        public static boolean c() {
            if (f47183a == -2) {
                d.b.g0.a.w0.a.N().getSwitch("swan_webview_backstage_optimize", -1);
                f47183a = -1;
            }
            return f47183a > -1;
        }

        public static int d() {
            return f47183a;
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f47185a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static d.b.g0.a.z0.j.a f() {
        return d.f47185a;
    }

    @Override // d.b.g0.a.z0.j.a
    @AnyThread
    public void onPause() {
        if (C0894c.c()) {
            this.f47180c = new a();
            k0.U(this.f47180c, C0894c.d() * 1000);
        }
    }

    @Override // d.b.g0.a.z0.j.a
    @AnyThread
    public void onResume() {
        if (C0894c.c()) {
            k0.X(new b());
        }
    }

    public c() {
        this.f47178a = false;
        this.f47179b = new ArrayList();
        if (C0894c.c()) {
            if (C0894c.b()) {
                this.f47179b.add(new d.b.g0.a.z0.j.d());
            }
            if (C0894c.a()) {
                this.f47179b.add(new d.b.g0.a.z0.j.b());
            }
        }
    }
}
