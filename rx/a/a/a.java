package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a jUI = new a();
    private final AtomicReference<b> jUJ = new AtomicReference<>();

    public static a cDF() {
        return jUI;
    }

    a() {
    }

    public b cDG() {
        if (this.jUJ.get() == null) {
            this.jUJ.compareAndSet(null, b.cDH());
        }
        return this.jUJ.get();
    }
}
