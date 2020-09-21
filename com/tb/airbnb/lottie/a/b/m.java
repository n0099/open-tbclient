package com.tb.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes17.dex */
public class m extends a<PointF, PointF> {
    private final PointF DC;
    private final a<Float, Float> osL;
    private final a<Float, Float> osM;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.DC = new PointF();
        this.osL = aVar;
        this.osM = aVar2;
        setProgress(getProgress());
    }

    @Override // com.tb.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.osL.setProgress(f);
        this.osM.setProgress(f);
        this.DC.set(this.osL.getValue().floatValue(), this.osM.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).iS();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: jp */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.tb.airbnb.lottie.e.a<PointF> aVar, float f) {
        return this.DC;
    }
}
