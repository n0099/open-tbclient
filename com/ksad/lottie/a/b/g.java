package com.ksad.lottie.a.b;

import android.graphics.Path;
import com.ksad.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<com.ksad.lottie.model.content.h, Path>> f31823a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a<Integer, Integer>> f31824b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Mask> f31825c;

    public g(List<Mask> list) {
        this.f31825c = list;
        this.f31823a = new ArrayList(list.size());
        this.f31824b = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f31823a.add(list.get(i2).b().a());
            this.f31824b.add(list.get(i2).c().a());
        }
    }

    public List<Mask> a() {
        return this.f31825c;
    }

    public List<a<com.ksad.lottie.model.content.h, Path>> b() {
        return this.f31823a;
    }

    public List<a<Integer, Integer>> c() {
        return this.f31824b;
    }
}
