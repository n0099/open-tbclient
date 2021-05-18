package d.a.i0.a.m;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.i0.a.a2.e;
import d.a.i0.a.a2.f;
import d.a.i0.a.e0.d;
import d.a.i0.a.p.d.n;
import d.a.i0.t.g;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends f {

    /* renamed from: d  reason: collision with root package name */
    public static final String f43255d = d.a.i0.a.d0.a.b() + "/ma/relate2user";

    /* renamed from: a  reason: collision with root package name */
    public final d.a.i0.a.v2.d1.c f43256a;

    /* renamed from: b  reason: collision with root package name */
    public String f43257b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43258c;

    /* loaded from: classes2.dex */
    public class a extends c {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f43259g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f43260h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, d.a.i0.a.m.a aVar, Activity activity, Bundle bundle) {
            super(bVar, aVar, null);
            this.f43259g = activity;
            this.f43260h = bundle;
        }

        @Override // d.a.i0.a.m.b.c
        public void c(d.a.i0.a.m.a aVar) {
            d.a.i0.a.c1.a.a0().b(this.f43259g, this.f43260h, aVar);
        }
    }

    /* renamed from: d.a.i0.a.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0726b extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n.b f43261a;

        public C0726b(n.b bVar) {
            this.f43261a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (jSONObject == null) {
                d.b("SwanAppAccount", "Response is null");
                this.f43261a.a(false);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && optJSONObject.optBoolean("relate")) {
                this.f43261a.a(true);
            } else {
                this.f43261a.a(false);
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
            this.f43261a.b(exc);
        }
    }

    /* loaded from: classes2.dex */
    public abstract class c extends d.a.i0.a.v2.d1.a implements d.a.i0.a.m.a {

        /* renamed from: f  reason: collision with root package name */
        public final d.a.i0.a.m.a f43262f;

        public /* synthetic */ c(b bVar, d.a.i0.a.m.a aVar, a aVar2) {
            this(bVar, aVar);
        }

        public abstract void c(d.a.i0.a.m.a aVar);

        @Override // d.a.i0.a.m.a
        public void onResult(int i2) {
            d.a.i0.a.m.a aVar = this.f43262f;
            if (aVar != null) {
                aVar.onResult(i2);
            }
            a();
        }

        @Override // java.lang.Runnable
        public void run() {
            c(this);
        }

        public c(b bVar, d.a.i0.a.m.a aVar) {
            this.f43262f = aVar;
        }
    }

    public b(e eVar) {
        super(eVar);
        this.f43256a = new d.a.i0.a.v2.d1.c();
        this.f43258c = false;
    }

    public static void b(String str, n.b bVar) {
        d.a.i0.m.e.a.g().getRequest().url(f43255d).cookieManager(d.a.i0.a.c1.a.p().a()).addUrlParam("app_key", str).addUrlParam("launchid", d.a.i0.a.r1.l.d.a()).build().executeAsyncOnUIBack(new C0726b(bVar));
    }

    public synchronized void a() {
        this.f43256a.c();
    }

    public String c(@NonNull Context context) {
        String h2 = d.a.i0.a.c1.a.a0().h(context);
        h(h2);
        return h2;
    }

    @NonNull
    public String d() {
        if (this.f43258c) {
            return TextUtils.isEmpty(this.f43257b) ? "" : this.f43257b;
        }
        return c(AppRuntime.getAppContext());
    }

    public boolean e(Context context) {
        return d.a.i0.a.c1.a.a0().e(context);
    }

    public void f(Activity activity, Bundle bundle, d.a.i0.a.m.a aVar) {
        g(new a(this, aVar, activity, bundle));
    }

    public final void g(c cVar) {
        this.f43256a.d(cVar);
    }

    public void h(String str) {
        this.f43257b = str;
        this.f43258c = true;
    }
}
