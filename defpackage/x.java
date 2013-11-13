package defpackage;

import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;
/* renamed from: x  reason: default package */
/* loaded from: classes.dex */
public class x implements HttpRequestInterceptor {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AsyncHttpClient f2991a;

    public x(AsyncHttpClient asyncHttpClient) {
        this.f2991a = asyncHttpClient;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        if (httpRequest.containsHeader("Accept-Encoding")) {
            return;
        }
        httpRequest.addHeader("Accept-Encoding", "gzip");
    }
}
