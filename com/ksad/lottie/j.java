package com.ksad.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class j<V> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final V f31814a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f31815b;

    public j(V v) {
        this.f31814a = v;
        this.f31815b = null;
    }

    public j(Throwable th) {
        this.f31815b = th;
        this.f31814a = null;
    }

    @Nullable
    public V a() {
        return this.f31814a;
    }

    @Nullable
    public Throwable b() {
        return this.f31815b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (a() == null || !a().equals(jVar.a())) {
                if (b() == null || jVar.b() == null) {
                    return false;
                }
                return b().toString().equals(b().toString());
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{a(), b()});
    }
}
