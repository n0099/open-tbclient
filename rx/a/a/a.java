package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a kvI = new a();
    private final AtomicReference<b> kvJ = new AtomicReference<>();

    public static a cPw() {
        return kvI;
    }

    a() {
    }

    public b cPx() {
        if (this.kvJ.get() == null) {
            this.kvJ.compareAndSet(null, b.cPy());
        }
        return this.kvJ.get();
    }
}
