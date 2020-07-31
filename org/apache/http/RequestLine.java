package org.apache.http;
@Deprecated
/* loaded from: classes20.dex */
public interface RequestLine {
    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
}
