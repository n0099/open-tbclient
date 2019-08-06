package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> kaQ = null;
    SoftReference<T> kaR = null;
    SoftReference<T> kaS = null;

    public void set(@Nonnull T t) {
        this.kaQ = new SoftReference<>(t);
        this.kaR = new SoftReference<>(t);
        this.kaS = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.kaQ == null) {
            return null;
        }
        return this.kaQ.get();
    }

    public void clear() {
        if (this.kaQ != null) {
            this.kaQ.clear();
            this.kaQ = null;
        }
        if (this.kaR != null) {
            this.kaR.clear();
            this.kaR = null;
        }
        if (this.kaS != null) {
            this.kaS.clear();
            this.kaS = null;
        }
    }
}
