package h.l.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f68845b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<b> f68846a = new AtomicReference<>();

    public static a a() {
        return f68845b;
    }

    public b b() {
        if (this.f68846a.get() == null) {
            this.f68846a.compareAndSet(null, b.a());
        }
        return this.f68846a.get();
    }
}
