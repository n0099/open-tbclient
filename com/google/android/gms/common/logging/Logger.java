package com.google.android.gms.common.logging;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;
@KeepForSdk
/* loaded from: classes9.dex */
public class Logger {
    public final String zza;
    public final String zzb;
    public final GmsLogger zzc;
    public final int zzd;

    @NonNull
    @KeepForSdk
    public String getTag() {
        return this.zza;
    }

    @KeepForSdk
    public boolean isLoggable(int i) {
        return this.zzd <= i;
    }

    @KeepForSdk
    public Logger(@NonNull String str, @NonNull String... strArr) {
        String sb;
        if (strArr.length == 0) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (String str2 : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(",");
                }
                sb2.append(str2);
            }
            sb2.append("] ");
            sb = sb2.toString();
        }
        this.zzb = sb;
        this.zza = str;
        this.zzc = new GmsLogger(str);
        int i = 2;
        while (i <= 7 && !Log.isLoggable(this.zza, i)) {
            i++;
        }
        this.zzd = i;
    }

    @KeepForSdk
    public void d(@NonNull String str, @Nullable Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.zza, format(str, objArr));
        }
    }

    @KeepForSdk
    public void e(@NonNull String str, @Nullable Object... objArr) {
        Log.e(this.zza, format(str, objArr));
    }

    @NonNull
    @KeepForSdk
    public String format(@NonNull String str, @Nullable Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzb.concat(str);
    }

    @KeepForSdk
    public void i(@NonNull String str, @Nullable Object... objArr) {
        Log.i(this.zza, format(str, objArr));
    }

    @KeepForSdk
    public void v(@NonNull String str, @Nullable Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.zza, format(str, objArr));
        }
    }

    @KeepForSdk
    public void w(@NonNull String str, @Nullable Object... objArr) {
        Log.w(this.zza, format(str, objArr));
    }

    @KeepForSdk
    public void e(@NonNull String str, @NonNull Throwable th, @Nullable Object... objArr) {
        Log.e(this.zza, format(str, objArr), th);
    }

    @KeepForSdk
    public void v(@NonNull String str, @NonNull Throwable th, @Nullable Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.zza, format(str, objArr), th);
        }
    }

    @KeepForSdk
    public void wtf(@NonNull String str, @NonNull Throwable th, @Nullable Object... objArr) {
        Log.wtf(this.zza, format(str, objArr), th);
    }

    @KeepForSdk
    public void wtf(@NonNull Throwable th) {
        Log.wtf(this.zza, th);
    }
}
