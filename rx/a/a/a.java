package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a isn = new a();
    private final AtomicReference<b> iso = new AtomicReference<>();

    public static a cbu() {
        return isn;
    }

    a() {
    }

    public b cbv() {
        if (this.iso.get() == null) {
            this.iso.compareAndSet(null, b.cbw());
        }
        return this.iso.get();
    }
}
