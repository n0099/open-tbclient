package h.l.b;

import android.os.Looper;
import h.g;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicReference<a> f67711b = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    public final g f67712a;

    public a() {
        g b2 = h.l.a.a.a().b().b();
        if (b2 != null) {
            this.f67712a = b2;
        } else {
            this.f67712a = new b(Looper.getMainLooper());
        }
    }

    public static a a() {
        a aVar;
        do {
            a aVar2 = f67711b.get();
            if (aVar2 != null) {
                return aVar2;
            }
            aVar = new a();
        } while (!f67711b.compareAndSet(null, aVar));
        return aVar;
    }

    public static g b() {
        return a().f67712a;
    }
}
