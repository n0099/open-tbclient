package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> jAr = null;
    SoftReference<T> jAs = null;
    SoftReference<T> jAt = null;

    public void set(@Nonnull T t) {
        this.jAr = new SoftReference<>(t);
        this.jAs = new SoftReference<>(t);
        this.jAt = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.jAr == null) {
            return null;
        }
        return this.jAr.get();
    }

    public void clear() {
        if (this.jAr != null) {
            this.jAr.clear();
            this.jAr = null;
        }
        if (this.jAs != null) {
            this.jAs.clear();
            this.jAs = null;
        }
        if (this.jAt != null) {
            this.jAt.clear();
            this.jAt = null;
        }
    }
}
