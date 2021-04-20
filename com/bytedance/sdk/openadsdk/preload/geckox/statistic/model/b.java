package com.bytedance.sdk.openadsdk.preload.geckox.statistic.model;

import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f30019a;

    /* renamed from: b  reason: collision with root package name */
    public String f30020b;

    /* renamed from: c  reason: collision with root package name */
    public String f30021c;

    /* renamed from: d  reason: collision with root package name */
    public String f30022d;

    /* renamed from: e  reason: collision with root package name */
    public String f30023e;

    /* renamed from: f  reason: collision with root package name */
    public String f30024f;

    /* renamed from: g  reason: collision with root package name */
    public int f30025g;

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
