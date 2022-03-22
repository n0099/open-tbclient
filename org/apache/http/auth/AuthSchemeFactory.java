package org.apache.http.auth;

import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: classes8.dex */
public interface AuthSchemeFactory {
    AuthScheme newInstance(HttpParams httpParams);
}
