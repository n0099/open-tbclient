package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes5.dex */
public class e extends f<Integer> {
    public e(List<com.tb.airbnb.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.tb.airbnb.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.km == null || aVar.kn == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.npA == null || (num = (Integer) this.npA.b(aVar.ec, aVar.kp.floatValue(), aVar.km, aVar.kn, f, bS(), getProgress())) == null) ? Integer.valueOf(com.tb.airbnb.lottie.d.e.lerp(aVar.km.intValue(), aVar.kn.intValue(), f)) : num;
    }
}
