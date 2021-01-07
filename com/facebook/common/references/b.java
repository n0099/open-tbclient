package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class b<T> {
    SoftReference<T> ptz = null;
    SoftReference<T> ptA = null;
    SoftReference<T> ptB = null;

    public void set(@Nonnull T t) {
        this.ptz = new SoftReference<>(t);
        this.ptA = new SoftReference<>(t);
        this.ptB = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.ptz == null) {
            return null;
        }
        return this.ptz.get();
    }

    public void clear() {
        if (this.ptz != null) {
            this.ptz.clear();
            this.ptz = null;
        }
        if (this.ptA != null) {
            this.ptA.clear();
            this.ptA = null;
        }
        if (this.ptB != null) {
            this.ptB.clear();
            this.ptB = null;
        }
    }
}
