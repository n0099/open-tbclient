package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes13.dex */
public class d implements b {
    final List<b> lIO;

    public List<b> getCacheKeys() {
        return this.lIO;
    }

    public String toString() {
        return "MultiCacheKey:" + this.lIO.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.lIO.equals(((d) obj).lIO);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.lIO.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean A(Uri uri) {
        for (int i = 0; i < this.lIO.size(); i++) {
            if (this.lIO.get(i).A(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String dks() {
        return this.lIO.get(0).dks();
    }
}
