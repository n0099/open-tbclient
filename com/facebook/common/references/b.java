package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class b<T> {
    SoftReference<T> poX = null;
    SoftReference<T> poY = null;
    SoftReference<T> poZ = null;

    public void set(@Nonnull T t) {
        this.poX = new SoftReference<>(t);
        this.poY = new SoftReference<>(t);
        this.poZ = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.poX == null) {
            return null;
        }
        return this.poX.get();
    }

    public void clear() {
        if (this.poX != null) {
            this.poX.clear();
            this.poX = null;
        }
        if (this.poY != null) {
            this.poY.clear();
            this.poY = null;
        }
        if (this.poZ != null) {
            this.poZ.clear();
            this.poZ = null;
        }
    }
}
