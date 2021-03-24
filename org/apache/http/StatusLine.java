package org.apache.http;
@Deprecated
/* loaded from: classes7.dex */
public interface StatusLine {
    ProtocolVersion getProtocolVersion();

    String getReasonPhrase();

    int getStatusCode();
}
