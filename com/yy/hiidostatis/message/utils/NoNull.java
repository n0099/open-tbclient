package com.yy.hiidostatis.message.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class NoNull {
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String noNull(String str) {
        return str == null ? "" : str;
    }

    public static <T> List<T> noNull(List<T> list) {
        return list == null ? new ArrayList() : list;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static <K, V> Map<K, V> noNull(Map<K, V> map) {
        return map == null ? new HashMap() : map;
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }
}
