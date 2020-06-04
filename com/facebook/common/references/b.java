package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b<T> {
    SoftReference<T> mmZ = null;
    SoftReference<T> mna = null;
    SoftReference<T> mnb = null;

    public void set(@Nonnull T t) {
        this.mmZ = new SoftReference<>(t);
        this.mna = new SoftReference<>(t);
        this.mnb = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.mmZ == null) {
            return null;
        }
        return this.mmZ.get();
    }

    public void clear() {
        if (this.mmZ != null) {
            this.mmZ.clear();
            this.mmZ = null;
        }
        if (this.mna != null) {
            this.mna.clear();
            this.mna = null;
        }
        if (this.mnb != null) {
            this.mnb.clear();
            this.mnb = null;
        }
    }
}
