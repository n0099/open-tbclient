package com.ss.android.downloadlib.f;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, a> f7733a = Collections.synchronizedMap(new HashMap());

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(String str);
    }

    public static void a(String[] strArr, a aVar) {
        if (strArr != null && strArr.length > 0) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            a(valueOf, aVar);
            TTDelegateActivity.a(valueOf, strArr);
        }
    }

    public static void a(String str) {
        a abd;
        if (!TextUtils.isEmpty(str) && (abd = abd(str)) != null) {
            abd.a();
        }
    }

    public static void a(String str, String str2) {
        a abd;
        if (!TextUtils.isEmpty(str) && (abd = abd(str)) != null) {
            abd.a(str2);
        }
    }

    private static void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            f7733a.put(str, aVar);
        }
    }

    private static a abd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f7733a.remove(str);
    }

    public static boolean b(String str) {
        return com.ss.android.downloadlib.a.j.eET().a(com.ss.android.downloadlib.a.j.a(), str);
    }
}
