package d.a.l0.a.h0.g;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.a.l0.a.l1.c;
import d.a.l0.o.a.a.l;
import d.a.l0.o.a.a.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45750e = d.a.l0.a.k.f46875a;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f45751f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    public static final int f45752g = d.a.l0.a.a.aiapps_slide_in_from_right;

    /* renamed from: h  reason: collision with root package name */
    public static final int f45753h = d.a.l0.a.a.aiapps_slide_out_to_right;

    /* renamed from: i  reason: collision with root package name */
    public static final int f45754i = d.a.l0.a.a.aiapps_hold;

    /* renamed from: a  reason: collision with root package name */
    public l f45755a;

    /* renamed from: c  reason: collision with root package name */
    public Queue<Runnable> f45757c = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d> f45756b = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public final List<a> f45758d = new CopyOnWriteArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public n f45759a;

        /* renamed from: b  reason: collision with root package name */
        public String f45760b;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f45762e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f45763f;

            public a(b bVar, d dVar, d dVar2) {
                this.f45762e = dVar;
                this.f45763f = dVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f45762e;
                if (dVar != null && dVar.V()) {
                    this.f45762e.m1(false);
                }
                d dVar2 = this.f45762e;
                if (dVar2 instanceof f) {
                    ((f) dVar2).M3();
                }
                this.f45763f.m1(true);
            }
        }

        /* renamed from: d.a.l0.a.h0.g.g$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0718b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f45764e;

            public RunnableC0718b(b bVar, d dVar) {
                this.f45764e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f45764e;
                if (dVar != null) {
                    dVar.m1(true);
                }
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f45765e;

            public c(b bVar, d dVar) {
                this.f45765e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f45765e;
                if (dVar != null) {
                    dVar.m1(false);
                }
            }
        }

        public b(String str) {
            this.f45759a = g.this.f45755a.a();
            this.f45760b = str;
        }

        public void a() {
            if (!TextUtils.isEmpty(this.f45760b)) {
                f.H3(this.f45760b);
            }
            while (!g.this.f45757c.isEmpty()) {
                if (g.this.f45757c.peek() != null) {
                    ((Runnable) g.this.f45757c.poll()).run();
                }
            }
            d();
            this.f45759a.e();
        }

        public boolean b() {
            a();
            return g.this.f45755a.c();
        }

        public void c(d dVar) {
            n nVar = this.f45759a;
            nVar.f(dVar);
            nVar.e();
            g.this.f45755a.c();
        }

        public final void d() {
            if (g.this.f45756b.isEmpty()) {
                return;
            }
            int size = g.this.f45756b.size();
            int i2 = size - 1;
            for (int i3 = i2; i3 >= 0; i3--) {
                if (i3 >= i2) {
                    if (g.f45750e) {
                        Log.d("SwanAppFragmentManager", "show fragment i " + i3 + " ,size: " + size);
                    }
                    this.f45759a.i((Fragment) g.this.f45756b.get(i3));
                } else {
                    this.f45759a.f((Fragment) g.this.f45756b.get(i3));
                }
            }
        }

        public final boolean e(String str) {
            return g.f45751f.contains(str);
        }

        public b f() {
            List<Fragment> d2 = g.this.f45755a.d();
            if (d2 != null && d2.size() != g.this.f45756b.size()) {
                for (Fragment fragment : d2) {
                    if (fragment != null && !g.this.f45756b.contains(fragment)) {
                        if (g.f45750e) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        for (a aVar : g.this.f45758d) {
                            if (aVar != null) {
                                aVar.b(fragment);
                            }
                        }
                        this.f45759a.g(fragment);
                    }
                }
            }
            h(g.this.f45756b.size());
            return this;
        }

        public b g() {
            h(1);
            return this;
        }

        public b h(int i2) {
            if (g.this.f45756b.isEmpty()) {
                return this;
            }
            ArrayList arrayList = (ArrayList) g.this.f45756b.clone();
            int size = arrayList.size();
            int i3 = size - i2;
            d dVar = (i3 < 0 || i2 <= 0) ? null : (d) arrayList.get(i3);
            while (true) {
                size--;
                if (size <= i3 - 1 || size < 0) {
                    break;
                }
                for (a aVar : g.this.f45758d) {
                    if (aVar != null) {
                        aVar.b((Fragment) arrayList.get(size));
                    }
                }
                this.f45759a.g((Fragment) arrayList.get(size));
                g.this.f45756b.remove(size);
            }
            g.this.f45757c.offer(new c(this, dVar));
            q();
            return this;
        }

        public b i() {
            if (g.this.f45756b.isEmpty()) {
                return this;
            }
            ArrayList arrayList = (ArrayList) g.this.f45756b.clone();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((d) arrayList.get(size)).Z1()) {
                    this.f45759a.g((Fragment) arrayList.get(size));
                    g.this.f45756b.remove(size);
                }
            }
            q();
            return this;
        }

        public b j(d dVar) {
            r(dVar);
            this.f45759a.b(d.a.l0.a.f.ai_apps_container, dVar, "SwanAppFragment");
            g.this.f45756b.add(dVar);
            for (a aVar : g.this.f45758d) {
                if (aVar != null) {
                    aVar.a(dVar);
                }
            }
            return this;
        }

        public b k(String str, d.a.l0.a.l1.b bVar) {
            return l(str, bVar, false);
        }

        @Nullable
        public b l(String str, d.a.l0.a.l1.b bVar, boolean z) {
            d M2;
            if ("about".equals(str)) {
                M2 = d.a.l0.a.h0.g.a.d3();
            } else if ("authority".equals(str)) {
                M2 = d.a.l0.a.h0.g.c.S2();
            } else if ("pluginFunPage".equals(str)) {
                M2 = h.L2(bVar.f47035g, bVar.f47034f);
            } else if (e(str)) {
                M2 = k.P2(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                M2 = j.I2();
            } else if ("normal".equals(str)) {
                c.a aVar = new c.a();
                aVar.d(bVar.f47033e);
                aVar.e(bVar.f47034f);
                aVar.b(bVar.f47035g);
                aVar.c(z);
                M2 = f.z3(aVar.a());
            } else {
                M2 = "running_info".equals(str) ? i.M2() : null;
            }
            if (M2 == null) {
                return null;
            }
            j(M2);
            return this;
        }

        public b m(int i2) {
            int size = g.this.f45756b.size();
            if (!g.this.f45756b.isEmpty() && i2 >= 0 && i2 < size) {
                this.f45759a.g((d) g.this.f45756b.remove(i2));
            }
            return this;
        }

        public b n(int i2, int i3) {
            this.f45759a.h(i2, i3);
            return this;
        }

        public void o(d dVar) {
            n nVar = this.f45759a;
            nVar.i(dVar);
            nVar.e();
            g.this.f45755a.c();
        }

        public b p(d.a.l0.a.l1.b bVar) {
            f l = g.this.l();
            if (l != null) {
                l.I3(bVar);
                return this;
            }
            return k("normal", bVar);
        }

        public final void q() {
            g.this.f45757c.offer(new RunnableC0718b(this, g.this.m()));
        }

        public final void r(d dVar) {
            g.this.f45757c.offer(new a(this, g.this.m(), dVar));
        }
    }

    static {
        f45751f.add("adLanding");
        f45751f.add("wxPay");
        f45751f.add("default_webview");
        f45751f.add("allianceLogin");
        f45751f.add("allianceChooseAddress");
        f45751f.add("qrCodePay");
    }

    public g(FragmentActivity fragmentActivity) {
        this.f45755a = fragmentActivity.getSupportFragmentManager();
    }

    public void g(@Nullable a aVar) {
        if (aVar != null) {
            this.f45758d.add(aVar);
        }
    }

    public b h() {
        return new b("");
    }

    public b i(String str) {
        return new b(str);
    }

    public d j(int i2) {
        if (this.f45756b.isEmpty() || i2 < 0 || i2 >= this.f45756b.size()) {
            return null;
        }
        return this.f45756b.get(i2);
    }

    public int k() {
        return this.f45756b.size();
    }

    public f l() {
        if (this.f45756b.isEmpty()) {
            return null;
        }
        int size = this.f45756b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f45756b.get(i2).Z1()) {
                return (f) this.f45756b.get(i2);
            }
        }
        return null;
    }

    public d m() {
        return j(this.f45756b.size() - 1);
    }

    public <T extends d> T n(Class<T> cls) {
        if (cls != null) {
            for (int size = this.f45756b.size() - 1; size >= 0; size--) {
                T t = (T) this.f45756b.get(size);
                if (t.getClass() == cls) {
                    return t;
                }
            }
            return null;
        }
        return null;
    }

    public f o() {
        for (int size = this.f45756b.size() - 1; size >= 0; size--) {
            d dVar = this.f45756b.get(size);
            if (dVar instanceof f) {
                return (f) dVar;
            }
        }
        return null;
    }

    public void p(@Nullable a aVar) {
        if (aVar == null) {
            return;
        }
        this.f45758d.remove(aVar);
    }
}
