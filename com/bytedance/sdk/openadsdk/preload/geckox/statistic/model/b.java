package com.bytedance.sdk.openadsdk.preload.geckox.statistic.model;

import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f30027a;

    /* renamed from: b  reason: collision with root package name */
    public String f30028b;

    /* renamed from: c  reason: collision with root package name */
    public String f30029c;

    /* renamed from: d  reason: collision with root package name */
    public String f30030d;

    /* renamed from: e  reason: collision with root package name */
    public String f30031e;

    /* renamed from: f  reason: collision with root package name */
    public String f30032f;

    /* renamed from: g  reason: collision with root package name */
    public int f30033g;

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
