package com.ksad.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: classes3.dex */
public final class j<V> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final V f5365a;
    @Nullable
    private final Throwable b;

    public j(V v) {
        this.f5365a = v;
        this.b = null;
    }

    public j(Throwable th) {
        this.b = th;
        this.f5365a = null;
    }

    @Nullable
    public V a() {
        return this.f5365a;
    }

    @Nullable
    public Throwable b() {
        return this.b;
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
