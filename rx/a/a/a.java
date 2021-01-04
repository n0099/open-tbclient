package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes15.dex */
public final class a {
    private static final a qqR = new a();
    private final AtomicReference<b> qqS = new AtomicReference<>();

    public static a eND() {
        return qqR;
    }

    a() {
    }

    public b eNE() {
        if (this.qqS.get() == null) {
            this.qqS.compareAndSet(null, b.eNF());
        }
        return this.qqS.get();
    }
}
