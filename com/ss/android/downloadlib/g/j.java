package com.ss.android.downloadlib.g;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class j {
    public static Map<String, a> a = Collections.synchronizedMap(new HashMap());

    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void a(String str);
    }

    public static void a(String str) {
        a c;
        if (TextUtils.isEmpty(str) || (c = c(str)) == null) {
            return;
        }
        c.a();
    }

    public static boolean b(String str) {
        return com.ss.android.downloadlib.addownload.j.e().a(com.ss.android.downloadlib.addownload.j.getContext(), str);
    }

    public static a c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a.remove(str);
    }

    public static void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            a.put(str, aVar);
        }
    }

    public static void a(String str, String str2) {
        a c;
        if (TextUtils.isEmpty(str) || (c = c(str)) == null) {
            return;
        }
        c.a(str2);
    }

    public static void a(String[] strArr, a aVar) {
        if (strArr != null && strArr.length > 0) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            a(valueOf, aVar);
            TTDelegateActivity.a(valueOf, strArr);
        }
    }
}
