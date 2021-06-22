package h.l.b;

import android.os.Looper;
import h.g;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicReference<a> f71794b = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    public final g f71795a;

    public a() {
        g b2 = h.l.a.a.a().b().b();
        if (b2 != null) {
            this.f71795a = b2;
        } else {
            this.f71795a = new b(Looper.getMainLooper());
        }
    }

    public static a a() {
        a aVar;
        do {
            a aVar2 = f71794b.get();
            if (aVar2 != null) {
                return aVar2;
            }
            aVar = new a();
        } while (!f71794b.compareAndSet(null, aVar));
        return aVar;
    }

    public static g b() {
        return a().f71795a;
    }
}
