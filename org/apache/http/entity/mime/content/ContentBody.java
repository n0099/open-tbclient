package org.apache.http.entity.mime.content;

import java.io.OutputStream;
/* loaded from: classes.dex */
public interface ContentBody extends ContentDescriptor {
    String getFilename();

    void writeTo(OutputStream outputStream);
}
