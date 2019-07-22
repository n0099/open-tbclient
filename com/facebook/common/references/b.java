package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> jZK = null;
    SoftReference<T> jZL = null;
    SoftReference<T> jZM = null;

    public void set(@Nonnull T t) {
        this.jZK = new SoftReference<>(t);
        this.jZL = new SoftReference<>(t);
        this.jZM = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.jZK == null) {
            return null;
        }
        return this.jZK.get();
    }

    public void clear() {
        if (this.jZK != null) {
            this.jZK.clear();
            this.jZK = null;
        }
        if (this.jZL != null) {
            this.jZL.clear();
            this.jZL = null;
        }
        if (this.jZM != null) {
            this.jZM.clear();
            this.jZM = null;
        }
    }
}
