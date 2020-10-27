package io.reactivex.internal.util;
/* loaded from: classes17.dex */
public final class c {
    public static void exj() {
        if (io.reactivex.e.a.exm()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.e.a.exn()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
