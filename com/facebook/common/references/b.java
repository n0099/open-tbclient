package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b<T> {
    SoftReference<T> lRT = null;
    SoftReference<T> lRU = null;
    SoftReference<T> lRV = null;

    public void set(@Nonnull T t) {
        this.lRT = new SoftReference<>(t);
        this.lRU = new SoftReference<>(t);
        this.lRV = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.lRT == null) {
            return null;
        }
        return this.lRT.get();
    }

    public void clear() {
        if (this.lRT != null) {
            this.lRT.clear();
            this.lRT = null;
        }
        if (this.lRU != null) {
            this.lRU.clear();
            this.lRU = null;
        }
        if (this.lRV != null) {
            this.lRV.clear();
            this.lRV = null;
        }
    }
}
