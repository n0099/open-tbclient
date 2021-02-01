package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class b<T> {
    SoftReference<T> pzh = null;
    SoftReference<T> pzi = null;
    SoftReference<T> pzj = null;

    public void set(@Nonnull T t) {
        this.pzh = new SoftReference<>(t);
        this.pzi = new SoftReference<>(t);
        this.pzj = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.pzh == null) {
            return null;
        }
        return this.pzh.get();
    }

    public void clear() {
        if (this.pzh != null) {
            this.pzh.clear();
            this.pzh = null;
        }
        if (this.pzi != null) {
            this.pzi.clear();
            this.pzi = null;
        }
        if (this.pzj != null) {
            this.pzj.clear();
            this.pzj = null;
        }
    }
}
