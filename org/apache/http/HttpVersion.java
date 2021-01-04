package org.apache.http;

import java.io.Serializable;
@Deprecated
/* loaded from: classes6.dex */
public final class HttpVersion extends ProtocolVersion implements Serializable {
    public static final String HTTP = "HTTP";
    public static final HttpVersion HTTP_0_9 = null;
    public static final HttpVersion HTTP_1_0 = null;
    public static final HttpVersion HTTP_1_1 = null;

    public HttpVersion(int i, int i2) {
        super(null, 0, 0);
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.ProtocolVersion
    public ProtocolVersion forVersion(int i, int i2) {
        throw new RuntimeException("Stub!");
    }
}
