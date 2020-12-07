package io.reactivex.internal.util;
/* loaded from: classes9.dex */
public final class c {
    public static void eDq() {
        if (io.reactivex.d.a.eDt()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.d.a.eDu()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
