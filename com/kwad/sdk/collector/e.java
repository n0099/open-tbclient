package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public abstract class e<T> {
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f55535b = false;

    public e(boolean z) {
        this.a = z;
    }

    @Nullable
    public final T a(Context context) {
        if (this.a && !this.f55535b) {
            try {
                return b(context);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
                return null;
            }
        }
        return null;
    }

    public void a(boolean z) {
        this.a = z;
    }

    @Nullable
    public abstract T b(Context context);
}
