package org.apache.http.entity.mime.content;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes8.dex */
public interface ContentBody extends ContentDescriptor {
    String getFilename();

    void writeTo(OutputStream outputStream) throws IOException;
}
