package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes7.dex */
public class PolystarShape implements b {
    private final String name;
    private final Type oin;
    private final com.tb.airbnb.lottie.model.a.b ojA;
    private final com.tb.airbnb.lottie.model.a.b ojB;
    private final com.tb.airbnb.lottie.model.a.b ojC;
    private final com.tb.airbnb.lottie.model.a.b ojD;
    private final m<PointF, PointF> ojf;
    private final com.tb.airbnb.lottie.model.a.b ojh;
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
        this.oin = type;
        this.ojz = bVar;
        this.ojf = mVar;
        this.ojh = bVar2;
        this.ojA = bVar3;
        this.ojB = bVar4;
        this.ojC = bVar5;
        this.ojD = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type edB() {
        return this.oin;
    }

    public com.tb.airbnb.lottie.model.a.b edC() {
        return this.ojz;
    }

    public m<PointF, PointF> edi() {
        return this.ojf;
    }

    public com.tb.airbnb.lottie.model.a.b edk() {
        return this.ojh;
    }

    public com.tb.airbnb.lottie.model.a.b edD() {
        return this.ojA;
    }

    public com.tb.airbnb.lottie.model.a.b edE() {
        return this.ojB;
    }

    public com.tb.airbnb.lottie.model.a.b edF() {
        return this.ojC;
    }

    public com.tb.airbnb.lottie.model.a.b edG() {
        return this.ojD;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
