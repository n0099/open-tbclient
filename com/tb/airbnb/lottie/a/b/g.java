package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import com.tb.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g {
    private final List<a<com.tb.airbnb.lottie.model.content.h, Path>> gK;
    private final List<a<Integer, Integer>> gL;
    private final List<Mask> gM;

    public g(List<Mask> list) {
        this.gM = list;
        this.gK = new ArrayList(list.size());
        this.gL = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.gK.add(list.get(i2).dHK().dHq());
                this.gL.add(list.get(i2).dHw().dHq());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> bX() {
        return this.gM;
    }

    public List<a<com.tb.airbnb.lottie.model.content.h, Path>> bY() {
        return this.gK;
    }

    public List<a<Integer, Integer>> bZ() {
        return this.gL;
    }
}
