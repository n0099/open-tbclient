package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class b<T> {
    SoftReference<T> nKM = null;
    SoftReference<T> nKN = null;
    SoftReference<T> nKO = null;

    public void set(@Nonnull T t) {
        this.nKM = new SoftReference<>(t);
        this.nKN = new SoftReference<>(t);
        this.nKO = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.nKM == null) {
            return null;
        }
        return this.nKM.get();
    }

    public void clear() {
        if (this.nKM != null) {
            this.nKM.clear();
            this.nKM = null;
        }
        if (this.nKN != null) {
            this.nKN.clear();
            this.nKN = null;
        }
        if (this.nKO != null) {
            this.nKO.clear();
            this.nKO = null;
        }
    }
}
