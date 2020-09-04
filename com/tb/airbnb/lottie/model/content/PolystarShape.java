package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes7.dex */
public class PolystarShape implements b {
    private final String name;
    private final Type oiF;
    private final com.tb.airbnb.lottie.model.a.b ojR;
    private final com.tb.airbnb.lottie.model.a.b ojS;
    private final com.tb.airbnb.lottie.model.a.b ojT;
    private final com.tb.airbnb.lottie.model.a.b ojU;
    private final com.tb.airbnb.lottie.model.a.b ojV;
    private final m<PointF, PointF> ojx;
    private final com.tb.airbnb.lottie.model.a.b ojz;

    /* loaded from: classes7.dex */
    public enum Type {
        Star(1),
        Polygon(2);
        
        private final int value;

        Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            Type[] values;
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, com.tb.airbnb.lottie.model.a.b bVar, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.b bVar2, com.tb.airbnb.lottie.model.a.b bVar3, com.tb.airbnb.lottie.model.a.b bVar4, com.tb.airbnb.lottie.model.a.b bVar5, com.tb.airbnb.lottie.model.a.b bVar6) {
        this.name = str;
        this.oiF = type;
        this.ojR = bVar;
        this.ojx = mVar;
        this.ojz = bVar2;
        this.ojS = bVar3;
        this.ojT = bVar4;
        this.ojU = bVar5;
        this.ojV = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type edK() {
        return this.oiF;
    }

    public com.tb.airbnb.lottie.model.a.b edL() {
        return this.ojR;
    }

    public m<PointF, PointF> edr() {
        return this.ojx;
    }

    public com.tb.airbnb.lottie.model.a.b edt() {
        return this.ojz;
    }

    public com.tb.airbnb.lottie.model.a.b edM() {
        return this.ojS;
    }

    public com.tb.airbnb.lottie.model.a.b edN() {
        return this.ojT;
    }

    public com.tb.airbnb.lottie.model.a.b edO() {
        return this.ojU;
    }

    public com.tb.airbnb.lottie.model.a.b edP() {
        return this.ojV;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
