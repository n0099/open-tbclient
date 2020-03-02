package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class a {
    private static final a nNv = new a();
    private final AtomicReference<b> nNw = new AtomicReference<>();

    public static a dNY() {
        return nNv;
    }

    a() {
    }

    public b dNZ() {
        if (this.nNw.get() == null) {
            this.nNw.compareAndSet(null, b.dOa());
        }
        return this.nNw.get();
    }
}
