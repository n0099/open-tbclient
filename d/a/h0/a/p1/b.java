package d.a.h0.a.p1;

import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.h0.a.k;
import d.a.h0.a.r1.d;
import d.a.h0.a.z0.f;
import d.a.h0.c.c;
import d.a.h0.l.l.e;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43534a = k.f43101a;

    /* loaded from: classes3.dex */
    public static class a extends ResponseCallback<d.a.h0.a.p1.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0728b f43535a;

        public a(InterfaceC0728b interfaceC0728b) {
            this.f43535a = interfaceC0728b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.h0.a.p1.a aVar, int i2) {
            InterfaceC0728b interfaceC0728b = this.f43535a;
            if (interfaceC0728b == null) {
                return;
            }
            if (aVar == null) {
                interfaceC0728b.a(null);
            } else {
                interfaceC0728b.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.h0.a.p1.a parseResponse(Response response, int i2) throws Exception {
            JSONObject optJSONObject;
            if (response == null || response.body() == null || (optJSONObject = new JSONObject(response.body().string()).optJSONObject("data")) == null) {
                return null;
            }
            if (b.f43534a) {
                Log.d("SwanAppRelatedSwanHelper", "parseResponse: RelateSwanData" + optJSONObject.toString());
            }
            return d.a.h0.a.p1.a.a(optJSONObject);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            InterfaceC0728b interfaceC0728b = this.f43535a;
            if (interfaceC0728b == null) {
                return;
            }
            interfaceC0728b.a(null);
        }
    }

    /* renamed from: d.a.h0.a.p1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0728b {
        void a(d.a.h0.a.p1.a aVar);
    }

    public static void b(InterfaceC0728b interfaceC0728b) {
        d.a.h0.k.e.a.f().getRequest().url(e.h(d.a.h0.a.w0.a.l().O())).addUrlParam("appkey", d.e().getAppId()).addUrlParam("swan_core_ver", d.a.h0.a.b2.b.g(f.V().N(), d.e().j())).addUrlParam("swan_game_ver", d.a.h0.a.b2.b.f(1)).addUrlParam("uid", d.a.h0.a.w0.a.O().f(d.a.h0.a.w0.a.c())).cookieManager(c.a().a()).build().executeAsync(new a(interfaceC0728b));
    }
}
