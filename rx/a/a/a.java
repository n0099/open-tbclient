package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes16.dex */
public final class a {
    private static final a pUo = new a();
    private final AtomicReference<b> pUp = new AtomicReference<>();

    public static a eBF() {
        return pUo;
    }

    a() {
    }

    public b eBG() {
        if (this.pUp.get() == null) {
            this.pUp.compareAndSet(null, b.eBH());
        }
        return this.pUp.get();
    }
}
