package com;

import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
public class c implements HttpResponseInterceptor {
    final /* synthetic */ AsyncHttpClient a;

    public c(AsyncHttpClient asyncHttpClient) {
        this.a = asyncHttpClient;
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
