package com.ksad.lottie.a.b;

import android.graphics.Path;
import com.ksad.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<com.ksad.lottie.model.content.h, Path>> f31921a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a<Integer, Integer>> f31922b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Mask> f31923c;

    public g(List<Mask> list) {
        this.f31923c = list;
        this.f31921a = new ArrayList(list.size());
        this.f31922b = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f31921a.add(list.get(i2).b().a());
            this.f31922b.add(list.get(i2).c().a());
        }
    }

    public List<Mask> a() {
        return this.f31923c;
    }

    public List<a<com.ksad.lottie.model.content.h, Path>> b() {
        return this.f31921a;
    }

    public List<a<Integer, Integer>> c() {
        return this.f31922b;
    }
}
