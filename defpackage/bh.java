package defpackage;

import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;
/* renamed from: bh  reason: default package */
/* loaded from: classes.dex */
public class bh implements HttpResponseInterceptor {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AsyncHttpClient f377a;

    public bh(AsyncHttpClient asyncHttpClient) {
        this.f377a = asyncHttpClient;
    }

    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        Header contentEncoding;
        HttpEntity entity = httpResponse.getEntity();
        if (entity == null || (contentEncoding = entity.getContentEncoding()) == null) {
            return;
        }
        HeaderElement[] elements = contentEncoding.getElements();
        for (HeaderElement headerElement : elements) {
            if (headerElement.getName().equalsIgnoreCase("gzip")) {
                httpResponse.setEntity(new AsyncHttpClient.a(httpResponse.getEntity()));
                return;
            }
        }
    }
}
