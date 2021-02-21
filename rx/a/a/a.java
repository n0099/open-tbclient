package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class a {
    private static final a qyB = new a();
    private final AtomicReference<b> qyC = new AtomicReference<>();

    public static a eMP() {
        return qyB;
    }

    a() {
    }

    public b eMQ() {
        if (this.qyC.get() == null) {
            this.qyC.compareAndSet(null, b.eMR());
        }
        return this.qyC.get();
    }
}
