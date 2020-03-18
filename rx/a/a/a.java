package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class a {
    private static final a nPt = new a();
    private final AtomicReference<b> nPu = new AtomicReference<>();

    public static a dOz() {
        return nPt;
    }

    a() {
    }

    public b dOA() {
        if (this.nPu.get() == null) {
            this.nPu.compareAndSet(null, b.dOB());
        }
        return this.nPu.get();
    }
}
