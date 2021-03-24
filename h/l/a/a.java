package h.l.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f67687b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<b> f67688a = new AtomicReference<>();

    public static a a() {
        return f67687b;
    }

    public b b() {
        if (this.f67688a.get() == null) {
            this.f67688a.compareAndSet(null, b.a());
        }
        return this.f67688a.get();
    }
}
