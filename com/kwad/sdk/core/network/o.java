package com.kwad.sdk.core.network;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class o {
    public static volatile o a;
    public final Map<String, String> b = new ConcurrentHashMap();

    public static o a() {
        if (a == null) {
            synchronized (o.class) {
                if (a == null) {
                    a = new o();
                }
            }
        }
        return a;
    }

    public final String a(String str) {
        return this.b.get(str);
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.b.put(str, str2);
    }
}
