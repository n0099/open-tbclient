package d.a.l0.a.y1;

import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.l0.a.a2.d;
import d.a.l0.a.g1.f;
import d.a.l0.a.k;
import d.a.l0.a.v2.o0;
import java.util.HashMap;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45904a = k.f43199a;

    /* loaded from: classes3.dex */
    public static class a extends ResponseCallback<d.a.l0.a.y1.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0922b f45905a;

        public a(InterfaceC0922b interfaceC0922b) {
            this.f45905a = interfaceC0922b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.l0.a.y1.a aVar, int i2) {
            InterfaceC0922b interfaceC0922b = this.f45905a;
            if (interfaceC0922b == null) {
                return;
            }
            if (aVar == null) {
                interfaceC0922b.a(null);
            } else {
                interfaceC0922b.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.l0.a.y1.a parseResponse(Response response, int i2) throws Exception {
            JSONObject optJSONObject;
            if (response == null || response.body() == null || (optJSONObject = new JSONObject(response.body().string()).optJSONObject("data")) == null) {
                return null;
            }
            if (b.f45904a) {
                Log.d("SwanAppRelatedSwanHelper", "parseResponse: RelateSwanData" + optJSONObject.toString());
            }
            return d.a.l0.a.y1.a.a(optJSONObject);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            InterfaceC0922b interfaceC0922b = this.f45905a;
            if (interfaceC0922b == null) {
                return;
            }
            interfaceC0922b.a(null);
        }
    }

    /* renamed from: d.a.l0.a.y1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0922b {
        void a(d.a.l0.a.y1.a aVar);
    }

    public static String b() {
        SwanCoreVersion N = f.V().N();
        String h2 = d.a.l0.n.i.f.h(d.a.l0.a.c1.a.n().I());
        HashMap hashMap = new HashMap(4);
        hashMap.put("appkey", d.g().getAppId());
        hashMap.put("swan_core_ver", d.a.l0.a.m2.b.i(N, d.g().l()));
        hashMap.put("swan_game_ver", d.a.l0.a.m2.b.h(1));
        hashMap.put("uid", d.a.l0.a.c1.a.a0().i(d.a.l0.a.c1.a.b()));
        return o0.b(h2, hashMap);
    }

    public static void c(InterfaceC0922b interfaceC0922b) {
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(b(), new a(interfaceC0922b));
        if (d.a.l0.m.e.a.g().c()) {
            aVar.f47974f = true;
        }
        aVar.f47975g = true;
        d.a.l0.m.e.a.g().d(aVar);
    }
}
