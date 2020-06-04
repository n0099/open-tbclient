package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes13.dex */
public class d implements b {
    final List<b> mlp;

    public List<b> dtQ() {
        return this.mlp;
    }

    public String toString() {
        return "MultiCacheKey:" + this.mlp.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.mlp.equals(((d) obj).mlp);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mlp.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean G(Uri uri) {
        for (int i = 0; i < this.mlp.size(); i++) {
            if (this.mlp.get(i).G(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String dtP() {
        return this.mlp.get(0).dtP();
    }
}
