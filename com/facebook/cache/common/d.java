package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes13.dex */
public class d implements b {
    final List<b> lGX;

    public List<b> getCacheKeys() {
        return this.lGX;
    }

    public String toString() {
        return "MultiCacheKey:" + this.lGX.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.lGX.equals(((d) obj).lGX);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.lGX.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean A(Uri uri) {
        for (int i = 0; i < this.lGX.size(); i++) {
            if (this.lGX.get(i).A(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String djU() {
        return this.lGX.get(0).djU();
    }
}
