package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes5.dex */
public class d implements b {
    final List<b> pxZ;

    public List<b> getCacheKeys() {
        return this.pxZ;
    }

    public String toString() {
        return "MultiCacheKey:" + this.pxZ.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.pxZ.equals(((d) obj).pxZ);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.pxZ.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        for (int i = 0; i < this.pxZ.size(); i++) {
            if (this.pxZ.get(i).I(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String erU() {
        return this.pxZ.get(0).erU();
    }
}
