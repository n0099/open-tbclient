package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class m {
    public static final Map<String, Long> a = new HashMap();

    public static void a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList<String> arrayList = new ArrayList(a.size());
        for (Map.Entry<String, Long> entry : a.entrySet()) {
            if (elapsedRealtime - entry.getValue().longValue() > 60000) {
                arrayList.add(entry.getKey());
            }
        }
        for (String str : arrayList) {
            a.remove(str);
        }
    }

    public static boolean a(byte[] bArr, String str) {
        boolean z = false;
        if (bArr != null && bArr.length > 0 && !TextUtils.isEmpty(str)) {
            String a2 = com.xiaomi.push.bo.a(bArr);
            if (!TextUtils.isEmpty(a2)) {
                synchronized (a) {
                    Map<String, Long> map = a;
                    if (map.get(a2 + str) != null) {
                        z = true;
                    } else {
                        Map<String, Long> map2 = a;
                        map2.put(a2 + str, Long.valueOf(SystemClock.elapsedRealtime()));
                    }
                    a();
                }
            }
        }
        return z;
    }
}
