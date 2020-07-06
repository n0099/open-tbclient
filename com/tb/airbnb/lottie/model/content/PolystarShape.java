package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class PolystarShape implements b {
    private final Type nFJ;
    private final m<PointF, PointF> nGB;
    private final com.tb.airbnb.lottie.model.a.b nGD;
    private final com.tb.airbnb.lottie.model.a.b nGV;
    private final com.tb.airbnb.lottie.model.a.b nGW;
    private final com.tb.airbnb.lottie.model.a.b nGX;
    private final com.tb.airbnb.lottie.model.a.b nGY;
    private final com.tb.airbnb.lottie.model.a.b nGZ;
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
        this.nFJ = type;
        this.nGV = bVar;
        this.nGB = mVar;
        this.nGD = bVar2;
        this.nGW = bVar3;
        this.nGX = bVar4;
        this.nGY = bVar5;
        this.nGZ = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type dOc() {
        return this.nFJ;
    }

    public com.tb.airbnb.lottie.model.a.b dOd() {
        return this.nGV;
    }

    public m<PointF, PointF> dNJ() {
        return this.nGB;
    }

    public com.tb.airbnb.lottie.model.a.b dNL() {
        return this.nGD;
    }

    public com.tb.airbnb.lottie.model.a.b dOe() {
        return this.nGW;
    }

    public com.tb.airbnb.lottie.model.a.b dOf() {
        return this.nGX;
    }

    public com.tb.airbnb.lottie.model.a.b dOg() {
        return this.nGY;
    }

    public com.tb.airbnb.lottie.model.a.b dOh() {
        return this.nGZ;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
