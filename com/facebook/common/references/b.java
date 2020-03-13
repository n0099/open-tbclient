package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b<T> {
    SoftReference<T> lIT = null;
    SoftReference<T> lIU = null;
    SoftReference<T> lIV = null;

    public void set(@Nonnull T t) {
        this.lIT = new SoftReference<>(t);
        this.lIU = new SoftReference<>(t);
        this.lIV = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.lIT == null) {
            return null;
        }
        return this.lIT.get();
    }

    public void clear() {
        if (this.lIT != null) {
            this.lIT.clear();
            this.lIT = null;
        }
        if (this.lIU != null) {
            this.lIU.clear();
            this.lIU = null;
        }
        if (this.lIV != null) {
            this.lIV.clear();
            this.lIV = null;
        }
    }
}
