package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes20.dex */
public class PolystarShape implements b {
    private final String name;
    private final m<PointF, PointF> pBX;
    private final com.tb.airbnb.lottie.model.a.b pBZ;
    private final Type pBf;
    private final com.tb.airbnb.lottie.model.a.b pCr;
    private final com.tb.airbnb.lottie.model.a.b pCs;
    private final com.tb.airbnb.lottie.model.a.b pCt;
    private final com.tb.airbnb.lottie.model.a.b pCu;
    private final com.tb.airbnb.lottie.model.a.b pCv;

    /* loaded from: classes20.dex */
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
        this.pBf = type;
        this.pCr = bVar;
        this.pBX = mVar;
        this.pBZ = bVar2;
        this.pCs = bVar3;
        this.pCt = bVar4;
        this.pCu = bVar5;
        this.pCv = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type eBF() {
        return this.pBf;
    }

    public com.tb.airbnb.lottie.model.a.b eBG() {
        return this.pCr;
    }

    public m<PointF, PointF> eBm() {
        return this.pBX;
    }

    public com.tb.airbnb.lottie.model.a.b eBo() {
        return this.pBZ;
    }

    public com.tb.airbnb.lottie.model.a.b eBH() {
        return this.pCs;
    }

    public com.tb.airbnb.lottie.model.a.b eBI() {
        return this.pCt;
    }

    public com.tb.airbnb.lottie.model.a.b eBJ() {
        return this.pCu;
    }

    public com.tb.airbnb.lottie.model.a.b eBK() {
        return this.pCv;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(gVar, aVar, this);
    }
}
