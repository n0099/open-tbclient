package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> jSD = null;
    SoftReference<T> jSE = null;
    SoftReference<T> jSF = null;

    public void set(@Nonnull T t) {
        this.jSD = new SoftReference<>(t);
        this.jSE = new SoftReference<>(t);
        this.jSF = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.jSD == null) {
            return null;
        }
        return this.jSD.get();
    }

    public void clear() {
        if (this.jSD != null) {
            this.jSD.clear();
            this.jSD = null;
        }
        if (this.jSE != null) {
            this.jSE.clear();
            this.jSE = null;
        }
        if (this.jSF != null) {
            this.jSF.clear();
            this.jSF = null;
        }
    }
}
