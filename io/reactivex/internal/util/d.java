package io.reactivex.internal.util;

import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class d {
    public static boolean a(AtomicReference<io.reactivex.disposables.b> atomicReference, io.reactivex.disposables.b bVar, Class<?> cls) {
        io.reactivex.internal.functions.a.n(bVar, "next is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() != DisposableHelper.DISPOSED) {
            F(cls);
        }
        return false;
    }

    public static boolean a(AtomicReference<org.a.d> atomicReference, org.a.d dVar, Class<?> cls) {
        io.reactivex.internal.functions.a.n(dVar, "next is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() != SubscriptionHelper.CANCELLED) {
            F(cls);
        }
        return false;
    }

    public static String acp(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void F(Class<?> cls) {
        io.reactivex.d.a.onError(new ProtocolViolationException(acp(cls.getName())));
    }
}
