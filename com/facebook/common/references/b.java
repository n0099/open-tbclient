package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class b<T> {
    SoftReference<T> nlb = null;
    SoftReference<T> nlc = null;
    SoftReference<T> nld = null;

    public void set(@Nonnull T t) {
        this.nlb = new SoftReference<>(t);
        this.nlc = new SoftReference<>(t);
        this.nld = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.nlb == null) {
            return null;
        }
        return this.nlb.get();
    }

    public void clear() {
        if (this.nlb != null) {
            this.nlb.clear();
            this.nlb = null;
        }
        if (this.nlc != null) {
            this.nlc.clear();
            this.nlc = null;
        }
        if (this.nld != null) {
            this.nld.clear();
            this.nld = null;
        }
    }
}
