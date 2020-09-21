package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes12.dex */
public class d implements b {
    final List<b> ntI;

    public List<b> dRR() {
        return this.ntI;
    }

    public String toString() {
        return "MultiCacheKey:" + this.ntI.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.ntI.equals(((d) obj).ntI);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.ntI.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        for (int i = 0; i < this.ntI.size(); i++) {
            if (this.ntI.get(i).I(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String dRQ() {
        return this.ntI.get(0).dRQ();
    }
}
