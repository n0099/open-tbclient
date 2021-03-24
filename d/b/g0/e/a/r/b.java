package d.b.g0.e.a.r;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import com.baidubce.AbstractBceClient;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements d.b.g0.e.a.m.e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f47691a;

    /* renamed from: b  reason: collision with root package name */
    public Context f47692b;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<String> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            if (response == null || response.body() == null) {
                return "";
            }
            response.body().close();
            return "";
        }
    }

    public b(Context context) {
        this.f47692b = context;
    }

    @Override // d.b.g0.e.a.m.e
    public void a(String str, JSONObject jSONObject, ResponseCallback<AdResponseInfo> responseCallback) {
        boolean startsWith = str.startsWith("https://");
        this.f47691a = startsWith;
        if (startsWith) {
            ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) d.b.g0.k.e.a.f().postRequest().url(str)).cookieManager(d.b.g0.a.w0.a.m().a())).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(responseCallback);
            return;
        }
        ((PostBodyRequest.PostBodyRequestBuilder) d.b.g0.k.e.a.f().postRequest().url(str)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(responseCallback);
    }

    @Override // d.b.g0.e.a.m.e
    public void b(String str, ResponseCallback<d.b.g0.e.a.p.a> responseCallback) {
        boolean startsWith = str.startsWith("https://");
        this.f47691a = startsWith;
        if (startsWith) {
            d.b.g0.k.e.a.f().getRequest().url(str).cookieManager(d.b.g0.a.w0.a.m().a()).build().executeAsync(responseCallback);
            return;
        }
        d.b.g0.k.e.a.f().getRequest().url(str).build().executeAsync(responseCallback);
    }

    @Override // d.b.g0.e.a.m.e
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.b.g0.k.d.a aVar = new d.b.g0.k.d.a();
        aVar.f48879b = "POST";
        aVar.f48878a = "https://pimlog.baidu.com/mapp/advlog";
        aVar.f48881d = RequestBody.create(MediaType.get(AbstractBceClient.DEFAULT_CONTENT_TYPE), str);
        d.b.g0.k.e.a.f().e(aVar);
    }

    @Override // d.b.g0.e.a.m.e
    public void d(String str) {
        a aVar = new a(this);
        boolean startsWith = str.startsWith("https://");
        this.f47691a = startsWith;
        if (startsWith) {
            d.b.g0.k.e.a.f().getRequest().url(str).cookieManager(d.b.g0.a.w0.a.m().a()).build().executeAsync(aVar);
            return;
        }
        d.b.g0.k.e.a.f().getRequest().url(str).build().executeAsync(aVar);
    }

    @Override // d.b.g0.e.a.m.e
    public void e(String str, ResponseCallback<AdResponseInfo> responseCallback) {
        boolean startsWith = str.startsWith("https://");
        this.f47691a = startsWith;
        if (startsWith) {
            d.b.g0.k.e.a.f().getRequest().url(str).cookieManager(d.b.g0.a.w0.a.m().a()).build().executeAsync(responseCallback);
            return;
        }
        d.b.g0.k.e.a.f().getRequest().url(str).build().executeAsync(responseCallback);
    }
}
