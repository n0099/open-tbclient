package d.b.g0.m.a.a;

import android.app.SharedElementCallback;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.baidu.swan.support.v4.app.Fragment;
import com.bumptech.glide.load.engine.GlideException;
import d.b.g0.m.a.a.n;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class e extends m implements Runnable {
    public static final boolean y;

    /* renamed from: e  reason: collision with root package name */
    public final l f49067e;

    /* renamed from: f  reason: collision with root package name */
    public d f49068f;

    /* renamed from: g  reason: collision with root package name */
    public d f49069g;

    /* renamed from: h  reason: collision with root package name */
    public int f49070h;
    public int i;
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
        public final /* synthetic */ Fragment f49071a;

        public a(e eVar, Fragment fragment) {
            this.f49071a = fragment;
        }

        @Override // d.b.g0.m.a.a.n.f
        public View getView() {
            return this.f49071a.W();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f49072e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f49073f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayList f49074g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ C1024e f49075h;
        public final /* synthetic */ boolean i;
        public final /* synthetic */ Fragment j;
        public final /* synthetic */ Fragment k;

        public b(View view, Object obj, ArrayList arrayList, C1024e c1024e, boolean z, Fragment fragment, Fragment fragment2) {
            this.f49072e = view;
            this.f49073f = obj;
            this.f49074g = arrayList;
            this.f49075h = c1024e;
            this.i = z;
            this.j = fragment;
            this.k = fragment2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f49072e.getViewTreeObserver().removeOnPreDrawListener(this);
            Object obj = this.f49073f;
            if (obj != null) {
                n.s(obj, this.f49074g);
                this.f49074g.clear();
                d.b.g0.m.a.c.a G = e.this.G(this.f49075h, this.i, this.j);
                n.v(this.f49073f, this.f49075h.f49091d, G, this.f49074g);
                e.this.N(G, this.f49075h);
                e.this.r(this.f49075h, this.j, this.k, this.i, G);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f49076e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ C1024e f49077f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f49078g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Object f49079h;

        public c(View view, C1024e c1024e, int i, Object obj) {
            this.f49076e = view;
            this.f49077f = c1024e;
            this.f49078g = i;
            this.f49079h = obj;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f49076e.getViewTreeObserver().removeOnPreDrawListener(this);
            e.this.z(this.f49077f, this.f49078g, this.f49079h);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public d f49080a;

        /* renamed from: b  reason: collision with root package name */
        public d f49081b;

        /* renamed from: c  reason: collision with root package name */
        public int f49082c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f49083d;

        /* renamed from: e  reason: collision with root package name */
        public int f49084e;

        /* renamed from: f  reason: collision with root package name */
        public int f49085f;

        /* renamed from: g  reason: collision with root package name */
        public int f49086g;

        /* renamed from: h  reason: collision with root package name */
        public int f49087h;
        public ArrayList<Fragment> i;
    }

    /* renamed from: d.b.g0.m.a.a.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1024e {

        /* renamed from: a  reason: collision with root package name */
        public d.b.g0.m.a.c.a<String, String> f49088a = new d.b.g0.m.a.c.a<>();

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<View> f49089b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public n.e f49090c = new n.e();

        /* renamed from: d  reason: collision with root package name */
        public View f49091d;

        public C1024e(e eVar) {
        }
    }

    static {
        y = Build.VERSION.SDK_INT >= 21;
    }

    public e(l lVar) {
        this.f49067e = lVar;
    }

    public static Object B(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return n.j(z ? fragment.r() : fragment.o());
    }

    public static Object C(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return n.j(z ? fragment.y() : fragment.p());
    }

    public static Object E(Fragment fragment, Fragment fragment2, boolean z) {
        Object A;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            A = fragment2.F();
        } else {
            A = fragment.A();
        }
        return n.w(A);
    }

    public static d.b.g0.m.a.c.a<String, View> J(ArrayList<String> arrayList, ArrayList<String> arrayList2, d.b.g0.m.a.c.a<String, View> aVar) {
        if (aVar.isEmpty()) {
            return aVar;
        }
        d.b.g0.m.a.c.a<String, View> aVar2 = new d.b.g0.m.a.c.a<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = aVar.get(arrayList.get(i));
            if (view != null) {
                aVar2.put(arrayList2.get(i), view);
            }
        }
        return aVar2;
    }

    public static void O(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        if (fragment == null || (i = fragment.B) == 0 || fragment.l0() || !fragment.i0() || fragment.W() == null || sparseArray.get(i) != null) {
            return;
        }
        sparseArray.put(i, fragment);
    }

    public static void Q(d.b.g0.m.a.c.a<String, String> aVar, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        for (int i = 0; i < aVar.size(); i++) {
            if (str.equals(aVar.k(i))) {
                aVar.j(i, str2);
                return;
            }
        }
        aVar.put(str, str2);
    }

    public static void S(C1024e c1024e, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                Q(c1024e.f49088a, arrayList.get(i), arrayList2.get(i));
            }
        }
    }

    public static Object s(Object obj, Fragment fragment, ArrayList<View> arrayList, d.b.g0.m.a.c.a<String, View> aVar, View view) {
        return obj != null ? n.g(obj, fragment.W(), arrayList, aVar, view) : obj;
    }

    public final void A(View view, C1024e c1024e, int i, Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new c(view, c1024e, i, obj));
    }

    public String D() {
        return this.p;
    }

    public final d.b.g0.m.a.c.a<String, View> F(C1024e c1024e, Fragment fragment, boolean z) {
        d.b.g0.m.a.c.a<String, View> aVar = new d.b.g0.m.a.c.a<>();
        View W = fragment.W();
        if (W == null || this.w == null) {
            return aVar;
        }
        n.m(aVar, W);
        if (z) {
            return J(this.w, this.x, aVar);
        }
        aVar.m(this.x);
        return aVar;
    }

    public final d.b.g0.m.a.c.a<String, View> G(C1024e c1024e, boolean z, Fragment fragment) {
        d.b.g0.m.a.c.a<String, View> F = F(c1024e, fragment, z);
        if (z) {
            SharedElementCallback sharedElementCallback = fragment.c0;
            if (sharedElementCallback != null) {
                sharedElementCallback.onMapSharedElements(this.x, F);
            }
            L(c1024e, F, true);
        } else {
            SharedElementCallback sharedElementCallback2 = fragment.b0;
            if (sharedElementCallback2 != null) {
                sharedElementCallback2.onMapSharedElements(this.x, F);
            }
            R(c1024e, F, true);
        }
        return F;
    }

    public C1024e H(boolean z, C1024e c1024e, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        C1024e c1024e2 = null;
        if (l.x) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            d.b.g0.m.a.c.d dVar = new d.b.g0.m.a.c.d("FragmentManager");
            PrintWriter printWriter = new PrintWriter(dVar);
            x(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
            t(printWriter);
            t(dVar);
        }
        if (y) {
            if (c1024e == null) {
                if (sparseArray.size() != 0 || sparseArray2.size() != 0) {
                    c1024e = n(sparseArray, sparseArray2, true);
                }
            } else if (!z) {
                S(c1024e, this.x, this.w);
            }
        }
        o(-1);
        int i = c1024e != null ? 0 : this.n;
        int i2 = c1024e != null ? 0 : this.m;
        for (d dVar2 = this.f49069g; dVar2 != null; dVar2 = dVar2.f49081b) {
            int i3 = c1024e != null ? 0 : dVar2.f49086g;
            int i4 = c1024e != null ? 0 : dVar2.f49087h;
            switch (dVar2.f49082c) {
                case 1:
                    Fragment fragment = dVar2.f49083d;
                    fragment.K = i4;
                    this.f49067e.Y(fragment, l.c0(i2), i);
                    break;
                case 2:
                    Fragment fragment2 = dVar2.f49083d;
                    if (fragment2 != null) {
                        fragment2.K = i4;
                        this.f49067e.Y(fragment2, l.c0(i2), i);
                    }
                    if (dVar2.i != null) {
                        for (int i5 = 0; i5 < dVar2.i.size(); i5++) {
                            Fragment fragment3 = dVar2.i.get(i5);
                            fragment3.K = i3;
                            this.f49067e.g(fragment3, false);
                        }
                        break;
                    } else {
                        break;
                    }
                case 3:
                    Fragment fragment4 = dVar2.f49083d;
                    fragment4.K = i3;
                    this.f49067e.g(fragment4, false);
                    break;
                case 4:
                    Fragment fragment5 = dVar2.f49083d;
                    fragment5.K = i3;
                    this.f49067e.j0(fragment5, l.c0(i2), i);
                    break;
                case 5:
                    Fragment fragment6 = dVar2.f49083d;
                    fragment6.K = i4;
                    this.f49067e.J(fragment6, l.c0(i2), i);
                    break;
                case 6:
                    Fragment fragment7 = dVar2.f49083d;
                    fragment7.K = i3;
                    this.f49067e.j(fragment7, l.c0(i2), i);
                    break;
                case 7:
                    Fragment fragment8 = dVar2.f49083d;
                    fragment8.K = i3;
                    this.f49067e.l(fragment8, l.c0(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + dVar2.f49082c);
            }
        }
        if (z) {
            l lVar = this.f49067e;
            lVar.Q(lVar.l, l.c0(i2), i, true);
        } else {
            c1024e2 = c1024e;
        }
        int i6 = this.r;
        if (i6 >= 0) {
            this.f49067e.G(i6);
            this.r = -1;
        }
        return c1024e2;
    }

    public final void I(C1024e c1024e, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        view.getViewTreeObserver().addOnPreDrawListener(new b(view, obj, arrayList, c1024e, z, fragment, fragment2));
    }

    public final d.b.g0.m.a.c.a<String, View> K(C1024e c1024e, Fragment fragment, boolean z) {
        d.b.g0.m.a.c.a<String, View> aVar = new d.b.g0.m.a.c.a<>();
        if (this.w != null) {
            n.m(aVar, fragment.W());
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
            L(c1024e, aVar, false);
        } else {
            SharedElementCallback sharedElementCallback2 = fragment.c0;
            if (sharedElementCallback2 != null) {
                sharedElementCallback2.onMapSharedElements(this.x, aVar);
            }
            R(c1024e, aVar, false);
        }
        return aVar;
    }

    public final void L(C1024e c1024e, d.b.g0.m.a.c.a<String, View> aVar, boolean z) {
        ArrayList<String> arrayList = this.x;
        int size = arrayList == null ? 0 : arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = this.w.get(i);
            View view = aVar.get(this.x.get(i));
            if (view != null) {
                String o = n.o(view);
                if (z) {
                    Q(c1024e.f49088a, str, o);
                } else {
                    Q(c1024e.f49088a, o, str);
                }
            }
        }
    }

    public m M(int i, int i2, int i3, int i4) {
        this.i = i;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        return this;
    }

    public final void N(d.b.g0.m.a.c.a<String, View> aVar, C1024e c1024e) {
        View view;
        if (this.x == null || aVar.isEmpty() || (view = aVar.get(this.x.get(0))) == null) {
            return;
        }
        c1024e.f49090c.f49128a = view;
    }

    public final void P(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        if (fragment == null || (i = fragment.B) == 0) {
            return;
        }
        sparseArray.put(i, fragment);
    }

    public final void R(C1024e c1024e, d.b.g0.m.a.c.a<String, View> aVar, boolean z) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            String h2 = aVar.h(i);
            String o = n.o(aVar.k(i));
            if (z) {
                Q(c1024e.f49088a, h2, o);
            } else {
                Q(c1024e.f49088a, o, h2);
            }
        }
    }

    @Override // d.b.g0.m.a.a.m
    public m a(int i, Fragment fragment) {
        w(i, fragment, null, 1);
        return this;
    }

    @Override // d.b.g0.m.a.a.m
    public m b(int i, Fragment fragment, String str) {
        w(i, fragment, str, 1);
        return this;
    }

    @Override // d.b.g0.m.a.a.m
    public int c() {
        return u(false);
    }

    @Override // d.b.g0.m.a.a.m
    public int d() {
        return u(true);
    }

    @Override // d.b.g0.m.a.a.m
    public m e(Fragment fragment) {
        d dVar = new d();
        dVar.f49082c = 4;
        dVar.f49083d = fragment;
        m(dVar);
        return this;
    }

    @Override // d.b.g0.m.a.a.m
    public m f(Fragment fragment) {
        d dVar = new d();
        dVar.f49082c = 3;
        dVar.f49083d = fragment;
        m(dVar);
        return this;
    }

    @Override // d.b.g0.m.a.a.m
    public m g(int i, int i2) {
        M(i, i2, 0, 0);
        return this;
    }

    @Override // d.b.g0.m.a.a.m
    public m h(Fragment fragment) {
        d dVar = new d();
        dVar.f49082c = 5;
        dVar.f49083d = fragment;
        m(dVar);
        return this;
    }

    public void m(d dVar) {
        if (this.f49068f == null) {
            this.f49069g = dVar;
            this.f49068f = dVar;
        } else {
            d dVar2 = this.f49069g;
            dVar.f49081b = dVar2;
            dVar2.f49080a = dVar;
            this.f49069g = dVar;
        }
        dVar.f49084e = this.i;
        dVar.f49085f = this.j;
        dVar.f49086g = this.k;
        dVar.f49087h = this.l;
        this.f49070h++;
    }

    public final C1024e n(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        C1024e c1024e = new C1024e(this);
        c1024e.f49091d = new View(this.f49067e.m.h());
        boolean z2 = false;
        for (int i = 0; i < sparseArray.size(); i++) {
            if (v(sparseArray.keyAt(i), c1024e, z, sparseArray, sparseArray2)) {
                z2 = true;
            }
        }
        for (int i2 = 0; i2 < sparseArray2.size(); i2++) {
            int keyAt = sparseArray2.keyAt(i2);
            if (sparseArray.get(keyAt) == null && v(keyAt, c1024e, z, sparseArray, sparseArray2)) {
                z2 = true;
            }
        }
        if (z2) {
            return c1024e;
        }
        return null;
    }

    public void o(int i) {
        if (this.o) {
            if (l.x) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (d dVar = this.f49068f; dVar != null; dVar = dVar.f49080a) {
                Fragment fragment = dVar.f49083d;
                if (fragment != null) {
                    fragment.v += i;
                    if (l.x) {
                        Log.v("FragmentManager", "Bump nesting of " + dVar.f49083d + " to " + dVar.f49083d.v);
                    }
                }
                ArrayList<Fragment> arrayList = dVar.i;
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment2 = dVar.i.get(size);
                        fragment2.v += i;
                        if (l.x) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment2 + " to " + fragment2.v);
                        }
                    }
                }
            }
        }
    }

    public void p(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f49067e.n.b()) {
            for (d dVar = this.f49068f; dVar != null; dVar = dVar.f49080a) {
                switch (dVar.f49082c) {
                    case 1:
                        O(sparseArray, dVar.f49083d);
                        break;
                    case 2:
                        ArrayList<Fragment> arrayList = dVar.i;
                        if (arrayList != null) {
                            for (int size = arrayList.size() - 1; size >= 0; size--) {
                                P(sparseArray2, dVar.i.get(size));
                            }
                        }
                        O(sparseArray, dVar.f49083d);
                        break;
                    case 3:
                        P(sparseArray2, dVar.f49083d);
                        break;
                    case 4:
                        P(sparseArray2, dVar.f49083d);
                        break;
                    case 5:
                        O(sparseArray, dVar.f49083d);
                        break;
                    case 6:
                        P(sparseArray2, dVar.f49083d);
                        break;
                    case 7:
                        O(sparseArray, dVar.f49083d);
                        break;
                }
            }
        }
    }

    public final void q(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f49067e.n.b()) {
            for (d dVar = this.f49068f; dVar != null; dVar = dVar.f49080a) {
                switch (dVar.f49082c) {
                    case 1:
                        P(sparseArray2, dVar.f49083d);
                        break;
                    case 2:
                        Fragment fragment = dVar.f49083d;
                        if (this.f49067e.f49105e != null) {
                            for (int i = 0; i < this.f49067e.f49105e.size(); i++) {
                                Fragment fragment2 = this.f49067e.f49105e.get(i);
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
                        O(sparseArray, dVar.f49083d);
                        break;
                    case 4:
                        O(sparseArray, dVar.f49083d);
                        break;
                    case 5:
                        P(sparseArray2, dVar.f49083d);
                        break;
                    case 6:
                        O(sparseArray, dVar.f49083d);
                        break;
                    case 7:
                        P(sparseArray2, dVar.f49083d);
                        break;
                }
            }
        }
    }

    public final void r(C1024e c1024e, Fragment fragment, Fragment fragment2, boolean z, d.b.g0.m.a.c.a<String, View> aVar) {
        SharedElementCallback sharedElementCallback = z ? fragment2.b0 : fragment.b0;
        if (sharedElementCallback != null) {
            sharedElementCallback.onSharedElementEnd(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), null);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        C1024e c1024e;
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
            c1024e = n(sparseArray, sparseArray2, false);
        } else {
            c1024e = null;
        }
        int i = c1024e != null ? 0 : this.n;
        int i2 = c1024e != null ? 0 : this.m;
        for (d dVar = this.f49068f; dVar != null; dVar = dVar.f49080a) {
            int i3 = c1024e != null ? 0 : dVar.f49084e;
            int i4 = c1024e != null ? 0 : dVar.f49085f;
            switch (dVar.f49082c) {
                case 1:
                    Fragment fragment = dVar.f49083d;
                    fragment.K = i3;
                    this.f49067e.g(fragment, false);
                    continue;
                case 2:
                    Fragment fragment2 = dVar.f49083d;
                    int i5 = fragment2.B;
                    if (this.f49067e.f49105e != null) {
                        for (int i6 = 0; i6 < this.f49067e.f49105e.size(); i6++) {
                            Fragment fragment3 = this.f49067e.f49105e.get(i6);
                            if (l.x) {
                                Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment3);
                            }
                            if (fragment3.B == i5) {
                                if (fragment3 == fragment2) {
                                    dVar.f49083d = null;
                                    fragment2 = null;
                                } else {
                                    if (dVar.i == null) {
                                        dVar.i = new ArrayList<>();
                                    }
                                    dVar.i.add(fragment3);
                                    fragment3.K = i4;
                                    if (this.o) {
                                        fragment3.v++;
                                        if (l.x) {
                                            Log.v("FragmentManager", "Bump nesting of " + fragment3 + " to " + fragment3.v);
                                        }
                                    }
                                    this.f49067e.Y(fragment3, i2, i);
                                }
                            }
                        }
                    }
                    if (fragment2 != null) {
                        fragment2.K = i3;
                        this.f49067e.g(fragment2, false);
                        continue;
                    }
                    break;
                case 3:
                    Fragment fragment4 = dVar.f49083d;
                    fragment4.K = i4;
                    this.f49067e.Y(fragment4, i2, i);
                    break;
                case 4:
                    Fragment fragment5 = dVar.f49083d;
                    fragment5.K = i4;
                    this.f49067e.J(fragment5, i2, i);
                    break;
                case 5:
                    Fragment fragment6 = dVar.f49083d;
                    fragment6.K = i3;
                    this.f49067e.j0(fragment6, i2, i);
                    break;
                case 6:
                    Fragment fragment7 = dVar.f49083d;
                    fragment7.K = i4;
                    this.f49067e.l(fragment7, i2, i);
                    break;
                case 7:
                    Fragment fragment8 = dVar.f49083d;
                    fragment8.K = i3;
                    this.f49067e.j(fragment8, i2, i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + dVar.f49082c);
            }
        }
        l lVar = this.f49067e;
        lVar.Q(lVar.l, i2, i, true);
        if (this.o) {
            this.f49067e.f(this);
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
                d.b.g0.m.a.c.d dVar = new d.b.g0.m.a.c.d("FragmentManager");
                PrintWriter printWriter = new PrintWriter(dVar);
                x(GlideException.IndentedAppendable.INDENT, null, printWriter, null);
                t(printWriter);
                t(dVar);
            }
            this.q = true;
            if (this.o) {
                this.r = this.f49067e.h(this);
            } else {
                this.r = -1;
            }
            this.f49067e.C(this, z);
            return this.r;
        }
        throw new IllegalStateException("commit already called");
    }

    public final boolean v(int i, C1024e c1024e, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Object obj;
        Object obj2;
        d.b.g0.m.a.c.a<String, View> aVar;
        boolean z2;
        Object obj3;
        View view;
        ViewGroup viewGroup = (ViewGroup) this.f49067e.n.a(i);
        if (viewGroup == null) {
            return false;
        }
        Fragment fragment = sparseArray2.get(i);
        Fragment fragment2 = sparseArray.get(i);
        Object B = B(fragment, z);
        Object E = E(fragment, fragment2, z);
        Object C = C(fragment2, z);
        ArrayList<View> arrayList = new ArrayList<>();
        Object obj4 = null;
        if (E != null) {
            d.b.g0.m.a.c.a<String, View> K = K(c1024e, fragment2, z);
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
                I(c1024e, viewGroup, E, fragment, fragment2, z, arrayList);
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
        Object s = s(obj, fragment2, arrayList2, aVar, c1024e.f49091d);
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
        d.b.g0.m.a.c.a aVar3 = new d.b.g0.m.a.c.a();
        if (fragment == null) {
            z2 = true;
        } else if (z) {
            z2 = fragment.i();
        } else {
            z2 = fragment.h();
        }
        Object r = n.r(obj2, s, obj4, z2);
        if (r != null) {
            obj3 = r;
            n.d(obj2, obj4, viewGroup, aVar2, c1024e.f49091d, c1024e.f49090c, c1024e.f49088a, arrayList4, aVar, aVar3, arrayList);
            A(viewGroup, c1024e, i, obj3);
            n.l(obj3, c1024e.f49091d, true);
            z(c1024e, i, obj3);
            n.e(viewGroup, obj3);
            n.i(viewGroup, c1024e.f49091d, obj2, arrayList4, s, arrayList2, obj4, arrayList, obj3, c1024e.f49089b, aVar3);
        } else {
            obj3 = r;
        }
        return obj3 != null;
    }

    public final void w(int i, Fragment fragment, String str, int i2) {
        fragment.w = this.f49067e;
        if (str != null) {
            String str2 = fragment.C;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.C + " now " + str);
            }
            fragment.C = str;
        }
        if (i != 0) {
            int i3 = fragment.A;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.A + " now " + i);
            }
            fragment.A = i;
            fragment.B = i;
        }
        d dVar = new d();
        dVar.f49082c = i2;
        dVar.f49083d = fragment;
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
            if (this.i != 0 || this.j != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.i));
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
        if (this.f49068f != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str3 = str + "    ";
            d dVar = this.f49068f;
            int i = 0;
            while (dVar != null) {
                switch (dVar.f49082c) {
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
                        str2 = "cmd=" + dVar.f49082c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(dVar.f49083d);
                if (z) {
                    if (dVar.f49084e != 0 || dVar.f49085f != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(dVar.f49084e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(dVar.f49085f));
                    }
                    if (dVar.f49086g != 0 || dVar.f49087h != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(dVar.f49086g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(dVar.f49087h));
                    }
                }
                ArrayList<Fragment> arrayList = dVar.i;
                if (arrayList != null && arrayList.size() > 0) {
                    for (int i2 = 0; i2 < dVar.i.size(); i2++) {
                        printWriter.print(str3);
                        if (dVar.i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str3);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(dVar.i.get(i2));
                    }
                }
                dVar = dVar.f49080a;
                i++;
            }
        }
    }

    public final void z(C1024e c1024e, int i, Object obj) {
        if (this.f49067e.f49105e != null) {
            for (int i2 = 0; i2 < this.f49067e.f49105e.size(); i2++) {
                Fragment fragment = this.f49067e.f49105e.get(i2);
                View view = fragment.M;
                if (view != null && fragment.L != null && fragment.B == i) {
                    if (fragment.D) {
                        if (!c1024e.f49089b.contains(view)) {
                            n.l(obj, fragment.M, true);
                            c1024e.f49089b.add(fragment.M);
                        }
                    } else {
                        n.l(obj, view, false);
                        c1024e.f49089b.remove(fragment.M);
                    }
                }
            }
        }
    }
}
