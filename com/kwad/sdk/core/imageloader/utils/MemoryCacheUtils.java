package com.kwad.sdk.core.imageloader.utils;

import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes7.dex */
public final class MemoryCacheUtils {
    public static final String URI_AND_SIZE_SEPARATOR = "_";
    public static final String WIDTH_AND_HEIGHT_SEPARATOR = "x";

    public static Comparator<String> createFuzzyKeyComparator() {
        return new Comparator<String>() { // from class: com.kwad.sdk.core.imageloader.utils.MemoryCacheUtils.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.substring(0, str.lastIndexOf("_")).compareTo(str2.substring(0, str2.lastIndexOf("_")));
            }
        };
    }

    public static List<String> findCacheKeysForImageUri(String str, MemoryCache memoryCache) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : memoryCache.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static List<DecodedResult> findCachedBitmapsForImageUri(String str, MemoryCache memoryCache) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : memoryCache.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(memoryCache.get(str2));
            }
        }
        return arrayList;
    }

    public static String generateKey(String str, ImageSize imageSize) {
        return str + "_" + imageSize.getWidth() + "x" + imageSize.getHeight();
    }

    public static void removeFromCache(String str, MemoryCache memoryCache) {
        ArrayList<String> arrayList = new ArrayList();
        for (String str2 : memoryCache.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        for (String str3 : arrayList) {
            memoryCache.remove(str3);
        }
    }
}
