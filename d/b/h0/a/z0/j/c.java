package d.b.h0.a.z0.j;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import d.b.h0.a.i2.k0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements d.b.h0.a.z0.j.a {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f47899a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final List<d.b.h0.a.z0.j.a> f47900b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f47901c;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d.b.h0.a.z0.j.a aVar : c.this.f47900b) {
                aVar.onPause();
            }
            c.this.f47899a = true;
            c.this.f47901c = null;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f47899a) {
                if (c.this.f47901c != null) {
                    k0.W(c.this.f47901c);
                    c.this.f47901c = null;
                }
                for (d.b.h0.a.z0.j.a aVar : c.this.f47900b) {
                    aVar.onResume();
                }
                c.this.f47899a = false;
            }
        }
    }

    /* renamed from: d.b.h0.a.z0.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0926c {

        /* renamed from: a  reason: collision with root package name */
        public static int f47904a = -2;

        /* renamed from: b  reason: collision with root package name */
        public static int f47905b = -2;

        public static boolean a() {
            if (f47905b == -2) {
                d.b.h0.a.w0.a.N().getSwitch("swan_webview_pause_control", 3);
                f47905b = 3;
            }
            return (f47905b & 2) == 2;
        }

        public static boolean b() {
            if (f47905b == -2) {
                d.b.h0.a.w0.a.N().getSwitch("swan_webview_pause_control", 3);
                f47905b = 3;
            }
            return (f47905b & 1) == 1;
        }

        public static boolean c() {
            if (f47904a == -2) {
                d.b.h0.a.w0.a.N().getSwitch("swan_webview_backstage_optimize", -1);
                f47904a = -1;
            }
            return f47904a > -1;
        }

        public static int d() {
            return f47904a;
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f47906a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static d.b.h0.a.z0.j.a f() {
        return d.f47906a;
    }

    @Override // d.b.h0.a.z0.j.a
    @AnyThread
    public void onPause() {
        if (C0926c.c()) {
            this.f47901c = new a();
            k0.U(this.f47901c, C0926c.d() * 1000);
        }
    }

    @Override // d.b.h0.a.z0.j.a
    @AnyThread
    public void onResume() {
        if (C0926c.c()) {
            k0.X(new b());
        }
    }

    public c() {
        this.f47899a = false;
        this.f47900b = new ArrayList();
        if (C0926c.c()) {
            if (C0926c.b()) {
                this.f47900b.add(new d.b.h0.a.z0.j.d());
            }
            if (C0926c.a()) {
                this.f47900b.add(new d.b.h0.a.z0.j.b());
            }
        }
    }
}
