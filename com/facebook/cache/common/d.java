package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes7.dex */
public class d implements b {
    final List<b> paC;

    public List<b> epe() {
        return this.paC;
    }

    public String toString() {
        return "MultiCacheKey:" + this.paC.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.paC.equals(((d) obj).paC);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.paC.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean K(Uri uri) {
        for (int i = 0; i < this.paC.size(); i++) {
            if (this.paC.get(i).K(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String epd() {
        return this.paC.get(0).epd();
    }
}
