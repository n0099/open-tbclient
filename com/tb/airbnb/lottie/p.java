package com.tb.airbnb.lottie;

import java.util.Map;
/* loaded from: classes6.dex */
public class p {
    private final Map<String, String> fF;
    private boolean fG;

    private String K(String str) {
        return str;
    }

    public final String L(String str) {
        if (this.fG && this.fF.containsKey(str)) {
            return this.fF.get(str);
        }
        String K = K(str);
        if (this.fG) {
            this.fF.put(str, K);
            return K;
        }
        return K;
    }
}
