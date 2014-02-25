package org.apache.commons.io.input;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
/* loaded from: classes.dex */
public class CharSequenceInputStream extends InputStream {
    private final ByteBuffer bbuf;
    private final CharBuffer cbuf;
    private final CharsetEncoder encoder;
    private int mark;

    public CharSequenceInputStream(CharSequence charSequence, Charset charset, int i) {
        this.encoder = charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        this.bbuf = ByteBuffer.allocate(i);
        this.bbuf.flip();
        this.cbuf = CharBuffer.wrap(charSequence);
        this.mark = -1;
    }

    public CharSequenceInputStream(CharSequence charSequence, String str, int i) {
        this(charSequence, Charset.forName(str), i);
    }

    public CharSequenceInputStream(CharSequence charSequence, Charset charset) {
        this(charSequence, charset, 2048);
    }

    public CharSequenceInputStream(CharSequence charSequence, String str) {
        this(charSequence, str, 2048);
    }

    private void fillBuffer() {
        this.bbuf.compact();
        CoderResult encode = this.encoder.encode(this.cbuf, this.bbuf, true);
        if (encode.isError()) {
            encode.throwException();
        }
        this.bbuf.flip();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (bArr == null) {
            throw new NullPointerException("Byte array is null");
        }
        if (i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException("Array Size=" + bArr.length + ", offset=" + i + ", length=" + i2);
        }
        if (i2 == 0) {
            return 0;
        }
        if (this.bbuf.hasRemaining() || this.cbuf.hasRemaining()) {
            while (i2 > 0) {
                if (this.bbuf.hasRemaining()) {
                    int min = Math.min(this.bbuf.remaining(), i2);
                    this.bbuf.get(bArr, i, min);
                    i += min;
                    i2 -= min;
                    i3 += min;
                } else {
                    fillBuffer();
                    if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
                        break;
                    }
                }
            }
            if (i3 != 0 || this.cbuf.hasRemaining()) {
                return i3;
            }
            return -1;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read() {
        while (!this.bbuf.hasRemaining()) {
            fillBuffer();
            if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
                return -1;
            }
        }
        return this.bbuf.get() & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        int i = 0;
        while (j > 0 && this.cbuf.hasRemaining()) {
            this.cbuf.get();
            j--;
            i++;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.cbuf.remaining();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.mark = this.cbuf.position();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        if (this.mark != -1) {
            this.cbuf.position(this.mark);
            this.mark = -1;
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }
}
