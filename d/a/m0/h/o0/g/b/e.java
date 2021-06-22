package d.a.m0.h.o0.g.b;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import d.a.m0.t.f;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public class e {

    /* loaded from: classes3.dex */
    public static class a extends StringResponseCallback {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
        }
    }

    public static Map<String, String> a(@NonNull d.a.m0.a.a2.e eVar, int i2, String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("app_key", eVar.D());
        treeMap.put("to_app_key", str);
        treeMap.put("source", String.valueOf(i2));
        treeMap.put("timestamp", c());
        StringBuilder sb = new StringBuilder();
        for (String str2 : treeMap.keySet()) {
            sb.append(str2);
            sb.append("=");
            sb.append((String) treeMap.get(str2));
            sb.append("&");
        }
        sb.append("dsb9Ao44");
        treeMap.put("sign", f.d(sb.toString().getBytes(), false));
        return treeMap;
    }

    public static void b(int i2, @NonNull ResponseCallback responseCallback) {
        d.a.m0.a.a2.e i3 = d.a.m0.a.a2.e.i();
        if (i3 == null) {
            responseCallback.onFail(new Exception("framework error: swan app is null."));
            return;
        }
        i3.X().getRequest().cookieManager(d.a.m0.a.c1.a.p().a()).url(d.a.m0.h.t.a.b().n()).addUrlParam("app_key", i3.D()).addUrlParam(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(5)).addUrlParam("source", String.valueOf(i2)).requestFrom(16).requestFrom(1607).build().executeAsync(responseCallback);
    }

    public static String c() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static void d(int i2, String str) {
        d.a.m0.a.a2.e i3 = d.a.m0.a.a2.e.i();
        if (i3 == null) {
            return;
        }
        String f2 = d.a.m0.h.t.a.b().f();
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) i3.X().postFormRequest().cookieManager(d.a.m0.a.c1.a.p().a())).url(f2)).addParams(a(i3, i2, str)).requestFrom(16)).requestFrom(1607)).build().executeAsync(new a());
    }
}
