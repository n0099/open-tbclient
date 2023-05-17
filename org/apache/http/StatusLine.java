package org.apache.http;
@Deprecated
/* loaded from: classes10.dex */
public interface StatusLine {
    ProtocolVersion getProtocolVersion();

    String getReasonPhrase();

    int getStatusCode();
}
