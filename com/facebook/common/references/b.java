package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> hXp = null;
    SoftReference<T> hXq = null;
    SoftReference<T> hXr = null;

    public void set(@Nonnull T t) {
        this.hXp = new SoftReference<>(t);
        this.hXq = new SoftReference<>(t);
        this.hXr = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.hXp == null) {
            return null;
        }
        return this.hXp.get();
    }

    public void clear() {
        if (this.hXp != null) {
            this.hXp.clear();
            this.hXp = null;
        }
        if (this.hXq != null) {
            this.hXq.clear();
            this.hXq = null;
        }
        if (this.hXr != null) {
            this.hXr.clear();
            this.hXr = null;
        }
    }
}
