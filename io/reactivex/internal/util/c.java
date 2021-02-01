package io.reactivex.internal.util;
/* loaded from: classes5.dex */
public final class c {
    public static void eKD() {
        if (io.reactivex.d.a.eKG()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.d.a.eKH()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
