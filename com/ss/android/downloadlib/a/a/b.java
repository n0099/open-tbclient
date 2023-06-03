package com.ss.android.downloadlib.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.ss.android.downloadlib.addownload.j;
/* loaded from: classes10.dex */
public class b {
    public static String a() {
        return b(j.getContext());
    }

    public static String a(Context context) {
        try {
            return a(c.a(a(), "MD5"));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(Context context) {
        String str;
        try {
            str = ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return "normal";
        }
        return str;
    }

    public static String a(byte[] bArr) {
        return a.a(bArr);
    }
}
