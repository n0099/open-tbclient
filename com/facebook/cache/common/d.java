package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes13.dex */
public class d implements b {
    final List<b> lQj;

    public List<b> dml() {
        return this.lQj;
    }

    public String toString() {
        return "MultiCacheKey:" + this.lQj.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.lQj.equals(((d) obj).lQj);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.lQj.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean E(Uri uri) {
        for (int i = 0; i < this.lQj.size(); i++) {
            if (this.lQj.get(i).E(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String dmk() {
        return this.lQj.get(0).dmk();
    }
}
