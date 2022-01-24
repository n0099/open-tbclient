package com.ss.android.socialbase.downloader.constants;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public static volatile String a = "";

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f59948b = "";

    /* renamed from: c  reason: collision with root package name */
    public static volatile String f59949c = "";

    /* renamed from: d  reason: collision with root package name */
    public static long f59950d = 512000;

    /* renamed from: e  reason: collision with root package name */
    public static long f59951e = 50;

    /* renamed from: f  reason: collision with root package name */
    public static long f59952f = 5242880;

    /* renamed from: g  reason: collision with root package name */
    public static long f59953g = 31457280;

    /* renamed from: h  reason: collision with root package name */
    public static long f59954h = 10485760;

    /* renamed from: i  reason: collision with root package name */
    public static final JSONObject f59955i = new JSONObject();

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a = str;
    }
}
