package org.apache.commons.io.output;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.input.ClosedInputStream;
/* loaded from: classes.dex */
public class ByteArrayOutputStream extends OutputStream {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private final List<byte[]> buffers;
    private int count;
    private byte[] currentBuffer;
    private int currentBufferIndex;
    private int filledBufferSum;

    public ByteArrayOutputStream() {
        this(1024);
    }

    public ByteArrayOutputStream(int i) {
        this.buffers = new ArrayList();
        if (i < 0) {
            throw new IllegalArgumentException("Negative initial size: " + i);
        }
        synchronized (this) {
            needNewBuffer(i);
        }
    }

    private void needNewBuffer(int i) {
        if (this.currentBufferIndex < this.buffers.size() - 1) {
            this.filledBufferSum += this.currentBuffer.length;
            this.currentBufferIndex++;
            this.currentBuffer = this.buffers.get(this.currentBufferIndex);
            return;
        }
        if (this.currentBuffer == null) {
            this.filledBufferSum = 0;
        } else {
            i = Math.max(this.currentBuffer.length << 1, i - this.filledBufferSum);
            this.filledBufferSum += this.currentBuffer.length;
        }
        this.currentBufferIndex++;
        this.currentBuffer = new byte[i];
        this.buffers.add(this.currentBuffer);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (i < 0 || i > bArr.length || i2 < 0 || i + i2 > bArr.length || i + i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 != 0) {
            synchronized (this) {
                int i3 = this.count + i2;
                int i4 = this.count - this.filledBufferSum;
                int i5 = i2;
                while (i5 > 0) {
                    int min = Math.min(i5, this.currentBuffer.length - i4);
                    System.arraycopy(bArr, (i + i2) - i5, this.currentBuffer, i4, min);
                    i5 -= min;
                    if (i5 > 0) {
                        needNewBuffer(i3);
                        i4 = 0;
                    }
                }
                this.count = i3;
            }
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        int i2 = this.count - this.filledBufferSum;
        if (i2 == this.currentBuffer.length) {
            needNewBuffer(this.count + 1);
            i2 = 0;
        }
        this.currentBuffer[i2] = (byte) i;
        this.count++;
    }

    public synchronized int write(InputStream inputStream) {
        int i;
        int i2 = this.count - this.filledBufferSum;
        i = 0;
        int read = inputStream.read(this.currentBuffer, i2, this.currentBuffer.length - i2);
        int i3 = i2;
        while (read != -1) {
            i += read;
            i3 += read;
            this.count = read + this.count;
            if (i3 == this.currentBuffer.length) {
                needNewBuffer(this.currentBuffer.length);
                i3 = 0;
            }
            read = inputStream.read(this.currentBuffer, i3, this.currentBuffer.length - i3);
        }
        return i;
    }

    public synchronized int size() {
        return this.count;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public synchronized void reset() {
        this.count = 0;
        this.filledBufferSum = 0;
        this.currentBufferIndex = 0;
        this.currentBuffer = this.buffers.get(this.currentBufferIndex);
    }

    public synchronized void writeTo(OutputStream outputStream) {
        int i = this.count;
        Iterator<byte[]> it = this.buffers.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            byte[] next = it.next();
            int min = Math.min(next.length, i2);
            outputStream.write(next, 0, min);
            i = i2 - min;
            if (i == 0) {
                break;
            }
        }
    }

    public static InputStream toBufferedInputStream(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(inputStream);
        return byteArrayOutputStream.toBufferedInputStream();
    }

    private InputStream toBufferedInputStream() {
        int i = this.count;
        if (i == 0) {
            return new ClosedInputStream();
        }
        ArrayList arrayList = new ArrayList(this.buffers.size());
        Iterator<byte[]> it = this.buffers.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            byte[] next = it.next();
            int min = Math.min(next.length, i2);
            arrayList.add(new ByteArrayInputStream(next, 0, min));
            i = i2 - min;
            if (i == 0) {
                break;
            }
        }
        return new SequenceInputStream(Collections.enumeration(arrayList));
    }

    public synchronized byte[] toByteArray() {
        byte[] bArr;
        int i = 0;
        synchronized (this) {
            int i2 = this.count;
            if (i2 == 0) {
                bArr = EMPTY_BYTE_ARRAY;
            } else {
                byte[] bArr2 = new byte[i2];
                Iterator<byte[]> it = this.buffers.iterator();
                while (true) {
                    int i3 = i2;
                    int i4 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    byte[] next = it.next();
                    int min = Math.min(next.length, i3);
                    System.arraycopy(next, 0, bArr2, i4, min);
                    i = i4 + min;
                    i2 = i3 - min;
                    if (i2 == 0) {
                        break;
                    }
                }
                bArr = bArr2;
            }
        }
        return bArr;
    }

    public String toString() {
        return new String(toByteArray());
    }

    public String toString(String str) {
        return new String(toByteArray(), str);
    }
}
