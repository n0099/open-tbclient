package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes12.dex */
public class d implements b {
    final List<b> nJc;

    public List<b> dVC() {
        return this.nJc;
    }

    public String toString() {
        return "MultiCacheKey:" + this.nJc.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.nJc.equals(((d) obj).nJc);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.nJc.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        for (int i = 0; i < this.nJc.size(); i++) {
            if (this.nJc.get(i).I(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String dVB() {
        return this.nJc.get(0).dVB();
    }
}
