package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import com.tb.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class g {
    private final List<a<com.tb.airbnb.lottie.model.content.h, Path>> CQ;
    private final List<a<Integer, Integer>> CV;
    private final List<Mask> CW;

    public g(List<Mask> list) {
        this.CW = list;
        this.CQ = new ArrayList(list.size());
        this.CV = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.CQ.add(list.get(i2).dRw().dRc());
                this.CV.add(list.get(i2).dRi().dRc());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> hK() {
        return this.CW;
    }

    public List<a<com.tb.airbnb.lottie.model.content.h, Path>> hL() {
        return this.CQ;
    }

    public List<a<Integer, Integer>> hM() {
        return this.CV;
    }
}
