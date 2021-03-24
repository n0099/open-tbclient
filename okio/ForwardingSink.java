package okio;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
/* loaded from: classes.dex */
public abstract class ForwardingSink implements Sink {
    public final Sink delegate;

    public ForwardingSink(Sink sink) {
        if (sink != null) {
            this.delegate = sink;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final Sink delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        this.delegate.write(buffer, j);
    }
}
