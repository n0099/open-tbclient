package org.apache.http.auth;

import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: classes10.dex */
public interface AuthSchemeFactory {
    AuthScheme newInstance(HttpParams httpParams);
}
