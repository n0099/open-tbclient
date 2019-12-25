package io.reactivex.internal.util;
/* loaded from: classes4.dex */
public final class c {
    public static void dEj() {
        if (io.reactivex.d.a.dEm()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.d.a.dEn()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
