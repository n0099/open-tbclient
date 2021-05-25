package d.a.l0.a.e2.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import d.a.l0.a.k;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class c<ResultDataT> {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f41674f = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public final i<ResultDataT> f41675a = new i<>();

    /* renamed from: b  reason: collision with root package name */
    public final Set<d.a.l0.a.v2.e1.b<i<ResultDataT>>> f41676b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<e> f41677c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f41678d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41679e = false;

    /* loaded from: classes3.dex */
    public class a extends e {
        public a() {
        }

        @Override // d.a.l0.a.e2.c.e
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

        @Override // d.a.l0.a.e2.c.e
        public boolean f() throws Exception {
            if (c.this.k()) {
                return true;
            }
            d.j("finalPrepare failed", Boolean.TRUE);
            if (c.f41674f) {
                throw new OAuthException(10001);
            }
            return true;
        }
    }

    /* renamed from: d.a.l0.a.e2.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0618c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f41682e;

        public RunnableC0618c(d.a.l0.a.v2.e1.b bVar) {
            this.f41682e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.v2.e1.b bVar = this.f41682e;
            if (bVar != null) {
                bVar.onCallback(c.this.f41675a);
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
        this.f41679e = true;
    }

    public void d() {
        e(null);
    }

    public void e(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.f41675a.f41738c = (OAuthException) exc;
        } else if (exc != null) {
            d.s("OAuthTask#finish", exc.getMessage());
            this.f41675a.f41738c = new OAuthException(exc, 10001);
        }
        if (!this.f41675a.c() && f41674f && exc != null) {
            exc.printStackTrace();
        }
        t(TaskState.FINISHED);
        d.j(toString(), Boolean.FALSE);
        h();
        this.f41676b.clear();
    }

    public TaskState f() {
        return this.f41675a.f41737b;
    }

    public final void g() {
        a aVar = new a();
        aVar.h(this);
        aVar.g();
        this.f41678d = true;
    }

    public final void h() {
        for (d.a.l0.a.v2.e1.b<i<ResultDataT>> bVar : this.f41676b) {
            d.k(new RunnableC0618c(bVar));
        }
    }

    public c i(@NonNull e eVar) {
        eVar.h(this);
        this.f41677c.offer(eVar);
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
            if (f41674f) {
                d.j("IllegalState on prepare", Boolean.FALSE);
            }
        } else if (!this.f41678d) {
            g();
        } else if (!this.f41677c.isEmpty()) {
            this.f41677c.poll().g();
        } else if (!this.f41679e) {
            c();
        } else {
            b();
        }
    }

    public c<ResultDataT> p(d.a.l0.a.v2.e1.b<i<ResultDataT>> bVar) {
        if (this.f41675a.f41737b.isCallbackAvailable()) {
            this.f41676b.add(bVar);
        }
        return this;
    }

    public void q() {
        this.f41675a.f41737b = TaskState.INIT;
        this.f41678d = false;
        this.f41679e = false;
    }

    public c<ResultDataT> r(String str) {
        return this;
    }

    public void s(ResultDataT resultdatat) {
        this.f41675a.f41736a = resultdatat;
    }

    public final void t(TaskState taskState) {
        this.f41675a.f41737b = taskState;
    }
}
