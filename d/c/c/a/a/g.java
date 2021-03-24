package d.c.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
/* loaded from: classes4.dex */
public abstract class g implements q {

    /* renamed from: e  reason: collision with root package name */
    public final q f65132e;

    public g(q qVar) {
        if (qVar != null) {
            this.f65132e = qVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // d.c.c.a.a.q
    public r a() {
        return this.f65132e.a();
    }

    @Override // d.c.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f65132e.close();
    }

    public final q n() {
        return this.f65132e;
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f65132e.toString() + SmallTailInfo.EMOTION_SUFFIX;
    }
}
