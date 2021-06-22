package d.a.m0.a.e2.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import d.a.m0.a.k;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class c<ResultDataT> {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45458f = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public final i<ResultDataT> f45459a = new i<>();

    /* renamed from: b  reason: collision with root package name */
    public final Set<d.a.m0.a.v2.e1.b<i<ResultDataT>>> f45460b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<e> f45461c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f45462d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45463e = false;

    /* loaded from: classes3.dex */
    public class a extends e {
        public a() {
        }

        @Override // d.a.m0.a.e2.c.e
        public boolean f() throws Exception {
            if (c.this.l()) {
                return true;
            }
            d.j("initialPrepare failed", Boolean.TRUE);
            throw new OAuthException(10001);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends e {
        public b() {
        }

        @Override // d.a.m0.a.e2.c.e
        public boolean f() throws Exception {
            if (c.this.k()) {
                return true;
            }
            d.j("finalPrepare failed", Boolean.TRUE);
            if (c.f45458f) {
                throw new OAuthException(10001);
            }
            return true;
        }
    }

    /* renamed from: d.a.m0.a.e2.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0677c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.v2.e1.b f45466e;

        public RunnableC0677c(d.a.m0.a.v2.e1.b bVar) {
            this.f45466e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.v2.e1.b bVar = this.f45466e;
            if (bVar != null) {
                bVar.onCallback(c.this.f45459a);
            }
        }
    }

    @NonNull
    public c a() {
        if (TaskState.INIT == f()) {
            t(TaskState.CALLING);
            o();
        }
        return this;
    }

    public final synchronized void b() {
        j();
    }

    public final void c() {
        b bVar = new b();
        bVar.h(this);
        bVar.g();
        this.f45463e = true;
    }

    public void d() {
        e(null);
    }

    public void e(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.f45459a.f45522c = (OAuthException) exc;
        } else if (exc != null) {
            d.s("OAuthTask#finish", exc.getMessage());
            this.f45459a.f45522c = new OAuthException(exc, 10001);
        }
        if (!this.f45459a.c() && f45458f && exc != null) {
            exc.printStackTrace();
        }
        t(TaskState.FINISHED);
        d.j(toString(), Boolean.FALSE);
        h();
        this.f45460b.clear();
    }

    public TaskState f() {
        return this.f45459a.f45521b;
    }

    public final void g() {
        a aVar = new a();
        aVar.h(this);
        aVar.g();
        this.f45462d = true;
    }

    public final void h() {
        for (d.a.m0.a.v2.e1.b<i<ResultDataT>> bVar : this.f45460b) {
            d.k(new RunnableC0677c(bVar));
        }
    }

    public c i(@NonNull e eVar) {
        eVar.h(this);
        this.f45461c.offer(eVar);
        return this;
    }

    public abstract void j();

    public abstract boolean k();

    public boolean l() {
        return true;
    }

    public void m(e eVar) {
        if (eVar.c()) {
            o();
        } else {
            e(eVar.b());
        }
    }

    public abstract ResultDataT n(JSONObject jSONObject) throws JSONException;

    public final void o() {
        if (!TaskState.CALLING.equals(f())) {
            if (f45458f) {
                d.j("IllegalState on prepare", Boolean.FALSE);
            }
        } else if (!this.f45462d) {
            g();
        } else if (!this.f45461c.isEmpty()) {
            this.f45461c.poll().g();
        } else if (!this.f45463e) {
            c();
        } else {
            b();
        }
    }

    public c<ResultDataT> p(d.a.m0.a.v2.e1.b<i<ResultDataT>> bVar) {
        if (this.f45459a.f45521b.isCallbackAvailable()) {
            this.f45460b.add(bVar);
        }
        return this;
    }

    public void q() {
        this.f45459a.f45521b = TaskState.INIT;
        this.f45462d = false;
        this.f45463e = false;
    }

    public c<ResultDataT> r(String str) {
        return this;
    }

    public void s(ResultDataT resultdatat) {
        this.f45459a.f45520a = resultdatat;
    }

    public final void t(TaskState taskState) {
        this.f45459a.f45521b = taskState;
    }
}
