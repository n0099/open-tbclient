package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> jQO;

    public List<b> cAQ() {
        return this.jQO;
    }

    public String toString() {
        return "MultiCacheKey:" + this.jQO.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.jQO.equals(((d) obj).jQO);
        }
        return false;
    }

    public int hashCode() {
        return this.jQO.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean x(Uri uri) {
        for (int i = 0; i < this.jQO.size(); i++) {
            if (this.jQO.get(i).x(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.jQO.get(0).getUriString();
    }
}
