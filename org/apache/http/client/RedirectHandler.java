package org.apache.http.client;

import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.protocol.HttpContext;
@Deprecated
/* loaded from: classes5.dex */
public interface RedirectHandler {
    URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException;

    boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext);
}
