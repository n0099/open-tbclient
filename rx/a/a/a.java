package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a kyJ = new a();
    private final AtomicReference<b> kyK = new AtomicReference<>();

    public static a cOo() {
        return kyJ;
    }

    a() {
    }

    public b cOp() {
        if (this.kyK.get() == null) {
            this.kyK.compareAndSet(null, b.cOq());
        }
        return this.kyK.get();
    }
}
