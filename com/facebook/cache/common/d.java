package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes5.dex */
public class d implements b {
    final List<b> prO;

    public List<b> getCacheKeys() {
        return this.prO;
    }

    public String toString() {
        return "MultiCacheKey:" + this.prO.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.prO.equals(((d) obj).prO);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.prO.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean L(Uri uri) {
        for (int i = 0; i < this.prO.size(); i++) {
            if (this.prO.get(i).L(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String etn() {
        return this.prO.get(0).etn();
    }
}
