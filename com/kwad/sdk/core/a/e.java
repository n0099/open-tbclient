package com.kwad.sdk.core.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes5.dex */
public final class e {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return b(str);
        }
        String[] split = str.split("&");
        Arrays.sort(split);
        return TextUtils.join("&", split);
    }

    public static String a(String str, String str2) {
        Uri parse = Uri.parse(str);
        return parse.getPath() + "&" + a(parse.getQuery()) + "&" + str2;
    }

    public static void a(String str, Map<String, String> map, String str2) {
        map.put("Ks-Sig1", c(a(str, str2)));
    }

    public static String b(String str) {
        return str == null ? "" : str;
    }

    public static String c(String str) {
        String doSign;
        Context a = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        return (a == null || (doSign = KWEGIDDFP.doSign(a, str)) == null) ? "" : doSign;
    }
}
