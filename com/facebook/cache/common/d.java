package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> jZK;

    public List<b> cBZ() {
        return this.jZK;
    }

    public String toString() {
        return "MultiCacheKey:" + this.jZK.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.jZK.equals(((d) obj).jZK);
        }
        return false;
    }

    public int hashCode() {
        return this.jZK.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean u(Uri uri) {
        for (int i = 0; i < this.jZK.size(); i++) {
            if (this.jZK.get(i).u(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String cBY() {
        return this.jZK.get(0).cBY();
    }
}
