package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes12.dex */
public final class a {
    private static final a pPp = new a();
    private final AtomicReference<b> pPq = new AtomicReference<>();

    public static a eFv() {
        return pPp;
    }

    a() {
    }

    public b eFw() {
        if (this.pPq.get() == null) {
            this.pPq.compareAndSet(null, b.eFx());
        }
        return this.pPq.get();
    }
}
