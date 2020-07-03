package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class a {
    private static final a oaX = new a();
    private final AtomicReference<b> oaY = new AtomicReference<>();

    public static a dUk() {
        return oaX;
    }

    a() {
    }

    public b dUl() {
        if (this.oaY.get() == null) {
            this.oaY.compareAndSet(null, b.dUm());
        }
        return this.oaY.get();
    }
}
