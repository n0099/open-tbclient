package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes9.dex */
public final class InflaterSource implements Source {
    public int bufferBytesHeldByInflater;
    public boolean closed;
    public final Inflater inflater;
    public final BufferedSource source;

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource != null) {
            if (inflater != null) {
                this.source = bufferedSource;
                this.inflater = inflater;
                return;
            }
            throw new IllegalArgumentException("inflater == null");
        }
        throw new IllegalArgumentException("source == null");
    }

    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.buffer(source), inflater);
    }

    private void releaseInflatedBytes() throws IOException {
        int i = this.bufferBytesHeldByInflater;
        if (i == 0) {
            return;
        }
        int remaining = i - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        Segment writableSegment;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (!this.closed) {
                if (i == 0) {
                    return 0L;
                }
                while (true) {
                    boolean refill = refill();
                    try {
                        writableSegment = buffer.writableSegment(1);
                        int inflate = this.inflater.inflate(writableSegment.data, writableSegment.limit, (int) Math.min(j, 8192 - writableSegment.limit));
                        if (inflate > 0) {
                            writableSegment.limit += inflate;
                            long j2 = inflate;
                            buffer.size += j2;
                            return j2;
                        } else if (this.inflater.finished() || this.inflater.needsDictionary()) {
                            break;
                        } else if (refill) {
                            throw new EOFException("source exhausted prematurely");
                        }
                    } catch (DataFormatException e) {
                        throw new IOException(e);
                    }
                }
                releaseInflatedBytes();
                if (writableSegment.pos == writableSegment.limit) {
                    buffer.head = writableSegment.pop();
                    SegmentPool.recycle(writableSegment);
                    return -1L;
                }
                return -1L;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        releaseInflatedBytes();
        if (this.inflater.getRemaining() == 0) {
            if (this.source.exhausted()) {
                return true;
            }
            Segment segment = this.source.buffer().head;
            int i = segment.limit;
            int i2 = segment.pos;
            int i3 = i - i2;
            this.bufferBytesHeldByInflater = i3;
            this.inflater.setInput(segment.data, i2, i3);
            return false;
        }
        throw new IllegalStateException("?");
    }
}
