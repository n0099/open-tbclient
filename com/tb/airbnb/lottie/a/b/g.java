package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import com.tb.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g {
    private final List<a<com.tb.airbnb.lottie.model.content.h, Path>> CO;
    private final List<a<Integer, Integer>> CP;
    private final List<Mask> CQ;

    public g(List<Mask> list) {
        this.CQ = list;
        this.CO = new ArrayList(list.size());
        this.CP = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.CO.add(list.get(i2).dOa().dNG());
                this.CP.add(list.get(i2).dNM().dNG());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> hK() {
        return this.CQ;
    }

    public List<a<com.tb.airbnb.lottie.model.content.h, Path>> hL() {
        return this.CO;
    }

    public List<a<Integer, Integer>> hM() {
        return this.CP;
    }
}
