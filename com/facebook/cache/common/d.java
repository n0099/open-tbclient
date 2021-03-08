package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes5.dex */
public class d implements b {
    final List<b> pAe;

    public List<b> getCacheKeys() {
        return this.pAe;
    }

    public String toString() {
        return "MultiCacheKey:" + this.pAe.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.pAe.equals(((d) obj).pAe);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.pAe.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        for (int i = 0; i < this.pAe.size(); i++) {
            if (this.pAe.get(i).I(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String esd() {
        return this.pAe.get(0).esd();
    }
}
