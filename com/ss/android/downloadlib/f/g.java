package com.ss.android.downloadlib.f;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, a> f13287a = Collections.synchronizedMap(new HashMap());

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
        a aaS;
        if (!TextUtils.isEmpty(str) && (aaS = aaS(str)) != null) {
            aaS.a();
        }
    }

    public static void a(String str, String str2) {
        a aaS;
        if (!TextUtils.isEmpty(str) && (aaS = aaS(str)) != null) {
            aaS.a(str2);
        }
    }

    private static void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            f13287a.put(str, aVar);
        }
    }

    private static a aaS(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f13287a.remove(str);
    }

    public static boolean b(String str) {
        return com.ss.android.downloadlib.a.j.eGh().a(com.ss.android.downloadlib.a.j.a(), str);
    }
}
