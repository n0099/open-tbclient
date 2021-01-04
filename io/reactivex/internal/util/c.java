package io.reactivex.internal.util;
/* loaded from: classes3.dex */
public final class c {
    public static void eLz() {
        if (io.reactivex.d.a.eLC()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.d.a.eLD()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
