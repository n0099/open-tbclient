package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class b<T> {
    SoftReference<T> poW = null;
    SoftReference<T> poX = null;
    SoftReference<T> poY = null;

    public void set(@Nonnull T t) {
        this.poW = new SoftReference<>(t);
        this.poX = new SoftReference<>(t);
        this.poY = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.poW == null) {
            return null;
        }
        return this.poW.get();
    }

    public void clear() {
        if (this.poW != null) {
            this.poW.clear();
            this.poW = null;
        }
        if (this.poX != null) {
            this.poX.clear();
            this.poX = null;
        }
        if (this.poY != null) {
            this.poY.clear();
            this.poY = null;
        }
    }
}
