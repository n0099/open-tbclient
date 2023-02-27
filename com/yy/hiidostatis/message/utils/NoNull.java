package com.yy.hiidostatis.message.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class NoNull {
    public static String noNull(String str) {
        return str == null ? "" : str;
    }

    public static boolean isEmpty(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    public static <T> List<T> noNull(List<T> list) {
        if (list == null) {
            return new ArrayList();
        }
        return list;
    }

    public static boolean isEmpty(Collection collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public static <K, V> Map<K, V> noNull(Map<K, V> map) {
        if (map == null) {
            return new HashMap();
        }
        return map;
    }

    public static boolean isEmpty(Map map) {
        if (map != null && !map.isEmpty()) {
            return false;
        }
        return true;
    }
}
