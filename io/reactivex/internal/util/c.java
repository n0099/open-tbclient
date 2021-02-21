package io.reactivex.internal.util;
/* loaded from: classes5.dex */
public final class c {
    public static void eKL() {
        if (io.reactivex.d.a.eKO()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.d.a.eKP()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
