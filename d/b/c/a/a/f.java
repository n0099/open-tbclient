package d.b.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
/* loaded from: classes5.dex */
public abstract class f implements p {

    /* renamed from: e  reason: collision with root package name */
    public final p f64435e;

    public f(p pVar) {
        if (pVar != null) {
            this.f64435e = pVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // d.b.c.a.a.p
    public r a() {
        return this.f64435e.a();
    }

    @Override // d.b.c.a.a.p
    public void b(c cVar, long j) throws IOException {
        this.f64435e.b(cVar, j);
    }

    @Override // d.b.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f64435e.close();
    }

    @Override // d.b.c.a.a.p, java.io.Flushable
    public void flush() throws IOException {
        this.f64435e.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f64435e.toString() + SmallTailInfo.EMOTION_SUFFIX;
    }
}
