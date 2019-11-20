package com.facebook.cache.common;

import android.net.Uri;
/* loaded from: classes2.dex */
public class g implements b {
    final String mKey;

    public g(String str) {
        this.mKey = (String) com.facebook.common.internal.g.checkNotNull(str);
    }

    public String toString() {
        return this.mKey;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            return this.mKey.equals(((g) obj).mKey);
        }
        return false;
    }

    public int hashCode() {
        return this.mKey.hashCode();
    }

    @Override // com.facebook.cache.common.b
    public boolean u(Uri uri) {
        return this.mKey.contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public String cBW() {
        return this.mKey;
    }
}
