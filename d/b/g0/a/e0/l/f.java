package d.b.g0.a.e0.l;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.b.g0.a.e1.c;
import d.b.g0.a.k;
import d.b.g0.m.a.a.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44010e = k.f45050a;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f44011f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    public static final int f44012g = d.b.g0.a.a.aiapps_slide_in_from_right;

    /* renamed from: h  reason: collision with root package name */
    public static final int f44013h = d.b.g0.a.a.aiapps_slide_out_to_right;
    public static final int i = d.b.g0.a.a.aiapps_hold;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.m.a.a.k f44014a;

    /* renamed from: c  reason: collision with root package name */
    public Queue<Runnable> f44016c = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c> f44015b = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public final List<a> f44017d = new CopyOnWriteArrayList();

    /* loaded from: classes3.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public m f44018a;

        /* renamed from: b  reason: collision with root package name */
        public String f44019b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.a.e0.l.c f44021e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.a.e0.l.c f44022f;

            public a(b bVar, d.b.g0.a.e0.l.c cVar, d.b.g0.a.e0.l.c cVar2) {
                this.f44021e = cVar;
                this.f44022f = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.a.e0.l.c cVar = this.f44021e;
                if (cVar != null && cVar.V()) {
                    this.f44021e.g1(false);
                }
                d.b.g0.a.e0.l.c cVar2 = this.f44021e;
                if (cVar2 instanceof e) {
                    ((e) cVar2).A3();
                }
                this.f44022f.g1(true);
            }
        }

        /* renamed from: d.b.g0.a.e0.l.f$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0662b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.a.e0.l.c f44023e;

            public RunnableC0662b(b bVar, d.b.g0.a.e0.l.c cVar) {
                this.f44023e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.a.e0.l.c cVar = this.f44023e;
                if (cVar != null) {
                    cVar.g1(true);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.a.e0.l.c f44024e;

            public c(b bVar, d.b.g0.a.e0.l.c cVar) {
                this.f44024e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.a.e0.l.c cVar = this.f44024e;
                if (cVar != null) {
                    cVar.g1(false);
                }
            }
        }

        public b(String str) {
            this.f44018a = f.this.f44014a.a();
            this.f44019b = str;
        }

        public void a() {
            if (!TextUtils.isEmpty(this.f44019b)) {
                e.v3(this.f44019b);
            }
            while (!f.this.f44016c.isEmpty()) {
                if (f.this.f44016c.peek() != null) {
                    ((Runnable) f.this.f44016c.poll()).run();
                }
            }
            d();
            this.f44018a.d();
        }

        public boolean b() {
            a();
            return f.this.f44014a.c();
        }

        public void c(d.b.g0.a.e0.l.c cVar) {
            m mVar = this.f44018a;
            mVar.e(cVar);
            mVar.d();
            f.this.f44014a.c();
        }

        public final void d() {
            if (f.this.f44015b.isEmpty()) {
                return;
            }
            int size = f.this.f44015b.size();
            int i = size - 1;
            for (int i2 = i; i2 >= 0; i2--) {
                if (i2 >= i) {
                    if (f.f44010e) {
                        Log.d("SwanAppFragmentManager", "show fragment i " + i2 + " ,size: " + size);
                    }
                    this.f44018a.h((Fragment) f.this.f44015b.get(i2));
                } else {
                    this.f44018a.e((Fragment) f.this.f44015b.get(i2));
                }
            }
        }

        public final boolean e(String str) {
            return f.f44011f.contains(str);
        }

        public b f() {
            List<Fragment> d2 = f.this.f44014a.d();
            if (d2 != null && d2.size() != f.this.f44015b.size()) {
                for (Fragment fragment : d2) {
                    if (fragment != null && !f.this.f44015b.contains(fragment)) {
                        if (f.f44010e) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        for (a aVar : f.this.f44017d) {
                            if (aVar != null) {
                                aVar.b(fragment);
                            }
                        }
                        this.f44018a.f(fragment);
                    }
                }
            }
            h(f.this.f44015b.size());
            return this;
        }

        public b g() {
            h(1);
            return this;
        }

        public b h(int i) {
            if (f.this.f44015b.isEmpty()) {
                return this;
            }
            ArrayList arrayList = (ArrayList) f.this.f44015b.clone();
            int size = arrayList.size();
            int i2 = size - i;
            d.b.g0.a.e0.l.c cVar = (i2 < 0 || i <= 0) ? null : (d.b.g0.a.e0.l.c) arrayList.get(i2);
            while (true) {
                size--;
                if (size <= i2 - 1 || size < 0) {
                    break;
                }
                for (a aVar : f.this.f44017d) {
                    if (aVar != null) {
                        aVar.b((Fragment) arrayList.get(size));
                    }
                }
                this.f44018a.f((Fragment) arrayList.get(size));
                f.this.f44015b.remove(size);
            }
            f.this.f44016c.offer(new c(this, cVar));
            q();
            return this;
        }

        public b i() {
            if (f.this.f44015b.isEmpty()) {
                return this;
            }
            ArrayList arrayList = (ArrayList) f.this.f44015b.clone();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((d.b.g0.a.e0.l.c) arrayList.get(size)).V1()) {
                    this.f44018a.f((Fragment) arrayList.get(size));
                    f.this.f44015b.remove(size);
                }
            }
            q();
            return this;
        }

        public b j(d.b.g0.a.e0.l.c cVar) {
            r(cVar);
            this.f44018a.b(d.b.g0.a.f.ai_apps_container, cVar, "SwanAppFragment");
            f.this.f44015b.add(cVar);
            for (a aVar : f.this.f44017d) {
                if (aVar != null) {
                    aVar.a(cVar);
                }
            }
            return this;
        }

        public b k(String str, d.b.g0.a.e1.b bVar) {
            return l(str, bVar, false);
        }

        public b l(String str, d.b.g0.a.e1.b bVar, boolean z) {
            d.b.g0.a.e0.l.c cVar;
            if ("about".equals(str)) {
                cVar = d.b.g0.a.e0.l.a.S2();
            } else if ("authority".equals(str)) {
                cVar = d.b.g0.a.e0.l.b.N2();
            } else if ("pluginFunPage".equals(str)) {
                cVar = g.F2(bVar.f44363c, bVar.f44362b);
            } else if (e(str)) {
                cVar = i.J2(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                cVar = h.C2();
            } else if ("normal".equals(str)) {
                c.a aVar = new c.a();
                aVar.d(bVar.f44361a);
                aVar.e(bVar.f44362b);
                aVar.b(bVar.f44363c);
                aVar.c(z);
                cVar = e.o3(aVar.a());
            } else {
                cVar = null;
            }
            if (cVar == null) {
                return null;
            }
            j(cVar);
            return this;
        }

        public b m(int i) {
            int size = f.this.f44015b.size();
            if (!f.this.f44015b.isEmpty() && i >= 0 && i < size) {
                this.f44018a.f((d.b.g0.a.e0.l.c) f.this.f44015b.remove(i));
            }
            return this;
        }

        public b n(int i, int i2) {
            this.f44018a.g(i, i2);
            return this;
        }

        public void o(d.b.g0.a.e0.l.c cVar) {
            m mVar = this.f44018a;
            mVar.h(cVar);
            mVar.d();
            f.this.f44014a.c();
        }

        public b p(d.b.g0.a.e1.b bVar) {
            e l = f.this.l();
            if (l != null) {
                l.w3(bVar);
                return this;
            }
            return k("normal", bVar);
        }

        public final void q() {
            f.this.f44016c.offer(new RunnableC0662b(this, f.this.m()));
        }

        public final void r(d.b.g0.a.e0.l.c cVar) {
            f.this.f44016c.offer(new a(this, f.this.m(), cVar));
        }
    }

    static {
        f44011f.add("adLanding");
        f44011f.add("wxPay");
        f44011f.add("default_webview");
        f44011f.add("allianceLogin");
        f44011f.add("allianceChooseAddress");
        f44011f.add("qrCodePay");
    }

    public f(FragmentActivity fragmentActivity) {
        this.f44014a = fragmentActivity.getSupportFragmentManager();
    }

    public void g(@Nullable a aVar) {
        if (aVar != null) {
            this.f44017d.add(aVar);
        }
    }

    public b h() {
        return new b("");
    }

    public b i(String str) {
        return new b(str);
    }

    public c j(int i2) {
        if (this.f44015b.isEmpty() || i2 < 0 || i2 >= this.f44015b.size()) {
            return null;
        }
        return this.f44015b.get(i2);
    }

    public int k() {
        return this.f44015b.size();
    }

    public e l() {
        if (this.f44015b.isEmpty()) {
            return null;
        }
        int size = this.f44015b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f44015b.get(i2).V1()) {
                return (e) this.f44015b.get(i2);
            }
        }
        return null;
    }

    public c m() {
        return j(this.f44015b.size() - 1);
    }

    public <T extends c> T n(Class<T> cls) {
        for (int size = this.f44015b.size() - 1; size >= 0; size--) {
            T t = (T) this.f44015b.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public e o() {
        for (int size = this.f44015b.size() - 1; size >= 0; size--) {
            c cVar = this.f44015b.get(size);
            if (cVar instanceof e) {
                return (e) cVar;
            }
        }
        return null;
    }

    public void p(@Nullable a aVar) {
        if (aVar == null) {
            return;
        }
        this.f44017d.remove(aVar);
    }
}
