package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> hVy;

    public List<b> bQQ() {
        return this.hVy;
    }

    public String toString() {
        return "MultiCacheKey:" + this.hVy.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.hVy.equals(((d) obj).hVy);
        }
        return false;
    }

    public int hashCode() {
        return this.hVy.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean i(Uri uri) {
        for (int i = 0; i < this.hVy.size(); i++) {
            if (this.hVy.get(i).i(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.hVy.get(0).getUriString();
    }
}
