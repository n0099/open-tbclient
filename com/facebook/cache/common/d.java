package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> jxX;

    public List<b> csT() {
        return this.jxX;
    }

    public String toString() {
        return "MultiCacheKey:" + this.jxX.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.jxX.equals(((d) obj).jxX);
        }
        return false;
    }

    public int hashCode() {
        return this.jxX.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean r(Uri uri) {
        for (int i = 0; i < this.jxX.size(); i++) {
            if (this.jxX.get(i).r(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.jxX.get(0).getUriString();
    }
}
