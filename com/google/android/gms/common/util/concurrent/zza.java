package com.google.android.gms.common.util.concurrent;

import android.os.Process;
/* loaded from: classes9.dex */
public final class zza implements Runnable {
    public final Runnable zza;

    public zza(Runnable runnable, int i) {
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.zza.run();
    }
}
