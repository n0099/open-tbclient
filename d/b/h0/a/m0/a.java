package d.b.h0.a.m0;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    public static Map<String, String> a(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "fminapp");
        hashMap.put("third_id", str);
        hashMap.put("op_type", str2);
        hashMap.put("sfrom", "sbox");
        hashMap.put("store", "uid_cuid");
        hashMap.put("source", "miniprogram_collection");
        if (Integer.valueOf(str3).intValue() > 0) {
            hashMap.put("sort_index", str3);
        }
        return hashMap;
    }

    public static Map<String, String> b(String str, String str2) {
        if (str != null && str2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "fminapp");
            hashMap.put("third_id", str);
            hashMap.put("sfrom", "sbox");
            hashMap.put("store", "uid_cuid");
            hashMap.put("source", "miniprogram_collection");
            hashMap.put("sort_index", str2);
            return hashMap;
        }
        return new HashMap();
    }
}
