package d.a.h0.a.m;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.h0.a.p.c.e;
import d.a.h0.a.r1.f;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends f {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.h0.a.i2.t0.c f43287a;

    /* renamed from: b  reason: collision with root package name */
    public String f43288b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43289c;

    /* loaded from: classes.dex */
    public class a extends c {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f43290g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f43291h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, d.a.h0.a.m.a aVar, Activity activity, Bundle bundle) {
            super(bVar, aVar, null);
            this.f43290g = activity;
            this.f43291h = bundle;
        }

        @Override // d.a.h0.a.m.b.c
        public void c(d.a.h0.a.m.a aVar) {
            d.a.h0.a.w0.a.O().a(this.f43290g, this.f43291h, aVar);
        }
    }

    /* renamed from: d.a.h0.a.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0704b extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e.a f43292a;

        public C0704b(e.a aVar) {
            this.f43292a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (jSONObject == null) {
                d.a.h0.a.c0.c.b("SwanAppAccount", "Response is null");
                this.f43292a.b(false);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && optJSONObject.optBoolean("relate")) {
                this.f43292a.b(true);
            } else {
                this.f43292a.b(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            if (response == null || response.body() == null) {
                return null;
            }
            return new JSONObject(d.a.h0.p.f.b(response.body().byteStream()));
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f43292a.a(exc);
        }
    }

    /* loaded from: classes.dex */
    public abstract class c extends d.a.h0.a.i2.t0.a implements d.a.h0.a.m.a {

        /* renamed from: f  reason: collision with root package name */
        public final d.a.h0.a.m.a f43293f;

        public /* synthetic */ c(b bVar, d.a.h0.a.m.a aVar, a aVar2) {
            this(bVar, aVar);
        }

        public abstract void c(d.a.h0.a.m.a aVar);

        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
            d.a.h0.a.m.a aVar = this.f43293f;
            if (aVar != null) {
                aVar.onResult(i2);
            }
            a();
        }

        @Override // java.lang.Runnable
        public void run() {
            c(this);
        }

        public c(b bVar, d.a.h0.a.m.a aVar) {
            this.f43293f = aVar;
        }
    }

    public b(d.a.h0.a.r1.e eVar) {
        super(eVar);
        this.f43287a = new d.a.h0.a.i2.t0.c();
        this.f43289c = false;
    }

    public static void b(String str, e.a aVar) {
        d.a.h0.k.e.a.f().getRequest().url("https://mbd.baidu.com/ma/relate2user").cookieManager(d.a.h0.a.w0.a.m().a()).addUrlParam(com.alipay.sdk.cons.b.f1831h, str).build().executeAsyncOnUIBack(new C0704b(aVar));
    }

    public synchronized void a() {
        this.f43287a.c();
    }

    public String c(@NonNull Context context) {
        String e2 = d.a.h0.a.w0.a.O().e(context);
        h(e2);
        return e2;
    }

    @NonNull
    public String d() {
        if (this.f43289c) {
            return TextUtils.isEmpty(this.f43288b) ? "" : this.f43288b;
        }
        return c(AppRuntime.getAppContext());
    }

    public boolean e(Context context) {
        return d.a.h0.a.w0.a.O().d(context);
    }

    public void f(Activity activity, Bundle bundle, d.a.h0.a.m.a aVar) {
        g(new a(this, aVar, activity, bundle));
    }

    public final void g(c cVar) {
        this.f43287a.d(cVar);
    }

    public void h(String str) {
        this.f43288b = str;
        this.f43289c = true;
    }
}
