package d.a.m0.a.h0.g;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.a.m0.a.l1.c;
import d.a.m0.o.a.a.l;
import d.a.m0.o.a.a.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45858e = d.a.m0.a.k.f46983a;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f45859f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    public static final int f45860g = d.a.m0.a.a.aiapps_slide_in_from_right;

    /* renamed from: h  reason: collision with root package name */
    public static final int f45861h = d.a.m0.a.a.aiapps_slide_out_to_right;

    /* renamed from: i  reason: collision with root package name */
    public static final int f45862i = d.a.m0.a.a.aiapps_hold;

    /* renamed from: a  reason: collision with root package name */
    public l f45863a;

    /* renamed from: c  reason: collision with root package name */
    public Queue<Runnable> f45865c = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d> f45864b = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public final List<a> f45866d = new CopyOnWriteArrayList();

    /* loaded from: classes3.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public n f45867a;

        /* renamed from: b  reason: collision with root package name */
        public String f45868b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f45870e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f45871f;

            public a(b bVar, d dVar, d dVar2) {
                this.f45870e = dVar;
                this.f45871f = dVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f45870e;
                if (dVar != null && dVar.V()) {
                    this.f45870e.m1(false);
                }
                d dVar2 = this.f45870e;
                if (dVar2 instanceof f) {
                    ((f) dVar2).M3();
                }
                this.f45871f.m1(true);
            }
        }

        /* renamed from: d.a.m0.a.h0.g.g$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0721b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f45872e;

            public RunnableC0721b(b bVar, d dVar) {
                this.f45872e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f45872e;
                if (dVar != null) {
                    dVar.m1(true);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f45873e;

            public c(b bVar, d dVar) {
                this.f45873e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f45873e;
                if (dVar != null) {
                    dVar.m1(false);
                }
            }
        }

        public b(String str) {
            this.f45867a = g.this.f45863a.a();
            this.f45868b = str;
        }

        public void a() {
            if (!TextUtils.isEmpty(this.f45868b)) {
                f.H3(this.f45868b);
            }
            while (!g.this.f45865c.isEmpty()) {
                if (g.this.f45865c.peek() != null) {
                    ((Runnable) g.this.f45865c.poll()).run();
                }
            }
            d();
            this.f45867a.e();
        }

        public boolean b() {
            a();
            return g.this.f45863a.c();
        }

        public void c(d dVar) {
            n nVar = this.f45867a;
            nVar.f(dVar);
            nVar.e();
            g.this.f45863a.c();
        }

        public final void d() {
            if (g.this.f45864b.isEmpty()) {
                return;
            }
            int size = g.this.f45864b.size();
            int i2 = size - 1;
            for (int i3 = i2; i3 >= 0; i3--) {
                if (i3 >= i2) {
                    if (g.f45858e) {
                        Log.d("SwanAppFragmentManager", "show fragment i " + i3 + " ,size: " + size);
                    }
                    this.f45867a.i((Fragment) g.this.f45864b.get(i3));
                } else {
                    this.f45867a.f((Fragment) g.this.f45864b.get(i3));
                }
            }
        }

        public final boolean e(String str) {
            return g.f45859f.contains(str);
        }

        public b f() {
            List<Fragment> d2 = g.this.f45863a.d();
            if (d2 != null && d2.size() != g.this.f45864b.size()) {
                for (Fragment fragment : d2) {
                    if (fragment != null && !g.this.f45864b.contains(fragment)) {
                        if (g.f45858e) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        for (a aVar : g.this.f45866d) {
                            if (aVar != null) {
                                aVar.b(fragment);
                            }
                        }
                        this.f45867a.g(fragment);
                    }
                }
            }
            h(g.this.f45864b.size());
            return this;
        }

        public b g() {
            h(1);
            return this;
        }

        public b h(int i2) {
            if (g.this.f45864b.isEmpty()) {
                return this;
            }
            ArrayList arrayList = (ArrayList) g.this.f45864b.clone();
            int size = arrayList.size();
            int i3 = size - i2;
            d dVar = (i3 < 0 || i2 <= 0) ? null : (d) arrayList.get(i3);
            while (true) {
                size--;
                if (size <= i3 - 1 || size < 0) {
                    break;
                }
                for (a aVar : g.this.f45866d) {
                    if (aVar != null) {
                        aVar.b((Fragment) arrayList.get(size));
                    }
                }
                this.f45867a.g((Fragment) arrayList.get(size));
                g.this.f45864b.remove(size);
            }
            g.this.f45865c.offer(new c(this, dVar));
            q();
            return this;
        }

        public b i() {
            if (g.this.f45864b.isEmpty()) {
                return this;
            }
            ArrayList arrayList = (ArrayList) g.this.f45864b.clone();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((d) arrayList.get(size)).Z1()) {
                    this.f45867a.g((Fragment) arrayList.get(size));
                    g.this.f45864b.remove(size);
                }
            }
            q();
            return this;
        }

        public b j(d dVar) {
            r(dVar);
            this.f45867a.b(d.a.m0.a.f.ai_apps_container, dVar, "SwanAppFragment");
            g.this.f45864b.add(dVar);
            for (a aVar : g.this.f45866d) {
                if (aVar != null) {
                    aVar.a(dVar);
                }
            }
            return this;
        }

        public b k(String str, d.a.m0.a.l1.b bVar) {
            return l(str, bVar, false);
        }

        @Nullable
        public b l(String str, d.a.m0.a.l1.b bVar, boolean z) {
            d M2;
            if ("about".equals(str)) {
                M2 = d.a.m0.a.h0.g.a.d3();
            } else if ("authority".equals(str)) {
                M2 = d.a.m0.a.h0.g.c.S2();
            } else if ("pluginFunPage".equals(str)) {
                M2 = h.L2(bVar.f47143g, bVar.f47142f);
            } else if (e(str)) {
                M2 = k.P2(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                M2 = j.I2();
            } else if ("normal".equals(str)) {
                c.a aVar = new c.a();
                aVar.d(bVar.f47141e);
                aVar.e(bVar.f47142f);
                aVar.b(bVar.f47143g);
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
            int size = g.this.f45864b.size();
            if (!g.this.f45864b.isEmpty() && i2 >= 0 && i2 < size) {
                this.f45867a.g((d) g.this.f45864b.remove(i2));
            }
            return this;
        }

        public b n(int i2, int i3) {
            this.f45867a.h(i2, i3);
            return this;
        }

        public void o(d dVar) {
            n nVar = this.f45867a;
            nVar.i(dVar);
            nVar.e();
            g.this.f45863a.c();
        }

        public b p(d.a.m0.a.l1.b bVar) {
            f l = g.this.l();
            if (l != null) {
                l.I3(bVar);
                return this;
            }
            return k("normal", bVar);
        }

        public final void q() {
            g.this.f45865c.offer(new RunnableC0721b(this, g.this.m()));
        }

        public final void r(d dVar) {
            g.this.f45865c.offer(new a(this, g.this.m(), dVar));
        }
    }

    static {
        f45859f.add("adLanding");
        f45859f.add("wxPay");
        f45859f.add("default_webview");
        f45859f.add("allianceLogin");
        f45859f.add("allianceChooseAddress");
        f45859f.add("qrCodePay");
    }

    public g(FragmentActivity fragmentActivity) {
        this.f45863a = fragmentActivity.getSupportFragmentManager();
    }

    public void g(@Nullable a aVar) {
        if (aVar != null) {
            this.f45866d.add(aVar);
        }
    }

    public b h() {
        return new b("");
    }

    public b i(String str) {
        return new b(str);
    }

    public d j(int i2) {
        if (this.f45864b.isEmpty() || i2 < 0 || i2 >= this.f45864b.size()) {
            return null;
        }
        return this.f45864b.get(i2);
    }

    public int k() {
        return this.f45864b.size();
    }

    public f l() {
        if (this.f45864b.isEmpty()) {
            return null;
        }
        int size = this.f45864b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f45864b.get(i2).Z1()) {
                return (f) this.f45864b.get(i2);
            }
        }
        return null;
    }

    public d m() {
        return j(this.f45864b.size() - 1);
    }

    public <T extends d> T n(Class<T> cls) {
        if (cls != null) {
            for (int size = this.f45864b.size() - 1; size >= 0; size--) {
                T t = (T) this.f45864b.get(size);
                if (t.getClass() == cls) {
                    return t;
                }
            }
            return null;
        }
        return null;
    }

    public f o() {
        for (int size = this.f45864b.size() - 1; size >= 0; size--) {
            d dVar = this.f45864b.get(size);
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
        this.f45866d.remove(aVar);
    }
}
