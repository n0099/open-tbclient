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
    public static final boolean f40832h = k.f43199a;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.c0.e.a f40833a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public V f40834b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public M f40835c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public M f40836d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public SwanAppComponentContainerView f40837e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public j f40838f;

    /* renamed from: g  reason: collision with root package name */
    public int f40839g;

    /* renamed from: d.a.l0.a.c0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0571a extends j<Object> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f40840e;

        public C0571a(String str) {
            this.f40840e = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: d.a.l0.a.c0.b.a */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: d.a.l0.a.c0.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.e
        public void onCompleted() {
            a aVar = a.this;
            aVar.f40834b = aVar.v(aVar.f40833a.b());
            a aVar2 = a.this;
            aVar2.B(aVar2.f40834b);
            a.this.f40837e.setTargetView(a.this.f40834b, 0);
            a aVar3 = a.this;
            aVar3.D(aVar3.f40834b, a.this.f40835c, new d.a.l0.a.c0.f.b(true));
            if (a.f40832h) {
                Log.d("Component-Base", this.f40840e + " insert delayed（view）: success");
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            d.l("Component-Base", this.f40840e + " insert delayed（view）: fail");
            if (a.f40832h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                throw new RuntimeException("save subscriber and return subscriber: nolinear !");
            }
            a.this.C();
        }

        @Override // h.e
        public void onNext(Object obj) {
            d.l("Component-Base", this.f40840e + " success should call onCompleted");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a<Object> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f40842e;

        public b(long j) {
            this.f40842e = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super Object> jVar) {
            if (a.f40832h) {
                Log.d("Component-Base", "insert delayed => save thread: " + Thread.currentThread().getName());
            }
            if (this.f40842e != Thread.currentThread().getId()) {
                d.a.l0.a.c0.g.a.a("Component-Base", "save subscriber and return subscriber: nolinear !");
            }
            a.this.f40838f = jVar;
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
        this.f40835c = j;
        d.a.l0.a.c0.e.a c2 = d.a.l0.a.c0.d.a.c(j);
        this.f40833a = c2;
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
        if (f40832h) {
            Log.i("Component-Base", "=====================" + o + " start remove=====================");
        }
        d.a.l0.a.c0.e.a aVar = this.f40833a;
        if (aVar == null) {
            d.a.l0.a.c0.g.a.a("Component-Base", o + " remove with a null component context!");
            return new d.a.l0.a.c0.b.c(202, "component context is null");
        } else if (this.f40837e == null) {
            d.a.l0.a.e0.d.b("Component-Base", o + " remove must after insert");
            return new d.a.l0.a.c0.b.c(202, "component remove must after insert");
        } else if (!aVar.a().e(this)) {
            String str = o + " remove fail";
            d.a.l0.a.e0.d.b("Component-Base", str);
            return new d.a.l0.a.c0.b.c(1001, str);
        } else {
            A();
            if (f40832h) {
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
        if (this.f40837e == null) {
            d.a.l0.a.c0.g.a.a("Component-Base", "renderContainerView with a null container view");
            return;
        }
        if (bVar.a(1)) {
            this.f40837e.setHidden(m.j);
        }
        if (bVar.a(2)) {
            r(this.f40837e, m);
        }
    }

    public final void F() {
        j jVar = this.f40838f;
        if (jVar == null || jVar.isUnsubscribed()) {
            return;
        }
        this.f40838f.unsubscribe();
    }

    @NonNull
    @UiThread
    public final d.a.l0.a.c0.b.c G(@NonNull M m) {
        String o = o();
        d.a.l0.a.c0.b.c i2 = i(m);
        if (!i2.a()) {
            d.a.l0.a.e0.d.b("Component-Base", o + " update with a invalid model => " + i2.f40850b);
            return i2;
        }
        if (f40832h) {
            Log.i("Component-Base", "=====================" + o + " start update=====================");
        }
        M m2 = this.f40835c;
        if (m2 == m) {
            String str = o + " update with the same model";
            d.a.l0.a.c0.g.a.a("Component-Base", str);
            return new d.a.l0.a.c0.b.c(202, str);
        } else if (!TextUtils.equals(m2.f40845f, m.f40845f)) {
            String str2 = o + " update with different id: " + this.f40835c.f40845f + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f40845f;
            d.a.l0.a.c0.g.a.a("Component-Base", str2);
            return new d.a.l0.a.c0.b.c(202, str2);
        } else if (!TextUtils.equals(this.f40835c.f40846g, m.f40846g)) {
            String str3 = o + " update with different slave id: " + this.f40835c.f40846g + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f40846g;
            d.a.l0.a.c0.g.a.a("Component-Base", str3);
            return new d.a.l0.a.c0.b.c(202, str3);
        } else if (this.f40834b != null && this.f40837e != null) {
            if (this.f40833a == null) {
                d.a.l0.a.c0.g.a.a("Component-Base", o + " update with a null component context!");
                return new d.a.l0.a.c0.b.c(202, "component context is null");
            }
            M m3 = this.f40835c;
            this.f40836d = m3;
            d.a.l0.a.c0.f.b k = k(m3, m);
            M j = j(m);
            this.f40835c = j;
            D(this.f40834b, j, k);
            boolean f2 = this.f40833a.a().f(this, k);
            this.f40836d = null;
            if (!f2) {
                String str4 = o + " update component fail";
                d.a.l0.a.e0.d.b("Component-Base", str4);
                return new d.a.l0.a.c0.b.c(1001, str4);
            }
            if (f40832h) {
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
        this.f40839g = i2 | this.f40839g;
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
        if (TextUtils.isEmpty(m.f40846g)) {
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
        return j(this.f40835c);
    }

    @Nullable
    public final SwanAppComponentContainerView m() {
        return this.f40837e;
    }

    @NonNull
    public final M n() {
        return this.f40835c;
    }

    @NonNull
    public final String o() {
        d.a.l0.a.c0.b.c i2 = i(this.f40835c);
        if (i2.a()) {
            return this.f40835c.d();
        }
        return "【illegal component#" + i2.f40850b + "】";
    }

    @Nullable
    public final M p() {
        return this.f40836d;
    }

    @Nullable
    public final V q() {
        return this.f40834b;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        swanAppComponentContainerView.setOnTouchListener(new c(this, m.f40846g, m.f40845f, m.f40844e, m.k));
    }

    public final boolean s(int i2) {
        return (this.f40839g & i2) == i2;
    }

    public final boolean t() {
        return this.f40836d != null;
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
        d.a.l0.a.c0.b.c i2 = i(this.f40835c);
        if (!i2.a()) {
            d.a.l0.a.e0.d.b("Component-Base", o + " insert with a invalid model => " + i2.f40850b);
            return i2;
        }
        if (f40832h) {
            Log.i("Component-Base", "=====================" + o + " start insert=====================");
        }
        d.a.l0.a.c0.e.a aVar = this.f40833a;
        if (aVar == null) {
            d.a.l0.a.e0.d.b("Component-Base", o + " insert with a null component context!");
            return new d.a.l0.a.c0.b.c(202, "component context is null");
        }
        Context b2 = aVar.b();
        if (this.f40837e != null || this.f40834b != null) {
            d.a.l0.a.e0.d.l("Component-Base", o + " repeat insert");
        }
        V v = v(this.f40833a.b());
        this.f40834b = v;
        B(v);
        SwanAppComponentContainerView u = u(b2);
        this.f40837e = u;
        u.setTargetView(this.f40834b);
        D(this.f40834b, this.f40835c, new d.a.l0.a.c0.f.b(true));
        if (h(this.f40833a)) {
            if (f40832h) {
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
        d.a.l0.a.c0.b.c i2 = i(this.f40835c);
        if (!i2.a()) {
            d.a.l0.a.e0.d.b("Component-Base", o + " insert delayed with a invalid model => " + i2.f40850b);
            return null;
        }
        if (f40832h) {
            Log.i("Component-Base", "=====================" + o + " start insertDelayed=====================");
        }
        if (this.f40833a == null) {
            d.a.l0.a.c0.g.a.a("Component-Base", o + " insert delayed with a null component context!");
            return null;
        }
        if (this.f40837e != null) {
            d.a.l0.a.e0.d.l("Component-Base", o + " repeat insert delayed: container view repeat");
        }
        j jVar = this.f40838f;
        if (jVar != null && !jVar.isUnsubscribed()) {
            this.f40838f.unsubscribe();
            this.f40838f = null;
            d.a.l0.a.e0.d.l("Component-Base", o + " insert delayed repeat: subscriber repeat");
        }
        this.f40837e = u(this.f40833a.b());
        E(this.f40835c, new d.a.l0.a.c0.f.b(true));
        if (h(this.f40833a)) {
            if (f40832h) {
                Log.d("Component-Base", o + " insert delayed（container view）: success");
            }
            h.d.b(new b(Thread.currentThread().getId())).z(new C0571a(o));
            return this.f40838f;
        }
        d.a.l0.a.e0.d.b("Component-Base", o + " insert delayed: attach fail");
        return null;
    }

    public void y(boolean z) {
    }

    @CallSuper
    public void z() {
        if (f40832h) {
            Log.d("Component-Base", o() + " onDestroy");
        }
        F();
    }
}
