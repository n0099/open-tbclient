package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b<T> {
    SoftReference<T> mRh = null;
    SoftReference<T> mRi = null;
    SoftReference<T> mRj = null;

    public void set(@Nonnull T t) {
        this.mRh = new SoftReference<>(t);
        this.mRi = new SoftReference<>(t);
        this.mRj = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.mRh == null) {
            return null;
        }
        return this.mRh.get();
    }

    public void clear() {
        if (this.mRh != null) {
            this.mRh.clear();
            this.mRh = null;
        }
        if (this.mRi != null) {
            this.mRi.clear();
            this.mRi = null;
        }
        if (this.mRj != null) {
            this.mRj.clear();
            this.mRj = null;
        }
    }
}
