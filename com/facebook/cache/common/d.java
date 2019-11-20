package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> jYT;

    public List<b> cBX() {
        return this.jYT;
    }

    public String toString() {
        return "MultiCacheKey:" + this.jYT.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.jYT.equals(((d) obj).jYT);
        }
        return false;
    }

    public int hashCode() {
        return this.jYT.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean u(Uri uri) {
        for (int i = 0; i < this.jYT.size(); i++) {
            if (this.jYT.get(i).u(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String cBW() {
        return this.jYT.get(0).cBW();
    }
}
