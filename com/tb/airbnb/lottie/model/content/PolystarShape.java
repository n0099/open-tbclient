package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class PolystarShape implements b {
    private final Type mOC;
    private final com.tb.airbnb.lottie.model.a.b mPQ;
    private final com.tb.airbnb.lottie.model.a.b mPR;
    private final com.tb.airbnb.lottie.model.a.b mPS;
    private final com.tb.airbnb.lottie.model.a.b mPT;
    private final com.tb.airbnb.lottie.model.a.b mPU;
    private final m<PointF, PointF> mPw;
    private final com.tb.airbnb.lottie.model.a.b mPy;
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
        this.mOC = type;
        this.mPQ = bVar;
        this.mPw = mVar;
        this.mPy = bVar2;
        this.mPR = bVar3;
        this.mPS = bVar4;
        this.mPT = bVar5;
        this.mPU = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type dBK() {
        return this.mOC;
    }

    public com.tb.airbnb.lottie.model.a.b dBL() {
        return this.mPQ;
    }

    public m<PointF, PointF> dBr() {
        return this.mPw;
    }

    public com.tb.airbnb.lottie.model.a.b dBt() {
        return this.mPy;
    }

    public com.tb.airbnb.lottie.model.a.b dBM() {
        return this.mPR;
    }

    public com.tb.airbnb.lottie.model.a.b dBN() {
        return this.mPS;
    }

    public com.tb.airbnb.lottie.model.a.b dBO() {
        return this.mPT;
    }

    public com.tb.airbnb.lottie.model.a.b dBP() {
        return this.mPU;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
