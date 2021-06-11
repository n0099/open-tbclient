package d.a.l0.a.g1.j;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import d.a.l0.a.v2.q0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements d.a.l0.a.g1.j.a {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f45607a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.l0.a.g1.j.a> f45608b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f45609c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d.a.l0.a.g1.j.a aVar : c.this.f45608b) {
                aVar.onPause();
            }
            c.this.f45607a = true;
            c.this.f45609c = null;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f45607a) {
                if (c.this.f45609c != null) {
                    q0.a0(c.this.f45609c);
                    c.this.f45609c = null;
                }
                for (d.a.l0.a.g1.j.a aVar : c.this.f45608b) {
                    aVar.onResume();
                }
                c.this.f45607a = false;
            }
        }
    }

    /* renamed from: d.a.l0.a.g1.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0699c {

        /* renamed from: a  reason: collision with root package name */
        public static int f45612a = -2;

        /* renamed from: b  reason: collision with root package name */
        public static int f45613b = -2;

        public static boolean a() {
            if (f45613b == -2) {
                d.a.l0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                f45613b = 3;
            }
            return (f45613b & 2) == 2;
        }

        public static boolean b() {
            if (f45613b == -2) {
                d.a.l0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                f45613b = 3;
            }
            return (f45613b & 1) == 1;
        }

        public static boolean c() {
            if (f45612a == -2) {
                d.a.l0.a.c1.a.Z().getSwitch("swan_webview_backstage_optimize", -1);
                f45612a = -1;
            }
            return f45612a > -1;
        }

        public static int d() {
            return f45612a;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f45614a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static d.a.l0.a.g1.j.a f() {
        return d.f45614a;
    }

    @Override // d.a.l0.a.g1.j.a
    @AnyThread
    public void onPause() {
        if (C0699c.c()) {
            this.f45609c = new a();
            q0.Y(this.f45609c, C0699c.d() * 1000);
        }
    }

    @Override // d.a.l0.a.g1.j.a
    @AnyThread
    public void onResume() {
        if (C0699c.c()) {
            q0.b0(new b());
        }
    }

    public c() {
        this.f45607a = false;
        this.f45608b = new ArrayList();
        if (C0699c.c()) {
            if (C0699c.b()) {
                this.f45608b.add(new d.a.l0.a.g1.j.d());
            }
            if (C0699c.a()) {
                this.f45608b.add(new d.a.l0.a.g1.j.b());
            }
        }
    }
}
