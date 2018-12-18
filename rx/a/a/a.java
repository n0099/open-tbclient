package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a iBh = new a();
    private final AtomicReference<b> iBi = new AtomicReference<>();

    public static a ccT() {
        return iBh;
    }

    a() {
    }

    public b ccU() {
        if (this.iBi.get() == null) {
            this.iBi.compareAndSet(null, b.ccV());
        }
        return this.iBi.get();
    }
}
