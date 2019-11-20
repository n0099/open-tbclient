package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
public class e extends f<Integer> {
    public e(List<com.tb.airbnb.lottie.a.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.tb.airbnb.lottie.a.a<Integer> aVar, float f) {
        if (aVar.dK == null || aVar.dL == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return Integer.valueOf(com.tb.airbnb.lottie.c.e.lerp(aVar.dK.intValue(), aVar.dL.intValue(), f));
    }
}
