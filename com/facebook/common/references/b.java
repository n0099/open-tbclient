package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b<T> {
    SoftReference<T> mlP = null;
    SoftReference<T> mlQ = null;
    SoftReference<T> mlR = null;

    public void set(@Nonnull T t) {
        this.mlP = new SoftReference<>(t);
        this.mlQ = new SoftReference<>(t);
        this.mlR = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.mlP == null) {
            return null;
        }
        return this.mlP.get();
    }

    public void clear() {
        if (this.mlP != null) {
            this.mlP.clear();
            this.mlP = null;
        }
        if (this.mlQ != null) {
            this.mlQ.clear();
            this.mlQ = null;
        }
        if (this.mlR != null) {
            this.mlR.clear();
            this.mlR = null;
        }
    }
}
