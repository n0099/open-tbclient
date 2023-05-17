package com.google.android.gms.common.util.concurrent;

import androidx.annotation.NonNull;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
@KeepForSdk
/* loaded from: classes9.dex */
public class NumberedThreadFactory implements ThreadFactory {
    public final String zza;
    public final AtomicInteger zzb = new AtomicInteger();
    public final ThreadFactory zzc = Executors.defaultThreadFactory();

    @KeepForSdk
    public NumberedThreadFactory(@NonNull String str) {
        Preconditions.checkNotNull(str, "Name must not be null");
        this.zza = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    @NonNull
    public final Thread newThread(@NonNull Runnable runnable) {
        Thread newThread = this.zzc.newThread(new zza(runnable, 0));
        String str = this.zza;
        int andIncrement = this.zzb.getAndIncrement();
        StringBuilder sb = new StringBuilder(str.length() + 13);
        sb.append(str);
        sb.append(PreferencesUtil.LEFT_MOUNT);
        sb.append(andIncrement);
        sb.append(PreferencesUtil.RIGHT_MOUNT);
        newThread.setName(sb.toString());
        return newThread;
    }
}
