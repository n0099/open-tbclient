package com.kwad.sdk.collector;

import android.content.Context;
/* loaded from: classes6.dex */
public abstract class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f32709a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f32710b = false;

    public c(boolean z) {
        this.f32709a = z;
    }

    public final T a(Context context) {
        if (this.f32709a && !this.f32710b) {
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
