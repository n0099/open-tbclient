package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes4.dex */
public class at {
    public static final SimpleDateFormat a = new SimpleDateFormat("MM/dd", Locale.US);

    /* renamed from: b  reason: collision with root package name */
    public static final SimpleDateFormat f58112b = new SimpleDateFormat("yyyy/MM/dd", Locale.US);

    /* renamed from: c  reason: collision with root package name */
    public static final SimpleDateFormat f58113c = new SimpleDateFormat("MM月dd日", Locale.US);

    /* renamed from: d  reason: collision with root package name */
    public static final SimpleDateFormat f58114d = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);

    /* renamed from: e  reason: collision with root package name */
    public static final SimpleDateFormat f58115e = new SimpleDateFormat("HH:mm", Locale.US);

    /* renamed from: f  reason: collision with root package name */
    public static final SimpleDateFormat f58116f = new SimpleDateFormat("MM-dd", Locale.US);

    /* renamed from: g  reason: collision with root package name */
    public static final SimpleDateFormat f58117g = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    @Deprecated
    public static boolean a(String str) {
        return TextUtils.isEmpty(str) || StringUtil.NULL_STRING.equalsIgnoreCase(str);
    }

    public static boolean a(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }
}
