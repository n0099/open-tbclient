package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class b<T> {
    SoftReference<T> lEw = null;
    SoftReference<T> lEx = null;
    SoftReference<T> lEy = null;

    public void set(@Nonnull T t) {
        this.lEw = new SoftReference<>(t);
        this.lEx = new SoftReference<>(t);
        this.lEy = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.lEw == null) {
            return null;
        }
        return this.lEw.get();
    }

    public void clear() {
        if (this.lEw != null) {
            this.lEw.clear();
            this.lEw = null;
        }
        if (this.lEx != null) {
            this.lEx.clear();
            this.lEx = null;
        }
        if (this.lEy != null) {
            this.lEy.clear();
            this.lEy = null;
        }
    }
}
