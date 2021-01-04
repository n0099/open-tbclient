package io.reactivex.internal.disposables;

import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public enum DisposableHelper implements io.reactivex.disposables.b {
    DISPOSED;

    public static boolean isDisposed(io.reactivex.disposables.b bVar) {
        return bVar == DISPOSED;
    }

    public static boolean set(AtomicReference<io.reactivex.disposables.b> atomicReference, io.reactivex.disposables.b bVar) {
        io.reactivex.disposables.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.dispose();
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        if (bVar2 != null) {
            bVar2.dispose();
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<io.reactivex.disposables.b> atomicReference, io.reactivex.disposables.b bVar) {
        io.reactivex.internal.functions.a.m(bVar, "d is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() != DISPOSED) {
            reportDisposableSet();
        }
        return false;
    }

    public static boolean replace(AtomicReference<io.reactivex.disposables.b> atomicReference, io.reactivex.disposables.b bVar) {
        io.reactivex.disposables.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.dispose();
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        return true;
    }

    public static boolean dispose(AtomicReference<io.reactivex.disposables.b> atomicReference) {
        io.reactivex.disposables.b andSet;
        io.reactivex.disposables.b bVar = atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (bVar == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (andSet != null) {
            andSet.dispose();
        }
        return true;
    }

    public static boolean validate(io.reactivex.disposables.b bVar, io.reactivex.disposables.b bVar2) {
        if (bVar2 == null) {
            io.reactivex.d.a.onError(new NullPointerException("next is null"));
            return false;
        } else if (bVar != null) {
            bVar2.dispose();
            reportDisposableSet();
            return false;
        } else {
            return true;
        }
    }

    public static void reportDisposableSet() {
        io.reactivex.d.a.onError(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean trySet(AtomicReference<io.reactivex.disposables.b> atomicReference, io.reactivex.disposables.b bVar) {
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        if (atomicReference.get() == DISPOSED) {
            bVar.dispose();
        }
        return false;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return true;
    }
}
