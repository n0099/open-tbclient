package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b<T> {
    SoftReference<T> lIG = null;
    SoftReference<T> lIH = null;
    SoftReference<T> lII = null;

    public void set(@Nonnull T t) {
        this.lIG = new SoftReference<>(t);
        this.lIH = new SoftReference<>(t);
        this.lII = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.lIG == null) {
            return null;
        }
        return this.lIG.get();
    }

    public void clear() {
        if (this.lIG != null) {
            this.lIG.clear();
            this.lIG = null;
        }
        if (this.lIH != null) {
            this.lIH.clear();
            this.lIH = null;
        }
        if (this.lII != null) {
            this.lII.clear();
            this.lII = null;
        }
    }
}
