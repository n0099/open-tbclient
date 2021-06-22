package d.a.m0.n.i.i.f;

import android.text.TextUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidubce.AbstractBceClient;
import d.a.m0.m.c.h;
import java.security.InvalidParameterException;
import java.util.Map;
import okhttp3.MediaType;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends d.a.m0.n.i.a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f51829d = d.a.m0.n.c.f51766a;

    public static void a(String str, Map<String, String> map, Map<String, String> map2, d.a.m0.n.i.e<String> eVar) {
        if (d(str, eVar)) {
            return;
        }
        c(d.a.m0.m.e.a.g().getRequest(), str, map, map2, eVar);
    }

    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, d.a.m0.n.i.e<String> eVar) {
        if (d(str, eVar)) {
            return;
        }
        h postStringRequest = d.a.m0.m.e.a.g().postStringRequest();
        d.a.m0.n.d.a(postStringRequest, map);
        postStringRequest.content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6);
        c(postStringRequest, str, map, map2, eVar);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public static void c(HttpRequestBuilder<?> httpRequestBuilder, String str, Map<String, String> map, Map<String, String> map2, d.a.m0.n.i.e<String> eVar) {
        httpRequestBuilder.url(d.a.m0.n.i.f.i(str, map)).requestSubFrom(10).addHeader(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, "true").addHeaders(map2).userAgent(d.a.m0.n.i.a.f51799c).cookieManager(d.a.m0.n.i.a.f51798b).enableStat(true).build().executeStat(eVar);
    }

    public static boolean d(String str, d.a.m0.n.i.e<String> eVar) {
        if (TextUtils.isEmpty(str)) {
            if (f51829d) {
                throw new InvalidParameterException("PMS request URL is empty");
            }
            return true;
        } else if (eVar != null) {
            eVar.onStart();
            return false;
        } else {
            return false;
        }
    }
}
