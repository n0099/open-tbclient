package d.a.i0.a.e2.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import d.a.i0.a.k;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class c<ResultDataT> {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f41500f = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public final i<ResultDataT> f41501a = new i<>();

    /* renamed from: b  reason: collision with root package name */
    public final Set<d.a.i0.a.v2.e1.b<i<ResultDataT>>> f41502b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<e> f41503c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f41504d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41505e = false;

    /* loaded from: classes3.dex */
    public class a extends e {
        public a() {
        }

        @Override // d.a.i0.a.e2.c.e
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

        @Override // d.a.i0.a.e2.c.e
        public boolean f() throws Exception {
            if (c.this.k()) {
                return true;
            }
            d.j("finalPrepare failed", Boolean.TRUE);
            if (c.f41500f) {
                throw new OAuthException(10001);
            }
            return true;
        }
    }

    /* renamed from: d.a.i0.a.e2.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0607c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f41508e;

        public RunnableC0607c(d.a.i0.a.v2.e1.b bVar) {
            this.f41508e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.v2.e1.b bVar = this.f41508e;
            if (bVar != null) {
                bVar.onCallback(c.this.f41501a);
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
        this.f41505e = true;
    }

    public void d() {
        e(null);
    }

    public void e(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.f41501a.f41564c = (OAuthException) exc;
        } else if (exc != null) {
            d.s("OAuthTask#finish", exc.getMessage());
            this.f41501a.f41564c = new OAuthException(exc, 10001);
        }
        if (!this.f41501a.c() && f41500f && exc != null) {
            exc.printStackTrace();
        }
        t(TaskState.FINISHED);
        d.j(toString(), Boolean.FALSE);
        h();
        this.f41502b.clear();
    }

    public TaskState f() {
        return this.f41501a.f41563b;
    }

    public final void g() {
        a aVar = new a();
        aVar.h(this);
        aVar.g();
        this.f41504d = true;
    }

    public final void h() {
        for (d.a.i0.a.v2.e1.b<i<ResultDataT>> bVar : this.f41502b) {
            d.k(new RunnableC0607c(bVar));
        }
    }

    public c i(@NonNull e eVar) {
        eVar.h(this);
        this.f41503c.offer(eVar);
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
            if (f41500f) {
                d.j("IllegalState on prepare", Boolean.FALSE);
            }
        } else if (!this.f41504d) {
            g();
        } else if (!this.f41503c.isEmpty()) {
            this.f41503c.poll().g();
        } else if (!this.f41505e) {
            c();
        } else {
            b();
        }
    }

    public c<ResultDataT> p(d.a.i0.a.v2.e1.b<i<ResultDataT>> bVar) {
        if (this.f41501a.f41563b.isCallbackAvailable()) {
            this.f41502b.add(bVar);
        }
        return this;
    }

    public void q() {
        this.f41501a.f41563b = TaskState.INIT;
        this.f41504d = false;
        this.f41505e = false;
    }

    public c<ResultDataT> r(String str) {
        return this;
    }

    public void s(ResultDataT resultdatat) {
        this.f41501a.f41562a = resultdatat;
    }

    public final void t(TaskState taskState) {
        this.f41501a.f41563b = taskState;
    }
}
