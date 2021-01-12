package com.ksad.lottie.a.b;

import android.graphics.Path;
import com.ksad.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<com.ksad.lottie.model.content.h, Path>> f7959a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a<Integer, Integer>> f7960b;
    private final List<Mask> c;

    public g(List<Mask> list) {
        this.c = list;
        this.f7959a = new ArrayList(list.size());
        this.f7960b = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            this.f7959a.add(list.get(i2).b().a());
            this.f7960b.add(list.get(i2).c().a());
            i = i2 + 1;
        }
    }

    public List<Mask> a() {
        return this.c;
    }

    public List<a<com.ksad.lottie.model.content.h, Path>> b() {
        return this.f7959a;
    }

    public List<a<Integer, Integer>> c() {
        return this.f7960b;
    }
}
