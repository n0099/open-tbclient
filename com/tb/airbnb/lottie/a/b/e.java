package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
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
        if (aVar.kq == null || aVar.kr == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.nqu == null || (num = (Integer) this.nqu.b(aVar.ed, aVar.kt.floatValue(), aVar.kq, aVar.kr, f, bT(), getProgress())) == null) ? Integer.valueOf(com.tb.airbnb.lottie.d.e.lerp(aVar.kq.intValue(), aVar.kr.intValue(), f)) : num;
    }
}
