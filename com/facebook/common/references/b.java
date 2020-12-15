package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes19.dex */
public class b<T> {
    SoftReference<T> pcm = null;
    SoftReference<T> pcn = null;
    SoftReference<T> pco = null;

    public void set(@Nonnull T t) {
        this.pcm = new SoftReference<>(t);
        this.pcn = new SoftReference<>(t);
        this.pco = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.pcm == null) {
            return null;
        }
        return this.pcm.get();
    }

    public void clear() {
        if (this.pcm != null) {
            this.pcm.clear();
            this.pcm = null;
        }
        if (this.pcn != null) {
            this.pcn.clear();
            this.pcn = null;
        }
        if (this.pco != null) {
            this.pco.clear();
            this.pco = null;
        }
    }
}
