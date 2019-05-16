package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> jSC = null;
    SoftReference<T> jSD = null;
    SoftReference<T> jSE = null;

    public void set(@Nonnull T t) {
        this.jSC = new SoftReference<>(t);
        this.jSD = new SoftReference<>(t);
        this.jSE = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.jSC == null) {
            return null;
        }
        return this.jSC.get();
    }

    public void clear() {
        if (this.jSC != null) {
            this.jSC.clear();
            this.jSC = null;
        }
        if (this.jSD != null) {
            this.jSD.clear();
            this.jSD = null;
        }
        if (this.jSE != null) {
            this.jSE.clear();
            this.jSE = null;
        }
    }
}
