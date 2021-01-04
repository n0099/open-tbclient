package com.bytedance.sdk.openadsdk.preload.geckox.statistic.model;

import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f7816a;

    /* renamed from: b  reason: collision with root package name */
    public String f7817b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;

    public static String a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        String str = map.get("x-tt-logid");
        if (TextUtils.isEmpty(str)) {
            String str2 = map.get("X-Tt-Logid");
            if (TextUtils.isEmpty(str2)) {
                String str3 = map.get("X-TT-LOGID");
                return TextUtils.isEmpty(str3) ? "" : str3;
            }
            return str2;
        }
        return str;
    }
}
