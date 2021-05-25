package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes6.dex */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f34017a = new SimpleDateFormat("MM/dd", Locale.US);

    /* renamed from: b  reason: collision with root package name */
    public static final SimpleDateFormat f34018b = new SimpleDateFormat("yyyy/MM/dd", Locale.US);

    /* renamed from: c  reason: collision with root package name */
    public static final SimpleDateFormat f34019c = new SimpleDateFormat("MM月dd日", Locale.US);

    /* renamed from: d  reason: collision with root package name */
    public static final SimpleDateFormat f34020d = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);

    /* renamed from: e  reason: collision with root package name */
    public static final SimpleDateFormat f34021e = new SimpleDateFormat("HH:mm", Locale.US);

    /* renamed from: f  reason: collision with root package name */
    public static final SimpleDateFormat f34022f = new SimpleDateFormat("MM-dd", Locale.US);

    /* renamed from: g  reason: collision with root package name */
    public static final SimpleDateFormat f34023g = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public static boolean a(String str) {
        return TextUtils.isEmpty(str) || StringUtil.NULL_STRING.equalsIgnoreCase(str);
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }
}
