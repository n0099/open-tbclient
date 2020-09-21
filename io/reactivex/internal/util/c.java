package io.reactivex.internal.util;
/* loaded from: classes25.dex */
public final class c {
    public static void ejy() {
        if (io.reactivex.e.a.ejB()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.e.a.ejC()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
