package org.apache.http;

import java.io.IOException;
import org.apache.http.protocol.HttpContext;
@Deprecated
/* loaded from: classes6.dex */
public interface HttpResponseInterceptor {
    void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException;
}
