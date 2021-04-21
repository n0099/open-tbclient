package d.b.l0;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.PostByteRequest;
import java.io.IOException;
import java.util.Map;
import okhttp3.Response;
@Singleton
@Service
/* loaded from: classes5.dex */
public class h extends d.b.l0.a {

    /* loaded from: classes5.dex */
    public class a extends b0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Response f64925a;

        public a(h hVar, Response response) {
            this.f64925a = response;
        }

        @Override // d.b.l0.b0
        public void a() {
            this.f64925a.body().close();
        }

        @Override // d.b.l0.b0
        public String b() throws IOException {
            return this.f64925a.body().string();
        }

        @Override // d.b.l0.b0
        public String c() {
            return this.f64925a.message();
        }

        @Override // d.b.l0.b0
        public boolean d() {
            return this.f64925a.isSuccessful();
        }
    }

    @Override // d.b.l0.a
    public b0 c(String str, byte[] bArr, Map<String, String> map) throws IOException {
        PostByteRequest.PostByteRequestBuilder postByteRequest = HttpManager.getDefault(AppRuntime.getAppContext()).postByteRequest();
        postByteRequest.requestFrom(3);
        postByteRequest.url(str);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            postByteRequest.addHeader(entry.getKey(), entry.getValue());
        }
        postByteRequest.cookieManager(HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(true, true));
        return new a(this, postByteRequest.content(bArr).build().executeSync());
    }
}
