package org.apache.http.impl.client;

import org.apache.http.params.AbstractHttpParams;
import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: classes5.dex */
public class ClientParamsStack extends AbstractHttpParams {
    protected final HttpParams applicationParams;
    protected final HttpParams clientParams;
    protected final HttpParams overrideParams;
    protected final HttpParams requestParams;

    public ClientParamsStack(HttpParams httpParams, HttpParams httpParams2, HttpParams httpParams3, HttpParams httpParams4) {
        throw new RuntimeException("Stub!");
    }

    public ClientParamsStack(ClientParamsStack clientParamsStack) {
        throw new RuntimeException("Stub!");
    }

    public ClientParamsStack(ClientParamsStack clientParamsStack, HttpParams httpParams, HttpParams httpParams2, HttpParams httpParams3, HttpParams httpParams4) {
        throw new RuntimeException("Stub!");
    }

    public final HttpParams getApplicationParams() {
        throw new RuntimeException("Stub!");
    }

    public final HttpParams getClientParams() {
        throw new RuntimeException("Stub!");
    }

    public final HttpParams getRequestParams() {
        throw new RuntimeException("Stub!");
    }

    public final HttpParams getOverrideParams() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.params.HttpParams
    public Object getParameter(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setParameter(String str, Object obj) throws UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.params.HttpParams
    public boolean removeParameter(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams copy() {
        throw new RuntimeException("Stub!");
    }
}
