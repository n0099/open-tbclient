package com;

import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
public class x implements HttpRequestInterceptor {
    final /* synthetic */ AsyncHttpClient a;

    public x(AsyncHttpClient asyncHttpClient) {
        this.a = asyncHttpClient;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        if (httpRequest.containsHeader("Accept-Encoding")) {
            return;
        }
        httpRequest.addHeader("Accept-Encoding", "gzip");
    }
}
