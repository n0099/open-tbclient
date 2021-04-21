package com.ksad.lottie.a.b;

import android.graphics.Path;
import com.ksad.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<com.ksad.lottie.model.content.h, Path>> f31679a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a<Integer, Integer>> f31680b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Mask> f31681c;

    public g(List<Mask> list) {
        this.f31681c = list;
        this.f31679a = new ArrayList(list.size());
        this.f31680b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f31679a.add(list.get(i).b().a());
            this.f31680b.add(list.get(i).c().a());
        }
    }

    public List<Mask> a() {
        return this.f31681c;
    }

    public List<a<com.ksad.lottie.model.content.h, Path>> b() {
        return this.f31679a;
    }

    public List<a<Integer, Integer>> c() {
        return this.f31680b;
    }
}
