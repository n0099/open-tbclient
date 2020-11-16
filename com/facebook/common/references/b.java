package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b<T> {
    SoftReference<T> oNc = null;
    SoftReference<T> oNd = null;
    SoftReference<T> oNe = null;

    public void set(@Nonnull T t) {
        this.oNc = new SoftReference<>(t);
        this.oNd = new SoftReference<>(t);
        this.oNe = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.oNc == null) {
            return null;
        }
        return this.oNc.get();
    }

    public void clear() {
        if (this.oNc != null) {
            this.oNc.clear();
            this.oNc = null;
        }
        if (this.oNd != null) {
            this.oNd.clear();
            this.oNd = null;
        }
        if (this.oNe != null) {
            this.oNe.clear();
            this.oNe = null;
        }
    }
}
