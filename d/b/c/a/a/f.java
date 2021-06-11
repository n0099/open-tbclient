package d.b.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class f implements p {

    /* renamed from: e  reason: collision with root package name */
    public final p f68895e;

    public f(p pVar) {
        if (pVar != null) {
            this.f68895e = pVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // d.b.c.a.a.p
    public r a() {
        return this.f68895e.a();
    }

    @Override // d.b.c.a.a.p
    public void b(c cVar, long j) throws IOException {
        this.f68895e.b(cVar, j);
    }

    @Override // d.b.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f68895e.close();
    }

    @Override // d.b.c.a.a.p, java.io.Flushable
    public void flush() throws IOException {
        this.f68895e.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f68895e.toString() + SmallTailInfo.EMOTION_SUFFIX;
    }
}
