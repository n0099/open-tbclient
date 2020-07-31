package org.apache.http.auth;

import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: classes20.dex */
public interface AuthSchemeFactory {
    AuthScheme newInstance(HttpParams httpParams);
}
