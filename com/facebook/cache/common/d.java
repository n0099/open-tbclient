package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes13.dex */
public class d implements b {
    final List<b> lGV;

    public List<b> getCacheKeys() {
        return this.lGV;
    }

    public String toString() {
        return "MultiCacheKey:" + this.lGV.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.lGV.equals(((d) obj).lGV);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.lGV.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean A(Uri uri) {
        for (int i = 0; i < this.lGV.size(); i++) {
            if (this.lGV.get(i).A(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String djS() {
        return this.lGV.get(0).djS();
    }
}
