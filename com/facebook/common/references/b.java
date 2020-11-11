package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class b<T> {
    SoftReference<T> oLy = null;
    SoftReference<T> oLz = null;
    SoftReference<T> oLA = null;

    public void set(@Nonnull T t) {
        this.oLy = new SoftReference<>(t);
        this.oLz = new SoftReference<>(t);
        this.oLA = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.oLy == null) {
            return null;
        }
        return this.oLy.get();
    }

    public void clear() {
        if (this.oLy != null) {
            this.oLy.clear();
            this.oLy = null;
        }
        if (this.oLz != null) {
            this.oLz.clear();
            this.oLz = null;
        }
        if (this.oLA != null) {
            this.oLA.clear();
            this.oLA = null;
        }
    }
}
