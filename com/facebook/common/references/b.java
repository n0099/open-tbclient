package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> ijw = null;
    SoftReference<T> ijx = null;
    SoftReference<T> ijy = null;

    public void set(@Nonnull T t) {
        this.ijw = new SoftReference<>(t);
        this.ijx = new SoftReference<>(t);
        this.ijy = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.ijw == null) {
            return null;
        }
        return this.ijw.get();
    }

    public void clear() {
        if (this.ijw != null) {
            this.ijw.clear();
            this.ijw = null;
        }
        if (this.ijx != null) {
            this.ijx.clear();
            this.ijx = null;
        }
        if (this.ijy != null) {
            this.ijy.clear();
            this.ijy = null;
        }
    }
}
