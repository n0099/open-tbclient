package com.ss.android.downloadlib.f;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, a> f12987a = Collections.synchronizedMap(new HashMap());

    /* loaded from: classes4.dex */
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
        a ZL;
        if (!TextUtils.isEmpty(str) && (ZL = ZL(str)) != null) {
            ZL.a();
        }
    }

    public static void a(String str, String str2) {
        a ZL;
        if (!TextUtils.isEmpty(str) && (ZL = ZL(str)) != null) {
            ZL.a(str2);
        }
    }

    private static void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            f12987a.put(str, aVar);
        }
    }

    private static a ZL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f12987a.remove(str);
    }

    public static boolean b(String str) {
        return com.ss.android.downloadlib.a.j.eCq().a(com.ss.android.downloadlib.a.j.a(), str);
    }
}
