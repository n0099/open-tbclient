package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes14.dex */
public final class a {
    private static final a qnY = new a();
    private final AtomicReference<b> qnZ = new AtomicReference<>();

    public static a eKr() {
        return qnY;
    }

    a() {
    }

    public b eKs() {
        if (this.qnZ.get() == null) {
            this.qnZ.compareAndSet(null, b.eKt());
        }
        return this.qnZ.get();
    }
}
