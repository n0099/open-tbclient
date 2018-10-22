package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a iso = new a();
    private final AtomicReference<b> isp = new AtomicReference<>();

    public static a cbu() {
        return iso;
    }

    a() {
    }

    public b cbv() {
        if (this.isp.get() == null) {
            this.isp.compareAndSet(null, b.cbw());
        }
        return this.isp.get();
    }
}
