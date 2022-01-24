package org.apache.http;

import org.apache.http.util.CharArrayBuffer;
@Deprecated
/* loaded from: classes5.dex */
public interface FormattedHeader extends Header {
    CharArrayBuffer getBuffer();

    int getValuePos();
}
