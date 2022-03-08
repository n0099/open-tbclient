package com.ss.android.socialbase.downloader.constants;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    public static volatile String a = "";

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f58465b = "";

    /* renamed from: c  reason: collision with root package name */
    public static volatile String f58466c = "";

    /* renamed from: d  reason: collision with root package name */
    public static long f58467d = 512000;

    /* renamed from: e  reason: collision with root package name */
    public static long f58468e = 50;

    /* renamed from: f  reason: collision with root package name */
    public static long f58469f = 5242880;

    /* renamed from: g  reason: collision with root package name */
    public static long f58470g = 31457280;

    /* renamed from: h  reason: collision with root package name */
    public static long f58471h = 10485760;

    /* renamed from: i  reason: collision with root package name */
    public static final JSONObject f58472i = new JSONObject();

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a = str;
    }
}
