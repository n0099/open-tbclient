package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes12.dex */
public final class a {
    private static final a pPn = new a();
    private final AtomicReference<b> pPo = new AtomicReference<>();

    public static a eFu() {
        return pPn;
    }

    a() {
    }

    public b eFv() {
        if (this.pPo.get() == null) {
            this.pPo.compareAndSet(null, b.eFw());
        }
        return this.pPo.get();
    }
}
