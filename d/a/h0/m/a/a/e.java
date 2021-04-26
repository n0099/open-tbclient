package d.a.h0.m.a.a;

import android.app.SharedElementCallback;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.baidu.swan.support.v4.app.Fragment;
import com.bumptech.glide.load.engine.GlideException;
import d.a.h0.m.a.a.n;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class e extends m implements Runnable {
    public static final boolean y;

    /* renamed from: e  reason: collision with root package name */
    public final l f47303e;

    /* renamed from: f  reason: collision with root package name */
    public d f47304f;

    /* renamed from: g  reason: collision with root package name */
    public d f47305g;

    /* renamed from: h  reason: collision with root package name */
    public int f47306h;

    /* renamed from: i  reason: collision with root package name */
    public int f47307i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public String p;
    public boolean q;
    public int r = -1;
    public int s;
    public CharSequence t;
    public int u;
    public CharSequence v;
    public ArrayList<String> w;
    public ArrayList<String> x;

    /* loaded from: classes3.dex */
    public class a implements n.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f47308a;

        public a(e eVar, Fragment fragment) {
            this.f47308a = fragment;
        }

        @Override // d.a.h0.m.a.a.n.f
        public View getView() {
            return this.f47308a.P();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f47309e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f47310f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayList f47311g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ C0996e f47312h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f47313i;
        public final /* synthetic */ Fragment j;
        public final /* synthetic */ Fragment k;

        public b(View view, Object obj, ArrayList arrayList, C0996e c0996e, boolean z, Fragment fragment, Fragment fragment2) {
            this.f47309e = view;
            this.f47310f = obj;
            this.f47311g = arrayList;
            this.f47312h = c0996e;
            this.f47313i = z;
            this.j = fragment;
            this.k = fragment2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f47309e.getViewTreeObserver().removeOnPreDrawListener(this);
            Object obj = this.f47310f;
            if (obj != null) {
                n.s(obj, this.f47311g);
                this.f47311g.clear();
                d.a.h0.m.a.c.a G = e.this.G(this.f47312h, this.f47313i, this.j);
                n.v(this.f47310f, this.f47312h.f47331d, G, this.f47311g);
                e.this.N(G, this.f47312h);
                e.this.r(this.f47312h, this.j, this.k, this.f47313i, G);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f47314e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ C0996e f47315f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f47316g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Object f47317h;

        public c(View view, C0996e c0996e, int i2, Object obj) {
            this.f47314e = view;
            this.f47315f = c0996e;
            this.f47316g = i2;
            this.f47317h = obj;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f47314e.getViewTreeObserver().removeOnPreDrawListener(this);
            e.this.z(this.f47315f, this.f47316g, this.f47317h);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public d f47319a;

        /* renamed from: b  reason: collision with root package name */
        public d f47320b;

        /* renamed from: c  reason: collision with root package name */
        public int f47321c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f47322d;

        /* renamed from: e  reason: collision with root package name */
        public int f47323e;

        /* renamed from: f  reason: collision with root package name */
        public int f47324f;

        /* renamed from: g  reason: collision with root package name */
        public int f47325g;

        /* renamed from: h  reason: collision with root package name */
        public int f47326h;

        /* renamed from: i  reason: collision with root package name */
        public ArrayList<Fragment> f47327i;
    }

    /* renamed from: d.a.h0.m.a.a.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0996e {

        /* renamed from: a  reason: collision with root package name */
        public d.a.h0.m.a.c.a<String, String> f47328a = new d.a.h0.m.a.c.a<>();

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<View> f47329b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public n.e f47330c = new n.e();

        /* renamed from: d  reason: collision with root package name */
        public View f47331d;

        public C0996e(e eVar) {
        }
    }

    static {
        y = Build.VERSION.SDK_INT >= 21;
    }

    public e(l lVar) {
        this.f47303e = lVar;
    }

    public static Object B(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return n.j(z ? fragment.s() : fragment.o());
    }

    public static Object C(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return n.j(z ? fragment.u() : fragment.p());
    }

    public static Object E(Fragment fragment, Fragment fragment2, boolean z) {
        Object x;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            x = fragment2.y();
        } else {
            x = fragment.x();
        }
        return n.w(x);
    }

    public static d.a.h0.m.a.c.a<String, View> J(ArrayList<String> arrayList, ArrayList<String> arrayList2, d.a.h0.m.a.c.a<String, View> aVar) {
        if (aVar.isEmpty()) {
            return aVar;
        }
        d.a.h0.m.a.c.a<String, View> aVar2 = new d.a.h0.m.a.c.a<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = aVar.get(arrayList.get(i2));
            if (view != null) {
                aVar2.put(arrayList2.get(i2), view);
            }
        }
        return aVar2;
    }

    public static void O(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i2;
        if (fragment == null || (i2 = fragment.B) == 0 || fragment.g0() || !fragment.d0() || fragment.P() == null || sparseArray.get(i2) != null) {
            return;
        }
        sparseArray.put(i2, fragment);
    }

    public static void Q(d.a.h0.m.a.c.a<String, String> aVar, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            if (str.equals(aVar.k(i2))) {
                aVar.j(i2, str2);
                return;
            }
        }
        aVar.put(str, str2);
    }

    public static void S(C0996e c0996e, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Q(c0996e.f47328a, arrayList.get(i2), arrayList2.get(i2));
            }
        }
    }

    public static Object s(Object obj, Fragment fragment, ArrayList<View> arrayList, d.a.h0.m.a.c.a<String, View> aVar, View view) {
        return obj != null ? n.g(obj, fragment.P(), arrayList, aVar, view) : obj;
    }

    public final void A(View view, C0996e c0996e, int i2, Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new c(view, c0996e, i2, obj));
    }

    public String D() {
        return this.p;
    }

    public final d.a.h0.m.a.c.a<String, View> F(C0996e c0996e, Fragment fragment, boolean z) {
        d.a.h0.m.a.c.a<String, View> aVar = new d.a.h0.m.a.c.a<>();
        View P = fragment.P();
        if (P == null || this.w == null) {
            return aVar;
        }
        n.m(aVar, P);
        if (z) {
            return J(this.w, this.x, aVar);
        }
        aVar.m(this.x);
        return aVar;
    }

    public final d.a.h0.m.a.c.a<String, View> G(C0996e c0996e, boolean z, Fragment fragment) {
        d.a.h0.m.a.c.a<String, View> F = F(c0996e, fragment, z);
        if (z) {
            SharedElementCallback sharedElementCallback = fragment.c0;
            if (sharedElementCallback != null) {
                sharedElementCallback.onMapSharedElements(this.x, F);
            }
            L(c0996e, F, true);
        } else {
            SharedElementCallback sharedElementCallback2 = fragment.b0;
            if (sharedElementCallback2 != null) {
                sharedElementCallback2.onMapSharedElements(this.x, F);
            }
            R(c0996e, F, true);
        }
        return F;
    }

    public C0996e H(boolean z, C0996e c0996e, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        C0996e c0996e2 = null;
        if (l.x) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            d.a.h0.m.a.c.d dVar = new d.a.h0.m.a.c.d("FragmentManager");
            PrintWriter printWriter = new PrintWriter(dVar);
            x(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
            t(printWriter);
            t(dVar);
        }
        if (y) {
            if (c0996e == null) {
                if (sparseArray.size() != 0 || sparseArray2.size() != 0) {
                    c0996e = n(sparseArray, sparseArray2, true);
                }
            } else if (!z) {
                S(c0996e, this.x, this.w);
            }
        }
        o(-1);
        int i2 = c0996e != null ? 0 : this.n;
        int i3 = c0996e != null ? 0 : this.m;
        for (d dVar2 = this.f47305g; dVar2 != null; dVar2 = dVar2.f47320b) {
            int i4 = c0996e != null ? 0 : dVar2.f47325g;
            int i5 = c0996e != null ? 0 : dVar2.f47326h;
            switch (dVar2.f47321c) {
                case 1:
                    Fragment fragment = dVar2.f47322d;
                    fragment.K = i5;
                    this.f47303e.Y(fragment, l.c0(i3), i2);
                    break;
                case 2:
                    Fragment fragment2 = dVar2.f47322d;
                    if (fragment2 != null) {
                        fragment2.K = i5;
                        this.f47303e.Y(fragment2, l.c0(i3), i2);
                    }
                    if (dVar2.f47327i != null) {
                        for (int i6 = 0; i6 < dVar2.f47327i.size(); i6++) {
                            Fragment fragment3 = dVar2.f47327i.get(i6);
                            fragment3.K = i4;
                            this.f47303e.g(fragment3, false);
                        }
                        break;
                    } else {
                        break;
                    }
                case 3:
                    Fragment fragment4 = dVar2.f47322d;
                    fragment4.K = i4;
                    this.f47303e.g(fragment4, false);
                    break;
                case 4:
                    Fragment fragment5 = dVar2.f47322d;
                    fragment5.K = i4;
                    this.f47303e.j0(fragment5, l.c0(i3), i2);
                    break;
                case 5:
                    Fragment fragment6 = dVar2.f47322d;
                    fragment6.K = i5;
                    this.f47303e.J(fragment6, l.c0(i3), i2);
                    break;
                case 6:
                    Fragment fragment7 = dVar2.f47322d;
                    fragment7.K = i4;
                    this.f47303e.j(fragment7, l.c0(i3), i2);
                    break;
                case 7:
                    Fragment fragment8 = dVar2.f47322d;
                    fragment8.K = i4;
                    this.f47303e.l(fragment8, l.c0(i3), i2);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + dVar2.f47321c);
            }
        }
        if (z) {
            l lVar = this.f47303e;
            lVar.Q(lVar.l, l.c0(i3), i2, true);
        } else {
            c0996e2 = c0996e;
        }
        int i7 = this.r;
        if (i7 >= 0) {
            this.f47303e.G(i7);
            this.r = -1;
        }
        return c0996e2;
    }

    public final void I(C0996e c0996e, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        view.getViewTreeObserver().addOnPreDrawListener(new b(view, obj, arrayList, c0996e, z, fragment, fragment2));
    }

    public final d.a.h0.m.a.c.a<String, View> K(C0996e c0996e, Fragment fragment, boolean z) {
        d.a.h0.m.a.c.a<String, View> aVar = new d.a.h0.m.a.c.a<>();
        if (this.w != null) {
            n.m(aVar, fragment.P());
            if (z) {
                aVar.m(this.x);
            } else {
                aVar = J(this.w, this.x, aVar);
            }
        }
        if (z) {
            SharedElementCallback sharedElementCallback = fragment.b0;
            if (sharedElementCallback != null) {
                sharedElementCallback.onMapSharedElements(this.x, aVar);
            }
            L(c0996e, aVar, false);
        } else {
            SharedElementCallback sharedElementCallback2 = fragment.c0;
            if (sharedElementCallback2 != null) {
                sharedElementCallback2.onMapSharedElements(this.x, aVar);
            }
            R(c0996e, aVar, false);
        }
        return aVar;
    }

    public final void L(C0996e c0996e, d.a.h0.m.a.c.a<String, View> aVar, boolean z) {
        ArrayList<String> arrayList = this.x;
        int size = arrayList == null ? 0 : arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str = this.w.get(i2);
            View view = aVar.get(this.x.get(i2));
            if (view != null) {
                String o = n.o(view);
                if (z) {
                    Q(c0996e.f47328a, str, o);
                } else {
                    Q(c0996e.f47328a, o, str);
                }
            }
        }
    }

    public m M(int i2, int i3, int i4, int i5) {
        this.f47307i = i2;
        this.j = i3;
        this.k = i4;
        this.l = i5;
        return this;
    }

    public final void N(d.a.h0.m.a.c.a<String, View> aVar, C0996e c0996e) {
        View view;
        if (this.x == null || aVar.isEmpty() || (view = aVar.get(this.x.get(0))) == null) {
            return;
        }
        c0996e.f47330c.f47371a = view;
    }

    public final void P(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i2;
        if (fragment == null || (i2 = fragment.B) == 0) {
            return;
        }
        sparseArray.put(i2, fragment);
    }

    public final void R(C0996e c0996e, d.a.h0.m.a.c.a<String, View> aVar, boolean z) {
        int size = aVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            String h2 = aVar.h(i2);
            String o = n.o(aVar.k(i2));
            if (z) {
                Q(c0996e.f47328a, h2, o);
            } else {
                Q(c0996e.f47328a, o, h2);
            }
        }
    }

    @Override // d.a.h0.m.a.a.m
    public m a(int i2, Fragment fragment) {
        w(i2, fragment, null, 1);
        return this;
    }

    @Override // d.a.h0.m.a.a.m
    public m b(int i2, Fragment fragment, String str) {
        w(i2, fragment, str, 1);
        return this;
    }

    @Override // d.a.h0.m.a.a.m
    public int c() {
        return u(false);
    }

    @Override // d.a.h0.m.a.a.m
    public int d() {
        return u(true);
    }

    @Override // d.a.h0.m.a.a.m
    public m e(Fragment fragment) {
        d dVar = new d();
        dVar.f47321c = 4;
        dVar.f47322d = fragment;
        m(dVar);
        return this;
    }

    @Override // d.a.h0.m.a.a.m
    public m f(Fragment fragment) {
        d dVar = new d();
        dVar.f47321c = 3;
        dVar.f47322d = fragment;
        m(dVar);
        return this;
    }

    @Override // d.a.h0.m.a.a.m
    public m g(int i2, int i3) {
        M(i2, i3, 0, 0);
        return this;
    }

    @Override // d.a.h0.m.a.a.m
    public m h(Fragment fragment) {
        d dVar = new d();
        dVar.f47321c = 5;
        dVar.f47322d = fragment;
        m(dVar);
        return this;
    }

    public void m(d dVar) {
        if (this.f47304f == null) {
            this.f47305g = dVar;
            this.f47304f = dVar;
        } else {
            d dVar2 = this.f47305g;
            dVar.f47320b = dVar2;
            dVar2.f47319a = dVar;
            this.f47305g = dVar;
        }
        dVar.f47323e = this.f47307i;
        dVar.f47324f = this.j;
        dVar.f47325g = this.k;
        dVar.f47326h = this.l;
        this.f47306h++;
    }

    public final C0996e n(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        C0996e c0996e = new C0996e(this);
        c0996e.f47331d = new View(this.f47303e.m.h());
        boolean z2 = false;
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            if (v(sparseArray.keyAt(i2), c0996e, z, sparseArray, sparseArray2)) {
                z2 = true;
            }
        }
        for (int i3 = 0; i3 < sparseArray2.size(); i3++) {
            int keyAt = sparseArray2.keyAt(i3);
            if (sparseArray.get(keyAt) == null && v(keyAt, c0996e, z, sparseArray, sparseArray2)) {
                z2 = true;
            }
        }
        if (z2) {
            return c0996e;
        }
        return null;
    }

    public void o(int i2) {
        if (this.o) {
            if (l.x) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            for (d dVar = this.f47304f; dVar != null; dVar = dVar.f47319a) {
                Fragment fragment = dVar.f47322d;
                if (fragment != null) {
                    fragment.v += i2;
                    if (l.x) {
                        Log.v("FragmentManager", "Bump nesting of " + dVar.f47322d + " to " + dVar.f47322d.v);
                    }
                }
                ArrayList<Fragment> arrayList = dVar.f47327i;
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment2 = dVar.f47327i.get(size);
                        fragment2.v += i2;
                        if (l.x) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment2 + " to " + fragment2.v);
                        }
                    }
                }
            }
        }
    }

    public void p(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f47303e.n.b()) {
            for (d dVar = this.f47304f; dVar != null; dVar = dVar.f47319a) {
                switch (dVar.f47321c) {
                    case 1:
                        O(sparseArray, dVar.f47322d);
                        break;
                    case 2:
                        ArrayList<Fragment> arrayList = dVar.f47327i;
                        if (arrayList != null) {
                            for (int size = arrayList.size() - 1; size >= 0; size--) {
                                P(sparseArray2, dVar.f47327i.get(size));
                            }
                        }
                        O(sparseArray, dVar.f47322d);
                        break;
                    case 3:
                        P(sparseArray2, dVar.f47322d);
                        break;
                    case 4:
                        P(sparseArray2, dVar.f47322d);
                        break;
                    case 5:
                        O(sparseArray, dVar.f47322d);
                        break;
                    case 6:
                        P(sparseArray2, dVar.f47322d);
                        break;
                    case 7:
                        O(sparseArray, dVar.f47322d);
                        break;
                }
            }
        }
    }

    public final void q(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f47303e.n.b()) {
            for (d dVar = this.f47304f; dVar != null; dVar = dVar.f47319a) {
                switch (dVar.f47321c) {
                    case 1:
                        P(sparseArray2, dVar.f47322d);
                        break;
                    case 2:
                        Fragment fragment = dVar.f47322d;
                        if (this.f47303e.f47345e != null) {
                            for (int i2 = 0; i2 < this.f47303e.f47345e.size(); i2++) {
                                Fragment fragment2 = this.f47303e.f47345e.get(i2);
                                if (fragment == null || fragment2.B == fragment.B) {
                                    if (fragment2 == fragment) {
                                        fragment = null;
                                    } else {
                                        O(sparseArray, fragment2);
                                    }
                                }
                            }
                        }
                        P(sparseArray2, fragment);
                        break;
                    case 3:
                        O(sparseArray, dVar.f47322d);
                        break;
                    case 4:
                        O(sparseArray, dVar.f47322d);
                        break;
                    case 5:
                        P(sparseArray2, dVar.f47322d);
                        break;
                    case 6:
                        O(sparseArray, dVar.f47322d);
                        break;
                    case 7:
                        P(sparseArray2, dVar.f47322d);
                        break;
                }
            }
        }
    }

    public final void r(C0996e c0996e, Fragment fragment, Fragment fragment2, boolean z, d.a.h0.m.a.c.a<String, View> aVar) {
        SharedElementCallback sharedElementCallback = z ? fragment2.b0 : fragment.b0;
        if (sharedElementCallback != null) {
            sharedElementCallback.onSharedElementEnd(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), null);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        C0996e c0996e;
        if (l.x) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (this.o && this.r < 0) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        o(1);
        if (y) {
            SparseArray<Fragment> sparseArray = new SparseArray<>();
            SparseArray<Fragment> sparseArray2 = new SparseArray<>();
            q(sparseArray, sparseArray2);
            c0996e = n(sparseArray, sparseArray2, false);
        } else {
            c0996e = null;
        }
        int i2 = c0996e != null ? 0 : this.n;
        int i3 = c0996e != null ? 0 : this.m;
        for (d dVar = this.f47304f; dVar != null; dVar = dVar.f47319a) {
            int i4 = c0996e != null ? 0 : dVar.f47323e;
            int i5 = c0996e != null ? 0 : dVar.f47324f;
            switch (dVar.f47321c) {
                case 1:
                    Fragment fragment = dVar.f47322d;
                    fragment.K = i4;
                    this.f47303e.g(fragment, false);
                    continue;
                case 2:
                    Fragment fragment2 = dVar.f47322d;
                    int i6 = fragment2.B;
                    if (this.f47303e.f47345e != null) {
                        for (int i7 = 0; i7 < this.f47303e.f47345e.size(); i7++) {
                            Fragment fragment3 = this.f47303e.f47345e.get(i7);
                            if (l.x) {
                                Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment3);
                            }
                            if (fragment3.B == i6) {
                                if (fragment3 == fragment2) {
                                    dVar.f47322d = null;
                                    fragment2 = null;
                                } else {
                                    if (dVar.f47327i == null) {
                                        dVar.f47327i = new ArrayList<>();
                                    }
                                    dVar.f47327i.add(fragment3);
                                    fragment3.K = i5;
                                    if (this.o) {
                                        fragment3.v++;
                                        if (l.x) {
                                            Log.v("FragmentManager", "Bump nesting of " + fragment3 + " to " + fragment3.v);
                                        }
                                    }
                                    this.f47303e.Y(fragment3, i3, i2);
                                }
                            }
                        }
                    }
                    if (fragment2 != null) {
                        fragment2.K = i4;
                        this.f47303e.g(fragment2, false);
                        continue;
                    }
                    break;
                case 3:
                    Fragment fragment4 = dVar.f47322d;
                    fragment4.K = i5;
                    this.f47303e.Y(fragment4, i3, i2);
                    break;
                case 4:
                    Fragment fragment5 = dVar.f47322d;
                    fragment5.K = i5;
                    this.f47303e.J(fragment5, i3, i2);
                    break;
                case 5:
                    Fragment fragment6 = dVar.f47322d;
                    fragment6.K = i4;
                    this.f47303e.j0(fragment6, i3, i2);
                    break;
                case 6:
                    Fragment fragment7 = dVar.f47322d;
                    fragment7.K = i5;
                    this.f47303e.l(fragment7, i3, i2);
                    break;
                case 7:
                    Fragment fragment8 = dVar.f47322d;
                    fragment8.K = i4;
                    this.f47303e.j(fragment8, i3, i2);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + dVar.f47321c);
            }
        }
        l lVar = this.f47303e;
        lVar.Q(lVar.l, i3, i2, true);
        if (this.o) {
            this.f47303e.f(this);
        }
    }

    public final void t(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.r >= 0) {
            sb.append(" #");
            sb.append(this.r);
        }
        if (this.p != null) {
            sb.append(" ");
            sb.append(this.p);
        }
        sb.append("}");
        return sb.toString();
    }

    public int u(boolean z) {
        if (!this.q) {
            if (l.x) {
                Log.v("FragmentManager", "Commit: " + this);
                d.a.h0.m.a.c.d dVar = new d.a.h0.m.a.c.d("FragmentManager");
                PrintWriter printWriter = new PrintWriter(dVar);
                x(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                t(printWriter);
                t(dVar);
            }
            this.q = true;
            if (this.o) {
                this.r = this.f47303e.h(this);
            } else {
                this.r = -1;
            }
            this.f47303e.C(this, z);
            return this.r;
        }
        throw new IllegalStateException("commit already called");
    }

    public final boolean v(int i2, C0996e c0996e, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Object obj;
        Object obj2;
        d.a.h0.m.a.c.a<String, View> aVar;
        boolean z2;
        Object obj3;
        View view;
        ViewGroup viewGroup = (ViewGroup) this.f47303e.n.a(i2);
        if (viewGroup == null) {
            return false;
        }
        Fragment fragment = sparseArray2.get(i2);
        Fragment fragment2 = sparseArray.get(i2);
        Object B = B(fragment, z);
        Object E = E(fragment, fragment2, z);
        Object C = C(fragment2, z);
        ArrayList<View> arrayList = new ArrayList<>();
        Object obj4 = null;
        if (E != null) {
            d.a.h0.m.a.c.a<String, View> K = K(c0996e, fragment2, z);
            if (K.isEmpty()) {
                aVar = null;
                obj = C;
                obj2 = B;
            } else {
                SharedElementCallback sharedElementCallback = z ? fragment2.b0 : fragment.b0;
                if (sharedElementCallback != null) {
                    sharedElementCallback.onSharedElementStart(new ArrayList(K.keySet()), new ArrayList(K.values()), null);
                }
                obj = C;
                obj2 = B;
                I(c0996e, viewGroup, E, fragment, fragment2, z, arrayList);
                obj4 = E;
                aVar = K;
            }
        } else {
            obj = C;
            obj2 = B;
            aVar = null;
            obj4 = E;
        }
        if (obj2 == null && obj4 == null && obj == null) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Object s = s(obj, fragment2, arrayList2, aVar, c0996e.f47331d);
        ArrayList<String> arrayList3 = this.x;
        if (arrayList3 != null && aVar != null && (view = aVar.get(arrayList3.get(0))) != null) {
            if (s != null) {
                n.t(s, view);
            }
            if (obj4 != null) {
                n.t(obj4, view);
            }
        }
        a aVar2 = new a(this, fragment);
        ArrayList arrayList4 = new ArrayList();
        d.a.h0.m.a.c.a aVar3 = new d.a.h0.m.a.c.a();
        if (fragment == null) {
            z2 = true;
        } else if (z) {
            z2 = fragment.h();
        } else {
            z2 = fragment.g();
        }
        Object r = n.r(obj2, s, obj4, z2);
        if (r != null) {
            obj3 = r;
            n.d(obj2, obj4, viewGroup, aVar2, c0996e.f47331d, c0996e.f47330c, c0996e.f47328a, arrayList4, aVar, aVar3, arrayList);
            A(viewGroup, c0996e, i2, obj3);
            n.l(obj3, c0996e.f47331d, true);
            z(c0996e, i2, obj3);
            n.e(viewGroup, obj3);
            n.i(viewGroup, c0996e.f47331d, obj2, arrayList4, s, arrayList2, obj4, arrayList, obj3, c0996e.f47329b, aVar3);
        } else {
            obj3 = r;
        }
        return obj3 != null;
    }

    public final void w(int i2, Fragment fragment, String str, int i3) {
        fragment.w = this.f47303e;
        if (str != null) {
            String str2 = fragment.C;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.C + " now " + str);
            }
            fragment.C = str;
        }
        if (i2 != 0) {
            int i4 = fragment.A;
            if (i4 != 0 && i4 != i2) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.A + " now " + i2);
            }
            fragment.A = i2;
            fragment.B = i2;
        }
        d dVar = new d();
        dVar.f47321c = i3;
        dVar.f47322d = fragment;
        m(dVar);
    }

    public void x(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        y(str, printWriter, true);
    }

    public void y(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.p);
            printWriter.print(" mIndex=");
            printWriter.print(this.r);
            printWriter.print(" mCommitted=");
            printWriter.println(this.q);
            if (this.m != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.m));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.n));
            }
            if (this.f47307i != 0 || this.j != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f47307i));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.j));
            }
            if (this.k != 0 || this.l != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.k));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.l));
            }
            if (this.s != 0 || this.t != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.s));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.t);
            }
            if (this.u != 0 || this.v != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.u));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.v);
            }
        }
        if (this.f47304f != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str3 = str + "    ";
            d dVar = this.f47304f;
            int i2 = 0;
            while (dVar != null) {
                switch (dVar.f47321c) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    default:
                        str2 = "cmd=" + dVar.f47321c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(dVar.f47322d);
                if (z) {
                    if (dVar.f47323e != 0 || dVar.f47324f != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(dVar.f47323e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(dVar.f47324f));
                    }
                    if (dVar.f47325g != 0 || dVar.f47326h != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(dVar.f47325g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(dVar.f47326h));
                    }
                }
                ArrayList<Fragment> arrayList = dVar.f47327i;
                if (arrayList != null && arrayList.size() > 0) {
                    for (int i3 = 0; i3 < dVar.f47327i.size(); i3++) {
                        printWriter.print(str3);
                        if (dVar.f47327i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i3 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str3);
                            printWriter.print("  #");
                            printWriter.print(i3);
                            printWriter.print(": ");
                        }
                        printWriter.println(dVar.f47327i.get(i3));
                    }
                }
                dVar = dVar.f47319a;
                i2++;
            }
        }
    }

    public final void z(C0996e c0996e, int i2, Object obj) {
        if (this.f47303e.f47345e != null) {
            for (int i3 = 0; i3 < this.f47303e.f47345e.size(); i3++) {
                Fragment fragment = this.f47303e.f47345e.get(i3);
                View view = fragment.M;
                if (view != null && fragment.L != null && fragment.B == i2) {
                    if (fragment.D) {
                        if (!c0996e.f47329b.contains(view)) {
                            n.l(obj, fragment.M, true);
                            c0996e.f47329b.add(fragment.M);
                        }
                    } else {
                        n.l(obj, view, false);
                        c0996e.f47329b.remove(fragment.M);
                    }
                }
            }
        }
    }
}
