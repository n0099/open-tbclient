package com.qq.e.comm.net.rr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
/* loaded from: classes6.dex */
public abstract class AbstractResponse implements Response {

    /* renamed from: a  reason: collision with root package name */
    public final HttpURLConnection f38748a;

    /* renamed from: b  reason: collision with root package name */
    public int f38749b;

    public AbstractResponse(HttpURLConnection httpURLConnection) {
        this.f38749b = 0;
        if (httpURLConnection == null) {
            throw new AssertionError("AbstractResponse parameter is null");
        }
        this.f38748a = httpURLConnection;
        try {
            this.f38749b = httpURLConnection.getResponseCode();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.qq.e.comm.net.rr.Response
    public void close() throws IllegalStateException, IOException {
        this.f38748a.disconnect();
    }

    @Override // com.qq.e.comm.net.rr.Response
    public byte[] getBytesContent() throws IllegalStateException, IOException {
        if (200 != getStatusCode()) {
            return null;
        }
        InputStream streamContent = getStreamContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = streamContent.read(bArr);
            if (read <= 0) {
                streamContent.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    @Override // com.qq.e.comm.net.rr.Response
    public int getStatusCode() {
        return this.f38749b;
    }

    @Override // com.qq.e.comm.net.rr.Response
    public InputStream getStreamContent() throws IllegalStateException, IOException {
        return this.f38748a.getInputStream();
    }

    @Override // com.qq.e.comm.net.rr.Response
    public String getStringContent() throws IOException {
        return getStringContent("UTF-8");
    }

    @Override // com.qq.e.comm.net.rr.Response
    public String getStringContent(String str) throws IOException {
        byte[] bytesContent = getBytesContent();
        String str2 = null;
        if (bytesContent == null) {
            return null;
        }
        if (bytesContent.length == 0) {
            return "";
        }
        try {
            str2 = this.f38748a.getContentEncoding();
        } catch (Throwable unused) {
        }
        if (str2 != null) {
            str = str2;
        }
        return new String(bytesContent, str);
    }
}
