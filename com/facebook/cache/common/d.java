package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements b {
    final List<b> mPu;

    public List<b> dBJ() {
        return this.mPu;
    }

    public String toString() {
        return "MultiCacheKey:" + this.mPu.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.mPu.equals(((d) obj).mPu);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mPu.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean G(Uri uri) {
        for (int i = 0; i < this.mPu.size(); i++) {
            if (this.mPu.get(i).G(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String dBI() {
        return this.mPu.get(0).dBI();
    }
}
