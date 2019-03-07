package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> jys;

    public List<b> csN() {
        return this.jys;
    }

    public String toString() {
        return "MultiCacheKey:" + this.jys.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.jys.equals(((d) obj).jys);
        }
        return false;
    }

    public int hashCode() {
        return this.jys.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean r(Uri uri) {
        for (int i = 0; i < this.jys.size(); i++) {
            if (this.jys.get(i).r(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.jys.get(0).getUriString();
    }
}
