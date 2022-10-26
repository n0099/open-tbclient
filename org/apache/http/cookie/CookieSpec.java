package org.apache.http.cookie;

import java.util.List;
import org.apache.http.Header;
@Deprecated
/* loaded from: classes8.dex */
public interface CookieSpec {
    List formatCookies(List list);

    int getVersion();

    Header getVersionHeader();

    boolean match(Cookie cookie, CookieOrigin cookieOrigin);

    List parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException;

    void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException;
}
