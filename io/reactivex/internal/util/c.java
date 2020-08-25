package io.reactivex.internal.util;
/* loaded from: classes7.dex */
public final class c {
    public static void efs() {
        if (io.reactivex.e.a.efv()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.e.a.efw()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
