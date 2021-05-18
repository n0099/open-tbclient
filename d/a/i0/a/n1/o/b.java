package d.a.i0.a.n1.o;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class b implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f43558a = new HashMap<>();

    public void a(HashMap<String, String> hashMap) {
        this.f43558a.clear();
        if (hashMap == null || hashMap.size() < 1) {
            return;
        }
        this.f43558a = hashMap;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        HashMap<String, String> hashMap = this.f43558a;
        if (hashMap != null && hashMap.size() >= 1) {
            Request.Builder newBuilder = chain.request().newBuilder();
            for (Map.Entry<String, String> entry : this.f43558a.entrySet()) {
                newBuilder.addHeader(entry.getKey(), entry.getValue());
            }
            return chain.proceed(newBuilder.build());
        }
        return chain.proceed(chain.request());
    }
}
