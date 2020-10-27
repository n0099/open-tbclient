package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes12.dex */
public class d implements b {
    final List<b> oAv;

    public List<b> efA() {
        return this.oAv;
    }

    public String toString() {
        return "MultiCacheKey:" + this.oAv.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.oAv.equals(((d) obj).oAv);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.oAv.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        for (int i = 0; i < this.oAv.size(); i++) {
            if (this.oAv.get(i).I(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String efz() {
        return this.oAv.get(0).efz();
    }
}
