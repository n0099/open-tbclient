package f.b.x.i;

import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class d {
    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void b(Class<?> cls) {
        f.b.a0.a.f(new ProtocolViolationException(a(cls.getName())));
    }

    public static boolean c(AtomicReference<f.b.t.b> atomicReference, f.b.t.b bVar, Class<?> cls) {
        f.b.x.b.a.b(bVar, "next is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() != DisposableHelper.DISPOSED) {
            b(cls);
            return false;
        }
        return false;
    }

    public static boolean d(AtomicReference<g.d.d> atomicReference, g.d.d dVar, Class<?> cls) {
        f.b.x.b.a.b(dVar, "next is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() != SubscriptionHelper.CANCELLED) {
            b(cls);
            return false;
        }
        return false;
    }
}
