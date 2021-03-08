package io.reactivex.internal.util;
/* loaded from: classes6.dex */
public final class c {
    public static void eKt() {
        if (io.reactivex.d.a.eKw()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.d.a.eKx()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
