package com.sina.weibo.sdk.network.base;

import com.sina.weibo.sdk.network.exception.RequestException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class WbResponseBody {
    public InputStream inputStream;
    public long length;

    public WbResponseBody(InputStream inputStream, long j) {
        this.inputStream = inputStream;
        this.length = j;
    }

    public InputStream byteStream() {
        return this.inputStream;
    }

    public long contentLength() {
        return this.length;
    }

    public String string() throws RequestException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = this.inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    this.inputStream.close();
                    byteArrayOutputStream.close();
                    return new String(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (IOException e2) {
            throw new RequestException(e2.toString());
        }
    }
}
