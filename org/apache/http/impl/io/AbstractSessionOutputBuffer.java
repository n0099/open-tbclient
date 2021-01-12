package org.apache.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;
@Deprecated
/* loaded from: classes5.dex */
public abstract class AbstractSessionOutputBuffer implements SessionOutputBuffer {
    public AbstractSessionOutputBuffer() {
        throw new RuntimeException("Stub!");
    }

    protected void init(OutputStream outputStream, int i, HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    protected void flushBuffer() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void flush() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] bArr, int i, int i2) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] bArr) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(int i) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void writeLine(String str) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void writeLine(CharArrayBuffer charArrayBuffer) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public HttpTransportMetrics getMetrics() {
        throw new RuntimeException("Stub!");
    }
}
