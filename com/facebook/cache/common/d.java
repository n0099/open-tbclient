package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> hVz;

    public List<b> bQQ() {
        return this.hVz;
    }

    public String toString() {
        return "MultiCacheKey:" + this.hVz.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.hVz.equals(((d) obj).hVz);
        }
        return false;
    }

    public int hashCode() {
        return this.hVz.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean i(Uri uri) {
        for (int i = 0; i < this.hVz.size(); i++) {
            if (this.hVz.get(i).i(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.hVz.get(0).getUriString();
    }
}
