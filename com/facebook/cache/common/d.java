package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes11.dex */
public class d implements b {
    final List<b> lCL;

    public List<b> getCacheKeys() {
        return this.lCL;
    }

    public String toString() {
        return "MultiCacheKey:" + this.lCL.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.lCL.equals(((d) obj).lCL);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.lCL.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean z(Uri uri) {
        for (int i = 0; i < this.lCL.size(); i++) {
            if (this.lCL.get(i).z(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String dhC() {
        return this.lCL.get(0).dhC();
    }
}
