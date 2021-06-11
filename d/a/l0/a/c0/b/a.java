package d.a.l0.a.c0.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import d.a.l0.a.c0.b.b;
import d.a.l0.a.e0.d;
import d.a.l0.a.k;
import h.d;
import h.j;
/* loaded from: classes2.dex */
public abstract class a<V extends View, M extends d.a.l0.a.c0.b.b> {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f44508h = k.f46875a;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.c0.e.a f44509a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public V f44510b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public M f44511c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public M f44512d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public SwanAppComponentContainerView f44513e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public j f44514f;

    /* renamed from: g  reason: collision with root package name */
    public int f44515g;

    /* renamed from: d.a.l0.a.c0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0627a extends j<Object> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44516e;

        public C0627a(String str) {
            this.f44516e = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: d.a.l0.a.c0.b.a */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: d.a.l0.a.c0.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.e
        public void onCompleted() {
            a aVar = a.this;
            aVar.f44510b = aVar.v(aVar.f44509a.b());
            a aVar2 = a.this;
            aVar2.B(aVar2.f44510b);
            a.this.f44513e.setTargetView(a.this.f44510b, 0);
            a aVar3 = a.this;
            aVar3.D(aVar3.f44510b, a.this.f44511c, new d.a.l0.a.c0.f.b(true));
            if (a.f44508h) {
                Log.d("Component-Base", this.f44516e + " insert delayed（view）: success");
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            d.l("Component-Base", this.f44516e + " insert delayed（view）: fail");
            if (a.f44508h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                throw new RuntimeException("save subscriber and return subscriber: nolinear !");
            }
            a.this.C();
        }

        @Override // h.e
        public void onNext(Object obj) {
            d.l("Component-Base", this.f44516e + " success should call onCompleted");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a<Object> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f44518e;

        public b(long j) {
            this.f44518e = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super Object> jVar) {
            if (a.f44508h) {
                Log.d("Component-Base", "insert delayed => save thread: " + Thread.currentThread().getName());
            }
            if (this.f44518e != Thread.currentThread().getId()) {
                d.a.l0.a.c0.g.a.a("Component-Base", "save subscriber and return subscriber: nolinear !");
            }
            a.this.f44514f = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.l0.a.w2.g.b.b {
        public final /* synthetic */ boolean n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, String str, String str2, String str3, boolean z) {
            super(str, str2, str3);
            this.n = z;
        }

        @Override // d.a.l0.a.w2.g.b.b, android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.n && super.onTouch(view, motionEvent);
        }
    }

    public a(@Nullable Context context, @NonNull M m) {
        M j = j(m);
        this.f44511c = j;
        d.a.l0.a.c0.e.a c2 = d.a.l0.a.c0.d.a.c(j);
        this.f44509a = c2;
        if (c2 != null) {
            if (context != null) {
                c2.d(context);
                return;
            }
            return;
        }
        d.a.l0.a.e0.d.b("Component-Base", o() + " context is null !");
    }

    @CallSuper
    public void A() {
        F();
    }

    public void B(@NonNull V v) {
    }

    @NonNull
    @UiThread
    public final d.a.l0.a.c0.b.c C() {
        String o = o();
        if (f44508h) {
            Log.i("Component-Base", "=====================" + o + " start remove=====================");
        }
        d.a.l0.a.c0.e.a aVar = this.f44509a;
        if (aVar == null) {
            d.a.l0.a.c0.g.a.a("Component-Base", o + " remove with a null component context!");
            return new d.a.l0.a.c0.b.c(202, "component context is null");
        } else if (this.f44513e == null) {
            d.a.l0.a.e0.d.b("Component-Base", o + " remove must after insert");
            return new d.a.l0.a.c0.b.c(202, "component remove must after insert");
        } else if (!aVar.a().e(this)) {
            String str = o + " remove fail";
            d.a.l0.a.e0.d.b("Component-Base", str);
            return new d.a.l0.a.c0.b.c(1001, str);
        } else {
            A();
            if (f44508h) {
                Log.d("Component-Base", o + " remove: success");
            }
            return new d.a.l0.a.c0.b.c(0, "success");
        }
    }

    @CallSuper
    public void D(@NonNull V v, @NonNull M m, @NonNull d.a.l0.a.c0.f.b bVar) {
        E(m, bVar);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void E(@NonNull M m, @NonNull d.a.l0.a.c0.f.b bVar) {
        if (this.f44513e == null) {
            d.a.l0.a.c0.g.a.a("Component-Base", "renderContainerView with a null container view");
            return;
        }
        if (bVar.a(1)) {
            this.f44513e.setHidden(m.j);
        }
        if (bVar.a(2)) {
            r(this.f44513e, m);
        }
    }

    public final void F() {
        j jVar = this.f44514f;
        if (jVar == null || jVar.isUnsubscribed()) {
            return;
        }
        this.f44514f.unsubscribe();
    }

    @NonNull
    @UiThread
    public final d.a.l0.a.c0.b.c G(@NonNull M m) {
        String o = o();
        d.a.l0.a.c0.b.c i2 = i(m);
        if (!i2.a()) {
            d.a.l0.a.e0.d.b("Component-Base", o + " update with a invalid model => " + i2.f44526b);
            return i2;
        }
        if (f44508h) {
            Log.i("Component-Base", "=====================" + o + " start update=====================");
        }
        M m2 = this.f44511c;
        if (m2 == m) {
            String str = o + " update with the same model";
            d.a.l0.a.c0.g.a.a("Component-Base", str);
            return new d.a.l0.a.c0.b.c(202, str);
        } else if (!TextUtils.equals(m2.f44521f, m.f44521f)) {
            String str2 = o + " update with different id: " + this.f44511c.f44521f + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f44521f;
            d.a.l0.a.c0.g.a.a("Component-Base", str2);
            return new d.a.l0.a.c0.b.c(202, str2);
        } else if (!TextUtils.equals(this.f44511c.f44522g, m.f44522g)) {
            String str3 = o + " update with different slave id: " + this.f44511c.f44522g + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f44522g;
            d.a.l0.a.c0.g.a.a("Component-Base", str3);
            return new d.a.l0.a.c0.b.c(202, str3);
        } else if (this.f44510b != null && this.f44513e != null) {
            if (this.f44509a == null) {
                d.a.l0.a.c0.g.a.a("Component-Base", o + " update with a null component context!");
                return new d.a.l0.a.c0.b.c(202, "component context is null");
            }
            M m3 = this.f44511c;
            this.f44512d = m3;
            d.a.l0.a.c0.f.b k = k(m3, m);
            M j = j(m);
            this.f44511c = j;
            D(this.f44510b, j, k);
            boolean f2 = this.f44509a.a().f(this, k);
            this.f44512d = null;
            if (!f2) {
                String str4 = o + " update component fail";
                d.a.l0.a.e0.d.b("Component-Base", str4);
                return new d.a.l0.a.c0.b.c(1001, str4);
            }
            if (f44508h) {
                Log.d("Component-Base", o + " component update: success");
            }
            return new d.a.l0.a.c0.b.c(0, "success");
        } else {
            String str5 = o + " update must after insert succeeded";
            d.a.l0.a.c0.g.a.a("Component-Base", str5);
            return new d.a.l0.a.c0.b.c(202, str5);
        }
    }

    @NonNull
    public final a g(int i2) {
        this.f44515g = i2 | this.f44515g;
        return this;
    }

    public final boolean h(@NonNull d.a.l0.a.c0.e.a aVar) {
        boolean b2 = aVar.a().b(this);
        y(b2);
        return b2;
    }

    @NonNull
    public final d.a.l0.a.c0.b.c i(M m) {
        if (m == null) {
            return new d.a.l0.a.c0.b.c(202, "model is null");
        }
        if (TextUtils.isEmpty(m.f44522g)) {
            return new d.a.l0.a.c0.b.c(202, "slave id is empty");
        }
        if (!m.isValid()) {
            return new d.a.l0.a.c0.b.c(202, "model is invalid");
        }
        return new d.a.l0.a.c0.b.c(0, "model is valid");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final M j(@NonNull M m) {
        d.a.l0.a.c0.b.b bVar;
        try {
            bVar = (d.a.l0.a.c0.b.b) m.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            d.a.l0.a.c0.g.a.b("Component-Base", "model must implement cloneable", e2);
            bVar = null;
            if (bVar == null) {
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            d.a.l0.a.c0.g.a.b("Component-Base", "clone model fail ！", e3);
            bVar = null;
            if (bVar == null) {
            }
        }
        if (bVar == null) {
            d.a.l0.a.c0.g.a.a("Component-Base", "clone model fail ！");
            return m;
        }
        return (M) bVar;
    }

    @NonNull
    @CallSuper
    public d.a.l0.a.c0.f.b k(@NonNull M m, @NonNull M m2) {
        d.a.l0.a.c0.f.b bVar = new d.a.l0.a.c0.f.b();
        d.a.l0.a.l1.e.a.a aVar = m2.l;
        if (aVar != null && aVar.c(m.l)) {
            bVar.b(3);
        }
        if (m.j != m2.j) {
            bVar.b(1);
        }
        if (m.k != m2.k) {
            bVar.b(2);
        }
        return bVar;
    }

    @NonNull
    public final M l() {
        return j(this.f44511c);
    }

    @Nullable
    public final SwanAppComponentContainerView m() {
        return this.f44513e;
    }

    @NonNull
    public final M n() {
        return this.f44511c;
    }

    @NonNull
    public final String o() {
        d.a.l0.a.c0.b.c i2 = i(this.f44511c);
        if (i2.a()) {
            return this.f44511c.d();
        }
        return "【illegal component#" + i2.f44526b + "】";
    }

    @Nullable
    public final M p() {
        return this.f44512d;
    }

    @Nullable
    public final V q() {
        return this.f44510b;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        swanAppComponentContainerView.setOnTouchListener(new c(this, m.f44522g, m.f44521f, m.f44520e, m.k));
    }

    public final boolean s(int i2) {
        return (this.f44515g & i2) == i2;
    }

    public final boolean t() {
        return this.f44512d != null;
    }

    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        return new SwanAppComponentContainerView(context);
    }

    @NonNull
    public abstract V v(@NonNull Context context);

    @NonNull
    @UiThread
    public final d.a.l0.a.c0.b.c w() {
        String o = o();
        d.a.l0.a.c0.b.c i2 = i(this.f44511c);
        if (!i2.a()) {
            d.a.l0.a.e0.d.b("Component-Base", o + " insert with a invalid model => " + i2.f44526b);
            return i2;
        }
        if (f44508h) {
            Log.i("Component-Base", "=====================" + o + " start insert=====================");
        }
        d.a.l0.a.c0.e.a aVar = this.f44509a;
        if (aVar == null) {
            d.a.l0.a.e0.d.b("Component-Base", o + " insert with a null component context!");
            return new d.a.l0.a.c0.b.c(202, "component context is null");
        }
        Context b2 = aVar.b();
        if (this.f44513e != null || this.f44510b != null) {
            d.a.l0.a.e0.d.l("Component-Base", o + " repeat insert");
        }
        V v = v(this.f44509a.b());
        this.f44510b = v;
        B(v);
        SwanAppComponentContainerView u = u(b2);
        this.f44513e = u;
        u.setTargetView(this.f44510b);
        D(this.f44510b, this.f44511c, new d.a.l0.a.c0.f.b(true));
        if (h(this.f44509a)) {
            if (f44508h) {
                Log.d("Component-Base", o + " insert: success");
            }
            return new d.a.l0.a.c0.b.c(0, "success");
        }
        d.a.l0.a.e0.d.b("Component-Base", o + " insert: attach fail");
        return new d.a.l0.a.c0.b.c(1001, "attach fail");
    }

    @Nullable
    @UiThread
    public final j x() {
        String o = o();
        d.a.l0.a.c0.b.c i2 = i(this.f44511c);
        if (!i2.a()) {
            d.a.l0.a.e0.d.b("Component-Base", o + " insert delayed with a invalid model => " + i2.f44526b);
            return null;
        }
        if (f44508h) {
            Log.i("Component-Base", "=====================" + o + " start insertDelayed=====================");
        }
        if (this.f44509a == null) {
            d.a.l0.a.c0.g.a.a("Component-Base", o + " insert delayed with a null component context!");
            return null;
        }
        if (this.f44513e != null) {
            d.a.l0.a.e0.d.l("Component-Base", o + " repeat insert delayed: container view repeat");
        }
        j jVar = this.f44514f;
        if (jVar != null && !jVar.isUnsubscribed()) {
            this.f44514f.unsubscribe();
            this.f44514f = null;
            d.a.l0.a.e0.d.l("Component-Base", o + " insert delayed repeat: subscriber repeat");
        }
        this.f44513e = u(this.f44509a.b());
        E(this.f44511c, new d.a.l0.a.c0.f.b(true));
        if (h(this.f44509a)) {
            if (f44508h) {
                Log.d("Component-Base", o + " insert delayed（container view）: success");
            }
            h.d.b(new b(Thread.currentThread().getId())).z(new C0627a(o));
            return this.f44514f;
        }
        d.a.l0.a.e0.d.b("Component-Base", o + " insert delayed: attach fail");
        return null;
    }

    public void y(boolean z) {
    }

    @CallSuper
    public void z() {
        if (f44508h) {
            Log.d("Component-Base", o() + " onDestroy");
        }
        F();
    }
}
