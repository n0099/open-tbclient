package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class b<T> {
    SoftReference<T> pzH = null;
    SoftReference<T> pzI = null;
    SoftReference<T> pzJ = null;

    public void set(@Nonnull T t) {
        this.pzH = new SoftReference<>(t);
        this.pzI = new SoftReference<>(t);
        this.pzJ = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.pzH == null) {
            return null;
        }
        return this.pzH.get();
    }

    public void clear() {
        if (this.pzH != null) {
            this.pzH.clear();
            this.pzH = null;
        }
        if (this.pzI != null) {
            this.pzI.clear();
            this.pzI = null;
        }
        if (this.pzJ != null) {
            this.pzJ.clear();
            this.pzJ = null;
        }
    }
}
