package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a kxS = new a();
    private final AtomicReference<b> kxT = new AtomicReference<>();

    public static a cOm() {
        return kxS;
    }

    a() {
    }

    public b cOn() {
        if (this.kxT.get() == null) {
            this.kxT.compareAndSet(null, b.cOo());
        }
        return this.kxT.get();
    }
}
