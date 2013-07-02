package org.acra.util;

import java.io.IOException;
import java.net.SocketTimeoutException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
class d implements HttpRequestRetryHandler {
    private final HttpParams a;
    private final int b;

    private d(HttpParams httpParams, int i) {
        this.a = httpParams;
        this.b = i;
    }

    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        if (iOException instanceof SocketTimeoutException) {
            if (i <= this.b) {
                if (this.a != null) {
                    int soTimeout = HttpConnectionParams.getSoTimeout(this.a) * 2;
                    HttpConnectionParams.setSoTimeout(this.a, soTimeout);
                    org.acra.a.b.a(org.acra.a.a, "SocketTimeOut - increasing time out to " + soTimeout + " millis and trying again");
                } else {
                    org.acra.a.b.a(org.acra.a.a, "SocketTimeOut - no HttpParams, cannot increase time out. Trying again with current settings");
                }
                return true;
            }
            org.acra.a.b.a(org.acra.a.a, "SocketTimeOut but exceeded max number of retries : " + this.b);
        }
        return false;
    }
}
