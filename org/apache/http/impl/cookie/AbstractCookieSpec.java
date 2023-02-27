package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieSpec;
@Deprecated
/* loaded from: classes9.dex */
public abstract class AbstractCookieSpec implements CookieSpec {
    public AbstractCookieSpec() {
        throw new RuntimeException("Stub!");
    }

    public Collection<CookieAttributeHandler> getAttribHandlers() {
        throw new RuntimeException("Stub!");
    }

    public CookieAttributeHandler findAttribHandler(String str) {
        throw new RuntimeException("Stub!");
    }

    public CookieAttributeHandler getAttribHandler(String str) {
        throw new RuntimeException("Stub!");
    }

    public void registerAttribHandler(String str, CookieAttributeHandler cookieAttributeHandler) {
        throw new RuntimeException("Stub!");
    }
}
