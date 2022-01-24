package org.apache.http.client;

import java.io.IOException;
import org.apache.http.protocol.HttpContext;
@Deprecated
/* loaded from: classes5.dex */
public interface HttpRequestRetryHandler {
    boolean retryRequest(IOException iOException, int i2, HttpContext httpContext);
}
