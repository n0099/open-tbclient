package okio;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* loaded from: classes8.dex */
public final class RealBufferedSink implements BufferedSink {
    public final Buffer buffer = new Buffer();
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        if (sink != null) {
            this.sink = sink;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // okio.BufferedSink
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        Throwable th = null;
        try {
            if (this.buffer.size > 0) {
                this.sink.write(this.buffer, this.buffer.size);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() throws IOException {
        if (!this.closed) {
            long size = this.buffer.size();
            if (size > 0) {
                this.sink.write(this.buffer, size);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink emitCompleteSegments() throws IOException {
        if (!this.closed) {
            long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                this.sink.write(this.buffer, completeSegmentByteCount);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (!this.closed) {
            Buffer buffer = this.buffer;
            long j = buffer.size;
            if (j > 0) {
                this.sink.write(buffer, j);
            }
            this.sink.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.RealBufferedSink.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                RealBufferedSink.this.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    return;
                }
                realBufferedSink.flush();
            }

            public String toString() {
                return RealBufferedSink.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i2) throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (!realBufferedSink.closed) {
                    realBufferedSink.buffer.writeByte((int) ((byte) i2));
                    RealBufferedSink.this.emitCompleteSegments();
                    return;
                }
                throw new IOException("closed");
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (!realBufferedSink.closed) {
                    realBufferedSink.buffer.write(bArr, i2, i3);
                    RealBufferedSink.this.emitCompleteSegments();
                    return;
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        if (!this.closed) {
            this.buffer.write(buffer, j);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this.buffer, 8192L);
            if (read == -1) {
                return j;
            }
            j += read;
            emitCompleteSegments();
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink writeByte(int i2) throws IOException {
        if (!this.closed) {
            this.buffer.writeByte(i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeDecimalLong(long j) throws IOException {
        if (!this.closed) {
            this.buffer.writeDecimalLong(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeHexadecimalUnsignedLong(long j) throws IOException {
        if (!this.closed) {
            this.buffer.writeHexadecimalUnsignedLong(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeInt(int i2) throws IOException {
        if (!this.closed) {
            this.buffer.writeInt(i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeIntLe(int i2) throws IOException {
        if (!this.closed) {
            this.buffer.writeIntLe(i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeLong(long j) throws IOException {
        if (!this.closed) {
            this.buffer.writeLong(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeLongLe(long j) throws IOException {
        if (!this.closed) {
            this.buffer.writeLongLe(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShort(int i2) throws IOException {
        if (!this.closed) {
            this.buffer.writeShort(i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShortLe(int i2) throws IOException {
        if (!this.closed) {
            this.buffer.writeShortLe(i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeString(String str, Charset charset) throws IOException {
        if (!this.closed) {
            this.buffer.writeString(str, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String str) throws IOException {
        if (!this.closed) {
            this.buffer.writeUtf8(str);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8CodePoint(int i2) throws IOException {
        if (!this.closed) {
            this.buffer.writeUtf8CodePoint(i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(ByteString byteString) throws IOException {
        if (!this.closed) {
            this.buffer.write(byteString);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeString(String str, int i2, int i3, Charset charset) throws IOException {
        if (!this.closed) {
            this.buffer.writeString(str, i2, i3, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String str, int i2, int i3) throws IOException {
        if (!this.closed) {
            this.buffer.writeUtf8(str, i2, i3);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr) throws IOException {
        if (!this.closed) {
            this.buffer.write(bArr);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.closed) {
            this.buffer.write(bArr, i2, i3);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.closed) {
            int write = this.buffer.write(byteBuffer);
            emitCompleteSegments();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long read = source.read(this.buffer, j);
            if (read != -1) {
                j -= read;
                emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }
}
