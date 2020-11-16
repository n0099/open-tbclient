package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes14.dex */
public final class a {
    private static final a qfl = new a();
    private final AtomicReference<b> qfm = new AtomicReference<>();

    public static a eFv() {
        return qfl;
    }

    a() {
    }

    public b eFw() {
        if (this.qfm.get() == null) {
            this.qfm.compareAndSet(null, b.eFx());
        }
        return this.qfm.get();
    }
}
