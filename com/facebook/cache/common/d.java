package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes8.dex */
public class d implements b {
    final List<b> njr;

    public List<b> dNK() {
        return this.njr;
    }

    public String toString() {
        return "MultiCacheKey:" + this.njr.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.njr.equals(((d) obj).njr);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.njr.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean G(Uri uri) {
        for (int i = 0; i < this.njr.size(); i++) {
            if (this.njr.get(i).G(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String dNJ() {
        return this.njr.get(0).dNJ();
    }
}
