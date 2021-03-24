package d.b.g0.a.m;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.b.g0.a.p.c.e;
import d.b.g0.a.r1.f;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends f {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.g0.a.i2.t0.c f45227a;

    /* renamed from: b  reason: collision with root package name */
    public String f45228b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45229c;

    /* loaded from: classes3.dex */
    public class a extends c {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f45230g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f45231h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, d.b.g0.a.m.a aVar, Activity activity, Bundle bundle) {
            super(bVar, aVar, null);
            this.f45230g = activity;
            this.f45231h = bundle;
        }

        @Override // d.b.g0.a.m.b.c
        public void c(d.b.g0.a.m.a aVar) {
            d.b.g0.a.w0.a.O().b(this.f45230g, this.f45231h, aVar);
        }
    }

    /* renamed from: d.b.g0.a.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0732b extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e.a f45232a;

        public C0732b(e.a aVar) {
            this.f45232a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i) {
            if (jSONObject == null) {
                d.b.g0.a.c0.c.b("SwanAppAccount", "Response is null");
                this.f45232a.a(false);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && optJSONObject.optBoolean("relate")) {
                this.f45232a.a(true);
            } else {
                this.f45232a.a(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i) throws Exception {
            if (response == null || response.body() == null) {
                return null;
            }
            return new JSONObject(d.b.g0.p.f.b(response.body().byteStream()));
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f45232a.b(exc);
        }
    }

    /* loaded from: classes3.dex */
    public abstract class c extends d.b.g0.a.i2.t0.a implements d.b.g0.a.m.a {

        /* renamed from: f  reason: collision with root package name */
        public final d.b.g0.a.m.a f45233f;

        public /* synthetic */ c(b bVar, d.b.g0.a.m.a aVar, a aVar2) {
            this(bVar, aVar);
        }

        public abstract void c(d.b.g0.a.m.a aVar);

        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
            d.b.g0.a.m.a aVar = this.f45233f;
            if (aVar != null) {
                aVar.onResult(i);
            }
            a();
        }

        @Override // java.lang.Runnable
        public void run() {
            c(this);
        }

        public c(b bVar, d.b.g0.a.m.a aVar) {
            this.f45233f = aVar;
        }
    }

    public b(d.b.g0.a.r1.e eVar) {
        super(eVar);
        this.f45227a = new d.b.g0.a.i2.t0.c();
        this.f45229c = false;
    }

    public static void b(String str, e.a aVar) {
        d.b.g0.k.e.a.f().getRequest().url("https://mbd.baidu.com/ma/relate2user").cookieManager(d.b.g0.a.w0.a.m().a()).addUrlParam(com.alipay.sdk.cons.b.f1858h, str).build().executeAsyncOnUIBack(new C0732b(aVar));
    }

    public synchronized void a() {
        this.f45227a.c();
    }

    public String c(@NonNull Context context) {
        String a2 = d.b.g0.a.w0.a.O().a(context);
        h(a2);
        return a2;
    }

    @NonNull
    public String d() {
        if (this.f45229c) {
            return TextUtils.isEmpty(this.f45228b) ? "" : this.f45228b;
        }
        return c(AppRuntime.getAppContext());
    }

    public boolean e(Context context) {
        return d.b.g0.a.w0.a.O().g(context);
    }

    public void f(Activity activity, Bundle bundle, d.b.g0.a.m.a aVar) {
        g(new a(this, aVar, activity, bundle));
    }

    public final void g(c cVar) {
        this.f45227a.d(cVar);
    }

    public void h(String str) {
        this.f45228b = str;
        this.f45229c = true;
    }
}
