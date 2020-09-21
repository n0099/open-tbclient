package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes17.dex */
public class b<T> {
    SoftReference<T> nvt = null;
    SoftReference<T> nvu = null;
    SoftReference<T> nvv = null;

    public void set(@Nonnull T t) {
        this.nvt = new SoftReference<>(t);
        this.nvu = new SoftReference<>(t);
        this.nvv = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.nvt == null) {
            return null;
        }
        return this.nvt.get();
    }

    public void clear() {
        if (this.nvt != null) {
            this.nvt.clear();
            this.nvt = null;
        }
        if (this.nvu != null) {
            this.nvu.clear();
            this.nvu = null;
        }
        if (this.nvv != null) {
            this.nvv.clear();
            this.nvv = null;
        }
    }
}
