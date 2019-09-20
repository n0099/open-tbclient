package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes2.dex */
public class d implements b {
    final List<b> kbA;

    public List<b> cFb() {
        return this.kbA;
    }

    public String toString() {
        return "MultiCacheKey:" + this.kbA.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.kbA.equals(((d) obj).kbA);
        }
        return false;
    }

    public int hashCode() {
        return this.kbA.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean x(Uri uri) {
        for (int i = 0; i < this.kbA.size(); i++) {
            if (this.kbA.get(i).x(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String cFa() {
        return this.kbA.get(0).cFa();
    }
}
