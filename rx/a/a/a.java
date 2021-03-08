package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class a {
    private static final a qzd = new a();
    private final AtomicReference<b> qze = new AtomicReference<>();

    public static a eMx() {
        return qzd;
    }

    a() {
    }

    public b eMy() {
        if (this.qze.get() == null) {
            this.qze.compareAndSet(null, b.eMz());
        }
        return this.qze.get();
    }
}
