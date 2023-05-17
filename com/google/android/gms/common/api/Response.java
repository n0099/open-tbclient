package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;
/* loaded from: classes9.dex */
public class Response<T extends Result> {
    public T zza;

    public Response() {
    }

    public Response(@NonNull T t) {
        this.zza = t;
    }

    @NonNull
    public T getResult() {
        return this.zza;
    }

    public void setResult(@NonNull T t) {
        this.zza = t;
    }
}
