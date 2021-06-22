package d.b.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class g implements q {

    /* renamed from: e  reason: collision with root package name */
    public final q f69000e;

    public g(q qVar) {
        if (qVar != null) {
            this.f69000e = qVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // d.b.c.a.a.q
    public r a() {
        return this.f69000e.a();
    }

    @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f69000e.close();
    }

    public final q n() {
        return this.f69000e;
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f69000e.toString() + SmallTailInfo.EMOTION_SUFFIX;
    }
}
