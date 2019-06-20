package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a knd = new a();
    private final AtomicReference<b> kne = new AtomicReference<>();

    public static a cLm() {
        return knd;
    }

    a() {
    }

    public b cLn() {
        if (this.kne.get() == null) {
            this.kne.compareAndSet(null, b.cLo());
        }
        return this.kne.get();
    }
}
