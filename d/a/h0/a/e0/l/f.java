package d.a.h0.a.e0.l;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.a.h0.a.e1.c;
import d.a.h0.a.k;
import d.a.h0.m.a.a.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f42029e = k.f43101a;

    /* renamed from: f  reason: collision with root package name */
    public static final Set<String> f42030f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    public static final int f42031g = d.a.h0.a.a.aiapps_slide_in_from_right;

    /* renamed from: h  reason: collision with root package name */
    public static final int f42032h = d.a.h0.a.a.aiapps_slide_out_to_right;

    /* renamed from: i  reason: collision with root package name */
    public static final int f42033i = d.a.h0.a.a.aiapps_hold;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.m.a.a.k f42034a;

    /* renamed from: c  reason: collision with root package name */
    public Queue<Runnable> f42036c = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c> f42035b = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public final List<a> f42037d = new CopyOnWriteArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public m f42038a;

        /* renamed from: b  reason: collision with root package name */
        public String f42039b;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.a.e0.l.c f42041e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.a.e0.l.c f42042f;

            public a(b bVar, d.a.h0.a.e0.l.c cVar, d.a.h0.a.e0.l.c cVar2) {
                this.f42041e = cVar;
                this.f42042f = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.h0.a.e0.l.c cVar = this.f42041e;
                if (cVar != null && cVar.N()) {
                    this.f42041e.f1(false);
                }
                d.a.h0.a.e0.l.c cVar2 = this.f42041e;
                if (cVar2 instanceof e) {
                    ((e) cVar2).z3();
                }
                this.f42042f.f1(true);
            }
        }

        /* renamed from: d.a.h0.a.e0.l.f$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0634b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.a.e0.l.c f42043e;

            public RunnableC0634b(b bVar, d.a.h0.a.e0.l.c cVar) {
                this.f42043e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.h0.a.e0.l.c cVar = this.f42043e;
                if (cVar != null) {
                    cVar.f1(true);
                }
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.a.e0.l.c f42044e;

            public c(b bVar, d.a.h0.a.e0.l.c cVar) {
                this.f42044e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.h0.a.e0.l.c cVar = this.f42044e;
                if (cVar != null) {
                    cVar.f1(false);
                }
            }
        }

        public b(String str) {
            this.f42038a = f.this.f42034a.a();
            this.f42039b = str;
        }

        public void a() {
            if (!TextUtils.isEmpty(this.f42039b)) {
                e.u3(this.f42039b);
            }
            while (!f.this.f42036c.isEmpty()) {
                if (f.this.f42036c.peek() != null) {
                    ((Runnable) f.this.f42036c.poll()).run();
                }
            }
            d();
            this.f42038a.d();
        }

        public boolean b() {
            a();
            return f.this.f42034a.c();
        }

        public void c(d.a.h0.a.e0.l.c cVar) {
            m mVar = this.f42038a;
            mVar.e(cVar);
            mVar.d();
            f.this.f42034a.c();
        }

        public final void d() {
            if (f.this.f42035b.isEmpty()) {
                return;
            }
            int size = f.this.f42035b.size();
            int i2 = size - 1;
            for (int i3 = i2; i3 >= 0; i3--) {
                if (i3 >= i2) {
                    if (f.f42029e) {
                        Log.d("SwanAppFragmentManager", "show fragment i " + i3 + " ,size: " + size);
                    }
                    this.f42038a.h((Fragment) f.this.f42035b.get(i3));
                } else {
                    this.f42038a.e((Fragment) f.this.f42035b.get(i3));
                }
            }
        }

        public final boolean e(String str) {
            return f.f42030f.contains(str);
        }

        public b f() {
            List<Fragment> d2 = f.this.f42034a.d();
            if (d2 != null && d2.size() != f.this.f42035b.size()) {
                for (Fragment fragment : d2) {
                    if (fragment != null && !f.this.f42035b.contains(fragment)) {
                        if (f.f42029e) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        for (a aVar : f.this.f42037d) {
                            if (aVar != null) {
                                aVar.b(fragment);
                            }
                        }
                        this.f42038a.f(fragment);
                    }
                }
            }
            h(f.this.f42035b.size());
            return this;
        }

        public b g() {
            h(1);
            return this;
        }

        public b h(int i2) {
            if (f.this.f42035b.isEmpty()) {
                return this;
            }
            ArrayList arrayList = (ArrayList) f.this.f42035b.clone();
            int size = arrayList.size();
            int i3 = size - i2;
            d.a.h0.a.e0.l.c cVar = (i3 < 0 || i2 <= 0) ? null : (d.a.h0.a.e0.l.c) arrayList.get(i3);
            while (true) {
                size--;
                if (size <= i3 - 1 || size < 0) {
                    break;
                }
                for (a aVar : f.this.f42037d) {
                    if (aVar != null) {
                        aVar.b((Fragment) arrayList.get(size));
                    }
                }
                this.f42038a.f((Fragment) arrayList.get(size));
                f.this.f42035b.remove(size);
            }
            f.this.f42036c.offer(new c(this, cVar));
            q();
            return this;
        }

        public b i() {
            if (f.this.f42035b.isEmpty()) {
                return this;
            }
            ArrayList arrayList = (ArrayList) f.this.f42035b.clone();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((d.a.h0.a.e0.l.c) arrayList.get(size)).U1()) {
                    this.f42038a.f((Fragment) arrayList.get(size));
                    f.this.f42035b.remove(size);
                }
            }
            q();
            return this;
        }

        public b j(d.a.h0.a.e0.l.c cVar) {
            r(cVar);
            this.f42038a.b(d.a.h0.a.f.ai_apps_container, cVar, "SwanAppFragment");
            f.this.f42035b.add(cVar);
            for (a aVar : f.this.f42037d) {
                if (aVar != null) {
                    aVar.a(cVar);
                }
            }
            return this;
        }

        public b k(String str, d.a.h0.a.e1.b bVar) {
            return l(str, bVar, false);
        }

        public b l(String str, d.a.h0.a.e1.b bVar, boolean z) {
            d.a.h0.a.e0.l.c cVar;
            if ("about".equals(str)) {
                cVar = d.a.h0.a.e0.l.a.R2();
            } else if ("authority".equals(str)) {
                cVar = d.a.h0.a.e0.l.b.M2();
            } else if ("pluginFunPage".equals(str)) {
                cVar = g.E2(bVar.f42394c, bVar.f42393b);
            } else if (e(str)) {
                cVar = i.I2(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                cVar = h.B2();
            } else if ("normal".equals(str)) {
                c.a aVar = new c.a();
                aVar.d(bVar.f42392a);
                aVar.e(bVar.f42393b);
                aVar.b(bVar.f42394c);
                aVar.c(z);
                cVar = e.n3(aVar.a());
            } else {
                cVar = null;
            }
            if (cVar == null) {
                return null;
            }
            j(cVar);
            return this;
        }

        public b m(int i2) {
            int size = f.this.f42035b.size();
            if (!f.this.f42035b.isEmpty() && i2 >= 0 && i2 < size) {
                this.f42038a.f((d.a.h0.a.e0.l.c) f.this.f42035b.remove(i2));
            }
            return this;
        }

        public b n(int i2, int i3) {
            this.f42038a.g(i2, i3);
            return this;
        }

        public void o(d.a.h0.a.e0.l.c cVar) {
            m mVar = this.f42038a;
            mVar.h(cVar);
            mVar.d();
            f.this.f42034a.c();
        }

        public b p(d.a.h0.a.e1.b bVar) {
            e l = f.this.l();
            if (l != null) {
                l.v3(bVar);
                return this;
            }
            return k("normal", bVar);
        }

        public final void q() {
            f.this.f42036c.offer(new RunnableC0634b(this, f.this.m()));
        }

        public final void r(d.a.h0.a.e0.l.c cVar) {
            f.this.f42036c.offer(new a(this, f.this.m(), cVar));
        }
    }

    static {
        f42030f.add("adLanding");
        f42030f.add("wxPay");
        f42030f.add("default_webview");
        f42030f.add("allianceLogin");
        f42030f.add("allianceChooseAddress");
        f42030f.add("qrCodePay");
    }

    public f(FragmentActivity fragmentActivity) {
        this.f42034a = fragmentActivity.getSupportFragmentManager();
    }

    public void g(@Nullable a aVar) {
        if (aVar != null) {
            this.f42037d.add(aVar);
        }
    }

    public b h() {
        return new b("");
    }

    public b i(String str) {
        return new b(str);
    }

    public c j(int i2) {
        if (this.f42035b.isEmpty() || i2 < 0 || i2 >= this.f42035b.size()) {
            return null;
        }
        return this.f42035b.get(i2);
    }

    public int k() {
        return this.f42035b.size();
    }

    public e l() {
        if (this.f42035b.isEmpty()) {
            return null;
        }
        int size = this.f42035b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f42035b.get(i2).U1()) {
                return (e) this.f42035b.get(i2);
            }
        }
        return null;
    }

    public c m() {
        return j(this.f42035b.size() - 1);
    }

    public <T extends c> T n(Class<T> cls) {
        for (int size = this.f42035b.size() - 1; size >= 0; size--) {
            T t = (T) this.f42035b.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public e o() {
        for (int size = this.f42035b.size() - 1; size >= 0; size--) {
            c cVar = this.f42035b.get(size);
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
        this.f42037d.remove(aVar);
    }
}
