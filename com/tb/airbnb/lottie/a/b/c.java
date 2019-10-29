package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
public class c extends f<Float> {
    public c(List<com.tb.airbnb.lottie.a.a<Float>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: c */
    public Float a(com.tb.airbnb.lottie.a.a<Float> aVar, float f) {
        if (aVar.ej == null || aVar.ek == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return Float.valueOf(com.tb.airbnb.lottie.c.e.lerp(aVar.ej.floatValue(), aVar.ek.floatValue(), f));
    }
}
