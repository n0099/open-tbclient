package h.l.b;

import android.os.Looper;
import h.g;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicReference<a> f68434b = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    public final g f68435a;

    public a() {
        g b2 = h.l.a.a.a().b().b();
        if (b2 != null) {
            this.f68435a = b2;
        } else {
            this.f68435a = new b(Looper.getMainLooper());
        }
    }

    public static a a() {
        a aVar;
        do {
            a aVar2 = f68434b.get();
            if (aVar2 != null) {
                return aVar2;
            }
            aVar = new a();
        } while (!f68434b.compareAndSet(null, aVar));
        return aVar;
    }

    public static g b() {
        return a().f68435a;
    }
}
