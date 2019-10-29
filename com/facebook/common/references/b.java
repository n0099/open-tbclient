package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> kbw = null;
    SoftReference<T> kbx = null;
    SoftReference<T> kby = null;

    public void set(@Nonnull T t) {
        this.kbw = new SoftReference<>(t);
        this.kbx = new SoftReference<>(t);
        this.kby = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.kbw == null) {
            return null;
        }
        return this.kbw.get();
    }

    public void clear() {
        if (this.kbw != null) {
            this.kbw.clear();
            this.kbw = null;
        }
        if (this.kbx != null) {
            this.kbx.clear();
            this.kbx = null;
        }
        if (this.kby != null) {
            this.kby.clear();
            this.kby = null;
        }
    }
}
