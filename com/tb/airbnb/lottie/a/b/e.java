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
        if (aVar.kp == null || aVar.kq == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.nsh == null || (num = (Integer) this.nsh.b(aVar.ec, aVar.ks.floatValue(), aVar.kp, aVar.kq, f, bT(), getProgress())) == null) ? Integer.valueOf(com.tb.airbnb.lottie.d.e.lerp(aVar.kp.intValue(), aVar.kq.intValue(), f)) : num;
    }
}
