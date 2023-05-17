package com.kwad.sdk.core.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes9.dex */
public final class e {
    public static void a(String str, Map<String, String> map, String str2) {
        map.put("Ks-Sig1", bS(x(str, str2)));
    }

    public static String bQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return bR(str);
        }
        String[] split = str.split("&");
        Arrays.sort(split);
        return TextUtils.join("&", split);
    }

    public static String bR(String str) {
        return str == null ? "" : str;
    }

    public static String bS(String str) {
        String doSign;
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        return (context == null || (doSign = KWEGIDDFP.doSign(context, str)) == null) ? "" : doSign;
    }

    public static String x(String str, String str2) {
        Uri parse = Uri.parse(str);
        return parse.getPath() + "&" + bQ(parse.getQuery()) + "&" + str2;
    }
}
