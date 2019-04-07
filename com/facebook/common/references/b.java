package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> jzL = null;
    SoftReference<T> jzM = null;
    SoftReference<T> jzN = null;

    public void set(@Nonnull T t) {
        this.jzL = new SoftReference<>(t);
        this.jzM = new SoftReference<>(t);
        this.jzN = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.jzL == null) {
            return null;
        }
        return this.jzL.get();
    }

    public void clear() {
        if (this.jzL != null) {
            this.jzL.clear();
            this.jzL = null;
        }
        if (this.jzM != null) {
            this.jzM.clear();
            this.jzM = null;
        }
        if (this.jzN != null) {
            this.jzN.clear();
            this.jzN = null;
        }
    }
}
