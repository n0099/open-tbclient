package d.b.g0.a.v1.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import d.b.g0.a.k;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b<ResultDataT> {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47140f = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public final h<ResultDataT> f47141a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    public final Set<d.b.g0.a.i2.u0.b<h<ResultDataT>>> f47142b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<d> f47143c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f47144d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47145e = false;

    /* loaded from: classes3.dex */
    public class a extends d {
        public a() {
        }

        @Override // d.b.g0.a.v1.c.d
        public boolean f() throws Exception {
            if (b.this.l()) {
                return true;
            }
            d.b.g0.a.v1.c.c.j("initialPrepare failed", Boolean.TRUE);
            throw new OAuthException(10001);
        }
    }

    /* renamed from: d.b.g0.a.v1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0874b extends d {
        public C0874b() {
        }

        @Override // d.b.g0.a.v1.c.d
        public boolean f() throws Exception {
            if (b.this.k()) {
                return true;
            }
            d.b.g0.a.v1.c.c.j("finalPrepare failed", Boolean.TRUE);
            throw new OAuthException(10001);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f47148e;

        public c(d.b.g0.a.i2.u0.b bVar) {
            this.f47148e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.i2.u0.b bVar = this.f47148e;
            if (bVar != null) {
                bVar.onCallback(b.this.f47141a);
            }
        }
    }

    @NonNull
    public b a() {
        if (TaskState.INIT == f()) {
            s(TaskState.CALLING);
            o();
        }
        return this;
    }

    public final synchronized void b() {
        j();
    }

    public final void c() {
        C0874b c0874b = new C0874b();
        c0874b.h(this);
        c0874b.g();
        this.f47145e = true;
    }

    public void d() {
        e(null);
    }

    public void e(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.f47141a.f47202c = (OAuthException) exc;
        } else if (exc != null) {
            this.f47141a.f47202c = new OAuthException(exc, 10001);
        }
        if (!this.f47141a.c() && f47140f && exc != null) {
            exc.printStackTrace();
        }
        s(TaskState.FINISHED);
        d.b.g0.a.v1.c.c.j(toString(), Boolean.FALSE);
        h();
        this.f47142b.clear();
    }

    public TaskState f() {
        return this.f47141a.f47201b;
    }

    public final void g() {
        a aVar = new a();
        aVar.h(this);
        aVar.g();
        this.f47144d = true;
    }

    public final void h() {
        for (d.b.g0.a.i2.u0.b<h<ResultDataT>> bVar : this.f47142b) {
            d.b.g0.a.v1.c.c.k(new c(bVar));
        }
    }

    public b i(@NonNull d dVar) {
        dVar.h(this);
        this.f47143c.offer(dVar);
        return this;
    }

    public abstract void j();

    public abstract boolean k();

    public boolean l() {
        return true;
    }

    public void m(d dVar) {
        if (dVar.c()) {
            o();
        } else {
            e(dVar.b());
        }
    }

    public abstract ResultDataT n(JSONObject jSONObject) throws JSONException;

    public final void o() {
        if (!TaskState.CALLING.equals(f())) {
            if (f47140f) {
                d.b.g0.a.v1.c.c.j("IllegalState on prepare", Boolean.FALSE);
            }
        } else if (!this.f47144d) {
            g();
        } else if (!this.f47143c.isEmpty()) {
            this.f47143c.poll().g();
        } else if (!this.f47145e) {
            c();
        } else {
            b();
        }
    }

    public b<ResultDataT> p(d.b.g0.a.i2.u0.b<h<ResultDataT>> bVar) {
        if (this.f47141a.f47201b.isCallbackAvailable()) {
            this.f47142b.add(bVar);
        }
        return this;
    }

    public void q() {
        this.f47141a.f47201b = TaskState.INIT;
        this.f47144d = false;
        this.f47145e = false;
    }

    public void r(ResultDataT resultdatat) {
        this.f47141a.f47200a = resultdatat;
    }

    public final void s(TaskState taskState) {
        this.f47141a.f47201b = taskState;
    }
}
