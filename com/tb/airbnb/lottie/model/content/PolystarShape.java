package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes20.dex */
public class PolystarShape implements b {
    private final String name;
    private final m<PointF, PointF> pBV;
    private final com.tb.airbnb.lottie.model.a.b pBX;
    private final Type pBd;
    private final com.tb.airbnb.lottie.model.a.b pCp;
    private final com.tb.airbnb.lottie.model.a.b pCq;
    private final com.tb.airbnb.lottie.model.a.b pCr;
    private final com.tb.airbnb.lottie.model.a.b pCs;
    private final com.tb.airbnb.lottie.model.a.b pCt;

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
        this.pBd = type;
        this.pCp = bVar;
        this.pBV = mVar;
        this.pBX = bVar2;
        this.pCq = bVar3;
        this.pCr = bVar4;
        this.pCs = bVar5;
        this.pCt = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type eBE() {
        return this.pBd;
    }

    public com.tb.airbnb.lottie.model.a.b eBF() {
        return this.pCp;
    }

    public m<PointF, PointF> eBl() {
        return this.pBV;
    }

    public com.tb.airbnb.lottie.model.a.b eBn() {
        return this.pBX;
    }

    public com.tb.airbnb.lottie.model.a.b eBG() {
        return this.pCq;
    }

    public com.tb.airbnb.lottie.model.a.b eBH() {
        return this.pCr;
    }

    public com.tb.airbnb.lottie.model.a.b eBI() {
        return this.pCs;
    }

    public com.tb.airbnb.lottie.model.a.b eBJ() {
        return this.pCt;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(gVar, aVar, this);
    }
}
