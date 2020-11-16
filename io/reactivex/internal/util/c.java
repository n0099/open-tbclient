package io.reactivex.internal.util;
/* loaded from: classes5.dex */
public final class c {
    public static void eAZ() {
        if (io.reactivex.e.a.eBc()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.e.a.eBd()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
