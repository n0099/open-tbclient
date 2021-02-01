package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class a {
    private static final a qyb = new a();
    private final AtomicReference<b> qyc = new AtomicReference<>();

    public static a eMH() {
        return qyb;
    }

    a() {
    }

    public b eMI() {
        if (this.qyc.get() == null) {
            this.qyc.compareAndSet(null, b.eMJ());
        }
        return this.qyc.get();
    }
}
