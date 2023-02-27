package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public class GooglePlayServicesRepairableException extends UserRecoverableException {
    public final int zza;

    public int getConnectionStatusCode() {
        return this.zza;
    }

    public GooglePlayServicesRepairableException(int i, @NonNull String str, @NonNull Intent intent) {
        super(str, intent);
        this.zza = i;
    }
}
