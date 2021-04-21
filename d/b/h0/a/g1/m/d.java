package d.b.h0.a.g1.m;

import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class d implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        return chain.proceed(request.newBuilder().header("User-Agent", SwanAppNetworkUtils.g()).build());
    }
}
