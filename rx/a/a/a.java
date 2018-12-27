package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a iEr = new a();
    private final AtomicReference<b> iEs = new AtomicReference<>();

    public static a cdK() {
        return iEr;
    }

    a() {
    }

    public b cdL() {
        if (this.iEs.get() == null) {
            this.iEs.compareAndSet(null, b.cdM());
        }
        return this.iEs.get();
    }
}
