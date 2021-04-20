package d.c.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
/* loaded from: classes5.dex */
public abstract class f implements p {

    /* renamed from: e  reason: collision with root package name */
    public final p f65977e;

    public f(p pVar) {
        if (pVar != null) {
            this.f65977e = pVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // d.c.c.a.a.p
    public r a() {
        return this.f65977e.a();
    }

    @Override // d.c.c.a.a.p
    public void b(c cVar, long j) throws IOException {
        this.f65977e.b(cVar, j);
    }

    @Override // d.c.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f65977e.close();
    }

    @Override // d.c.c.a.a.p, java.io.Flushable
    public void flush() throws IOException {
        this.f65977e.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f65977e.toString() + SmallTailInfo.EMOTION_SUFFIX;
    }
}
