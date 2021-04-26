package com.facebook.cache.common;

import com.facebook.common.util.SecureHashUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class CacheKeyUtil {
    public static String getFirstResourceId(CacheKey cacheKey) {
        try {
            if (cacheKey instanceof MultiCacheKey) {
                return secureHashKey(((MultiCacheKey) cacheKey).getCacheKeys().get(0));
            }
            return secureHashKey(cacheKey);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static List<String> getResourceIds(CacheKey cacheKey) {
        try {
            if (cacheKey instanceof MultiCacheKey) {
                List<CacheKey> cacheKeys = ((MultiCacheKey) cacheKey).getCacheKeys();
                ArrayList arrayList = new ArrayList(cacheKeys.size());
                for (int i2 = 0; i2 < cacheKeys.size(); i2++) {
                    arrayList.add(secureHashKey(cacheKeys.get(i2)));
                }
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(secureHashKey(cacheKey));
            return arrayList2;
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String secureHashKey(CacheKey cacheKey) throws UnsupportedEncodingException {
        return SecureHashUtil.makeSHA1HashBase64(cacheKey.getUriString().getBytes("UTF-8"));
    }
}
