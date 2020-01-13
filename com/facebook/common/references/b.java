package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b<T> {
    SoftReference<T> lHU = null;
    SoftReference<T> lHV = null;
    SoftReference<T> lHW = null;

    public void set(@Nonnull T t) {
        this.lHU = new SoftReference<>(t);
        this.lHV = new SoftReference<>(t);
        this.lHW = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.lHU == null) {
            return null;
        }
        return this.lHU.get();
    }

    public void clear() {
        if (this.lHU != null) {
            this.lHU.clear();
            this.lHU = null;
        }
        if (this.lHV != null) {
            this.lHV.clear();
            this.lHV = null;
        }
        if (this.lHW != null) {
            this.lHW.clear();
            this.lHW = null;
        }
    }
}
