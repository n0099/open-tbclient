package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes5.dex */
public class d implements b {
    final List<b> pxz;

    public List<b> getCacheKeys() {
        return this.pxz;
    }

    public String toString() {
        return "MultiCacheKey:" + this.pxz.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.pxz.equals(((d) obj).pxz);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.pxz.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        for (int i = 0; i < this.pxz.size(); i++) {
            if (this.pxz.get(i).I(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String erM() {
        return this.pxz.get(0).erM();
    }
}
