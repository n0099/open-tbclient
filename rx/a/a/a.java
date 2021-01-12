package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes14.dex */
public final class a {
    private static final a qnX = new a();
    private final AtomicReference<b> qnY = new AtomicReference<>();

    public static a eKr() {
        return qnX;
    }

    a() {
    }

    public b eKs() {
        if (this.qnY.get() == null) {
            this.qnY.compareAndSet(null, b.eKt());
        }
        return this.qnY.get();
    }
}
