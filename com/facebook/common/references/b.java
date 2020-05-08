package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b<T> {
    SoftReference<T> lRX = null;
    SoftReference<T> lRY = null;
    SoftReference<T> lRZ = null;

    public void set(@Nonnull T t) {
        this.lRX = new SoftReference<>(t);
        this.lRY = new SoftReference<>(t);
        this.lRZ = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.lRX == null) {
            return null;
        }
        return this.lRX.get();
    }

    public void clear() {
        if (this.lRX != null) {
            this.lRX.clear();
            this.lRX = null;
        }
        if (this.lRY != null) {
            this.lRY.clear();
            this.lRY = null;
        }
        if (this.lRZ != null) {
            this.lRZ.clear();
            this.lRZ = null;
        }
    }
}
