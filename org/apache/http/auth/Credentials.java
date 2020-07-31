package org.apache.http.auth;

import java.security.Principal;
@Deprecated
/* loaded from: classes20.dex */
public interface Credentials {
    String getPassword();

    Principal getUserPrincipal();
}
