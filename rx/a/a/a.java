package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class a {
    private static final a nME = new a();
    private final AtomicReference<b> nMF = new AtomicReference<>();

    public static a dMJ() {
        return nME;
    }

    a() {
    }

    public b dMK() {
        if (this.nMF.get() == null) {
            this.nMF.compareAndSet(null, b.dML());
        }
        return this.nMF.get();
    }
}
