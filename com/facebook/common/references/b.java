package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b<T> {
    SoftReference<T> lHZ = null;
    SoftReference<T> lIa = null;
    SoftReference<T> lIb = null;

    public void set(@Nonnull T t) {
        this.lHZ = new SoftReference<>(t);
        this.lIa = new SoftReference<>(t);
        this.lIb = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.lHZ == null) {
            return null;
        }
        return this.lHZ.get();
    }

    public void clear() {
        if (this.lHZ != null) {
            this.lHZ.clear();
            this.lHZ = null;
        }
        if (this.lIa != null) {
            this.lIa.clear();
            this.lIa = null;
        }
        if (this.lIb != null) {
            this.lIb.clear();
            this.lIb = null;
        }
    }
}
