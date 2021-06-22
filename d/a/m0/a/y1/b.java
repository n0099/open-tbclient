package d.a.m0.a.y1;

import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.m0.a.a2.d;
import d.a.m0.a.g1.f;
import d.a.m0.a.k;
import d.a.m0.a.v2.o0;
import java.util.HashMap;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49686a = k.f46983a;

    /* loaded from: classes3.dex */
    public static class a extends ResponseCallback<d.a.m0.a.y1.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0981b f49687a;

        public a(InterfaceC0981b interfaceC0981b) {
            this.f49687a = interfaceC0981b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.m0.a.y1.a aVar, int i2) {
            InterfaceC0981b interfaceC0981b = this.f49687a;
            if (interfaceC0981b == null) {
                return;
            }
            if (aVar == null) {
                interfaceC0981b.a(null);
            } else {
                interfaceC0981b.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.m0.a.y1.a parseResponse(Response response, int i2) throws Exception {
            JSONObject optJSONObject;
            if (response == null || response.body() == null || (optJSONObject = new JSONObject(response.body().string()).optJSONObject("data")) == null) {
                return null;
            }
            if (b.f49686a) {
                Log.d("SwanAppRelatedSwanHelper", "parseResponse: RelateSwanData" + optJSONObject.toString());
            }
            return d.a.m0.a.y1.a.a(optJSONObject);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            InterfaceC0981b interfaceC0981b = this.f49687a;
            if (interfaceC0981b == null) {
                return;
            }
            interfaceC0981b.a(null);
        }
    }

    /* renamed from: d.a.m0.a.y1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0981b {
        void a(d.a.m0.a.y1.a aVar);
    }

    public static String b() {
        SwanCoreVersion N = f.V().N();
        String h2 = d.a.m0.n.i.f.h(d.a.m0.a.c1.a.n().I());
        HashMap hashMap = new HashMap(4);
        hashMap.put("appkey", d.g().getAppId());
        hashMap.put("swan_core_ver", d.a.m0.a.m2.b.i(N, d.g().l()));
        hashMap.put("swan_game_ver", d.a.m0.a.m2.b.h(1));
        hashMap.put("uid", d.a.m0.a.c1.a.a0().i(d.a.m0.a.c1.a.b()));
        return o0.b(h2, hashMap);
    }

    public static void c(InterfaceC0981b interfaceC0981b) {
        d.a.m0.m.d.a aVar = new d.a.m0.m.d.a(b(), new a(interfaceC0981b));
        if (d.a.m0.m.e.a.g().c()) {
            aVar.f51756f = true;
        }
        aVar.f51757g = true;
        d.a.m0.m.e.a.g().d(aVar);
    }
}
