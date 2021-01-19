package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes5.dex */
public class d implements b {
    final List<b> pnk;

    public List<b> getCacheKeys() {
        return this.pnk;
    }

    public String toString() {
        return "MultiCacheKey:" + this.pnk.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.pnk.equals(((d) obj).pnk);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.pnk.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        for (int i = 0; i < this.pnk.size(); i++) {
            if (this.pnk.get(i).I(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String ept() {
        return this.pnk.get(0).ept();
    }
}
