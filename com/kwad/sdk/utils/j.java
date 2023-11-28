package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public abstract class j<T> {
    public boolean Jq;
    public boolean aMZ = false;

    @Nullable
    public abstract T bP(Context context);

    public j(boolean z) {
        this.Jq = z;
    }

    public final void bN(boolean z) {
        this.Jq = z;
    }

    @Nullable
    public final T bO(Context context) {
        if (!this.Jq || this.aMZ) {
            return null;
        }
        try {
            return bP(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return null;
        }
    }
}
