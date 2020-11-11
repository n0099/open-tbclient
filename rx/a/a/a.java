package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes16.dex */
public final class a {
    private static final a qdI = new a();
    private final AtomicReference<b> qdJ = new AtomicReference<>();

    public static a eFu() {
        return qdI;
    }

    a() {
    }

    public b eFv() {
        if (this.qdJ.get() == null) {
            this.qdJ.compareAndSet(null, b.eFw());
        }
        return this.qdJ.get();
    }
}
