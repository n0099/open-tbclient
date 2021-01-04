package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class b<T> {
    SoftReference<T> ptr = null;
    SoftReference<T> ptt = null;
    SoftReference<T> ptu = null;

    public void set(@Nonnull T t) {
        this.ptr = new SoftReference<>(t);
        this.ptt = new SoftReference<>(t);
        this.ptu = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.ptr == null) {
            return null;
        }
        return this.ptr.get();
    }

    public void clear() {
        if (this.ptr != null) {
            this.ptr.clear();
            this.ptr = null;
        }
        if (this.ptt != null) {
            this.ptt.clear();
            this.ptt = null;
        }
        if (this.ptu != null) {
            this.ptu.clear();
            this.ptu = null;
        }
    }
}
