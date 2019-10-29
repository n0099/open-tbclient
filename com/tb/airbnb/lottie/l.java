package com.tb.airbnb.lottie;

import java.util.Map;
/* loaded from: classes6.dex */
public class l {
    private final Map<String, String> eh;
    private boolean ei;

    public String I(String str) {
        return str;
    }

    public final String J(String str) {
        if (this.ei && this.eh.containsKey(str)) {
            return this.eh.get(str);
        }
        String I = I(str);
        if (this.ei) {
            this.eh.put(str, I);
            return I;
        }
        return I;
    }
}
