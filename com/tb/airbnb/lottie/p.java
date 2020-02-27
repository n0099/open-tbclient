package com.tb.airbnb.lottie;

import java.util.Map;
/* loaded from: classes6.dex */
public class p {
    private final Map<String, String> fG;
    private boolean fH;

    private String K(String str) {
        return str;
    }

    public final String L(String str) {
        if (this.fH && this.fG.containsKey(str)) {
            return this.fG.get(str);
        }
        String K = K(str);
        if (this.fH) {
            this.fG.put(str, K);
            return K;
        }
        return K;
    }
}
