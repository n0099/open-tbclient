package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> iew;

    public List<b> bSr() {
        return this.iew;
    }

    public String toString() {
        return "MultiCacheKey:" + this.iew.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.iew.equals(((d) obj).iew);
        }
        return false;
    }

    public int hashCode() {
        return this.iew.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean j(Uri uri) {
        for (int i = 0; i < this.iew.size(); i++) {
            if (this.iew.get(i).j(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.iew.get(0).getUriString();
    }
}
