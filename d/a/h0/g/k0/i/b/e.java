package d.a.h0.g.k0.i.b;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
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

    public static Map<String, String> a(@NonNull d.a.h0.a.r1.e eVar, int i2, String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(com.alipay.sdk.cons.b.f1831h, eVar.B());
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
        treeMap.put("sign", d.a.h0.p.e.d(sb.toString().getBytes(), false));
        return treeMap;
    }

    public static void b(int i2, @NonNull ResponseCallback responseCallback) {
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null) {
            responseCallback.onFail(new Exception("framework error: swan app is null."));
            return;
        }
        h2.V().getRequest().cookieManager(d.a.h0.a.w0.a.m().a()).url(d.a.h0.a.w0.a.l().C()).addUrlParam(com.alipay.sdk.cons.b.f1831h, h2.B()).addUrlParam(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(5)).addUrlParam("source", String.valueOf(i2)).build().executeAsync(responseCallback);
    }

    public static String c() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static void d(int i2, String str) {
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null) {
            return;
        }
        String k = d.a.h0.a.w0.a.l().k();
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) h2.V().postFormRequest().cookieManager(d.a.h0.a.w0.a.m().a())).url(k)).addParams(a(h2, i2, str)).build().executeAsync(new a());
    }
}
