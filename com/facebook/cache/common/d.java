package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes8.dex */
public class d implements b {
    final List<b> njJ;

    public List<b> dNT() {
        return this.njJ;
    }

    public String toString() {
        return "MultiCacheKey:" + this.njJ.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.njJ.equals(((d) obj).njJ);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.njJ.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean G(Uri uri) {
        for (int i = 0; i < this.njJ.size(); i++) {
            if (this.njJ.get(i).G(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String dNS() {
        return this.njJ.get(0).dNS();
    }
}
