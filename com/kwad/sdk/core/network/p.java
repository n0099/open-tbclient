package com.kwad.sdk.core.network;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class p {
    public static volatile p YV;
    public final Map<String, String> XD = new ConcurrentHashMap();

    public static p tE() {
        if (YV == null) {
            synchronized (p.class) {
                if (YV == null) {
                    YV = new p();
                }
            }
        }
        return YV;
    }

    public final void D(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.XD.put(str, str2);
    }

    public final String bW(String str) {
        return this.XD.get(str);
    }
}
