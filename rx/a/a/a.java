package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class a {
    private static final a ndA = new a();
    private final AtomicReference<b> ndB = new AtomicReference<>();

    public static a dGg() {
        return ndA;
    }

    a() {
    }

    public b dGh() {
        if (this.ndB.get() == null) {
            this.ndB.compareAndSet(null, b.dGi());
        }
        return this.ndB.get();
    }
}
