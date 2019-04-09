package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> jzM = null;
    SoftReference<T> jzN = null;
    SoftReference<T> jzO = null;

    public void set(@Nonnull T t) {
        this.jzM = new SoftReference<>(t);
        this.jzN = new SoftReference<>(t);
        this.jzO = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.jzM == null) {
            return null;
        }
        return this.jzM.get();
    }

    public void clear() {
        if (this.jzM != null) {
            this.jzM.clear();
            this.jzM = null;
        }
        if (this.jzN != null) {
            this.jzN.clear();
            this.jzN = null;
        }
        if (this.jzO != null) {
            this.jzO.clear();
            this.jzO = null;
        }
    }
}
