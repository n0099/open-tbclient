package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> jAz = null;
    SoftReference<T> jAA = null;
    SoftReference<T> jAB = null;

    public void set(@Nonnull T t) {
        this.jAz = new SoftReference<>(t);
        this.jAA = new SoftReference<>(t);
        this.jAB = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.jAz == null) {
            return null;
        }
        return this.jAz.get();
    }

    public void clear() {
        if (this.jAz != null) {
            this.jAz.clear();
            this.jAz = null;
        }
        if (this.jAA != null) {
            this.jAA.clear();
            this.jAA = null;
        }
        if (this.jAB != null) {
            this.jAB.clear();
            this.jAB = null;
        }
    }
}
