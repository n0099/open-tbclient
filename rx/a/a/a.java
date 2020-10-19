package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes16.dex */
public final class a {
    private static final a pcV = new a();
    private final AtomicReference<b> pcW = new AtomicReference<>();

    public static a erH() {
        return pcV;
    }

    a() {
    }

    public b erI() {
        if (this.pcW.get() == null) {
            this.pcW.compareAndSet(null, b.erJ());
        }
        return this.pcW.get();
    }
}
