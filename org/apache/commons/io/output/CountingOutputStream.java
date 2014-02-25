package org.apache.commons.io.output;

import java.io.OutputStream;
/* loaded from: classes.dex */
public class CountingOutputStream extends ProxyOutputStream {
    private long count;

    public CountingOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.count = 0L;
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream
    protected synchronized void beforeWrite(int i) {
        this.count += i;
    }

    public int getCount() {
        long byteCount = getByteCount();
        if (byteCount > 2147483647L) {
            throw new ArithmeticException("The byte count " + byteCount + " is too large to be converted to an int");
        }
        return (int) byteCount;
    }

    public int resetCount() {
        long resetByteCount = resetByteCount();
        if (resetByteCount > 2147483647L) {
            throw new ArithmeticException("The byte count " + resetByteCount + " is too large to be converted to an int");
        }
        return (int) resetByteCount;
    }

    public synchronized long getByteCount() {
        return this.count;
    }

    public synchronized long resetByteCount() {
        long j;
        j = this.count;
        this.count = 0L;
        return j;
    }
}
