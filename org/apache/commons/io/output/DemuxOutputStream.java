package org.apache.commons.io.output;

import java.io.OutputStream;
/* loaded from: classes.dex */
public class DemuxOutputStream extends OutputStream {
    private final InheritableThreadLocal<OutputStream> m_streams = new InheritableThreadLocal<>();

    public OutputStream bindStream(OutputStream outputStream) {
        OutputStream outputStream2 = this.m_streams.get();
        this.m_streams.set(outputStream);
        return outputStream2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        OutputStream outputStream = this.m_streams.get();
        if (outputStream != null) {
            outputStream.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        OutputStream outputStream = this.m_streams.get();
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        OutputStream outputStream = this.m_streams.get();
        if (outputStream != null) {
            outputStream.write(i);
        }
    }
}
