package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class b<T> {
    SoftReference<T> nlt = null;
    SoftReference<T> nlu = null;
    SoftReference<T> nlv = null;

    public void set(@Nonnull T t) {
        this.nlt = new SoftReference<>(t);
        this.nlu = new SoftReference<>(t);
        this.nlv = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.nlt == null) {
            return null;
        }
        return this.nlt.get();
    }

    public void clear() {
        if (this.nlt != null) {
            this.nlt.clear();
            this.nlt = null;
        }
        if (this.nlu != null) {
            this.nlu.clear();
            this.nlu = null;
        }
        if (this.nlv != null) {
            this.nlv.clear();
            this.nlv = null;
        }
    }
}
