package org.apache.http.entity;

import java.io.IOException;
import java.io.OutputStream;
@Deprecated
/* loaded from: classes7.dex */
public interface ContentProducer {
    void writeTo(OutputStream outputStream) throws IOException;
}
