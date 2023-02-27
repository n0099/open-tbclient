package com.google.android.gms.common.api;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
/* loaded from: classes7.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public abstract void onFailure(@NonNull Status status);

    public abstract void onSuccess(@NonNull R r);

    @Override // com.google.android.gms.common.api.ResultCallback
    @KeepForSdk
    public final void onResult(@NonNull R r) {
        Status status = r.getStatus();
        if (status.isSuccess()) {
            onSuccess(r);
            return;
        }
        onFailure(status);
        if (r instanceof Releasable) {
            try {
                ((Releasable) r).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(r);
                String.valueOf(valueOf).length();
                Log.w(com.huawei.hms.support.api.client.ResultCallbacks.TAG, "Unable to release ".concat(String.valueOf(valueOf)), e);
            }
        }
    }
}
