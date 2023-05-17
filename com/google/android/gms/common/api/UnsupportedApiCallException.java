package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
/* loaded from: classes9.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    public final Feature zza;

    @KeepForSdk
    public UnsupportedApiCallException(@NonNull Feature feature) {
        this.zza = feature;
    }

    @Override // java.lang.Throwable
    @NonNull
    public String getMessage() {
        String valueOf = String.valueOf(this.zza);
        String.valueOf(valueOf).length();
        return "Missing ".concat(String.valueOf(valueOf));
    }
}
