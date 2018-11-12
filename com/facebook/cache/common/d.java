package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> hXj;

    public List<b> bQl() {
        return this.hXj;
    }

    public String toString() {
        return "MultiCacheKey:" + this.hXj.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.hXj.equals(((d) obj).hXj);
        }
        return false;
    }

    public int hashCode() {
        return this.hXj.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean i(Uri uri) {
        for (int i = 0; i < this.hXj.size(); i++) {
            if (this.hXj.get(i).i(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.hXj.get(0).getUriString();
    }
}
