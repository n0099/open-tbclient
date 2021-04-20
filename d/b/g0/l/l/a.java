package d.b.g0.l.l;

import android.text.TextUtils;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.http.request.PostStringRequest;
import com.baidubce.AbstractBceClient;
import java.security.InvalidParameterException;
import java.util.Map;
import okhttp3.MediaType;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static d.b.g0.k.e.a f49317a = d.b.g0.k.e.a.f();

    /* renamed from: b  reason: collision with root package name */
    public static CookieManager f49318b = d.b.g0.l.f.b().a();

    @Deprecated
    public static void a(String str, Map<String, String> map, Map<String, String> map2, StatResponseCallback<String> statResponseCallback) {
        if (!TextUtils.isEmpty(str)) {
            GetRequest.GetRequestBuilder url = f49317a.getRequest().url(e.i(str, map));
            if (map2 != null) {
                url.addHeaders(map2);
            }
            url.cookieManager(f49318b).enableStat(true).build().executeStat(statResponseCallback);
            return;
        }
        throw new InvalidParameterException("PMS request URL is empty");
    }

    @Deprecated
    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, StatResponseCallback<String> statResponseCallback) {
        if (!TextUtils.isEmpty(str)) {
            PostStringRequest.PostStringRequestBuilder mediaType = f49317a.postStringRequest().url(e.i(str, map)).content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE));
            if (map2 != null) {
                mediaType.addHeaders(map2);
            }
            mediaType.cookieManager(f49318b).enableStat(true).build().executeStat(statResponseCallback);
            return;
        }
        throw new InvalidParameterException("PMS request URL is empty");
    }
}
