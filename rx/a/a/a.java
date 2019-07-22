package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a kuC = new a();
    private final AtomicReference<b> kuD = new AtomicReference<>();

    public static a cPb() {
        return kuC;
    }

    a() {
    }

    public b cPc() {
        if (this.kuD.get() == null) {
            this.kuD.compareAndSet(null, b.cPd());
        }
        return this.kuD.get();
    }
}
