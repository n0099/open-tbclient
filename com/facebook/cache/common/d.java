package com.facebook.cache.common;

import android.net.Uri;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements b {
    final List<b> mPw;

    public List<b> dBK() {
        return this.mPw;
    }

    public String toString() {
        return "MultiCacheKey:" + this.mPw.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return this.mPw.equals(((d) obj).mPw);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.mPw.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean G(Uri uri) {
        for (int i = 0; i < this.mPw.size(); i++) {
            if (this.mPw.get(i).G(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public String dBJ() {
        return this.mPw.get(0).dBJ();
    }
}
