package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import com.tb.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class g {
    private final List<a<com.tb.airbnb.lottie.model.content.h, Path>> DT;
    private final List<a<Integer, Integer>> DU;
    private final List<Mask> DV;

    public g(List<Mask> list) {
        this.DV = list;
        this.DT = new ArrayList(list.size());
        this.DU = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.DT.add(list.get(i2).elq().ekW());
                this.DU.add(list.get(i2).elc().ekW());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> jn() {
        return this.DV;
    }

    public List<a<com.tb.airbnb.lottie.model.content.h, Path>> jo() {
        return this.DT;
    }

    public List<a<Integer, Integer>> jp() {
        return this.DU;
    }
}
