package h.l.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f67708b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<b> f67709a = new AtomicReference<>();

    public static a a() {
        return f67708b;
    }

    public b b() {
        if (this.f67709a.get() == null) {
            this.f67709a.compareAndSet(null, b.a());
        }
        return this.f67709a.get();
    }
}
