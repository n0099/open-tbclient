package com.tb.airbnb.lottie;

import java.util.Map;
/* loaded from: classes16.dex */
public class r {
    private final Map<String, String> CG;
    private boolean CH;

    private String bg(String str) {
        return str;
    }

    public final String bh(String str) {
        if (this.CH && this.CG.containsKey(str)) {
            return this.CG.get(str);
        }
        String bg = bg(str);
        if (this.CH) {
            this.CG.put(str, bg);
            return bg;
        }
        return bg;
    }
}
