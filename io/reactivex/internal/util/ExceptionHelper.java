package io.reactivex.internal.util;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ExceptionHelper {
    public static final Throwable TERMINATED = new Termination();

    public static RuntimeException L(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
    }

    public static <T> boolean addThrowable(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        do {
            th2 = atomicReference.get();
            if (th2 == TERMINATED) {
                return false;
            }
        } while (!atomicReference.compareAndSet(th2, th2 == null ? th : new CompositeException(th2, th)));
        return true;
    }

    public static <T> Throwable terminate(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        if (th != TERMINATED) {
            return atomicReference.getAndSet(TERMINATED);
        }
        return th;
    }

    public static <E extends Throwable> Exception M(Throwable th) throws Throwable {
        if (th instanceof Exception) {
            return (Exception) th;
        }
        throw th;
    }

    /* loaded from: classes7.dex */
    static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        Termination() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }
}
