package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes13.dex */
public class d implements b {
    final List<b> mkf;

    public List<b> dtC() {
        return this.mkf;
    }

    public String toString() {
        return "MultiCacheKey:" + this.mkf.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.mkf.equals(((d) obj).mkf);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mkf.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean G(Uri uri) {
        for (int i = 0; i < this.mkf.size(); i++) {
            if (this.mkf.get(i).G(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String dtB() {
        return this.mkf.get(0).dtB();
    }
}
