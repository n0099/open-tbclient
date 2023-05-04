package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class UserRecoverableException extends Exception {
    public final Intent zza;

    public UserRecoverableException(@NonNull String str, @NonNull Intent intent) {
        super(str);
        this.zza = intent;
    }

    @NonNull
    public Intent getIntent() {
        return new Intent(this.zza);
    }
}
