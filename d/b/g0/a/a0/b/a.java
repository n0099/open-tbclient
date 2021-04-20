package d.b.g0.a.a0.b;

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
import d.b.g0.a.a0.b.b;
import d.b.g0.a.k;
import h.d;
import h.j;
/* loaded from: classes2.dex */
public abstract class a<V extends View, M extends d.b.g0.a.a0.b.b> {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f43492h = k.f45443a;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.a0.e.a f43493a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public V f43494b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public M f43495c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public M f43496d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public SwanAppComponentContainerView f43497e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public j f43498f;

    /* renamed from: g  reason: collision with root package name */
    public int f43499g;

    /* renamed from: d.b.g0.a.a0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0602a extends j<Object> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43500e;

        public C0602a(String str) {
            this.f43500e = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: d.b.g0.a.a0.b.a */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: d.b.g0.a.a0.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.e
        public void onCompleted() {
            a aVar = a.this;
            aVar.f43494b = aVar.v(aVar.f43493a.b());
            a aVar2 = a.this;
            aVar2.B(aVar2.f43494b);
            a.this.f43497e.setTargetView(a.this.f43494b, 0);
            a aVar3 = a.this;
            aVar3.D(aVar3.f43494b, a.this.f43495c, new d.b.g0.a.a0.f.b(true));
            if (a.f43492h) {
                Log.d("Component-Base", this.f43500e + " insert delayed（view）: success");
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            d.b.g0.a.c0.c.l("Component-Base", this.f43500e + " insert delayed（view）: fail");
            if (a.f43492h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                throw new RuntimeException("save subscriber and return subscriber: nolinear !");
            }
            a.this.C();
        }

        @Override // h.e
        public void onNext(Object obj) {
            d.b.g0.a.c0.c.l("Component-Base", this.f43500e + " success should call onCompleted");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a<Object> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f43502e;

        public b(long j) {
            this.f43502e = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super Object> jVar) {
            if (a.f43492h) {
                Log.d("Component-Base", "insert delayed => save thread: " + Thread.currentThread().getName());
            }
            if (this.f43502e != Thread.currentThread().getId()) {
                d.b.g0.a.a0.g.a.a("Component-Base", "save subscriber and return subscriber: nolinear !");
            }
            a.this.f43498f = jVar;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.b.g0.a.j2.f.b.b {
        public final /* synthetic */ boolean n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, String str, String str2, String str3, boolean z) {
            super(str, str2, str3);
            this.n = z;
        }

        @Override // d.b.g0.a.j2.f.b.b, android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.n && super.onTouch(view, motionEvent);
        }
    }

    public a(@Nullable Context context, @NonNull M m) {
        M j = j(m);
        this.f43495c = j;
        d.b.g0.a.a0.e.a c2 = d.b.g0.a.a0.d.a.c(j);
        this.f43493a = c2;
        if (c2 != null) {
            if (context != null) {
                c2.d(context);
                return;
            }
            return;
        }
        d.b.g0.a.c0.c.b("Component-Base", o() + " context is null !");
    }

    @CallSuper
    public void A() {
        F();
    }

    public void B(@NonNull V v) {
    }

    @NonNull
    @UiThread
    public final d.b.g0.a.a0.b.c C() {
        String o = o();
        if (f43492h) {
            Log.i("Component-Base", "=====================" + o + " start remove=====================");
        }
        d.b.g0.a.a0.e.a aVar = this.f43493a;
        if (aVar == null) {
            d.b.g0.a.a0.g.a.a("Component-Base", o + " remove with a null component context!");
            return new d.b.g0.a.a0.b.c(202, "component context is null");
        } else if (this.f43497e == null) {
            d.b.g0.a.c0.c.b("Component-Base", o + " remove must after insert");
            return new d.b.g0.a.a0.b.c(202, "component remove must after insert");
        } else if (!aVar.a().e(this)) {
            String str = o + " remove fail";
            d.b.g0.a.c0.c.b("Component-Base", str);
            return new d.b.g0.a.a0.b.c(1001, str);
        } else {
            A();
            if (f43492h) {
                Log.d("Component-Base", o + " remove: success");
            }
            return new d.b.g0.a.a0.b.c(0, "success");
        }
    }

    @CallSuper
    public void D(@NonNull V v, @NonNull M m, @NonNull d.b.g0.a.a0.f.b bVar) {
        E(m, bVar);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void E(@NonNull M m, @NonNull d.b.g0.a.a0.f.b bVar) {
        if (this.f43497e == null) {
            d.b.g0.a.a0.g.a.a("Component-Base", "renderContainerView with a null container view");
            return;
        }
        if (bVar.a(1)) {
            this.f43497e.setHidden(m.j);
        }
        if (bVar.a(2)) {
            r(this.f43497e, m);
        }
    }

    public final void F() {
        j jVar = this.f43498f;
        if (jVar == null || jVar.isUnsubscribed()) {
            return;
        }
        this.f43498f.unsubscribe();
    }

    @NonNull
    @UiThread
    public final d.b.g0.a.a0.b.c G(@NonNull M m) {
        String o = o();
        d.b.g0.a.a0.b.c i = i(m);
        if (!i.a()) {
            d.b.g0.a.c0.c.b("Component-Base", o + " update with a invalid model => " + i.f43509b);
            return i;
        }
        if (f43492h) {
            Log.i("Component-Base", "=====================" + o + " start update=====================");
        }
        M m2 = this.f43495c;
        if (m2 == m) {
            String str = o + " update with the same model";
            d.b.g0.a.a0.g.a.a("Component-Base", str);
            return new d.b.g0.a.a0.b.c(202, str);
        } else if (!TextUtils.equals(m2.f43505f, m.f43505f)) {
            String str2 = o + " update with different id: " + this.f43495c.f43505f + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f43505f;
            d.b.g0.a.a0.g.a.a("Component-Base", str2);
            return new d.b.g0.a.a0.b.c(202, str2);
        } else if (!TextUtils.equals(this.f43495c.f43506g, m.f43506g)) {
            String str3 = o + " update with different slave id: " + this.f43495c.f43506g + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f43506g;
            d.b.g0.a.a0.g.a.a("Component-Base", str3);
            return new d.b.g0.a.a0.b.c(202, str3);
        } else if (this.f43494b != null && this.f43497e != null) {
            if (this.f43493a == null) {
                d.b.g0.a.a0.g.a.a("Component-Base", o + " update with a null component context!");
                return new d.b.g0.a.a0.b.c(202, "component context is null");
            }
            M m3 = this.f43495c;
            this.f43496d = m3;
            d.b.g0.a.a0.f.b k = k(m3, m);
            M j = j(m);
            this.f43495c = j;
            D(this.f43494b, j, k);
            boolean f2 = this.f43493a.a().f(this, k);
            this.f43496d = null;
            if (!f2) {
                String str4 = o + " update component fail";
                d.b.g0.a.c0.c.b("Component-Base", str4);
                return new d.b.g0.a.a0.b.c(1001, str4);
            }
            if (f43492h) {
                Log.d("Component-Base", o + " component update: success");
            }
            return new d.b.g0.a.a0.b.c(0, "success");
        } else {
            String str5 = o + " update must after insert succeeded";
            d.b.g0.a.a0.g.a.a("Component-Base", str5);
            return new d.b.g0.a.a0.b.c(202, str5);
        }
    }

    @NonNull
    public final a g(int i) {
        this.f43499g = i | this.f43499g;
        return this;
    }

    public final boolean h(@NonNull d.b.g0.a.a0.e.a aVar) {
        boolean b2 = aVar.a().b(this);
        y(b2);
        return b2;
    }

    @NonNull
    public final d.b.g0.a.a0.b.c i(M m) {
        if (m == null) {
            return new d.b.g0.a.a0.b.c(202, "model is null");
        }
        if (TextUtils.isEmpty(m.f43506g)) {
            return new d.b.g0.a.a0.b.c(202, "slave id is empty");
        }
        if (!m.isValid()) {
            return new d.b.g0.a.a0.b.c(202, "model is invalid");
        }
        return new d.b.g0.a.a0.b.c(0, "model is valid");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final M j(@NonNull M m) {
        d.b.g0.a.a0.b.b bVar;
        try {
            bVar = (d.b.g0.a.a0.b.b) m.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            d.b.g0.a.a0.g.a.b("Component-Base", "model must implement cloneable", e2);
            bVar = null;
            if (bVar == null) {
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            d.b.g0.a.a0.g.a.b("Component-Base", "clone model fail ！", e3);
            bVar = null;
            if (bVar == null) {
            }
        }
        if (bVar == null) {
            d.b.g0.a.a0.g.a.a("Component-Base", "clone model fail ！");
            return m;
        }
        return (M) bVar;
    }

    @NonNull
    @CallSuper
    public d.b.g0.a.a0.f.b k(@NonNull M m, @NonNull M m2) {
        d.b.g0.a.a0.f.b bVar = new d.b.g0.a.a0.f.b();
        d.b.g0.a.e1.d.a.a aVar = m2.l;
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
        return j(this.f43495c);
    }

    @Nullable
    public final SwanAppComponentContainerView m() {
        return this.f43497e;
    }

    @NonNull
    public final M n() {
        return this.f43495c;
    }

    @NonNull
    public final String o() {
        d.b.g0.a.a0.b.c i = i(this.f43495c);
        if (i.a()) {
            return this.f43495c.d();
        }
        return "【illegal component#" + i.f43509b + "】";
    }

    @Nullable
    public final M p() {
        return this.f43496d;
    }

    @Nullable
    public final V q() {
        return this.f43494b;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        swanAppComponentContainerView.setOnTouchListener(new c(this, m.f43506g, m.f43505f, m.f43504e, m.k));
    }

    public final boolean s(int i) {
        return (this.f43499g & i) == i;
    }

    public final boolean t() {
        return this.f43496d != null;
    }

    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        return new SwanAppComponentContainerView(context);
    }

    @NonNull
    public abstract V v(@NonNull Context context);

    @NonNull
    @UiThread
    public final d.b.g0.a.a0.b.c w() {
        String o = o();
        d.b.g0.a.a0.b.c i = i(this.f43495c);
        if (!i.a()) {
            d.b.g0.a.c0.c.b("Component-Base", o + " insert with a invalid model => " + i.f43509b);
            return i;
        }
        if (f43492h) {
            Log.i("Component-Base", "=====================" + o + " start insert=====================");
        }
        d.b.g0.a.a0.e.a aVar = this.f43493a;
        if (aVar == null) {
            d.b.g0.a.c0.c.b("Component-Base", o + " insert with a null component context!");
            return new d.b.g0.a.a0.b.c(202, "component context is null");
        }
        Context b2 = aVar.b();
        if (this.f43497e != null || this.f43494b != null) {
            d.b.g0.a.c0.c.l("Component-Base", o + " repeat insert");
        }
        V v = v(this.f43493a.b());
        this.f43494b = v;
        B(v);
        SwanAppComponentContainerView u = u(b2);
        this.f43497e = u;
        u.setTargetView(this.f43494b);
        D(this.f43494b, this.f43495c, new d.b.g0.a.a0.f.b(true));
        if (h(this.f43493a)) {
            if (f43492h) {
                Log.d("Component-Base", o + " insert: success");
            }
            return new d.b.g0.a.a0.b.c(0, "success");
        }
        d.b.g0.a.c0.c.b("Component-Base", o + " insert: attach fail");
        return new d.b.g0.a.a0.b.c(1001, "attach fail");
    }

    @Nullable
    @UiThread
    public final j x() {
        String o = o();
        d.b.g0.a.a0.b.c i = i(this.f43495c);
        if (!i.a()) {
            d.b.g0.a.c0.c.b("Component-Base", o + " insert delayed with a invalid model => " + i.f43509b);
            return null;
        }
        if (f43492h) {
            Log.i("Component-Base", "=====================" + o + " start insertDelayed=====================");
        }
        if (this.f43493a == null) {
            d.b.g0.a.a0.g.a.a("Component-Base", o + " insert delayed with a null component context!");
            return null;
        }
        if (this.f43497e != null) {
            d.b.g0.a.c0.c.l("Component-Base", o + " repeat insert delayed: container view repeat");
        }
        j jVar = this.f43498f;
        if (jVar != null && !jVar.isUnsubscribed()) {
            this.f43498f.unsubscribe();
            this.f43498f = null;
            d.b.g0.a.c0.c.l("Component-Base", o + " insert delayed repeat: subscriber repeat");
        }
        this.f43497e = u(this.f43493a.b());
        E(this.f43495c, new d.b.g0.a.a0.f.b(true));
        if (h(this.f43493a)) {
            if (f43492h) {
                Log.d("Component-Base", o + " insert delayed（container view）: success");
            }
            d.c(new b(Thread.currentThread().getId())).B(new C0602a(o));
            return this.f43498f;
        }
        d.b.g0.a.c0.c.b("Component-Base", o + " insert delayed: attach fail");
        return null;
    }

    public void y(boolean z) {
    }

    @CallSuper
    public void z() {
        if (f43492h) {
            Log.d("Component-Base", o() + " onDestroy");
        }
        F();
    }
}
