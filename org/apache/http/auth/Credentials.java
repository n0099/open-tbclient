package org.apache.http.auth;

import java.security.Principal;
@Deprecated
/* loaded from: classes7.dex */
public interface Credentials {
    String getPassword();

    Principal getUserPrincipal();
}
