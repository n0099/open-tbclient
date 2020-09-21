package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a {
    private static final a oNF = new a();
    private final AtomicReference<b> oNG = new AtomicReference<>();

    public static a enV() {
        return oNF;
    }

    a() {
    }

    public b enW() {
        if (this.oNG.get() == null) {
            this.oNG.compareAndSet(null, b.enX());
        }
        return this.oNG.get();
    }
}
