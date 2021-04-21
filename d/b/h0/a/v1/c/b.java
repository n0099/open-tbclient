package d.b.h0.a.v1.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import d.b.h0.a.k;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b<ResultDataT> {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47469f = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public final h<ResultDataT> f47470a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    public final Set<d.b.h0.a.i2.u0.b<h<ResultDataT>>> f47471b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<d> f47472c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f47473d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47474e = false;

    /* loaded from: classes3.dex */
    public class a extends d {
        public a() {
        }

        @Override // d.b.h0.a.v1.c.d
        public boolean f() throws Exception {
            if (b.this.l()) {
                return true;
            }
            d.b.h0.a.v1.c.c.j("initialPrepare failed", Boolean.TRUE);
            throw new OAuthException(10001);
        }
    }

    /* renamed from: d.b.h0.a.v1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0894b extends d {
        public C0894b() {
        }

        @Override // d.b.h0.a.v1.c.d
        public boolean f() throws Exception {
            if (b.this.k()) {
                return true;
            }
            d.b.h0.a.v1.c.c.j("finalPrepare failed", Boolean.TRUE);
            throw new OAuthException(10001);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.u0.b f47477e;

        public c(d.b.h0.a.i2.u0.b bVar) {
            this.f47477e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.i2.u0.b bVar = this.f47477e;
            if (bVar != null) {
                bVar.onCallback(b.this.f47470a);
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
        C0894b c0894b = new C0894b();
        c0894b.h(this);
        c0894b.g();
        this.f47474e = true;
    }

    public void d() {
        e(null);
    }

    public void e(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.f47470a.f47531c = (OAuthException) exc;
        } else if (exc != null) {
            this.f47470a.f47531c = new OAuthException(exc, 10001);
        }
        if (!this.f47470a.c() && f47469f && exc != null) {
            exc.printStackTrace();
        }
        s(TaskState.FINISHED);
        d.b.h0.a.v1.c.c.j(toString(), Boolean.FALSE);
        h();
        this.f47471b.clear();
    }

    public TaskState f() {
        return this.f47470a.f47530b;
    }

    public final void g() {
        a aVar = new a();
        aVar.h(this);
        aVar.g();
        this.f47473d = true;
    }

    public final void h() {
        for (d.b.h0.a.i2.u0.b<h<ResultDataT>> bVar : this.f47471b) {
            d.b.h0.a.v1.c.c.k(new c(bVar));
        }
    }

    public b i(@NonNull d dVar) {
        dVar.h(this);
        this.f47472c.offer(dVar);
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
            if (f47469f) {
                d.b.h0.a.v1.c.c.j("IllegalState on prepare", Boolean.FALSE);
            }
        } else if (!this.f47473d) {
            g();
        } else if (!this.f47472c.isEmpty()) {
            this.f47472c.poll().g();
        } else if (!this.f47474e) {
            c();
        } else {
            b();
        }
    }

    public b<ResultDataT> p(d.b.h0.a.i2.u0.b<h<ResultDataT>> bVar) {
        if (this.f47470a.f47530b.isCallbackAvailable()) {
            this.f47471b.add(bVar);
        }
        return this;
    }

    public void q() {
        this.f47470a.f47530b = TaskState.INIT;
        this.f47473d = false;
        this.f47474e = false;
    }

    public void r(ResultDataT resultdatat) {
        this.f47470a.f47529a = resultdatat;
    }

    public final void s(TaskState taskState) {
        this.f47470a.f47530b = taskState;
    }
}
