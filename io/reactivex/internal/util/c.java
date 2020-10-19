package io.reactivex.internal.util;
/* loaded from: classes17.dex */
public final class c {
    public static void enk() {
        if (io.reactivex.e.a.enn()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.e.a.eno()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
