package io.reactivex.internal.util;
/* loaded from: classes7.dex */
public final class c {
    public static void dPP() {
        if (io.reactivex.e.a.dPS()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.e.a.dPT()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
