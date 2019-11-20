package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import com.tb.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g {
    private final List<a<com.tb.airbnb.lottie.model.content.h, Path>> eU;
    private final List<a<Integer, Integer>> eV;
    private final List<Mask> eW;

    public g(List<Mask> list) {
        this.eW = list;
        this.eU = new ArrayList(list.size());
        this.eV = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.eU.add(list.get(i2).cLN().cLl());
                this.eV.add(list.get(i2).cLx().cLl());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> bL() {
        return this.eW;
    }

    public List<a<com.tb.airbnb.lottie.model.content.h, Path>> bM() {
        return this.eU;
    }

    public List<a<Integer, Integer>> bN() {
        return this.eV;
    }
}
