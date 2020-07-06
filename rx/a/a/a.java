package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class a {
    private static final a oba = new a();
    private final AtomicReference<b> obb = new AtomicReference<>();

    public static a dUo() {
        return oba;
    }

    a() {
    }

    public b dUp() {
        if (this.obb.get() == null) {
            this.obb.compareAndSet(null, b.dUq());
        }
        return this.obb.get();
    }
}
