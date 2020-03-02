package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b<T> {
    SoftReference<T> lII = null;
    SoftReference<T> lIJ = null;
    SoftReference<T> lIK = null;

    public void set(@Nonnull T t) {
        this.lII = new SoftReference<>(t);
        this.lIJ = new SoftReference<>(t);
        this.lIK = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.lII == null) {
            return null;
        }
        return this.lII.get();
    }

    public void clear() {
        if (this.lII != null) {
            this.lII.clear();
            this.lII = null;
        }
        if (this.lIJ != null) {
            this.lIJ.clear();
            this.lIJ = null;
        }
        if (this.lIK != null) {
            this.lIK.clear();
            this.lIK = null;
        }
    }
}
