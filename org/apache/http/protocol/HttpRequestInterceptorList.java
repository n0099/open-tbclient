package org.apache.http.protocol;

import java.util.List;
import org.apache.http.HttpRequestInterceptor;
@Deprecated
/* loaded from: classes4.dex */
public interface HttpRequestInterceptorList {
    void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor);

    void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor, int i2);

    void clearRequestInterceptors();

    HttpRequestInterceptor getRequestInterceptor(int i2);

    int getRequestInterceptorCount();

    void removeRequestInterceptorByClass(Class cls);

    void setInterceptors(List list);
}
