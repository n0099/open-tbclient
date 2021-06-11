package h.l.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f71687b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<b> f71688a = new AtomicReference<>();

    public static a a() {
        return f71687b;
    }

    public b b() {
        if (this.f71688a.get() == null) {
            this.f71688a.compareAndSet(null, b.a());
        }
        return this.f71688a.get();
    }
}
