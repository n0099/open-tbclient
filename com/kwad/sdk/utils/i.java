package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public abstract class i<T> {
    public boolean a;
    public boolean b = false;

    public i(boolean z) {
        this.a = z;
    }

    @Nullable
    public final T a(Context context) {
        if (this.a && !this.b) {
            try {
                return b(context);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.b(th);
                return null;
            }
        }
        return null;
    }

    public final void a(boolean z) {
        this.a = z;
    }

    @Nullable
    public abstract T b(Context context);
}
