package okio;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
/* loaded from: classes8.dex */
public abstract class ForwardingSource implements Source {
    public final Source delegate;

    public ForwardingSource(Source source) {
        if (source != null) {
            this.delegate = source;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final Source delegate() {
        return this.delegate;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        return this.delegate.read(buffer, j);
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + SmallTailInfo.EMOTION_SUFFIX;
    }
}
