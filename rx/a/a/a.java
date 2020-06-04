package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class a {
    private static final a nFm = new a();
    private final AtomicReference<b> nFn = new AtomicReference<>();

    public static a dPE() {
        return nFm;
    }

    a() {
    }

    public b dPF() {
        if (this.nFn.get() == null) {
            this.nFn.compareAndSet(null, b.dPG());
        }
        return this.nFn.get();
    }
}
