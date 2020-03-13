package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes13.dex */
public class d implements b {
    final List<b> lHi;

    public List<b> getCacheKeys() {
        return this.lHi;
    }

    public String toString() {
        return "MultiCacheKey:" + this.lHi.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.lHi.equals(((d) obj).lHi);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.lHi.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean A(Uri uri) {
        for (int i = 0; i < this.lHi.size(); i++) {
            if (this.lHi.get(i).A(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String djV() {
        return this.lHi.get(0).djV();
    }
}
