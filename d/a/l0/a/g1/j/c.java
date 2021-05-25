package d.a.l0.a.g1.j;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import d.a.l0.a.v2.q0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements d.a.l0.a.g1.j.a {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f41931a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.l0.a.g1.j.a> f41932b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f41933c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d.a.l0.a.g1.j.a aVar : c.this.f41932b) {
                aVar.onPause();
            }
            c.this.f41931a = true;
            c.this.f41933c = null;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f41931a) {
                if (c.this.f41933c != null) {
                    q0.a0(c.this.f41933c);
                    c.this.f41933c = null;
                }
                for (d.a.l0.a.g1.j.a aVar : c.this.f41932b) {
                    aVar.onResume();
                }
                c.this.f41931a = false;
            }
        }
    }

    /* renamed from: d.a.l0.a.g1.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0643c {

        /* renamed from: a  reason: collision with root package name */
        public static int f41936a = -2;

        /* renamed from: b  reason: collision with root package name */
        public static int f41937b = -2;

        public static boolean a() {
            if (f41937b == -2) {
                d.a.l0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                f41937b = 3;
            }
            return (f41937b & 2) == 2;
        }

        public static boolean b() {
            if (f41937b == -2) {
                d.a.l0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                f41937b = 3;
            }
            return (f41937b & 1) == 1;
        }

        public static boolean c() {
            if (f41936a == -2) {
                d.a.l0.a.c1.a.Z().getSwitch("swan_webview_backstage_optimize", -1);
                f41936a = -1;
            }
            return f41936a > -1;
        }

        public static int d() {
            return f41936a;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f41938a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static d.a.l0.a.g1.j.a f() {
        return d.f41938a;
    }

    @Override // d.a.l0.a.g1.j.a
    @AnyThread
    public void onPause() {
        if (C0643c.c()) {
            this.f41933c = new a();
            q0.Y(this.f41933c, C0643c.d() * 1000);
        }
    }

    @Override // d.a.l0.a.g1.j.a
    @AnyThread
    public void onResume() {
        if (C0643c.c()) {
            q0.b0(new b());
        }
    }

    public c() {
        this.f41931a = false;
        this.f41932b = new ArrayList();
        if (C0643c.c()) {
            if (C0643c.b()) {
                this.f41932b.add(new d.a.l0.a.g1.j.d());
            }
            if (C0643c.a()) {
                this.f41932b.add(new d.a.l0.a.g1.j.b());
            }
        }
    }
}
