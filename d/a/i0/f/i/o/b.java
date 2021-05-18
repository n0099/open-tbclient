package d.a.i0.f.i.o;

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
public class b implements d.a.i0.f.i.l.g {

    /* renamed from: a  reason: collision with root package name */
    public boolean f46599a;

    /* renamed from: b  reason: collision with root package name */
    public Context f46600b;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<String> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i2) throws Exception {
            if (response == null || response.body() == null) {
                return "";
            }
            response.body().close();
            return "";
        }
    }

    public b(Context context) {
        this.f46600b = context;
    }

    @Override // d.a.i0.f.i.l.g
    public void a(String str, JSONObject jSONObject, ResponseCallback<AdResponseInfo> responseCallback) {
        boolean startsWith = str.startsWith("https://");
        this.f46599a = startsWith;
        if (startsWith) {
            ((PostBodyRequest.PostBodyRequestBuilder) d.a.i0.m.e.a.g().postRequest().url(str)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(responseCallback);
        } else {
            ((PostBodyRequest.PostBodyRequestBuilder) d.a.i0.m.e.a.g().postRequest().url(str)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(responseCallback);
        }
    }

    @Override // d.a.i0.f.i.l.g
    public void b(String str, ResponseCallback<d.a.i0.f.i.k.a> responseCallback) {
        boolean startsWith = str.startsWith("https://");
        this.f46599a = startsWith;
        if (startsWith) {
            d.a.i0.m.e.a.g().getRequest().url(str).build().executeAsync(responseCallback);
        } else {
            d.a.i0.m.e.a.g().getRequest().url(str).build().executeAsync(responseCallback);
        }
    }

    @Override // d.a.i0.f.i.l.g
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.i0.m.d.a aVar = new d.a.i0.m.d.a();
        aVar.f47794b = "POST";
        aVar.f47793a = "https://pimlog.baidu.com/mapp/advlog";
        aVar.f47796d = RequestBody.create(MediaType.get(AbstractBceClient.DEFAULT_CONTENT_TYPE), str);
        d.a.i0.m.e.a.g().e(aVar);
    }

    @Override // d.a.i0.f.i.l.g
    public void d(String str) {
        a aVar = new a(this);
        boolean startsWith = str.startsWith("https://");
        this.f46599a = startsWith;
        if (startsWith) {
            d.a.i0.m.e.a.g().getRequest().url(str).build().executeAsync(aVar);
        } else {
            d.a.i0.m.e.a.g().getRequest().url(str).build().executeAsync(aVar);
        }
    }

    @Override // d.a.i0.f.i.l.g
    public void e(String str, ResponseCallback<AdResponseInfo> responseCallback) {
        boolean startsWith = str.startsWith("https://");
        this.f46599a = startsWith;
        if (startsWith) {
            d.a.i0.m.e.a.g().getRequest().url(str).build().executeAsync(responseCallback);
        } else {
            d.a.i0.m.e.a.g().getRequest().url(str).build().executeAsync(responseCallback);
        }
    }
}
