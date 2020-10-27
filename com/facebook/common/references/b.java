package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class b<T> {
    SoftReference<T> oCf = null;
    SoftReference<T> oCg = null;
    SoftReference<T> oCh = null;

    public void set(@Nonnull T t) {
        this.oCf = new SoftReference<>(t);
        this.oCg = new SoftReference<>(t);
        this.oCh = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.oCf == null) {
            return null;
        }
        return this.oCf.get();
    }

    public void clear() {
        if (this.oCf != null) {
            this.oCf.clear();
            this.oCf = null;
        }
        if (this.oCg != null) {
            this.oCg.clear();
            this.oCg = null;
        }
        if (this.oCh != null) {
            this.oCh.clear();
            this.oCh = null;
        }
    }
}
