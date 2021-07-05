package d.a.q0.m;

import android.content.Context;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.List;
import okhttp3.Interceptor;
/* loaded from: classes8.dex */
public interface a {
    String a();

    CookieManager g();

    Context getAppContext();

    int getReadTimeout();

    int h();

    boolean i();

    boolean isDebug();

    void j(String str, HttpRequestBuilder httpRequestBuilder);

    List<Interceptor> k();

    int l();
}
