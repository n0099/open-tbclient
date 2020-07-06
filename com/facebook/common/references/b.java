package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b<T> {
    SoftReference<T> mJc = null;
    SoftReference<T> mJd = null;
    SoftReference<T> mJe = null;

    public void set(@Nonnull T t) {
        this.mJc = new SoftReference<>(t);
        this.mJd = new SoftReference<>(t);
        this.mJe = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.mJc == null) {
            return null;
        }
        return this.mJc.get();
    }

    public void clear() {
        if (this.mJc != null) {
            this.mJc.clear();
            this.mJc = null;
        }
        if (this.mJd != null) {
            this.mJd.clear();
            this.mJd = null;
        }
        if (this.mJe != null) {
            this.mJe.clear();
            this.mJe = null;
        }
    }
}
