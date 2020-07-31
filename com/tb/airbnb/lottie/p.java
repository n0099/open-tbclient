package com.tb.airbnb.lottie;

import java.util.Map;
/* loaded from: classes5.dex */
public class p {
    private final Map<String, String> BK;
    private boolean BL;

    private String bb(String str) {
        return str;
    }

    public final String bc(String str) {
        if (this.BL && this.BK.containsKey(str)) {
            return this.BK.get(str);
        }
        String bb = bb(str);
        if (this.BL) {
            this.BK.put(str, bb);
            return bb;
        }
        return bb;
    }
}
