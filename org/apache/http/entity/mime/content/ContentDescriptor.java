package org.apache.http.entity.mime.content;
/* loaded from: classes3.dex */
public interface ContentDescriptor {
    String getCharset();

    long getContentLength();

    String getMediaType();

    String getMimeType();

    String getSubType();

    String getTransferEncoding();
}
