package com.kwad.sdk.collector;

import android.content.Context;
/* loaded from: classes6.dex */
public abstract class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f31883a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31884b = false;

    public c(boolean z) {
        this.f31883a = z;
    }

    public final T a(Context context) {
        if (this.f31883a && !this.f31884b) {
            try {
                return b(context);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
                return null;
            }
        }
        return null;
    }

    public abstract T b(Context context);
}
