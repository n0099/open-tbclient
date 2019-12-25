package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes2.dex */
public class c extends f<Float> {
    public c(List<com.tb.airbnb.lottie.a.a<Float>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: c */
    public Float a(com.tb.airbnb.lottie.a.a<Float> aVar, float f) {
        if (aVar.kn == null || aVar.ko == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return Float.valueOf(com.tb.airbnb.lottie.c.e.lerp(aVar.kn.floatValue(), aVar.ko.floatValue(), f));
    }
}
