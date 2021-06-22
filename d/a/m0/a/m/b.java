package d.a.m0.a.m;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.m0.a.a2.e;
import d.a.m0.a.a2.f;
import d.a.m0.a.e0.d;
import d.a.m0.a.p.d.n;
import d.a.m0.t.g;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends f {

    /* renamed from: d  reason: collision with root package name */
    public static final String f47213d = d.a.m0.a.d0.a.b() + "/ma/relate2user";

    /* renamed from: a  reason: collision with root package name */
    public final d.a.m0.a.v2.d1.c f47214a;

    /* renamed from: b  reason: collision with root package name */
    public String f47215b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47216c;

    /* loaded from: classes2.dex */
    public class a extends c {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f47217g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f47218h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, d.a.m0.a.m.a aVar, Activity activity, Bundle bundle) {
            super(bVar, aVar, null);
            this.f47217g = activity;
            this.f47218h = bundle;
        }

        @Override // d.a.m0.a.m.b.c
        public void c(d.a.m0.a.m.a aVar) {
            d.a.m0.a.c1.a.a0().b(this.f47217g, this.f47218h, aVar);
        }
    }

    /* renamed from: d.a.m0.a.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0796b extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n.b f47219a;

        public C0796b(n.b bVar) {
            this.f47219a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (jSONObject == null) {
                d.b("SwanAppAccount", "Response is null");
                this.f47219a.a(false);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && optJSONObject.optBoolean("relate")) {
                this.f47219a.a(true);
            } else {
                this.f47219a.a(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            if (response == null || response.body() == null) {
                return null;
            }
            return new JSONObject(g.b(response.body().byteStream()));
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f47219a.b(exc);
        }
    }

    /* loaded from: classes2.dex */
    public abstract class c extends d.a.m0.a.v2.d1.a implements d.a.m0.a.m.a {

        /* renamed from: f  reason: collision with root package name */
        public final d.a.m0.a.m.a f47220f;

        public /* synthetic */ c(b bVar, d.a.m0.a.m.a aVar, a aVar2) {
            this(bVar, aVar);
        }

        public abstract void c(d.a.m0.a.m.a aVar);

        @Override // d.a.m0.a.m.a
        public void onResult(int i2) {
            d.a.m0.a.m.a aVar = this.f47220f;
            if (aVar != null) {
                aVar.onResult(i2);
            }
            a();
        }

        @Override // java.lang.Runnable
        public void run() {
            c(this);
        }

        public c(b bVar, d.a.m0.a.m.a aVar) {
            this.f47220f = aVar;
        }
    }

    public b(e eVar) {
        super(eVar);
        this.f47214a = new d.a.m0.a.v2.d1.c();
        this.f47216c = false;
    }

    public static void b(String str, n.b bVar) {
        d.a.m0.m.e.a.g().getRequest().url(f47213d).cookieManager(d.a.m0.a.c1.a.p().a()).addUrlParam("app_key", str).addUrlParam("launchid", d.a.m0.a.r1.l.d.a()).build().executeAsyncOnUIBack(new C0796b(bVar));
    }

    public synchronized void a() {
        this.f47214a.c();
    }

    public String c(@NonNull Context context) {
        String h2 = d.a.m0.a.c1.a.a0().h(context);
        h(h2);
        return h2;
    }

    @NonNull
    public String d() {
        if (this.f47216c) {
            return TextUtils.isEmpty(this.f47215b) ? "" : this.f47215b;
        }
        return c(AppRuntime.getAppContext());
    }

    public boolean e(Context context) {
        return d.a.m0.a.c1.a.a0().e(context);
    }

    public void f(Activity activity, Bundle bundle, d.a.m0.a.m.a aVar) {
        g(new a(this, aVar, activity, bundle));
    }

    public final void g(c cVar) {
        this.f47214a.d(cVar);
    }

    public void h(String str) {
        this.f47215b = str;
        this.f47216c = true;
    }
}
