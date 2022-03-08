package com.kwad.sdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class f {
    public static String a(String str) {
        String doSign;
        Context context = KsAdSDKImpl.get().getContext();
        return (context == null || (doSign = KWEGIDDFP.doSign(context, str)) == null) ? "" : doSign;
    }

    public static List<String> a(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!b(key)) {
                arrayList.add(key + "=" + c(entry.getValue()));
            }
        }
        try {
            Collections.sort(arrayList);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        return arrayList;
    }

    public static void a(String str, Map<String, String> map, String str2) {
        map.put("Ks-Sig1", a(b(str, new HashMap(), str2)));
    }

    public static String b(String str, Map<String, String> map, String str2) {
        List<String> a = a(map);
        return str + "&" + TextUtils.join("&", a) + "&" + str2;
    }

    public static boolean b(String str) {
        return TextUtils.isEmpty(str) || str.startsWith("__");
    }

    public static String c(String str) {
        return str == null ? "" : str;
    }
}
