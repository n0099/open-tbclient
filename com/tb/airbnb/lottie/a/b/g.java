package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import com.tb.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g {
    private final List<a<com.tb.airbnb.lottie.model.content.h, Path>> fx;
    private final List<a<Integer, Integer>> fy;
    private final List<Mask> fz;

    public g(List<Mask> list) {
        this.fz = list;
        this.fx = new ArrayList(list.size());
        this.fy = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.fx.add(list.get(i2).cLP().cLn());
                this.fy.add(list.get(i2).cLz().cLn());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> bL() {
        return this.fz;
    }

    public List<a<com.tb.airbnb.lottie.model.content.h, Path>> bM() {
        return this.fx;
    }

    public List<a<Integer, Integer>> bN() {
        return this.fy;
    }
}
