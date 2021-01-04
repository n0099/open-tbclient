package org.apache.http;
@Deprecated
/* loaded from: classes6.dex */
public interface RequestLine {
    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
}
