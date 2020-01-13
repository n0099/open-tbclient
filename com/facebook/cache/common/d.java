package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes12.dex */
public class d implements b {
    final List<b> lGj;

    public List<b> getCacheKeys() {
        return this.lGj;
    }

    public String toString() {
        return "MultiCacheKey:" + this.lGj.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.lGj.equals(((d) obj).lGj);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.lGj.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean z(Uri uri) {
        for (int i = 0; i < this.lGj.size(); i++) {
            if (this.lGj.get(i).z(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String diD() {
        return this.lGj.get(0).diD();
    }
}
