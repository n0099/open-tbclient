package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
public class b extends f<Integer> {
    public b(List<com.tb.airbnb.lottie.a.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.tb.airbnb.lottie.a.a<Integer> aVar, float f) {
        if (aVar.ej == null || aVar.ek == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return Integer.valueOf(com.tb.airbnb.lottie.c.a.b(f, aVar.ej.intValue(), aVar.ek.intValue()));
    }
}
