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
/* loaded from: classes3.dex */
public abstract class a<V extends View, M extends d.b.g0.a.a0.b.b> {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f43099h = k.f45050a;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.a0.e.a f43100a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public V f43101b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public M f43102c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public M f43103d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public SwanAppComponentContainerView f43104e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public j f43105f;

    /* renamed from: g  reason: collision with root package name */
    public int f43106g;

    /* renamed from: d.b.g0.a.a0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0589a extends j<Object> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43107e;

        public C0589a(String str) {
            this.f43107e = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: d.b.g0.a.a0.b.a */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: d.b.g0.a.a0.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.e
        public void onCompleted() {
            a aVar = a.this;
            aVar.f43101b = aVar.v(aVar.f43100a.b());
            a aVar2 = a.this;
            aVar2.B(aVar2.f43101b);
            a.this.f43104e.setTargetView(a.this.f43101b, 0);
            a aVar3 = a.this;
            aVar3.D(aVar3.f43101b, a.this.f43102c, new d.b.g0.a.a0.f.b(true));
            if (a.f43099h) {
                Log.d("Component-Base", this.f43107e + " insert delayed（view）: success");
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            d.b.g0.a.c0.c.l("Component-Base", this.f43107e + " insert delayed（view）: fail");
            if (a.f43099h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                throw new RuntimeException("save subscriber and return subscriber: nolinear !");
            }
            a.this.C();
        }

        @Override // h.e
        public void onNext(Object obj) {
            d.b.g0.a.c0.c.l("Component-Base", this.f43107e + " success should call onCompleted");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a<Object> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f43109e;

        public b(long j) {
            this.f43109e = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super Object> jVar) {
            if (a.f43099h) {
                Log.d("Component-Base", "insert delayed => save thread: " + Thread.currentThread().getName());
            }
            if (this.f43109e != Thread.currentThread().getId()) {
                d.b.g0.a.a0.g.a.a("Component-Base", "save subscriber and return subscriber: nolinear !");
            }
            a.this.f43105f = jVar;
        }
    }

    /* loaded from: classes3.dex */
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
        this.f43102c = j;
        d.b.g0.a.a0.e.a c2 = d.b.g0.a.a0.d.a.c(j);
        this.f43100a = c2;
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
        if (f43099h) {
            Log.i("Component-Base", "=====================" + o + " start remove=====================");
        }
        d.b.g0.a.a0.e.a aVar = this.f43100a;
        if (aVar == null) {
            d.b.g0.a.a0.g.a.a("Component-Base", o + " remove with a null component context!");
            return new d.b.g0.a.a0.b.c(202, "component context is null");
        } else if (this.f43104e == null) {
            d.b.g0.a.c0.c.b("Component-Base", o + " remove must after insert");
            return new d.b.g0.a.a0.b.c(202, "component remove must after insert");
        } else if (!aVar.a().e(this)) {
            String str = o + " remove fail";
            d.b.g0.a.c0.c.b("Component-Base", str);
            return new d.b.g0.a.a0.b.c(1001, str);
        } else {
            A();
            if (f43099h) {
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
        if (this.f43104e == null) {
            d.b.g0.a.a0.g.a.a("Component-Base", "renderContainerView with a null container view");
            return;
        }
        if (bVar.a(1)) {
            this.f43104e.setHidden(m.j);
        }
        if (bVar.a(2)) {
            r(this.f43104e, m);
        }
    }

    public final void F() {
        j jVar = this.f43105f;
        if (jVar == null || jVar.isUnsubscribed()) {
            return;
        }
        this.f43105f.unsubscribe();
    }

    @NonNull
    @UiThread
    public final d.b.g0.a.a0.b.c G(@NonNull M m) {
        String o = o();
        d.b.g0.a.a0.b.c i = i(m);
        if (!i.a()) {
            d.b.g0.a.c0.c.b("Component-Base", o + " update with a invalid model => " + i.f43116b);
            return i;
        }
        if (f43099h) {
            Log.i("Component-Base", "=====================" + o + " start update=====================");
        }
        M m2 = this.f43102c;
        if (m2 == m) {
            String str = o + " update with the same model";
            d.b.g0.a.a0.g.a.a("Component-Base", str);
            return new d.b.g0.a.a0.b.c(202, str);
        } else if (!TextUtils.equals(m2.f43112f, m.f43112f)) {
            String str2 = o + " update with different id: " + this.f43102c.f43112f + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f43112f;
            d.b.g0.a.a0.g.a.a("Component-Base", str2);
            return new d.b.g0.a.a0.b.c(202, str2);
        } else if (!TextUtils.equals(this.f43102c.f43113g, m.f43113g)) {
            String str3 = o + " update with different slave id: " + this.f43102c.f43113g + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f43113g;
            d.b.g0.a.a0.g.a.a("Component-Base", str3);
            return new d.b.g0.a.a0.b.c(202, str3);
        } else if (this.f43101b != null && this.f43104e != null) {
            if (this.f43100a == null) {
                d.b.g0.a.a0.g.a.a("Component-Base", o + " update with a null component context!");
                return new d.b.g0.a.a0.b.c(202, "component context is null");
            }
            M m3 = this.f43102c;
            this.f43103d = m3;
            d.b.g0.a.a0.f.b k = k(m3, m);
            M j = j(m);
            this.f43102c = j;
            D(this.f43101b, j, k);
            boolean f2 = this.f43100a.a().f(this, k);
            this.f43103d = null;
            if (!f2) {
                String str4 = o + " update component fail";
                d.b.g0.a.c0.c.b("Component-Base", str4);
                return new d.b.g0.a.a0.b.c(1001, str4);
            }
            if (f43099h) {
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
        this.f43106g = i | this.f43106g;
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
        if (TextUtils.isEmpty(m.f43113g)) {
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
        return j(this.f43102c);
    }

    @Nullable
    public final SwanAppComponentContainerView m() {
        return this.f43104e;
    }

    @NonNull
    public final M n() {
        return this.f43102c;
    }

    @NonNull
    public final String o() {
        d.b.g0.a.a0.b.c i = i(this.f43102c);
        if (i.a()) {
            return this.f43102c.d();
        }
        return "【illegal component#" + i.f43116b + "】";
    }

    @Nullable
    public final M p() {
        return this.f43103d;
    }

    @Nullable
    public final V q() {
        return this.f43101b;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        swanAppComponentContainerView.setOnTouchListener(new c(this, m.f43113g, m.f43112f, m.f43111e, m.k));
    }

    public final boolean s(int i) {
        return (this.f43106g & i) == i;
    }

    public final boolean t() {
        return this.f43103d != null;
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
        d.b.g0.a.a0.b.c i = i(this.f43102c);
        if (!i.a()) {
            d.b.g0.a.c0.c.b("Component-Base", o + " insert with a invalid model => " + i.f43116b);
            return i;
        }
        if (f43099h) {
            Log.i("Component-Base", "=====================" + o + " start insert=====================");
        }
        d.b.g0.a.a0.e.a aVar = this.f43100a;
        if (aVar == null) {
            d.b.g0.a.c0.c.b("Component-Base", o + " insert with a null component context!");
            return new d.b.g0.a.a0.b.c(202, "component context is null");
        }
        Context b2 = aVar.b();
        if (this.f43104e != null || this.f43101b != null) {
            d.b.g0.a.c0.c.l("Component-Base", o + " repeat insert");
        }
        V v = v(this.f43100a.b());
        this.f43101b = v;
        B(v);
        SwanAppComponentContainerView u = u(b2);
        this.f43104e = u;
        u.setTargetView(this.f43101b);
        D(this.f43101b, this.f43102c, new d.b.g0.a.a0.f.b(true));
        if (h(this.f43100a)) {
            if (f43099h) {
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
        d.b.g0.a.a0.b.c i = i(this.f43102c);
        if (!i.a()) {
            d.b.g0.a.c0.c.b("Component-Base", o + " insert delayed with a invalid model => " + i.f43116b);
            return null;
        }
        if (f43099h) {
            Log.i("Component-Base", "=====================" + o + " start insertDelayed=====================");
        }
        if (this.f43100a == null) {
            d.b.g0.a.a0.g.a.a("Component-Base", o + " insert delayed with a null component context!");
            return null;
        }
        if (this.f43104e != null) {
            d.b.g0.a.c0.c.l("Component-Base", o + " repeat insert delayed: container view repeat");
        }
        j jVar = this.f43105f;
        if (jVar != null && !jVar.isUnsubscribed()) {
            this.f43105f.unsubscribe();
            this.f43105f = null;
            d.b.g0.a.c0.c.l("Component-Base", o + " insert delayed repeat: subscriber repeat");
        }
        this.f43104e = u(this.f43100a.b());
        E(this.f43102c, new d.b.g0.a.a0.f.b(true));
        if (h(this.f43100a)) {
            if (f43099h) {
                Log.d("Component-Base", o + " insert delayed（container view）: success");
            }
            d.c(new b(Thread.currentThread().getId())).B(new C0589a(o));
            return this.f43105f;
        }
        d.b.g0.a.c0.c.b("Component-Base", o + " insert delayed: attach fail");
        return null;
    }

    public void y(boolean z) {
    }

    @CallSuper
    public void z() {
        if (f43099h) {
            Log.d("Component-Base", o() + " onDestroy");
        }
        F();
    }
}
