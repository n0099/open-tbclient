package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> jAg = null;
    SoftReference<T> jAh = null;
    SoftReference<T> jAi = null;

    public void set(@Nonnull T t) {
        this.jAg = new SoftReference<>(t);
        this.jAh = new SoftReference<>(t);
        this.jAi = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.jAg == null) {
            return null;
        }
        return this.jAg.get();
    }

    public void clear() {
        if (this.jAg != null) {
            this.jAg.clear();
            this.jAg = null;
        }
        if (this.jAh != null) {
            this.jAh.clear();
            this.jAh = null;
        }
        if (this.jAi != null) {
            this.jAi.clear();
            this.jAi = null;
        }
    }
}
