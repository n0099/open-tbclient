package com.tb.airbnb.lottie;

import android.support.annotation.Nullable;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class k<V> {
    @Nullable
    private final Throwable exception;
    @Nullable
    private final V value;

    public k(V v) {
        this.value = v;
        this.exception = null;
    }

    public k(Throwable th) {
        this.exception = th;
        this.value = null;
    }

    @Nullable
    public V getValue() {
        return this.value;
    }

    @Nullable
    public Throwable hl() {
        return this.exception;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (getValue() == null || !getValue().equals(kVar.getValue())) {
                if (hl() == null || kVar.hl() == null) {
                    return false;
                }
                return hl().toString().equals(hl().toString());
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getValue(), hl()});
    }
}
