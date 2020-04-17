package com.tb.airbnb.lottie;

import java.util.Map;
/* loaded from: classes6.dex */
public class p {
    private final Map<String, String> Bi;
    private boolean Bj;

    private String ba(String str) {
        return str;
    }

    public final String bb(String str) {
        if (this.Bj && this.Bi.containsKey(str)) {
            return this.Bi.get(str);
        }
        String ba = ba(str);
        if (this.Bj) {
            this.Bi.put(str, ba);
            return ba;
        }
        return ba;
    }
}
