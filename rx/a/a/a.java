package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class a {
    private static final a ojK = new a();
    private final AtomicReference<b> ojL = new AtomicReference<>();

    public static a dXK() {
        return ojK;
    }

    a() {
    }

    public b dXL() {
        if (this.ojL.get() == null) {
            this.ojL.compareAndSet(null, b.dXM());
        }
        return this.ojL.get();
    }
}
