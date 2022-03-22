package com.ss.android.socialbase.downloader.constants;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public static volatile String a = "";

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f43196b = "";

    /* renamed from: c  reason: collision with root package name */
    public static volatile String f43197c = "";

    /* renamed from: d  reason: collision with root package name */
    public static long f43198d = 512000;

    /* renamed from: e  reason: collision with root package name */
    public static long f43199e = 50;

    /* renamed from: f  reason: collision with root package name */
    public static long f43200f = 5242880;

    /* renamed from: g  reason: collision with root package name */
    public static long f43201g = 31457280;

    /* renamed from: h  reason: collision with root package name */
    public static long f43202h = 10485760;
    public static final JSONObject i = new JSONObject();

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a = str;
    }
}
