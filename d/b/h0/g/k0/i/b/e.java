package d.b.h0.g.k0.i.b;

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
        public void onSuccess(String str, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
        }
    }

    public static Map<String, String> a(@NonNull d.b.h0.a.r1.e eVar, int i, String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(com.alipay.sdk.cons.b.f1883h, eVar.B());
        treeMap.put("to_app_key", str);
        treeMap.put("source", String.valueOf(i));
        treeMap.put("timestamp", c());
        StringBuilder sb = new StringBuilder();
        for (String str2 : treeMap.keySet()) {
            sb.append(str2);
            sb.append("=");
            sb.append((String) treeMap.get(str2));
            sb.append("&");
        }
        sb.append("dsb9Ao44");
        treeMap.put("sign", d.b.h0.p.e.d(sb.toString().getBytes(), false));
        return treeMap;
    }

    public static void b(int i, @NonNull ResponseCallback responseCallback) {
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        if (y == null) {
            responseCallback.onFail(new Exception("framework error: swan app is null."));
            return;
        }
        y.V().getRequest().cookieManager(d.b.h0.a.w0.a.m().a()).url(d.b.h0.a.w0.a.l().l()).addUrlParam(com.alipay.sdk.cons.b.f1883h, y.B()).addUrlParam(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(5)).addUrlParam("source", String.valueOf(i)).build().executeAsync(responseCallback);
    }

    public static String c() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static void d(int i, String str) {
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        if (y == null) {
            return;
        }
        String y2 = d.b.h0.a.w0.a.l().y();
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) y.V().postFormRequest().cookieManager(d.b.h0.a.w0.a.m().a())).url(y2)).addParams(a(y, i, str)).build().executeAsync(new a());
    }
}
