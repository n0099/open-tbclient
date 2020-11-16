package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes17.dex */
public class d implements b {
    final List<b> oLs;

    public List<b> ejn() {
        return this.oLs;
    }

    public String toString() {
        return "MultiCacheKey:" + this.oLs.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.oLs.equals(((d) obj).oLs);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.oLs.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean J(Uri uri) {
        for (int i = 0; i < this.oLs.size(); i++) {
            if (this.oLs.get(i).J(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String ejm() {
        return this.oLs.get(0).ejm();
    }
}
