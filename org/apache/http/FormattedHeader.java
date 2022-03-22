package org.apache.http;

import org.apache.http.util.CharArrayBuffer;
@Deprecated
/* loaded from: classes8.dex */
public interface FormattedHeader extends Header {
    CharArrayBuffer getBuffer();

    int getValuePos();
}
