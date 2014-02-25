package org.apache.commons.io.input;

import java.io.InputStream;
/* loaded from: classes.dex */
public class AutoCloseInputStream extends ProxyInputStream {
    public AutoCloseInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.in.close();
        this.in = new ClosedInputStream();
    }

    @Override // org.apache.commons.io.input.ProxyInputStream
    protected void afterRead(int i) {
        if (i == -1) {
            close();
        }
    }

    protected void finalize() {
        close();
        super.finalize();
    }
}
