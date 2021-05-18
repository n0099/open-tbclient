package d.a.i0.a.y1;

import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.i0.a.a2.d;
import d.a.i0.a.g1.f;
import d.a.i0.a.k;
import d.a.i0.a.v2.o0;
import java.util.HashMap;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45728a = k.f43025a;

    /* loaded from: classes3.dex */
    public static class a extends ResponseCallback<d.a.i0.a.y1.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0911b f45729a;

        public a(InterfaceC0911b interfaceC0911b) {
            this.f45729a = interfaceC0911b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.i0.a.y1.a aVar, int i2) {
            InterfaceC0911b interfaceC0911b = this.f45729a;
            if (interfaceC0911b == null) {
                return;
            }
            if (aVar == null) {
                interfaceC0911b.a(null);
            } else {
                interfaceC0911b.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.i0.a.y1.a parseResponse(Response response, int i2) throws Exception {
            JSONObject optJSONObject;
            if (response == null || response.body() == null || (optJSONObject = new JSONObject(response.body().string()).optJSONObject("data")) == null) {
                return null;
            }
            if (b.f45728a) {
                Log.d("SwanAppRelatedSwanHelper", "parseResponse: RelateSwanData" + optJSONObject.toString());
            }
            return d.a.i0.a.y1.a.a(optJSONObject);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            InterfaceC0911b interfaceC0911b = this.f45729a;
            if (interfaceC0911b == null) {
                return;
            }
            interfaceC0911b.a(null);
        }
    }

    /* renamed from: d.a.i0.a.y1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0911b {
        void a(d.a.i0.a.y1.a aVar);
    }

    public static String b() {
        SwanCoreVersion N = f.V().N();
        String h2 = d.a.i0.n.i.f.h(d.a.i0.a.c1.a.n().I());
        HashMap hashMap = new HashMap(4);
        hashMap.put("appkey", d.g().getAppId());
        hashMap.put("swan_core_ver", d.a.i0.a.m2.b.i(N, d.g().l()));
        hashMap.put("swan_game_ver", d.a.i0.a.m2.b.h(1));
        hashMap.put("uid", d.a.i0.a.c1.a.a0().i(d.a.i0.a.c1.a.b()));
        return o0.b(h2, hashMap);
    }

    public static void c(InterfaceC0911b interfaceC0911b) {
        d.a.i0.m.d.a aVar = new d.a.i0.m.d.a(b(), new a(interfaceC0911b));
        if (d.a.i0.m.e.a.g().c()) {
            aVar.f47798f = true;
        }
        aVar.f47799g = true;
        d.a.i0.m.e.a.g().d(aVar);
    }
}
