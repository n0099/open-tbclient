package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> jyL;

    public List<b> csX() {
        return this.jyL;
    }

    public String toString() {
        return "MultiCacheKey:" + this.jyL.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.jyL.equals(((d) obj).jyL);
        }
        return false;
    }

    public int hashCode() {
        return this.jyL.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean r(Uri uri) {
        for (int i = 0; i < this.jyL.size(); i++) {
            if (this.jyL.get(i).r(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.jyL.get(0).getUriString();
    }
}
