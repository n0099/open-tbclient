package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes17.dex */
public class PolystarShape implements b {
    private final String name;
    private final Type pJZ;
    private final m<PointF, PointF> pKR;
    private final com.tb.airbnb.lottie.model.a.b pKT;
    private final com.tb.airbnb.lottie.model.a.b pLl;
    private final com.tb.airbnb.lottie.model.a.b pLm;
    private final com.tb.airbnb.lottie.model.a.b pLn;
    private final com.tb.airbnb.lottie.model.a.b pLo;
    private final com.tb.airbnb.lottie.model.a.b pLp;

    /* loaded from: classes17.dex */
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
        this.pJZ = type;
        this.pLl = bVar;
        this.pKR = mVar;
        this.pKT = bVar2;
        this.pLm = bVar3;
        this.pLn = bVar4;
        this.pLo = bVar5;
        this.pLp = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type ezi() {
        return this.pJZ;
    }

    public com.tb.airbnb.lottie.model.a.b ezj() {
        return this.pLl;
    }

    public m<PointF, PointF> eyP() {
        return this.pKR;
    }

    public com.tb.airbnb.lottie.model.a.b eyR() {
        return this.pKT;
    }

    public com.tb.airbnb.lottie.model.a.b ezk() {
        return this.pLm;
    }

    public com.tb.airbnb.lottie.model.a.b ezl() {
        return this.pLn;
    }

    public com.tb.airbnb.lottie.model.a.b ezm() {
        return this.pLo;
    }

    public com.tb.airbnb.lottie.model.a.b ezn() {
        return this.pLp;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(gVar, aVar, this);
    }
}
