package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> jyD;

    public List<b> cta() {
        return this.jyD;
    }

    public String toString() {
        return "MultiCacheKey:" + this.jyD.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.jyD.equals(((d) obj).jyD);
        }
        return false;
    }

    public int hashCode() {
        return this.jyD.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean r(Uri uri) {
        for (int i = 0; i < this.jyD.size(); i++) {
            if (this.jyD.get(i).r(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.jyD.get(0).getUriString();
    }
}
