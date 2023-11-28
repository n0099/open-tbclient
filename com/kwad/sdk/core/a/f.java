package com.kwad.sdk.core.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes10.dex */
public final class f {
    public static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    public static String N(String str, String str2) {
        Uri parse = Uri.parse(str);
        return parse.getPath() + "&" + dm(parse.getQuery()) + "&" + str2;
    }

    public static void a(String str, Map<String, String> map, String str2) {
        map.put("Ks-Sig1", dn(N(str, str2)));
    }

    public static String dm(String str) {
        if (TextUtils.isEmpty(str)) {
            return emptyIfNull(str);
        }
        String[] split = str.split("&");
        Arrays.sort(split);
        return TextUtils.join("&", split);
    }

    public static String dn(String str) {
        String doSign;
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null || (doSign = KWEGIDDFP.doSign(context, str)) == null) {
            return "";
        }
        return doSign;
    }
}
