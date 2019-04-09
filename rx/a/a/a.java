package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a jUJ = new a();
    private final AtomicReference<b> jUK = new AtomicReference<>();

    public static a cDF() {
        return jUJ;
    }

    a() {
    }

    public b cDG() {
        if (this.jUK.get() == null) {
            this.jUK.compareAndSet(null, b.cDH());
        }
        return this.jUK.get();
    }
}
