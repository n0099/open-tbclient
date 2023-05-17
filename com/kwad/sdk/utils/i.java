package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public abstract class i<T> {
    public boolean Dv;
    public boolean anc = false;

    public i(boolean z) {
        this.Dv = z;
    }

    public final void aD(boolean z) {
        this.Dv = z;
    }

    @Nullable
    public final T bZ(Context context) {
        if (this.Dv && !this.anc) {
            try {
                return ca(context);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                return null;
            }
        }
        return null;
    }

    @Nullable
    public abstract T ca(Context context);
}
