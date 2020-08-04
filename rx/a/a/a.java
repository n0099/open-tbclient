package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class a {
    private static final a ojM = new a();
    private final AtomicReference<b> ojN = new AtomicReference<>();

    public static a dXL() {
        return ojM;
    }

    a() {
    }

    public b dXM() {
        if (this.ojN.get() == null) {
            this.ojN.compareAndSet(null, b.dXN());
        }
        return this.ojN.get();
    }
}
