package org.apache.http.client;

import java.io.IOException;
import org.apache.http.HttpResponse;
@Deprecated
/* loaded from: classes8.dex */
public interface ResponseHandler {
    Object handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException;
}
