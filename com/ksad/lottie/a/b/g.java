package com.ksad.lottie.a.b;

import android.graphics.Path;
import com.ksad.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<com.ksad.lottie.model.content.h, Path>> f5323a;
    private final List<a<Integer, Integer>> b;
    private final List<Mask> c;

    public g(List<Mask> list) {
        this.c = list;
        this.f5323a = new ArrayList(list.size());
        this.b = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            this.f5323a.add(list.get(i2).b().a());
            this.b.add(list.get(i2).c().a());
            i = i2 + 1;
        }
    }

    public List<Mask> a() {
        return this.c;
    }

    public List<a<com.ksad.lottie.model.content.h, Path>> b() {
        return this.f5323a;
    }

    public List<a<Integer, Integer>> c() {
        return this.b;
    }
}
