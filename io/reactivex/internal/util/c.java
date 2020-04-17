package io.reactivex.internal.util;
/* loaded from: classes7.dex */
public final class c {
    public static void dDe() {
        if (io.reactivex.e.a.dDh()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.e.a.dDi()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
