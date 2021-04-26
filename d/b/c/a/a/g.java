package d.b.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
/* loaded from: classes5.dex */
public abstract class g implements q {

    /* renamed from: e  reason: collision with root package name */
    public final q f64436e;

    public g(q qVar) {
        if (qVar != null) {
            this.f64436e = qVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // d.b.c.a.a.q
    public r a() {
        return this.f64436e.a();
    }

    @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f64436e.close();
    }

    public final q n() {
        return this.f64436e;
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f64436e.toString() + SmallTailInfo.EMOTION_SUFFIX;
    }
}
