package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> jQP;

    public List<b> cAS() {
        return this.jQP;
    }

    public String toString() {
        return "MultiCacheKey:" + this.jQP.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.jQP.equals(((d) obj).jQP);
        }
        return false;
    }

    public int hashCode() {
        return this.jQP.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean x(Uri uri) {
        for (int i = 0; i < this.jQP.size(); i++) {
            if (this.jQP.get(i).x(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.jQP.get(0).getUriString();
    }
}
