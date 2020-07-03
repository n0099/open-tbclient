package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b<T> {
    SoftReference<T> mIZ = null;
    SoftReference<T> mJa = null;
    SoftReference<T> mJb = null;

    public void set(@Nonnull T t) {
        this.mIZ = new SoftReference<>(t);
        this.mJa = new SoftReference<>(t);
        this.mJb = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.mIZ == null) {
            return null;
        }
        return this.mIZ.get();
    }

    public void clear() {
        if (this.mIZ != null) {
            this.mIZ.clear();
            this.mIZ = null;
        }
        if (this.mJa != null) {
            this.mJa.clear();
            this.mJa = null;
        }
        if (this.mJb != null) {
            this.mJb.clear();
            this.mJb = null;
        }
    }
}
