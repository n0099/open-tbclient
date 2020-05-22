package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class a {
    private static final a nEc = new a();
    private final AtomicReference<b> nEd = new AtomicReference<>();

    public static a dPq() {
        return nEc;
    }

    a() {
    }

    public b dPr() {
        if (this.nEd.get() == null) {
            this.nEd.compareAndSet(null, b.dPs());
        }
        return this.nEd.get();
    }
}
