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
    public static final boolean f46747f = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public final h<ResultDataT> f46748a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    public final Set<d.b.g0.a.i2.u0.b<h<ResultDataT>>> f46749b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<d> f46750c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f46751d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46752e = false;

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
    public class C0861b extends d {
        public C0861b() {
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
        public final /* synthetic */ d.b.g0.a.i2.u0.b f46755e;

        public c(d.b.g0.a.i2.u0.b bVar) {
            this.f46755e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.i2.u0.b bVar = this.f46755e;
            if (bVar != null) {
                bVar.onCallback(b.this.f46748a);
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
        C0861b c0861b = new C0861b();
        c0861b.h(this);
        c0861b.g();
        this.f46752e = true;
    }

    public void d() {
        e(null);
    }

    public void e(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.f46748a.f46809c = (OAuthException) exc;
        } else if (exc != null) {
            this.f46748a.f46809c = new OAuthException(exc, 10001);
        }
        if (!this.f46748a.c() && f46747f && exc != null) {
            exc.printStackTrace();
        }
        s(TaskState.FINISHED);
        d.b.g0.a.v1.c.c.j(toString(), Boolean.FALSE);
        h();
        this.f46749b.clear();
    }

    public TaskState f() {
        return this.f46748a.f46808b;
    }

    public final void g() {
        a aVar = new a();
        aVar.h(this);
        aVar.g();
        this.f46751d = true;
    }

    public final void h() {
        for (d.b.g0.a.i2.u0.b<h<ResultDataT>> bVar : this.f46749b) {
            d.b.g0.a.v1.c.c.k(new c(bVar));
        }
    }

    public b i(@NonNull d dVar) {
        dVar.h(this);
        this.f46750c.offer(dVar);
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
            if (f46747f) {
                d.b.g0.a.v1.c.c.j("IllegalState on prepare", Boolean.FALSE);
            }
        } else if (!this.f46751d) {
            g();
        } else if (!this.f46750c.isEmpty()) {
            this.f46750c.poll().g();
        } else if (!this.f46752e) {
            c();
        } else {
            b();
        }
    }

    public b<ResultDataT> p(d.b.g0.a.i2.u0.b<h<ResultDataT>> bVar) {
        if (this.f46748a.f46808b.isCallbackAvailable()) {
            this.f46749b.add(bVar);
        }
        return this;
    }

    public void q() {
        this.f46748a.f46808b = TaskState.INIT;
        this.f46751d = false;
        this.f46752e = false;
    }

    public void r(ResultDataT resultdatat) {
        this.f46748a.f46807a = resultdatat;
    }

    public final void s(TaskState taskState) {
        this.f46748a.f46808b = taskState;
    }
}
