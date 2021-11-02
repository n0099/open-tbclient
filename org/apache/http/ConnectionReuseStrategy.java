package org.apache.http;

import org.apache.http.protocol.HttpContext;
@Deprecated
/* loaded from: classes3.dex */
public interface ConnectionReuseStrategy {
    boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext);
}
