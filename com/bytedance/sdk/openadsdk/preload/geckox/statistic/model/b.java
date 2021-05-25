package com.bytedance.sdk.openadsdk.preload.geckox.statistic.model;

import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f30118a;

    /* renamed from: b  reason: collision with root package name */
    public String f30119b;

    /* renamed from: c  reason: collision with root package name */
    public String f30120c;

    /* renamed from: d  reason: collision with root package name */
    public String f30121d;

    /* renamed from: e  reason: collision with root package name */
    public String f30122e;

    /* renamed from: f  reason: collision with root package name */
    public String f30123f;

    /* renamed from: g  reason: collision with root package name */
    public int f30124g;

    public static String a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            String str = map.get("x-tt-logid");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String str2 = map.get("X-Tt-Logid");
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            String str3 = map.get("X-TT-LOGID");
            if (!TextUtils.isEmpty(str3)) {
                return str3;
            }
        }
        return "";
    }
}
