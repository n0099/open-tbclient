package d.a.m0;

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
public class h extends d.a.m0.a {

    /* loaded from: classes5.dex */
    public class a extends c0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Response f63952a;

        public a(h hVar, Response response) {
            this.f63952a = response;
        }

        @Override // d.a.m0.c0
        public void a() {
            this.f63952a.body().close();
        }

        @Override // d.a.m0.c0
        public String b() throws IOException {
            return this.f63952a.body().string();
        }

        @Override // d.a.m0.c0
        public String c() {
            return this.f63952a.message();
        }

        @Override // d.a.m0.c0
        public boolean d() {
            return this.f63952a.isSuccessful();
        }
    }

    @Override // d.a.m0.a
    public c0 c(String str, byte[] bArr, Map<String, String> map) throws IOException {
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
