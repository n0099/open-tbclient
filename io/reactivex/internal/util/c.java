package io.reactivex.internal.util;
/* loaded from: classes7.dex */
public final class c {
    public static void dTq() {
        if (io.reactivex.e.a.dTt()) {
            if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.g) || io.reactivex.e.a.dTu()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
