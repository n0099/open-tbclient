package com.kwad.sdk.utils;

import android.content.Context;
/* loaded from: classes8.dex */
public abstract class i {
    public boolean Dv;
    public boolean anc = false;

    public i(boolean z) {
        this.Dv = z;
    }

    public final void aD(boolean z) {
        this.Dv = z;
    }

    public final Object bZ(Context context) {
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

    public abstract Object ca(Context context);
}
