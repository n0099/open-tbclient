package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> igm = null;
    SoftReference<T> ign = null;
    SoftReference<T> igo = null;

    public void set(@Nonnull T t) {
        this.igm = new SoftReference<>(t);
        this.ign = new SoftReference<>(t);
        this.igo = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.igm == null) {
            return null;
        }
        return this.igm.get();
    }

    public void clear() {
        if (this.igm != null) {
            this.igm.clear();
            this.igm = null;
        }
        if (this.ign != null) {
            this.ign.clear();
            this.ign = null;
        }
        if (this.igo != null) {
            this.igo.clear();
            this.igo = null;
        }
    }
}
