package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> jQS;

    public List<b> cAR() {
        return this.jQS;
    }

    public String toString() {
        return "MultiCacheKey:" + this.jQS.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.jQS.equals(((d) obj).jQS);
        }
        return false;
    }

    public int hashCode() {
        return this.jQS.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean x(Uri uri) {
        for (int i = 0; i < this.jQS.size(); i++) {
            if (this.jQS.get(i).x(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String getUriString() {
        return this.jQS.get(0).getUriString();
    }
}
