package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b<T> {
    SoftReference<T> lKz = null;
    SoftReference<T> lKA = null;
    SoftReference<T> lKB = null;

    public void set(@Nonnull T t) {
        this.lKz = new SoftReference<>(t);
        this.lKA = new SoftReference<>(t);
        this.lKB = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.lKz == null) {
            return null;
        }
        return this.lKz.get();
    }

    public void clear() {
        if (this.lKz != null) {
            this.lKz.clear();
            this.lKz = null;
        }
        if (this.lKA != null) {
            this.lKA.clear();
            this.lKA = null;
        }
        if (this.lKB != null) {
            this.lKB.clear();
            this.lKB = null;
        }
    }
}
