package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes7.dex */
public class d implements b {
    final List<b> paA;

    public List<b> epd() {
        return this.paA;
    }

    public String toString() {
        return "MultiCacheKey:" + this.paA.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.paA.equals(((d) obj).paA);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.paA.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean K(Uri uri) {
        for (int i = 0; i < this.paA.size(); i++) {
            if (this.paA.get(i).K(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String epc() {
        return this.paA.get(0).epc();
    }
}
