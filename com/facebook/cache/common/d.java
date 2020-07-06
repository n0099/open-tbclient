package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes13.dex */
public class d implements b {
    final List<b> mHo;

    public List<b> dyx() {
        return this.mHo;
    }

    public String toString() {
        return "MultiCacheKey:" + this.mHo.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.mHo.equals(((d) obj).mHo);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHo.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean H(Uri uri) {
        for (int i = 0; i < this.mHo.size(); i++) {
            if (this.mHo.get(i).H(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String dyw() {
        return this.mHo.get(0).dyw();
    }
}
