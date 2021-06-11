package org.apache.http.entity.mime.content;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes8.dex */
public class ByteArrayBody extends AbstractContentBody {
    public final byte[] data;
    public final String filename;

    public ByteArrayBody(byte[] bArr, String str, String str2) {
        super(str);
        if (bArr != null) {
            this.data = bArr;
            this.filename = str2;
            return;
        }
        throw new IllegalArgumentException("byte[] may not be null");
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public String getCharset() {
        return null;
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return this.data.length;
    }

    @Override // org.apache.http.entity.mime.content.ContentBody
    public String getFilename() {
        return this.filename;
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return "binary";
    }

    @Override // org.apache.http.entity.mime.content.ContentBody
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.data);
    }

    public ByteArrayBody(byte[] bArr, String str) {
        this(bArr, "application/octet-stream", str);
    }
}
