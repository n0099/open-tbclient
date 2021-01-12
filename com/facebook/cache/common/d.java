package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes5.dex */
public class d implements b {
    final List<b> pnj;

    public List<b> getCacheKeys() {
        return this.pnj;
    }

    public String toString() {
        return "MultiCacheKey:" + this.pnj.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.pnj.equals(((d) obj).pnj);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.pnj.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        for (int i = 0; i < this.pnj.size(); i++) {
            if (this.pnj.get(i).I(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String ept() {
        return this.pnj.get(0).ept();
    }
}
