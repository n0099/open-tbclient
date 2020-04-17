package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class a {
    private static final a niZ = new a();
    private final AtomicReference<b> nja = new AtomicReference<>();

    public static a dHz() {
        return niZ;
    }

    a() {
    }

    public b dHA() {
        if (this.nja.get() == null) {
            this.nja.compareAndSet(null, b.dHB());
        }
        return this.nja.get();
    }
}
