package com.kwad.sdk.core.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import com.kwad.sdk.KsAdSDKImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class f {
    public static String a(String str) {
        String b;
        Context context = KsAdSDKImpl.get().getContext();
        return (context == null || (b = com.yxcorp.kuaishou.addfp.a.b(context, str)) == null) ? "" : b;
    }

    private static List<String> a(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!b(key)) {
                arrayList.add(key + "=" + c(entry.getValue()));
            }
        }
        try {
            Collections.sort(arrayList);
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        return arrayList;
    }

    public static void a(String str, Map<String, String> map, JSONObject jSONObject) {
        map.put("Ks-Sig1", a(b(str, new HashMap(), jSONObject)));
    }

    private static String b(String str, Map<String, String> map, JSONObject jSONObject) {
        return str + ETAG.ITEM_SEPARATOR + TextUtils.join(ETAG.ITEM_SEPARATOR, a(map)) + ETAG.ITEM_SEPARATOR + jSONObject.toString();
    }

    private static boolean b(String str) {
        return TextUtils.isEmpty(str) || str.startsWith("__");
    }

    private static String c(String str) {
        return str == null ? "" : str;
    }
}
