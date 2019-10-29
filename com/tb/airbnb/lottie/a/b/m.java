package com.tb.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes6.dex */
public class m extends a<PointF, PointF> {
    private final PointF fA;
    private final a<Float, Float> ktC;
    private final a<Float, Float> ktD;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.fA = new PointF();
        this.ktC = aVar;
        this.ktD = aVar2;
    }

    @Override // com.tb.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.ktC.setProgress(f);
        this.ktD.setProgress(f);
        this.fA.set(this.ktC.getValue().floatValue(), this.ktD.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).bt();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: bO */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.tb.airbnb.lottie.a.a<PointF> aVar, float f) {
        return this.fA;
    }
}
