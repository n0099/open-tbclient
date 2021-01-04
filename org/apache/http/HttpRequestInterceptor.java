package org.apache.http;

import java.io.IOException;
import org.apache.http.protocol.HttpContext;
@Deprecated
/* loaded from: classes6.dex */
public interface HttpRequestInterceptor {
    void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException;
}
