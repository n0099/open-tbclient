package org.apache.http.client;

import java.io.IOException;
import org.apache.http.HttpResponse;
@Deprecated
/* loaded from: classes20.dex */
public interface ResponseHandler<T> {
    T handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException;
}
