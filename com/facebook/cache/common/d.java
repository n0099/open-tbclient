package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes13.dex */
public class d implements b {
    final List<b> mHl;

    public List<b> dyt() {
        return this.mHl;
    }

    public String toString() {
        return "MultiCacheKey:" + this.mHl.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.mHl.equals(((d) obj).mHl);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mHl.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean H(Uri uri) {
        for (int i = 0; i < this.mHl.size(); i++) {
            if (this.mHl.get(i).H(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String dys() {
        return this.mHl.get(0).dys();
    }
}
