package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes16.dex */
public class PolystarShape implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b pAo;
    private final com.tb.airbnb.lottie.model.a.b pAp;
    private final com.tb.airbnb.lottie.model.a.b pAq;
    private final com.tb.airbnb.lottie.model.a.b pAr;
    private final com.tb.airbnb.lottie.model.a.b pAs;
    private final m<PointF, PointF> pzU;
    private final com.tb.airbnb.lottie.model.a.b pzW;
    private final Type pzc;

    /* loaded from: classes16.dex */
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
        this.pzc = type;
        this.pAo = bVar;
        this.pzU = mVar;
        this.pzW = bVar2;
        this.pAp = bVar3;
        this.pAq = bVar4;
        this.pAr = bVar5;
        this.pAs = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type evs() {
        return this.pzc;
    }

    public com.tb.airbnb.lottie.model.a.b evt() {
        return this.pAo;
    }

    public m<PointF, PointF> euZ() {
        return this.pzU;
    }

    public com.tb.airbnb.lottie.model.a.b evb() {
        return this.pzW;
    }

    public com.tb.airbnb.lottie.model.a.b evu() {
        return this.pAp;
    }

    public com.tb.airbnb.lottie.model.a.b evv() {
        return this.pAq;
    }

    public com.tb.airbnb.lottie.model.a.b evw() {
        return this.pAr;
    }

    public com.tb.airbnb.lottie.model.a.b evx() {
        return this.pAs;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
