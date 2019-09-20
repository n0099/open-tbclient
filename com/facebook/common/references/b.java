package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> kdn = null;
    SoftReference<T> kdo = null;
    SoftReference<T> kdp = null;

    public void set(@Nonnull T t) {
        this.kdn = new SoftReference<>(t);
        this.kdo = new SoftReference<>(t);
        this.kdp = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.kdn == null) {
            return null;
        }
        return this.kdn.get();
    }

    public void clear() {
        if (this.kdn != null) {
            this.kdn.clear();
            this.kdn = null;
        }
        if (this.kdo != null) {
            this.kdo.clear();
            this.kdo = null;
        }
        if (this.kdp != null) {
            this.kdp.clear();
            this.kdp = null;
        }
    }
}
