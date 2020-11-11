package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes16.dex */
public class PolystarShape implements b {
    private final String name;
    private final Type pIw;
    private final com.tb.airbnb.lottie.model.a.b pJI;
    private final com.tb.airbnb.lottie.model.a.b pJJ;
    private final com.tb.airbnb.lottie.model.a.b pJK;
    private final com.tb.airbnb.lottie.model.a.b pJL;
    private final com.tb.airbnb.lottie.model.a.b pJM;
    private final m<PointF, PointF> pJo;
    private final com.tb.airbnb.lottie.model.a.b pJq;

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
        this.pIw = type;
        this.pJI = bVar;
        this.pJo = mVar;
        this.pJq = bVar2;
        this.pJJ = bVar3;
        this.pJK = bVar4;
        this.pJL = bVar5;
        this.pJM = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type ezh() {
        return this.pIw;
    }

    public com.tb.airbnb.lottie.model.a.b ezi() {
        return this.pJI;
    }

    public m<PointF, PointF> eyO() {
        return this.pJo;
    }

    public com.tb.airbnb.lottie.model.a.b eyQ() {
        return this.pJq;
    }

    public com.tb.airbnb.lottie.model.a.b ezj() {
        return this.pJJ;
    }

    public com.tb.airbnb.lottie.model.a.b ezk() {
        return this.pJK;
    }

    public com.tb.airbnb.lottie.model.a.b ezl() {
        return this.pJL;
    }

    public com.tb.airbnb.lottie.model.a.b ezm() {
        return this.pJM;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(gVar, aVar, this);
    }
}
