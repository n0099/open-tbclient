package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> hYZ = null;
    SoftReference<T> hZa = null;
    SoftReference<T> hZb = null;

    public void set(@Nonnull T t) {
        this.hYZ = new SoftReference<>(t);
        this.hZa = new SoftReference<>(t);
        this.hZb = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.hYZ == null) {
            return null;
        }
        return this.hYZ.get();
    }

    public void clear() {
        if (this.hYZ != null) {
            this.hYZ.clear();
            this.hYZ = null;
        }
        if (this.hZa != null) {
            this.hZa.clear();
            this.hZa = null;
        }
        if (this.hZb != null) {
            this.hZb.clear();
            this.hZb = null;
        }
    }
}
