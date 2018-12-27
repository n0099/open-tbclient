package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> ihG;

    public List<b> bTh() {
        return this.ihG;
    }

    public String toString() {
        return "MultiCacheKey:" + this.ihG.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.ihG.equals(((d) obj).ihG);
        }
        return false;
    }

    public int hashCode() {
        return this.ihG.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean j(Uri uri) {
        for (int i = 0; i < this.ihG.size(); i++) {
            if (this.ihG.get(i).j(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.ihG.get(0).getUriString();
    }
}
