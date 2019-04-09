package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> jxY;

    public List<b> csT() {
        return this.jxY;
    }

    public String toString() {
        return "MultiCacheKey:" + this.jxY.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.jxY.equals(((d) obj).jxY);
        }
        return false;
    }

    public int hashCode() {
        return this.jxY.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean r(Uri uri) {
        for (int i = 0; i < this.jxY.size(); i++) {
            if (this.jxY.get(i).r(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.jxY.get(0).getUriString();
    }
}
