package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> iiO;

    public List<b> bTP() {
        return this.iiO;
    }

    public String toString() {
        return "MultiCacheKey:" + this.iiO.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.iiO.equals(((d) obj).iiO);
        }
        return false;
    }

    public int hashCode() {
        return this.iiO.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean j(Uri uri) {
        for (int i = 0; i < this.iiO.size(); i++) {
            if (this.iiO.get(i).j(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.iiO.get(0).getUriString();
    }
}
