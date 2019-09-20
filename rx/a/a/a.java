package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a kyb = new a();
    private final AtomicReference<b> kyc = new AtomicReference<>();

    public static a cQi() {
        return kyb;
    }

    a() {
    }

    public b cQj() {
        if (this.kyc.get() == null) {
            this.kyc.compareAndSet(null, b.cQk());
        }
        return this.kyc.get();
    }
}
