package io.reactivex.internal.util;
/* loaded from: classes7.dex */
public final class c {
    public static void dPT() {
        if (io.reactivex.e.a.dPW()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.e.a.dPX()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
