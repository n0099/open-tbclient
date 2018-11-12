package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a itY = new a();
    private final AtomicReference<b> itZ = new AtomicReference<>();

    public static a caR() {
        return itY;
    }

    a() {
    }

    public b caS() {
        if (this.itZ.get() == null) {
            this.itZ.compareAndSet(null, b.caT());
        }
        return this.itZ.get();
    }
}
