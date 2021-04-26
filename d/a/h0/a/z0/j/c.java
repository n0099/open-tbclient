package d.a.h0.a.z0.j;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import d.a.h0.a.i2.k0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements d.a.h0.a.z0.j.a {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f45335a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.h0.a.z0.j.a> f45336b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f45337c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d.a.h0.a.z0.j.a aVar : c.this.f45336b) {
                aVar.onPause();
            }
            c.this.f45335a = true;
            c.this.f45337c = null;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f45335a) {
                if (c.this.f45337c != null) {
                    k0.W(c.this.f45337c);
                    c.this.f45337c = null;
                }
                for (d.a.h0.a.z0.j.a aVar : c.this.f45336b) {
                    aVar.onResume();
                }
                c.this.f45335a = false;
            }
        }
    }

    /* renamed from: d.a.h0.a.z0.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0865c {

        /* renamed from: a  reason: collision with root package name */
        public static int f45340a = -2;

        /* renamed from: b  reason: collision with root package name */
        public static int f45341b = -2;

        public static boolean a() {
            if (f45341b == -2) {
                d.a.h0.a.w0.a.N().getSwitch("swan_webview_pause_control", 3);
                f45341b = 3;
            }
            return (f45341b & 2) == 2;
        }

        public static boolean b() {
            if (f45341b == -2) {
                d.a.h0.a.w0.a.N().getSwitch("swan_webview_pause_control", 3);
                f45341b = 3;
            }
            return (f45341b & 1) == 1;
        }

        public static boolean c() {
            if (f45340a == -2) {
                d.a.h0.a.w0.a.N().getSwitch("swan_webview_backstage_optimize", -1);
                f45340a = -1;
            }
            return f45340a > -1;
        }

        public static int d() {
            return f45340a;
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f45342a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static d.a.h0.a.z0.j.a f() {
        return d.f45342a;
    }

    @Override // d.a.h0.a.z0.j.a
    @AnyThread
    public void onPause() {
        if (C0865c.c()) {
            this.f45337c = new a();
            k0.U(this.f45337c, C0865c.d() * 1000);
        }
    }

    @Override // d.a.h0.a.z0.j.a
    @AnyThread
    public void onResume() {
        if (C0865c.c()) {
            k0.X(new b());
        }
    }

    public c() {
        this.f45335a = false;
        this.f45336b = new ArrayList();
        if (C0865c.c()) {
            if (C0865c.b()) {
                this.f45336b.add(new d.a.h0.a.z0.j.d());
            }
            if (C0865c.a()) {
                this.f45336b.add(new d.a.h0.a.z0.j.b());
            }
        }
    }
}
