package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> ikD = null;
    SoftReference<T> ikE = null;
    SoftReference<T> ikF = null;

    public void set(@Nonnull T t) {
        this.ikD = new SoftReference<>(t);
        this.ikE = new SoftReference<>(t);
        this.ikF = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.ikD == null) {
            return null;
        }
        return this.ikD.get();
    }

    public void clear() {
        if (this.ikD != null) {
            this.ikD.clear();
            this.ikD = null;
        }
        if (this.ikE != null) {
            this.ikE.clear();
            this.ikE = null;
        }
        if (this.ikF != null) {
            this.ikF.clear();
            this.ikF = null;
        }
    }
}
