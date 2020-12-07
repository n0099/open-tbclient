package org.apache.http.entity;

import java.io.IOException;
import java.io.OutputStream;
@Deprecated
/* loaded from: classes11.dex */
public interface ContentProducer {
    void writeTo(OutputStream outputStream) throws IOException;
}
