package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import com.tb.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g {
    private final List<a<com.tb.airbnb.lottie.model.content.h, Path>> Cm;
    private final List<a<Integer, Integer>> Cn;
    private final List<Mask> Co;

    public g(List<Mask> list) {
        this.Co = list;
        this.Cm = new ArrayList(list.size());
        this.Cn = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.Cm.add(list.get(i2).dJq().dIW());
                this.Cn.add(list.get(i2).dJc().dIW());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> hu() {
        return this.Co;
    }

    public List<a<com.tb.airbnb.lottie.model.content.h, Path>> hv() {
        return this.Cm;
    }

    public List<a<Integer, Integer>> hw() {
        return this.Cn;
    }
}
