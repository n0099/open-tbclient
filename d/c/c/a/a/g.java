package d.c.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
/* loaded from: classes5.dex */
public abstract class g implements q {

    /* renamed from: e  reason: collision with root package name */
    public final q f65133e;

    public g(q qVar) {
        if (qVar != null) {
            this.f65133e = qVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // d.c.c.a.a.q
    public r a() {
        return this.f65133e.a();
    }

    @Override // d.c.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f65133e.close();
    }

    public final q n() {
        return this.f65133e;
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f65133e.toString() + SmallTailInfo.EMOTION_SUFFIX;
    }
}
