package com.kwad.sdk.core.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class f {
    public static String a(String str) {
        String n;
        Context context = KsAdSDKImpl.get().getContext();
        return (context == null || (n = d.r.a.a.b.n(context, str)) == null) ? "" : n;
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

    public static void a(String str, Map<String, String> map, JSONObject jSONObject) {
        map.put("Ks-Sig1", a(b(str, new HashMap(), jSONObject)));
    }

    public static String b(String str, Map<String, String> map, JSONObject jSONObject) {
        List<String> a2 = a(map);
        return str + "&" + TextUtils.join("&", a2) + "&" + jSONObject.toString();
    }

    public static boolean b(String str) {
        return TextUtils.isEmpty(str) || str.startsWith("__");
    }

    public static String c(String str) {
        return str == null ? "" : str;
    }
}
