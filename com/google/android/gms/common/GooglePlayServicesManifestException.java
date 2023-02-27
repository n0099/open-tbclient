package com.google.android.gms.common;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;
@KeepName
/* loaded from: classes7.dex */
public class GooglePlayServicesManifestException extends IllegalStateException {
    public final int zza;

    public int getActualVersion() {
        return this.zza;
    }

    public GooglePlayServicesManifestException(int i, @NonNull String str) {
        super(str);
        this.zza = i;
    }

    public int getExpectedVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }
}
