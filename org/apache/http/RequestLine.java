package org.apache.http;
@Deprecated
/* loaded from: classes11.dex */
public interface RequestLine {
    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
}
