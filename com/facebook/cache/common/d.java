package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> iiN;

    public List<b> bTP() {
        return this.iiN;
    }

    public String toString() {
        return "MultiCacheKey:" + this.iiN.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.iiN.equals(((d) obj).iiN);
        }
        return false;
    }

    public int hashCode() {
        return this.iiN.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean j(Uri uri) {
        for (int i = 0; i < this.iiN.size(); i++) {
            if (this.iiN.get(i).j(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.iiN.get(0).getUriString();
    }
}
