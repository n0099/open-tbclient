package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> kaF = null;
    SoftReference<T> kaG = null;
    SoftReference<T> kaH = null;

    public void set(@Nonnull T t) {
        this.kaF = new SoftReference<>(t);
        this.kaG = new SoftReference<>(t);
        this.kaH = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.kaF == null) {
            return null;
        }
        return this.kaF.get();
    }

    public void clear() {
        if (this.kaF != null) {
            this.kaF.clear();
            this.kaF = null;
        }
        if (this.kaG != null) {
            this.kaG.clear();
            this.kaG = null;
        }
        if (this.kaH != null) {
            this.kaH.clear();
            this.kaH = null;
        }
    }
}
