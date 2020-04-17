package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class PolystarShape implements b {
    private final Type mOz;
    private final com.tb.airbnb.lottie.model.a.b mPN;
    private final com.tb.airbnb.lottie.model.a.b mPO;
    private final com.tb.airbnb.lottie.model.a.b mPP;
    private final com.tb.airbnb.lottie.model.a.b mPQ;
    private final com.tb.airbnb.lottie.model.a.b mPR;
    private final m<PointF, PointF> mPt;
    private final com.tb.airbnb.lottie.model.a.b mPv;
    private final String name;

    /* loaded from: classes6.dex */
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
        this.mOz = type;
        this.mPN = bVar;
        this.mPt = mVar;
        this.mPv = bVar2;
        this.mPO = bVar3;
        this.mPP = bVar4;
        this.mPQ = bVar5;
        this.mPR = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type dBO() {
        return this.mOz;
    }

    public com.tb.airbnb.lottie.model.a.b dBP() {
        return this.mPN;
    }

    public m<PointF, PointF> dBv() {
        return this.mPt;
    }

    public com.tb.airbnb.lottie.model.a.b dBx() {
        return this.mPv;
    }

    public com.tb.airbnb.lottie.model.a.b dBQ() {
        return this.mPO;
    }

    public com.tb.airbnb.lottie.model.a.b dBR() {
        return this.mPP;
    }

    public com.tb.airbnb.lottie.model.a.b dBS() {
        return this.mPQ;
    }

    public com.tb.airbnb.lottie.model.a.b dBT() {
        return this.mPR;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
