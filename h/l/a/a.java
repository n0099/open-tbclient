package h.l.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f71791b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<b> f71792a = new AtomicReference<>();

    public static a a() {
        return f71791b;
    }

    public b b() {
        if (this.f71792a.get() == null) {
            this.f71792a.compareAndSet(null, b.a());
        }
        return this.f71792a.get();
    }
}
