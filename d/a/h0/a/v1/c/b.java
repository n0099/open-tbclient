package d.a.h0.a.v1.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import d.a.h0.a.k;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b<ResultDataT> {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f44890f = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public final h<ResultDataT> f44891a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    public final Set<d.a.h0.a.i2.u0.b<h<ResultDataT>>> f44892b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<d> f44893c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f44894d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f44895e = false;

    /* loaded from: classes3.dex */
    public class a extends d {
        public a() {
        }

        @Override // d.a.h0.a.v1.c.d
        public boolean f() throws Exception {
            if (b.this.l()) {
                return true;
            }
            d.a.h0.a.v1.c.c.j("initialPrepare failed", Boolean.TRUE);
            throw new OAuthException(10001);
        }
    }

    /* renamed from: d.a.h0.a.v1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0833b extends d {
        public C0833b() {
        }

        @Override // d.a.h0.a.v1.c.d
        public boolean f() throws Exception {
            if (b.this.k()) {
                return true;
            }
            d.a.h0.a.v1.c.c.j("finalPrepare failed", Boolean.TRUE);
            throw new OAuthException(10001);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f44898e;

        public c(d.a.h0.a.i2.u0.b bVar) {
            this.f44898e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.i2.u0.b bVar = this.f44898e;
            if (bVar != null) {
                bVar.onCallback(b.this.f44891a);
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
        C0833b c0833b = new C0833b();
        c0833b.h(this);
        c0833b.g();
        this.f44895e = true;
    }

    public void d() {
        e(null);
    }

    public void e(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.f44891a.f44954c = (OAuthException) exc;
        } else if (exc != null) {
            this.f44891a.f44954c = new OAuthException(exc, 10001);
        }
        if (!this.f44891a.c() && f44890f && exc != null) {
            exc.printStackTrace();
        }
        s(TaskState.FINISHED);
        d.a.h0.a.v1.c.c.j(toString(), Boolean.FALSE);
        h();
        this.f44892b.clear();
    }

    public TaskState f() {
        return this.f44891a.f44953b;
    }

    public final void g() {
        a aVar = new a();
        aVar.h(this);
        aVar.g();
        this.f44894d = true;
    }

    public final void h() {
        for (d.a.h0.a.i2.u0.b<h<ResultDataT>> bVar : this.f44892b) {
            d.a.h0.a.v1.c.c.k(new c(bVar));
        }
    }

    public b i(@NonNull d dVar) {
        dVar.h(this);
        this.f44893c.offer(dVar);
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
            if (f44890f) {
                d.a.h0.a.v1.c.c.j("IllegalState on prepare", Boolean.FALSE);
            }
        } else if (!this.f44894d) {
            g();
        } else if (!this.f44893c.isEmpty()) {
            this.f44893c.poll().g();
        } else if (!this.f44895e) {
            c();
        } else {
            b();
        }
    }

    public b<ResultDataT> p(d.a.h0.a.i2.u0.b<h<ResultDataT>> bVar) {
        if (this.f44891a.f44953b.isCallbackAvailable()) {
            this.f44892b.add(bVar);
        }
        return this;
    }

    public void q() {
        this.f44891a.f44953b = TaskState.INIT;
        this.f44894d = false;
        this.f44895e = false;
    }

    public void r(ResultDataT resultdatat) {
        this.f44891a.f44952a = resultdatat;
    }

    public final void s(TaskState taskState) {
        this.f44891a.f44953b = taskState;
    }
}
