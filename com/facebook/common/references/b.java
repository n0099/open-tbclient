package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> jSG = null;
    SoftReference<T> jSH = null;
    SoftReference<T> jSI = null;

    public void set(@Nonnull T t) {
        this.jSG = new SoftReference<>(t);
        this.jSH = new SoftReference<>(t);
        this.jSI = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.jSG == null) {
            return null;
        }
        return this.jSG.get();
    }

    public void clear() {
        if (this.jSG != null) {
            this.jSG.clear();
            this.jSG = null;
        }
        if (this.jSH != null) {
            this.jSH.clear();
            this.jSH = null;
        }
        if (this.jSI != null) {
            this.jSI.clear();
            this.jSI = null;
        }
    }
}
