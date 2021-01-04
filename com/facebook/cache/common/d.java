package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes6.dex */
public class d implements b {
    final List<b> prN;

    public List<b> getCacheKeys() {
        return this.prN;
    }

    public String toString() {
        return "MultiCacheKey:" + this.prN.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.prN.equals(((d) obj).prN);
        }
        return false;
    }

    public int hashCode() {
        return this.prN.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean L(Uri uri) {
        for (int i = 0; i < this.prN.size(); i++) {
            if (this.prN.get(i).L(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String etj() {
        return this.prN.get(0).etj();
    }
}
