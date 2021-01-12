package com.ksad.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class j<V> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final V f8027a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f8028b;

    public j(V v) {
        this.f8027a = v;
        this.f8028b = null;
    }

    public j(Throwable th) {
        this.f8028b = th;
        this.f8027a = null;
    }

    @Nullable
    public V a() {
        return this.f8027a;
    }

    @Nullable
    public Throwable b() {
        return this.f8028b;
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
