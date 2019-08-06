package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> jZd;

    public List<b> cEn() {
        return this.jZd;
    }

    public String toString() {
        return "MultiCacheKey:" + this.jZd.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.jZd.equals(((d) obj).jZd);
        }
        return false;
    }

    public int hashCode() {
        return this.jZd.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean x(Uri uri) {
        for (int i = 0; i < this.jZd.size(); i++) {
            if (this.jZd.get(i).x(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String cEm() {
        return this.jZd.get(0).cEm();
    }
}
