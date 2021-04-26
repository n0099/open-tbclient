package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import java.util.List;
/* loaded from: classes6.dex */
public class MultiCacheKey implements CacheKey {
    public final List<CacheKey> mCacheKeys;

    public MultiCacheKey(List<CacheKey> list) {
        this.mCacheKeys = (List) Preconditions.checkNotNull(list);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(Uri uri) {
        for (int i2 = 0; i2 < this.mCacheKeys.size(); i2++) {
            if (this.mCacheKeys.get(i2).containsUri(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiCacheKey) {
            return this.mCacheKeys.equals(((MultiCacheKey) obj).mCacheKeys);
        }
        return false;
    }

    public List<CacheKey> getCacheKeys() {
        return this.mCacheKeys;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        return this.mCacheKeys.get(0).getUriString();
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.mCacheKeys.hashCode();
    }

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        return "MultiCacheKey:" + this.mCacheKeys.toString();
    }
}
