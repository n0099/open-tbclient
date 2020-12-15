package io.reactivex.internal.util;
/* loaded from: classes9.dex */
public final class c {
    public static void eDr() {
        if (io.reactivex.d.a.eDu()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.d.a.eDv()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
