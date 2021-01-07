package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes15.dex */
public final class a {
    private static final a qsz = new a();
    private final AtomicReference<b> qsA = new AtomicReference<>();

    public static a eOh() {
        return qsz;
    }

    a() {
    }

    public b eOi() {
        if (this.qsA.get() == null) {
            this.qsA.compareAndSet(null, b.eOj());
        }
        return this.qsA.get();
    }
}
