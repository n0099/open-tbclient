package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b<T> {
    SoftReference<T> mRf = null;
    SoftReference<T> mRg = null;
    SoftReference<T> mRh = null;

    public void set(@Nonnull T t) {
        this.mRf = new SoftReference<>(t);
        this.mRg = new SoftReference<>(t);
        this.mRh = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.mRf == null) {
            return null;
        }
        return this.mRf.get();
    }

    public void clear() {
        if (this.mRf != null) {
            this.mRf.clear();
            this.mRf = null;
        }
        if (this.mRg != null) {
            this.mRg.clear();
            this.mRg = null;
        }
        if (this.mRh != null) {
            this.mRh.clear();
            this.mRh = null;
        }
    }
}
