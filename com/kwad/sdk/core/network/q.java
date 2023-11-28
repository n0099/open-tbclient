package com.kwad.sdk.core.network;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class q {
    public static volatile q aum;
    public final Map<String, String> asV = new ConcurrentHashMap();

    public static q CF() {
        if (aum == null) {
            synchronized (q.class) {
                if (aum == null) {
                    aum = new q();
                }
            }
        }
        return aum;
    }

    public final void S(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.asV.put(str, str2);
        }
    }

    public final String dp(String str) {
        return this.asV.get(str);
    }
}
