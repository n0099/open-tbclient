package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> ikE = null;
    SoftReference<T> ikF = null;
    SoftReference<T> ikG = null;

    public void set(@Nonnull T t) {
        this.ikE = new SoftReference<>(t);
        this.ikF = new SoftReference<>(t);
        this.ikG = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.ikE == null) {
            return null;
        }
        return this.ikE.get();
    }

    public void clear() {
        if (this.ikE != null) {
            this.ikE.clear();
            this.ikE = null;
        }
        if (this.ikF != null) {
            this.ikF.clear();
            this.ikF = null;
        }
        if (this.ikG != null) {
            this.ikG.clear();
            this.ikG = null;
        }
    }
}
