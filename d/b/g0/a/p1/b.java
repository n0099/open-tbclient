package d.b.g0.a.p1;

import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.b.g0.a.k;
import d.b.g0.a.r1.d;
import d.b.g0.a.z0.f;
import d.b.g0.c.c;
import d.b.g0.l.l.e;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45465a = k.f45050a;

    /* loaded from: classes3.dex */
    public static class a extends ResponseCallback<d.b.g0.a.p1.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0756b f45466a;

        public a(InterfaceC0756b interfaceC0756b) {
            this.f45466a = interfaceC0756b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.b.g0.a.p1.a aVar, int i) {
            InterfaceC0756b interfaceC0756b = this.f45466a;
            if (interfaceC0756b == null) {
                return;
            }
            if (aVar == null) {
                interfaceC0756b.a(null);
            } else {
                interfaceC0756b.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.b.g0.a.p1.a parseResponse(Response response, int i) throws Exception {
            JSONObject optJSONObject;
            if (response == null || response.body() == null || (optJSONObject = new JSONObject(response.body().string()).optJSONObject("data")) == null) {
                return null;
            }
            if (b.f45465a) {
                Log.d("SwanAppRelatedSwanHelper", "parseResponse: RelateSwanData" + optJSONObject.toString());
            }
            return d.b.g0.a.p1.a.a(optJSONObject);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            InterfaceC0756b interfaceC0756b = this.f45466a;
            if (interfaceC0756b == null) {
                return;
            }
            interfaceC0756b.a(null);
        }
    }

    /* renamed from: d.b.g0.a.p1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0756b {
        void a(d.b.g0.a.p1.a aVar);
    }

    public static void b(InterfaceC0756b interfaceC0756b) {
        d.b.g0.k.e.a.f().getRequest().url(e.h(d.b.g0.a.w0.a.l().L())).addUrlParam("appkey", d.e().getAppId()).addUrlParam("swan_core_ver", d.b.g0.a.b2.b.g(f.V().L(), d.e().h())).addUrlParam("swan_game_ver", d.b.g0.a.b2.b.f(1)).addUrlParam("uid", d.b.g0.a.w0.a.O().c(d.b.g0.a.w0.a.c())).cookieManager(c.a().a()).build().executeAsync(new a(interfaceC0756b));
    }
}
