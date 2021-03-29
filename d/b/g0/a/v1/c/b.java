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
/* loaded from: classes2.dex */
public abstract class b<ResultDataT> {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f46748f = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public final h<ResultDataT> f46749a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    public final Set<d.b.g0.a.i2.u0.b<h<ResultDataT>>> f46750b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<d> f46751c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f46752d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46753e = false;

    /* loaded from: classes2.dex */
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
    /* loaded from: classes2.dex */
    public class C0862b extends d {
        public C0862b() {
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

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f46756e;

        public c(d.b.g0.a.i2.u0.b bVar) {
            this.f46756e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.i2.u0.b bVar = this.f46756e;
            if (bVar != null) {
                bVar.onCallback(b.this.f46749a);
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
        C0862b c0862b = new C0862b();
        c0862b.h(this);
        c0862b.g();
        this.f46753e = true;
    }

    public void d() {
        e(null);
    }

    public void e(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.f46749a.f46810c = (OAuthException) exc;
        } else if (exc != null) {
            this.f46749a.f46810c = new OAuthException(exc, 10001);
        }
        if (!this.f46749a.c() && f46748f && exc != null) {
            exc.printStackTrace();
        }
        s(TaskState.FINISHED);
        d.b.g0.a.v1.c.c.j(toString(), Boolean.FALSE);
        h();
        this.f46750b.clear();
    }

    public TaskState f() {
        return this.f46749a.f46809b;
    }

    public final void g() {
        a aVar = new a();
        aVar.h(this);
        aVar.g();
        this.f46752d = true;
    }

    public final void h() {
        for (d.b.g0.a.i2.u0.b<h<ResultDataT>> bVar : this.f46750b) {
            d.b.g0.a.v1.c.c.k(new c(bVar));
        }
    }

    public b i(@NonNull d dVar) {
        dVar.h(this);
        this.f46751c.offer(dVar);
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
            if (f46748f) {
                d.b.g0.a.v1.c.c.j("IllegalState on prepare", Boolean.FALSE);
            }
        } else if (!this.f46752d) {
            g();
        } else if (!this.f46751c.isEmpty()) {
            this.f46751c.poll().g();
        } else if (!this.f46753e) {
            c();
        } else {
            b();
        }
    }

    public b<ResultDataT> p(d.b.g0.a.i2.u0.b<h<ResultDataT>> bVar) {
        if (this.f46749a.f46809b.isCallbackAvailable()) {
            this.f46750b.add(bVar);
        }
        return this;
    }

    public void q() {
        this.f46749a.f46809b = TaskState.INIT;
        this.f46752d = false;
        this.f46753e = false;
    }

    public void r(ResultDataT resultdatat) {
        this.f46749a.f46808a = resultdatat;
    }

    public final void s(TaskState taskState) {
        this.f46749a.f46809b = taskState;
    }
}
