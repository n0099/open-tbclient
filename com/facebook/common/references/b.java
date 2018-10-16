package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> hXo = null;
    SoftReference<T> hXp = null;
    SoftReference<T> hXq = null;

    public void set(@Nonnull T t) {
        this.hXo = new SoftReference<>(t);
        this.hXp = new SoftReference<>(t);
        this.hXq = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.hXo == null) {
            return null;
        }
        return this.hXo.get();
    }

    public void clear() {
        if (this.hXo != null) {
            this.hXo.clear();
            this.hXo = null;
        }
        if (this.hXp != null) {
            this.hXp.clear();
            this.hXp = null;
        }
        if (this.hXq != null) {
            this.hXq.clear();
            this.hXq = null;
        }
    }
}
