package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class b<T> {
    SoftReference<T> pBM = null;
    SoftReference<T> pBN = null;
    SoftReference<T> pBO = null;

    public void set(@Nonnull T t) {
        this.pBM = new SoftReference<>(t);
        this.pBN = new SoftReference<>(t);
        this.pBO = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.pBM == null) {
            return null;
        }
        return this.pBM.get();
    }

    public void clear() {
        if (this.pBM != null) {
            this.pBM.clear();
            this.pBM = null;
        }
        if (this.pBN != null) {
            this.pBN.clear();
            this.pBN = null;
        }
        if (this.pBO != null) {
            this.pBO.clear();
            this.pBO = null;
        }
    }
}
