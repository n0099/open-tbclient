package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes13.dex */
public class d implements b {
    final List<b> lQn;

    public List<b> dmj() {
        return this.lQn;
    }

    public String toString() {
        return "MultiCacheKey:" + this.lQn.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.lQn.equals(((d) obj).lQn);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.lQn.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean E(Uri uri) {
        for (int i = 0; i < this.lQn.size(); i++) {
            if (this.lQn.get(i).E(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String dmi() {
        return this.lQn.get(0).dmi();
    }
}
