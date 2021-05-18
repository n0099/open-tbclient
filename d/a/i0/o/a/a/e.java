package d.a.i0.o.a.a;

import android.app.SharedElementCallback;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.baidu.swan.support.v4.app.Fragment;
import com.bumptech.glide.load.engine.GlideException;
import d.a.i0.o.a.a.o;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class e extends n implements Runnable {
    public static final boolean y;

    /* renamed from: e  reason: collision with root package name */
    public final m f48018e;

    /* renamed from: f  reason: collision with root package name */
    public d f48019f;

    /* renamed from: g  reason: collision with root package name */
    public d f48020g;

    /* renamed from: h  reason: collision with root package name */
    public int f48021h;

    /* renamed from: i  reason: collision with root package name */
    public int f48022i;
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
    public class a implements o.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f48023a;

        public a(e eVar, Fragment fragment) {
            this.f48023a = fragment;
        }

        @Override // d.a.i0.o.a.a.o.f
        public View getView() {
            return this.f48023a.b0();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f48024e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f48025f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayList f48026g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ C1070e f48027h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f48028i;
        public final /* synthetic */ Fragment j;
        public final /* synthetic */ Fragment k;

        public b(View view, Object obj, ArrayList arrayList, C1070e c1070e, boolean z, Fragment fragment, Fragment fragment2) {
            this.f48024e = view;
            this.f48025f = obj;
            this.f48026g = arrayList;
            this.f48027h = c1070e;
            this.f48028i = z;
            this.j = fragment;
            this.k = fragment2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f48024e.getViewTreeObserver().removeOnPreDrawListener(this);
            Object obj = this.f48025f;
            if (obj != null) {
                o.s(obj, this.f48026g);
                this.f48026g.clear();
                d.a.i0.o.a.c.a H = e.this.H(this.f48027h, this.f48028i, this.j);
                o.v(this.f48025f, this.f48027h.f48046d, H, this.f48026g);
                e.this.O(H, this.f48027h);
                e.this.s(this.f48027h, this.j, this.k, this.f48028i, H);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f48029e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ C1070e f48030f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48031g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Object f48032h;

        public c(View view, C1070e c1070e, int i2, Object obj) {
            this.f48029e = view;
            this.f48030f = c1070e;
            this.f48031g = i2;
            this.f48032h = obj;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f48029e.getViewTreeObserver().removeOnPreDrawListener(this);
            e.this.A(this.f48030f, this.f48031g, this.f48032h);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public d f48034a;

        /* renamed from: b  reason: collision with root package name */
        public d f48035b;

        /* renamed from: c  reason: collision with root package name */
        public int f48036c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f48037d;

        /* renamed from: e  reason: collision with root package name */
        public int f48038e;

        /* renamed from: f  reason: collision with root package name */
        public int f48039f;

        /* renamed from: g  reason: collision with root package name */
        public int f48040g;

        /* renamed from: h  reason: collision with root package name */
        public int f48041h;

        /* renamed from: i  reason: collision with root package name */
        public ArrayList<Fragment> f48042i;
    }

    /* renamed from: d.a.i0.o.a.a.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1070e {

        /* renamed from: a  reason: collision with root package name */
        public d.a.i0.o.a.c.a<String, String> f48043a = new d.a.i0.o.a.c.a<>();

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<View> f48044b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public o.e f48045c = new o.e();

        /* renamed from: d  reason: collision with root package name */
        public View f48046d;

        public C1070e(e eVar) {
        }
    }

    static {
        y = Build.VERSION.SDK_INT >= 21;
    }

    public e(m mVar) {
        this.f48018e = mVar;
    }

    public static Object C(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return o.j(z ? fragment.w() : fragment.r());
    }

    public static Object D(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return o.j(z ? fragment.A() : fragment.s());
    }

    public static Object F(Fragment fragment, Fragment fragment2, boolean z) {
        Object H;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            H = fragment2.I();
        } else {
            H = fragment.H();
        }
        return o.w(H);
    }

    public static d.a.i0.o.a.c.a<String, View> K(ArrayList<String> arrayList, ArrayList<String> arrayList2, d.a.i0.o.a.c.a<String, View> aVar) {
        if (aVar.isEmpty()) {
            return aVar;
        }
        d.a.i0.o.a.c.a<String, View> aVar2 = new d.a.i0.o.a.c.a<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = aVar.get(arrayList.get(i2));
            if (view != null) {
                aVar2.put(arrayList2.get(i2), view);
            }
        }
        return aVar2;
    }

    public static void P(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i2;
        if (fragment == null || (i2 = fragment.B) == 0 || fragment.q0() || !fragment.n0() || fragment.b0() == null || sparseArray.get(i2) != null) {
            return;
        }
        sparseArray.put(i2, fragment);
    }

    public static void R(d.a.i0.o.a.c.a<String, String> aVar, String str, String str2) {
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

    public static void T(C1070e c1070e, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                R(c1070e.f48043a, arrayList.get(i2), arrayList2.get(i2));
            }
        }
    }

    public static Object t(Object obj, Fragment fragment, ArrayList<View> arrayList, d.a.i0.o.a.c.a<String, View> aVar, View view) {
        return obj != null ? o.g(obj, fragment.b0(), arrayList, aVar, view) : obj;
    }

    public final void A(C1070e c1070e, int i2, Object obj) {
        if (this.f48018e.f48060e != null) {
            for (int i3 = 0; i3 < this.f48018e.f48060e.size(); i3++) {
                Fragment fragment = this.f48018e.f48060e.get(i3);
                View view = fragment.M;
                if (view != null && fragment.L != null && fragment.B == i2) {
                    if (fragment.D) {
                        if (!c1070e.f48044b.contains(view)) {
                            o.l(obj, fragment.M, true);
                            c1070e.f48044b.add(fragment.M);
                        }
                    } else {
                        o.l(obj, view, false);
                        c1070e.f48044b.remove(fragment.M);
                    }
                }
            }
        }
    }

    public final void B(View view, C1070e c1070e, int i2, Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new c(view, c1070e, i2, obj));
    }

    public String E() {
        return this.p;
    }

    public final d.a.i0.o.a.c.a<String, View> G(C1070e c1070e, Fragment fragment, boolean z) {
        d.a.i0.o.a.c.a<String, View> aVar = new d.a.i0.o.a.c.a<>();
        View b0 = fragment.b0();
        if (b0 == null || this.w == null) {
            return aVar;
        }
        o.m(aVar, b0);
        if (z) {
            return K(this.w, this.x, aVar);
        }
        aVar.m(this.x);
        return aVar;
    }

    public final d.a.i0.o.a.c.a<String, View> H(C1070e c1070e, boolean z, Fragment fragment) {
        d.a.i0.o.a.c.a<String, View> G = G(c1070e, fragment, z);
        if (z) {
            SharedElementCallback sharedElementCallback = fragment.c0;
            if (sharedElementCallback != null) {
                sharedElementCallback.onMapSharedElements(this.x, G);
            }
            M(c1070e, G, true);
        } else {
            SharedElementCallback sharedElementCallback2 = fragment.b0;
            if (sharedElementCallback2 != null) {
                sharedElementCallback2.onMapSharedElements(this.x, G);
            }
            S(c1070e, G, true);
        }
        return G;
    }

    public C1070e I(boolean z, C1070e c1070e, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        C1070e c1070e2 = null;
        if (m.x) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            d.a.i0.o.a.c.d dVar = new d.a.i0.o.a.c.d("FragmentManager");
            PrintWriter printWriter = new PrintWriter(dVar);
            y(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
            u(printWriter);
            u(dVar);
        }
        if (y) {
            if (c1070e == null) {
                if (sparseArray.size() != 0 || sparseArray2.size() != 0) {
                    c1070e = o(sparseArray, sparseArray2, true);
                }
            } else if (!z) {
                T(c1070e, this.x, this.w);
            }
        }
        p(-1);
        int i2 = c1070e != null ? 0 : this.n;
        int i3 = c1070e != null ? 0 : this.m;
        for (d dVar2 = this.f48020g; dVar2 != null; dVar2 = dVar2.f48035b) {
            int i4 = c1070e != null ? 0 : dVar2.f48040g;
            int i5 = c1070e != null ? 0 : dVar2.f48041h;
            switch (dVar2.f48036c) {
                case 1:
                    Fragment fragment = dVar2.f48037d;
                    fragment.K = i5;
                    this.f48018e.Z(fragment, m.d0(i3), i2);
                    break;
                case 2:
                    Fragment fragment2 = dVar2.f48037d;
                    if (fragment2 != null) {
                        fragment2.K = i5;
                        this.f48018e.Z(fragment2, m.d0(i3), i2);
                    }
                    if (dVar2.f48042i != null) {
                        for (int i6 = 0; i6 < dVar2.f48042i.size(); i6++) {
                            Fragment fragment3 = dVar2.f48042i.get(i6);
                            fragment3.K = i4;
                            this.f48018e.h(fragment3, false);
                        }
                        break;
                    } else {
                        break;
                    }
                case 3:
                    Fragment fragment4 = dVar2.f48037d;
                    fragment4.K = i4;
                    this.f48018e.h(fragment4, false);
                    break;
                case 4:
                    Fragment fragment5 = dVar2.f48037d;
                    fragment5.K = i4;
                    this.f48018e.k0(fragment5, m.d0(i3), i2);
                    break;
                case 5:
                    Fragment fragment6 = dVar2.f48037d;
                    fragment6.K = i5;
                    this.f48018e.K(fragment6, m.d0(i3), i2);
                    break;
                case 6:
                    Fragment fragment7 = dVar2.f48037d;
                    fragment7.K = i4;
                    this.f48018e.k(fragment7, m.d0(i3), i2);
                    break;
                case 7:
                    Fragment fragment8 = dVar2.f48037d;
                    fragment8.K = i4;
                    this.f48018e.m(fragment8, m.d0(i3), i2);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + dVar2.f48036c);
            }
        }
        if (z) {
            m mVar = this.f48018e;
            mVar.R(mVar.l, m.d0(i3), i2, true);
        } else {
            c1070e2 = c1070e;
        }
        int i7 = this.r;
        if (i7 >= 0) {
            this.f48018e.H(i7);
            this.r = -1;
        }
        return c1070e2;
    }

    public final void J(C1070e c1070e, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        view.getViewTreeObserver().addOnPreDrawListener(new b(view, obj, arrayList, c1070e, z, fragment, fragment2));
    }

    public final d.a.i0.o.a.c.a<String, View> L(C1070e c1070e, Fragment fragment, boolean z) {
        d.a.i0.o.a.c.a<String, View> aVar = new d.a.i0.o.a.c.a<>();
        if (this.w != null) {
            o.m(aVar, fragment.b0());
            if (z) {
                aVar.m(this.x);
            } else {
                aVar = K(this.w, this.x, aVar);
            }
        }
        if (z) {
            SharedElementCallback sharedElementCallback = fragment.b0;
            if (sharedElementCallback != null) {
                sharedElementCallback.onMapSharedElements(this.x, aVar);
            }
            M(c1070e, aVar, false);
        } else {
            SharedElementCallback sharedElementCallback2 = fragment.c0;
            if (sharedElementCallback2 != null) {
                sharedElementCallback2.onMapSharedElements(this.x, aVar);
            }
            S(c1070e, aVar, false);
        }
        return aVar;
    }

    public final void M(C1070e c1070e, d.a.i0.o.a.c.a<String, View> aVar, boolean z) {
        ArrayList<String> arrayList = this.x;
        int size = arrayList == null ? 0 : arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str = this.w.get(i2);
            View view = aVar.get(this.x.get(i2));
            if (view != null) {
                String o = o.o(view);
                if (z) {
                    R(c1070e.f48043a, str, o);
                } else {
                    R(c1070e.f48043a, o, str);
                }
            }
        }
    }

    public n N(int i2, int i3, int i4, int i5) {
        this.f48022i = i2;
        this.j = i3;
        this.k = i4;
        this.l = i5;
        return this;
    }

    public final void O(d.a.i0.o.a.c.a<String, View> aVar, C1070e c1070e) {
        View view;
        if (this.x == null || aVar.isEmpty() || (view = aVar.get(this.x.get(0))) == null) {
            return;
        }
        c1070e.f48045c.f48089a = view;
    }

    public final void Q(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i2;
        if (fragment == null || (i2 = fragment.B) == 0) {
            return;
        }
        sparseArray.put(i2, fragment);
    }

    public final void S(C1070e c1070e, d.a.i0.o.a.c.a<String, View> aVar, boolean z) {
        int size = aVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            String h2 = aVar.h(i2);
            String o = o.o(aVar.k(i2));
            if (z) {
                R(c1070e.f48043a, h2, o);
            } else {
                R(c1070e.f48043a, o, h2);
            }
        }
    }

    @Override // d.a.i0.o.a.a.n
    public n a(int i2, Fragment fragment) {
        x(i2, fragment, null, 1);
        return this;
    }

    @Override // d.a.i0.o.a.a.n
    public n b(int i2, Fragment fragment, String str) {
        x(i2, fragment, str, 1);
        return this;
    }

    @Override // d.a.i0.o.a.a.n
    public n c(Fragment fragment, String str) {
        x(0, fragment, str, 1);
        return this;
    }

    @Override // d.a.i0.o.a.a.n
    public int d() {
        return v(false);
    }

    @Override // d.a.i0.o.a.a.n
    public int e() {
        return v(true);
    }

    @Override // d.a.i0.o.a.a.n
    public n f(Fragment fragment) {
        d dVar = new d();
        dVar.f48036c = 4;
        dVar.f48037d = fragment;
        n(dVar);
        return this;
    }

    @Override // d.a.i0.o.a.a.n
    public n g(Fragment fragment) {
        d dVar = new d();
        dVar.f48036c = 3;
        dVar.f48037d = fragment;
        n(dVar);
        return this;
    }

    @Override // d.a.i0.o.a.a.n
    public n h(int i2, int i3) {
        N(i2, i3, 0, 0);
        return this;
    }

    @Override // d.a.i0.o.a.a.n
    public n i(Fragment fragment) {
        d dVar = new d();
        dVar.f48036c = 5;
        dVar.f48037d = fragment;
        n(dVar);
        return this;
    }

    public void n(d dVar) {
        if (this.f48019f == null) {
            this.f48020g = dVar;
            this.f48019f = dVar;
        } else {
            d dVar2 = this.f48020g;
            dVar.f48035b = dVar2;
            dVar2.f48034a = dVar;
            this.f48020g = dVar;
        }
        dVar.f48038e = this.f48022i;
        dVar.f48039f = this.j;
        dVar.f48040g = this.k;
        dVar.f48041h = this.l;
        this.f48021h++;
    }

    public final C1070e o(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        C1070e c1070e = new C1070e(this);
        c1070e.f48046d = new View(this.f48018e.m.h());
        boolean z2 = false;
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            if (w(sparseArray.keyAt(i2), c1070e, z, sparseArray, sparseArray2)) {
                z2 = true;
            }
        }
        for (int i3 = 0; i3 < sparseArray2.size(); i3++) {
            int keyAt = sparseArray2.keyAt(i3);
            if (sparseArray.get(keyAt) == null && w(keyAt, c1070e, z, sparseArray, sparseArray2)) {
                z2 = true;
            }
        }
        if (z2) {
            return c1070e;
        }
        return null;
    }

    public void p(int i2) {
        if (this.o) {
            if (m.x) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            for (d dVar = this.f48019f; dVar != null; dVar = dVar.f48034a) {
                Fragment fragment = dVar.f48037d;
                if (fragment != null) {
                    fragment.v += i2;
                    if (m.x) {
                        Log.v("FragmentManager", "Bump nesting of " + dVar.f48037d + " to " + dVar.f48037d.v);
                    }
                }
                ArrayList<Fragment> arrayList = dVar.f48042i;
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment2 = dVar.f48042i.get(size);
                        fragment2.v += i2;
                        if (m.x) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment2 + " to " + fragment2.v);
                        }
                    }
                }
            }
        }
    }

    public void q(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f48018e.n.b()) {
            for (d dVar = this.f48019f; dVar != null; dVar = dVar.f48034a) {
                switch (dVar.f48036c) {
                    case 1:
                        P(sparseArray, dVar.f48037d);
                        break;
                    case 2:
                        ArrayList<Fragment> arrayList = dVar.f48042i;
                        if (arrayList != null) {
                            for (int size = arrayList.size() - 1; size >= 0; size--) {
                                Q(sparseArray2, dVar.f48042i.get(size));
                            }
                        }
                        P(sparseArray, dVar.f48037d);
                        break;
                    case 3:
                        Q(sparseArray2, dVar.f48037d);
                        break;
                    case 4:
                        Q(sparseArray2, dVar.f48037d);
                        break;
                    case 5:
                        P(sparseArray, dVar.f48037d);
                        break;
                    case 6:
                        Q(sparseArray2, dVar.f48037d);
                        break;
                    case 7:
                        P(sparseArray, dVar.f48037d);
                        break;
                }
            }
        }
    }

    public final void r(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f48018e.n.b()) {
            for (d dVar = this.f48019f; dVar != null; dVar = dVar.f48034a) {
                switch (dVar.f48036c) {
                    case 1:
                        Q(sparseArray2, dVar.f48037d);
                        break;
                    case 2:
                        Fragment fragment = dVar.f48037d;
                        if (this.f48018e.f48060e != null) {
                            for (int i2 = 0; i2 < this.f48018e.f48060e.size(); i2++) {
                                Fragment fragment2 = this.f48018e.f48060e.get(i2);
                                if (fragment == null || fragment2.B == fragment.B) {
                                    if (fragment2 == fragment) {
                                        fragment = null;
                                    } else {
                                        P(sparseArray, fragment2);
                                    }
                                }
                            }
                        }
                        Q(sparseArray2, fragment);
                        break;
                    case 3:
                        P(sparseArray, dVar.f48037d);
                        break;
                    case 4:
                        P(sparseArray, dVar.f48037d);
                        break;
                    case 5:
                        Q(sparseArray2, dVar.f48037d);
                        break;
                    case 6:
                        P(sparseArray, dVar.f48037d);
                        break;
                    case 7:
                        Q(sparseArray2, dVar.f48037d);
                        break;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        C1070e c1070e;
        if (m.x) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (this.o && this.r < 0) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        p(1);
        if (y) {
            SparseArray<Fragment> sparseArray = new SparseArray<>();
            SparseArray<Fragment> sparseArray2 = new SparseArray<>();
            r(sparseArray, sparseArray2);
            c1070e = o(sparseArray, sparseArray2, false);
        } else {
            c1070e = null;
        }
        int i2 = c1070e != null ? 0 : this.n;
        int i3 = c1070e != null ? 0 : this.m;
        for (d dVar = this.f48019f; dVar != null; dVar = dVar.f48034a) {
            int i4 = c1070e != null ? 0 : dVar.f48038e;
            int i5 = c1070e != null ? 0 : dVar.f48039f;
            switch (dVar.f48036c) {
                case 1:
                    Fragment fragment = dVar.f48037d;
                    fragment.K = i4;
                    this.f48018e.h(fragment, false);
                    continue;
                case 2:
                    Fragment fragment2 = dVar.f48037d;
                    int i6 = fragment2.B;
                    if (this.f48018e.f48060e != null) {
                        for (int i7 = 0; i7 < this.f48018e.f48060e.size(); i7++) {
                            Fragment fragment3 = this.f48018e.f48060e.get(i7);
                            if (m.x) {
                                Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment3);
                            }
                            if (fragment3.B == i6) {
                                if (fragment3 == fragment2) {
                                    dVar.f48037d = null;
                                    fragment2 = null;
                                } else {
                                    if (dVar.f48042i == null) {
                                        dVar.f48042i = new ArrayList<>();
                                    }
                                    dVar.f48042i.add(fragment3);
                                    fragment3.K = i5;
                                    if (this.o) {
                                        fragment3.v++;
                                        if (m.x) {
                                            Log.v("FragmentManager", "Bump nesting of " + fragment3 + " to " + fragment3.v);
                                        }
                                    }
                                    this.f48018e.Z(fragment3, i3, i2);
                                }
                            }
                        }
                    }
                    if (fragment2 != null) {
                        fragment2.K = i4;
                        this.f48018e.h(fragment2, false);
                        continue;
                    }
                    break;
                case 3:
                    Fragment fragment4 = dVar.f48037d;
                    fragment4.K = i5;
                    this.f48018e.Z(fragment4, i3, i2);
                    break;
                case 4:
                    Fragment fragment5 = dVar.f48037d;
                    fragment5.K = i5;
                    this.f48018e.K(fragment5, i3, i2);
                    break;
                case 5:
                    Fragment fragment6 = dVar.f48037d;
                    fragment6.K = i4;
                    this.f48018e.k0(fragment6, i3, i2);
                    break;
                case 6:
                    Fragment fragment7 = dVar.f48037d;
                    fragment7.K = i5;
                    this.f48018e.m(fragment7, i3, i2);
                    break;
                case 7:
                    Fragment fragment8 = dVar.f48037d;
                    fragment8.K = i4;
                    this.f48018e.k(fragment8, i3, i2);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + dVar.f48036c);
            }
        }
        m mVar = this.f48018e;
        mVar.R(mVar.l, i3, i2, true);
        if (this.o) {
            this.f48018e.g(this);
        }
    }

    public final void s(C1070e c1070e, Fragment fragment, Fragment fragment2, boolean z, d.a.i0.o.a.c.a<String, View> aVar) {
        SharedElementCallback sharedElementCallback = z ? fragment2.b0 : fragment.b0;
        if (sharedElementCallback != null) {
            sharedElementCallback.onSharedElementEnd(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), null);
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

    public final void u(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public int v(boolean z) {
        if (!this.q) {
            if (m.x) {
                Log.v("FragmentManager", "Commit: " + this);
                d.a.i0.o.a.c.d dVar = new d.a.i0.o.a.c.d("FragmentManager");
                PrintWriter printWriter = new PrintWriter(dVar);
                y(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                u(printWriter);
                u(dVar);
            }
            this.q = true;
            if (this.o) {
                this.r = this.f48018e.i(this);
            } else {
                this.r = -1;
            }
            this.f48018e.D(this, z);
            return this.r;
        }
        throw new IllegalStateException("commit already called");
    }

    public final boolean w(int i2, C1070e c1070e, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Object obj;
        Object obj2;
        d.a.i0.o.a.c.a<String, View> aVar;
        boolean z2;
        Object obj3;
        View view;
        ViewGroup viewGroup = (ViewGroup) this.f48018e.n.a(i2);
        if (viewGroup == null) {
            return false;
        }
        Fragment fragment = sparseArray2.get(i2);
        Fragment fragment2 = sparseArray.get(i2);
        Object C = C(fragment, z);
        Object F = F(fragment, fragment2, z);
        Object D = D(fragment2, z);
        ArrayList<View> arrayList = new ArrayList<>();
        Object obj4 = null;
        if (F != null) {
            d.a.i0.o.a.c.a<String, View> L = L(c1070e, fragment2, z);
            if (L.isEmpty()) {
                aVar = null;
                obj = D;
                obj2 = C;
            } else {
                SharedElementCallback sharedElementCallback = z ? fragment2.b0 : fragment.b0;
                if (sharedElementCallback != null) {
                    sharedElementCallback.onSharedElementStart(new ArrayList(L.keySet()), new ArrayList(L.values()), null);
                }
                obj = D;
                obj2 = C;
                J(c1070e, viewGroup, F, fragment, fragment2, z, arrayList);
                obj4 = F;
                aVar = L;
            }
        } else {
            obj = D;
            obj2 = C;
            aVar = null;
            obj4 = F;
        }
        if (obj2 == null && obj4 == null && obj == null) {
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Object t = t(obj, fragment2, arrayList2, aVar, c1070e.f48046d);
        ArrayList<String> arrayList3 = this.x;
        if (arrayList3 != null && aVar != null && (view = aVar.get(arrayList3.get(0))) != null) {
            if (t != null) {
                o.t(t, view);
            }
            if (obj4 != null) {
                o.t(obj4, view);
            }
        }
        a aVar2 = new a(this, fragment);
        ArrayList arrayList4 = new ArrayList();
        d.a.i0.o.a.c.a aVar3 = new d.a.i0.o.a.c.a();
        if (fragment == null) {
            z2 = true;
        } else if (z) {
            z2 = fragment.k();
        } else {
            z2 = fragment.j();
        }
        Object r = o.r(obj2, t, obj4, z2);
        if (r != null) {
            obj3 = r;
            o.d(obj2, obj4, viewGroup, aVar2, c1070e.f48046d, c1070e.f48045c, c1070e.f48043a, arrayList4, aVar, aVar3, arrayList);
            B(viewGroup, c1070e, i2, obj3);
            o.l(obj3, c1070e.f48046d, true);
            A(c1070e, i2, obj3);
            o.e(viewGroup, obj3);
            o.i(viewGroup, c1070e.f48046d, obj2, arrayList4, t, arrayList2, obj4, arrayList, obj3, c1070e.f48044b, aVar3);
        } else {
            obj3 = r;
        }
        return obj3 != null;
    }

    public final void x(int i2, Fragment fragment, String str, int i3) {
        fragment.w = this.f48018e;
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
        dVar.f48036c = i3;
        dVar.f48037d = fragment;
        n(dVar);
    }

    public void y(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        z(str, printWriter, true);
    }

    public void z(String str, PrintWriter printWriter, boolean z) {
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
            if (this.f48022i != 0 || this.j != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f48022i));
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
        if (this.f48019f != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str3 = str + "    ";
            d dVar = this.f48019f;
            int i2 = 0;
            while (dVar != null) {
                switch (dVar.f48036c) {
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
                        str2 = "cmd=" + dVar.f48036c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(dVar.f48037d);
                if (z) {
                    if (dVar.f48038e != 0 || dVar.f48039f != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(dVar.f48038e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(dVar.f48039f));
                    }
                    if (dVar.f48040g != 0 || dVar.f48041h != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(dVar.f48040g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(dVar.f48041h));
                    }
                }
                ArrayList<Fragment> arrayList = dVar.f48042i;
                if (arrayList != null && arrayList.size() > 0) {
                    for (int i3 = 0; i3 < dVar.f48042i.size(); i3++) {
                        printWriter.print(str3);
                        if (dVar.f48042i.size() == 1) {
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
                        printWriter.println(dVar.f48042i.get(i3));
                    }
                }
                dVar = dVar.f48034a;
                i2++;
            }
        }
    }
}
