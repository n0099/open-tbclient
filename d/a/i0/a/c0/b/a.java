package d.a.i0.a.c0.b;

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
import d.a.i0.a.c0.b.b;
import d.a.i0.a.e0.d;
import d.a.i0.a.k;
import h.d;
import h.j;
/* loaded from: classes2.dex */
public abstract class a<V extends View, M extends d.a.i0.a.c0.b.b> {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f40658h = k.f43025a;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.c0.e.a f40659a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public V f40660b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public M f40661c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public M f40662d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public SwanAppComponentContainerView f40663e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public j f40664f;

    /* renamed from: g  reason: collision with root package name */
    public int f40665g;

    /* renamed from: d.a.i0.a.c0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0560a extends j<Object> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f40666e;

        public C0560a(String str) {
            this.f40666e = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: d.a.i0.a.c0.b.a */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: d.a.i0.a.c0.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.e
        public void onCompleted() {
            a aVar = a.this;
            aVar.f40660b = aVar.v(aVar.f40659a.b());
            a aVar2 = a.this;
            aVar2.B(aVar2.f40660b);
            a.this.f40663e.setTargetView(a.this.f40660b, 0);
            a aVar3 = a.this;
            aVar3.D(aVar3.f40660b, a.this.f40661c, new d.a.i0.a.c0.f.b(true));
            if (a.f40658h) {
                Log.d("Component-Base", this.f40666e + " insert delayed（view）: success");
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            d.l("Component-Base", this.f40666e + " insert delayed（view）: fail");
            if (a.f40658h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                throw new RuntimeException("save subscriber and return subscriber: nolinear !");
            }
            a.this.C();
        }

        @Override // h.e
        public void onNext(Object obj) {
            d.l("Component-Base", this.f40666e + " success should call onCompleted");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a<Object> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f40668e;

        public b(long j) {
            this.f40668e = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super Object> jVar) {
            if (a.f40658h) {
                Log.d("Component-Base", "insert delayed => save thread: " + Thread.currentThread().getName());
            }
            if (this.f40668e != Thread.currentThread().getId()) {
                d.a.i0.a.c0.g.a.a("Component-Base", "save subscriber and return subscriber: nolinear !");
            }
            a.this.f40664f = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.i0.a.w2.g.b.b {
        public final /* synthetic */ boolean n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, String str, String str2, String str3, boolean z) {
            super(str, str2, str3);
            this.n = z;
        }

        @Override // d.a.i0.a.w2.g.b.b, android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.n && super.onTouch(view, motionEvent);
        }
    }

    public a(@Nullable Context context, @NonNull M m) {
        M j = j(m);
        this.f40661c = j;
        d.a.i0.a.c0.e.a c2 = d.a.i0.a.c0.d.a.c(j);
        this.f40659a = c2;
        if (c2 != null) {
            if (context != null) {
                c2.d(context);
                return;
            }
            return;
        }
        d.a.i0.a.e0.d.b("Component-Base", o() + " context is null !");
    }

    @CallSuper
    public void A() {
        F();
    }

    public void B(@NonNull V v) {
    }

    @NonNull
    @UiThread
    public final d.a.i0.a.c0.b.c C() {
        String o = o();
        if (f40658h) {
            Log.i("Component-Base", "=====================" + o + " start remove=====================");
        }
        d.a.i0.a.c0.e.a aVar = this.f40659a;
        if (aVar == null) {
            d.a.i0.a.c0.g.a.a("Component-Base", o + " remove with a null component context!");
            return new d.a.i0.a.c0.b.c(202, "component context is null");
        } else if (this.f40663e == null) {
            d.a.i0.a.e0.d.b("Component-Base", o + " remove must after insert");
            return new d.a.i0.a.c0.b.c(202, "component remove must after insert");
        } else if (!aVar.a().e(this)) {
            String str = o + " remove fail";
            d.a.i0.a.e0.d.b("Component-Base", str);
            return new d.a.i0.a.c0.b.c(1001, str);
        } else {
            A();
            if (f40658h) {
                Log.d("Component-Base", o + " remove: success");
            }
            return new d.a.i0.a.c0.b.c(0, "success");
        }
    }

    @CallSuper
    public void D(@NonNull V v, @NonNull M m, @NonNull d.a.i0.a.c0.f.b bVar) {
        E(m, bVar);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void E(@NonNull M m, @NonNull d.a.i0.a.c0.f.b bVar) {
        if (this.f40663e == null) {
            d.a.i0.a.c0.g.a.a("Component-Base", "renderContainerView with a null container view");
            return;
        }
        if (bVar.a(1)) {
            this.f40663e.setHidden(m.j);
        }
        if (bVar.a(2)) {
            r(this.f40663e, m);
        }
    }

    public final void F() {
        j jVar = this.f40664f;
        if (jVar == null || jVar.isUnsubscribed()) {
            return;
        }
        this.f40664f.unsubscribe();
    }

    @NonNull
    @UiThread
    public final d.a.i0.a.c0.b.c G(@NonNull M m) {
        String o = o();
        d.a.i0.a.c0.b.c i2 = i(m);
        if (!i2.a()) {
            d.a.i0.a.e0.d.b("Component-Base", o + " update with a invalid model => " + i2.f40676b);
            return i2;
        }
        if (f40658h) {
            Log.i("Component-Base", "=====================" + o + " start update=====================");
        }
        M m2 = this.f40661c;
        if (m2 == m) {
            String str = o + " update with the same model";
            d.a.i0.a.c0.g.a.a("Component-Base", str);
            return new d.a.i0.a.c0.b.c(202, str);
        } else if (!TextUtils.equals(m2.f40671f, m.f40671f)) {
            String str2 = o + " update with different id: " + this.f40661c.f40671f + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f40671f;
            d.a.i0.a.c0.g.a.a("Component-Base", str2);
            return new d.a.i0.a.c0.b.c(202, str2);
        } else if (!TextUtils.equals(this.f40661c.f40672g, m.f40672g)) {
            String str3 = o + " update with different slave id: " + this.f40661c.f40672g + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f40672g;
            d.a.i0.a.c0.g.a.a("Component-Base", str3);
            return new d.a.i0.a.c0.b.c(202, str3);
        } else if (this.f40660b != null && this.f40663e != null) {
            if (this.f40659a == null) {
                d.a.i0.a.c0.g.a.a("Component-Base", o + " update with a null component context!");
                return new d.a.i0.a.c0.b.c(202, "component context is null");
            }
            M m3 = this.f40661c;
            this.f40662d = m3;
            d.a.i0.a.c0.f.b k = k(m3, m);
            M j = j(m);
            this.f40661c = j;
            D(this.f40660b, j, k);
            boolean f2 = this.f40659a.a().f(this, k);
            this.f40662d = null;
            if (!f2) {
                String str4 = o + " update component fail";
                d.a.i0.a.e0.d.b("Component-Base", str4);
                return new d.a.i0.a.c0.b.c(1001, str4);
            }
            if (f40658h) {
                Log.d("Component-Base", o + " component update: success");
            }
            return new d.a.i0.a.c0.b.c(0, "success");
        } else {
            String str5 = o + " update must after insert succeeded";
            d.a.i0.a.c0.g.a.a("Component-Base", str5);
            return new d.a.i0.a.c0.b.c(202, str5);
        }
    }

    @NonNull
    public final a g(int i2) {
        this.f40665g = i2 | this.f40665g;
        return this;
    }

    public final boolean h(@NonNull d.a.i0.a.c0.e.a aVar) {
        boolean b2 = aVar.a().b(this);
        y(b2);
        return b2;
    }

    @NonNull
    public final d.a.i0.a.c0.b.c i(M m) {
        if (m == null) {
            return new d.a.i0.a.c0.b.c(202, "model is null");
        }
        if (TextUtils.isEmpty(m.f40672g)) {
            return new d.a.i0.a.c0.b.c(202, "slave id is empty");
        }
        if (!m.isValid()) {
            return new d.a.i0.a.c0.b.c(202, "model is invalid");
        }
        return new d.a.i0.a.c0.b.c(0, "model is valid");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final M j(@NonNull M m) {
        d.a.i0.a.c0.b.b bVar;
        try {
            bVar = (d.a.i0.a.c0.b.b) m.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            d.a.i0.a.c0.g.a.b("Component-Base", "model must implement cloneable", e2);
            bVar = null;
            if (bVar == null) {
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            d.a.i0.a.c0.g.a.b("Component-Base", "clone model fail ！", e3);
            bVar = null;
            if (bVar == null) {
            }
        }
        if (bVar == null) {
            d.a.i0.a.c0.g.a.a("Component-Base", "clone model fail ！");
            return m;
        }
        return (M) bVar;
    }

    @NonNull
    @CallSuper
    public d.a.i0.a.c0.f.b k(@NonNull M m, @NonNull M m2) {
        d.a.i0.a.c0.f.b bVar = new d.a.i0.a.c0.f.b();
        d.a.i0.a.l1.e.a.a aVar = m2.l;
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
        return j(this.f40661c);
    }

    @Nullable
    public final SwanAppComponentContainerView m() {
        return this.f40663e;
    }

    @NonNull
    public final M n() {
        return this.f40661c;
    }

    @NonNull
    public final String o() {
        d.a.i0.a.c0.b.c i2 = i(this.f40661c);
        if (i2.a()) {
            return this.f40661c.d();
        }
        return "【illegal component#" + i2.f40676b + "】";
    }

    @Nullable
    public final M p() {
        return this.f40662d;
    }

    @Nullable
    public final V q() {
        return this.f40660b;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        swanAppComponentContainerView.setOnTouchListener(new c(this, m.f40672g, m.f40671f, m.f40670e, m.k));
    }

    public final boolean s(int i2) {
        return (this.f40665g & i2) == i2;
    }

    public final boolean t() {
        return this.f40662d != null;
    }

    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        return new SwanAppComponentContainerView(context);
    }

    @NonNull
    public abstract V v(@NonNull Context context);

    @NonNull
    @UiThread
    public final d.a.i0.a.c0.b.c w() {
        String o = o();
        d.a.i0.a.c0.b.c i2 = i(this.f40661c);
        if (!i2.a()) {
            d.a.i0.a.e0.d.b("Component-Base", o + " insert with a invalid model => " + i2.f40676b);
            return i2;
        }
        if (f40658h) {
            Log.i("Component-Base", "=====================" + o + " start insert=====================");
        }
        d.a.i0.a.c0.e.a aVar = this.f40659a;
        if (aVar == null) {
            d.a.i0.a.e0.d.b("Component-Base", o + " insert with a null component context!");
            return new d.a.i0.a.c0.b.c(202, "component context is null");
        }
        Context b2 = aVar.b();
        if (this.f40663e != null || this.f40660b != null) {
            d.a.i0.a.e0.d.l("Component-Base", o + " repeat insert");
        }
        V v = v(this.f40659a.b());
        this.f40660b = v;
        B(v);
        SwanAppComponentContainerView u = u(b2);
        this.f40663e = u;
        u.setTargetView(this.f40660b);
        D(this.f40660b, this.f40661c, new d.a.i0.a.c0.f.b(true));
        if (h(this.f40659a)) {
            if (f40658h) {
                Log.d("Component-Base", o + " insert: success");
            }
            return new d.a.i0.a.c0.b.c(0, "success");
        }
        d.a.i0.a.e0.d.b("Component-Base", o + " insert: attach fail");
        return new d.a.i0.a.c0.b.c(1001, "attach fail");
    }

    @Nullable
    @UiThread
    public final j x() {
        String o = o();
        d.a.i0.a.c0.b.c i2 = i(this.f40661c);
        if (!i2.a()) {
            d.a.i0.a.e0.d.b("Component-Base", o + " insert delayed with a invalid model => " + i2.f40676b);
            return null;
        }
        if (f40658h) {
            Log.i("Component-Base", "=====================" + o + " start insertDelayed=====================");
        }
        if (this.f40659a == null) {
            d.a.i0.a.c0.g.a.a("Component-Base", o + " insert delayed with a null component context!");
            return null;
        }
        if (this.f40663e != null) {
            d.a.i0.a.e0.d.l("Component-Base", o + " repeat insert delayed: container view repeat");
        }
        j jVar = this.f40664f;
        if (jVar != null && !jVar.isUnsubscribed()) {
            this.f40664f.unsubscribe();
            this.f40664f = null;
            d.a.i0.a.e0.d.l("Component-Base", o + " insert delayed repeat: subscriber repeat");
        }
        this.f40663e = u(this.f40659a.b());
        E(this.f40661c, new d.a.i0.a.c0.f.b(true));
        if (h(this.f40659a)) {
            if (f40658h) {
                Log.d("Component-Base", o + " insert delayed（container view）: success");
            }
            h.d.b(new b(Thread.currentThread().getId())).z(new C0560a(o));
            return this.f40664f;
        }
        d.a.i0.a.e0.d.b("Component-Base", o + " insert delayed: attach fail");
        return null;
    }

    public void y(boolean z) {
    }

    @CallSuper
    public void z() {
        if (f40658h) {
            Log.d("Component-Base", o() + " onDestroy");
        }
        F();
    }
}
