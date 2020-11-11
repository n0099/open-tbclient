package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes12.dex */
public class d implements b {
    final List<b> oJO;

    public List<b> ejp() {
        return this.oJO;
    }

    public String toString() {
        return "MultiCacheKey:" + this.oJO.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.oJO.equals(((d) obj).oJO);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.oJO.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean I(Uri uri) {
        for (int i = 0; i < this.oJO.size(); i++) {
            if (this.oJO.get(i).I(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String ejo() {
        return this.oJO.get(0).ejo();
    }
}
