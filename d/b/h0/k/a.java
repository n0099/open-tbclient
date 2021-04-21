package d.b.h0.k;

import android.content.Context;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.List;
import okhttp3.Interceptor;
/* loaded from: classes3.dex */
public interface a {
    CookieManager a();

    String b();

    int c();

    List<Interceptor> d();

    void e(String str, HttpRequestBuilder httpRequestBuilder);

    int f();

    Context getAppContext();

    int getReadTimeout();

    boolean isDebug();
}
