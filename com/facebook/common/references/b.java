package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
/* loaded from: classes19.dex */
public class b<T> {
    SoftReference<T> pck = null;
    SoftReference<T> pcl = null;
    SoftReference<T> pcm = null;

    public void set(@Nonnull T t) {
        this.pck = new SoftReference<>(t);
        this.pcl = new SoftReference<>(t);
        this.pcm = new SoftReference<>(t);
    }

    @Nullable
    public T get() {
        if (this.pck == null) {
            return null;
        }
        return this.pck.get();
    }

    public void clear() {
        if (this.pck != null) {
            this.pck.clear();
            this.pck = null;
        }
        if (this.pcl != null) {
            this.pcl.clear();
            this.pcl = null;
        }
        if (this.pcm != null) {
            this.pcm.clear();
            this.pcm = null;
        }
    }
}
