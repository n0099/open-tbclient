package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class PolystarShape implements b {
    private final String name;
    private final Type niH;
    private final com.tb.airbnb.lottie.model.a.b njB;
    private final com.tb.airbnb.lottie.model.a.b njT;
    private final com.tb.airbnb.lottie.model.a.b njU;
    private final com.tb.airbnb.lottie.model.a.b njV;
    private final com.tb.airbnb.lottie.model.a.b njW;
    private final com.tb.airbnb.lottie.model.a.b njX;
    private final m<PointF, PointF> njz;

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
        this.niH = type;
        this.njT = bVar;
        this.njz = mVar;
        this.njB = bVar2;
        this.njU = bVar3;
        this.njV = bVar4;
        this.njW = bVar5;
        this.njX = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type dJe() {
        return this.niH;
    }

    public com.tb.airbnb.lottie.model.a.b dJf() {
        return this.njT;
    }

    public m<PointF, PointF> dIL() {
        return this.njz;
    }

    public com.tb.airbnb.lottie.model.a.b dIN() {
        return this.njB;
    }

    public com.tb.airbnb.lottie.model.a.b dJg() {
        return this.njU;
    }

    public com.tb.airbnb.lottie.model.a.b dJh() {
        return this.njV;
    }

    public com.tb.airbnb.lottie.model.a.b dJi() {
        return this.njW;
    }

    public com.tb.airbnb.lottie.model.a.b dJj() {
        return this.njX;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
