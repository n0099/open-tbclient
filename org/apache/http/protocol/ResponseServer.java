package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
@Deprecated
/* loaded from: classes7.dex */
public class ResponseServer implements HttpResponseInterceptor {
    public ResponseServer() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }
}
