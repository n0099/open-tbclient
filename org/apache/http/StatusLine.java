package org.apache.http;
@Deprecated
/* loaded from: classes4.dex */
public interface StatusLine {
    ProtocolVersion getProtocolVersion();

    String getReasonPhrase();

    int getStatusCode();
}
