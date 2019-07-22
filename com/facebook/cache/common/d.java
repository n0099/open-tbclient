package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> jXX;

    public List<b> cDS() {
        return this.jXX;
    }

    public String toString() {
        return "MultiCacheKey:" + this.jXX.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.jXX.equals(((d) obj).jXX);
        }
        return false;
    }

    public int hashCode() {
        return this.jXX.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean x(Uri uri) {
        for (int i = 0; i < this.jXX.size(); i++) {
            if (this.jXX.get(i).x(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String cDR() {
        return this.jXX.get(0).cDR();
    }
}
