package io.reactivex.internal.subscriptions;

import io.reactivex.e.a;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes25.dex */
public enum SubscriptionHelper implements d {
    CANCELLED;

    @Override // org.a.d
    public void request(long j) {
    }

    @Override // org.a.d
    public void cancel() {
    }

    public static boolean validate(d dVar, d dVar2) {
        if (dVar2 == null) {
            a.onError(new NullPointerException("next is null"));
            return false;
        } else if (dVar != null) {
            dVar2.cancel();
            reportSubscriptionSet();
            return false;
        } else {
            return true;
        }
    }

    public static void reportSubscriptionSet() {
        a.onError(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean validate(long j) {
        if (j <= 0) {
            a.onError(new IllegalArgumentException("n > 0 required but it was " + j));
            return false;
        }
        return true;
    }

    public static void reportMoreProduced(long j) {
        a.onError(new ProtocolViolationException("More produced than requested: " + j));
    }

    public static boolean isCancelled(d dVar) {
        return dVar == CANCELLED;
    }

    public static boolean set(AtomicReference<d> atomicReference, d dVar) {
        d dVar2;
        do {
            dVar2 = atomicReference.get();
            if (dVar2 == CANCELLED) {
                if (dVar != null) {
                    dVar.cancel();
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(dVar2, dVar));
        if (dVar2 != null) {
            dVar2.cancel();
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<d> atomicReference, d dVar) {
        io.reactivex.internal.functions.a.k(dVar, "s is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() != CANCELLED) {
            reportSubscriptionSet();
        }
        return false;
    }

    public static boolean replace(AtomicReference<d> atomicReference, d dVar) {
        d dVar2;
        do {
            dVar2 = atomicReference.get();
            if (dVar2 == CANCELLED) {
                if (dVar != null) {
                    dVar.cancel();
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(dVar2, dVar));
        return true;
    }

    public static boolean cancel(AtomicReference<d> atomicReference) {
        d andSet;
        if (atomicReference.get() == CANCELLED || (andSet = atomicReference.getAndSet(CANCELLED)) == CANCELLED) {
            return false;
        }
        if (andSet != null) {
            andSet.cancel();
        }
        return true;
    }

    public static boolean deferredSetOnce(AtomicReference<d> atomicReference, AtomicLong atomicLong, d dVar) {
        if (setOnce(atomicReference, dVar)) {
            long andSet = atomicLong.getAndSet(0L);
            if (andSet != 0) {
                dVar.request(andSet);
            }
            return true;
        }
        return false;
    }

    public static void deferredRequest(AtomicReference<d> atomicReference, AtomicLong atomicLong, long j) {
        d dVar = atomicReference.get();
        if (dVar != null) {
            dVar.request(j);
        } else if (validate(j)) {
            b.a(atomicLong, j);
            d dVar2 = atomicReference.get();
            if (dVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    dVar2.request(andSet);
                }
            }
        }
    }
}
