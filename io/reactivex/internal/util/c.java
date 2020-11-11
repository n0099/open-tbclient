package io.reactivex.internal.util;
/* loaded from: classes17.dex */
public final class c {
    public static void eAY() {
        if (io.reactivex.e.a.eBb()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.e.a.eBc()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
