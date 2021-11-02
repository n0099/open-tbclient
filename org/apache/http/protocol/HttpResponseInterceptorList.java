package org.apache.http.protocol;

import java.util.List;
import org.apache.http.HttpResponseInterceptor;
@Deprecated
/* loaded from: classes3.dex */
public interface HttpResponseInterceptorList {
    void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor);

    void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor, int i2);

    void clearResponseInterceptors();

    HttpResponseInterceptor getResponseInterceptor(int i2);

    int getResponseInterceptorCount();

    void removeResponseInterceptorByClass(Class cls);

    void setInterceptors(List list);
}
