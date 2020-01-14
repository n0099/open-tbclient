package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes12.dex */
public class d implements b {
    final List<b> lGo;

    public List<b> getCacheKeys() {
        return this.lGo;
    }

    public String toString() {
        return "MultiCacheKey:" + this.lGo.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.lGo.equals(((d) obj).lGo);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.lGo.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean z(Uri uri) {
        for (int i = 0; i < this.lGo.size(); i++) {
            if (this.lGo.get(i).z(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String diF() {
        return this.lGo.get(0).diF();
    }
}
