package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.Header;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.util.CharArrayBuffer;
@Deprecated
/* loaded from: classes5.dex */
public class RFC2965Spec extends RFC2109Spec {
    public RFC2965Spec() {
        throw new RuntimeException("Stub!");
    }

    public RFC2965Spec(String[] strArr, boolean z) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.RFC2109Spec, org.apache.http.cookie.CookieSpec
    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.RFC2109Spec, org.apache.http.impl.cookie.CookieSpecBase, org.apache.http.cookie.CookieSpec
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.CookieSpecBase, org.apache.http.cookie.CookieSpec
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.RFC2109Spec
    protected void formatCookieAsVer(CharArrayBuffer charArrayBuffer, Cookie cookie, int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.RFC2109Spec, org.apache.http.cookie.CookieSpec
    public int getVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.RFC2109Spec, org.apache.http.cookie.CookieSpec
    public Header getVersionHeader() {
        throw new RuntimeException("Stub!");
    }
}
