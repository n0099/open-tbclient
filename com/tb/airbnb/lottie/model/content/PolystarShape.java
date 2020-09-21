package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes17.dex */
public class PolystarShape implements b {
    private final String name;
    private final Type osp;
    private final com.tb.airbnb.lottie.model.a.b otB;
    private final com.tb.airbnb.lottie.model.a.b otC;
    private final com.tb.airbnb.lottie.model.a.b otD;
    private final com.tb.airbnb.lottie.model.a.b otE;
    private final com.tb.airbnb.lottie.model.a.b otF;
    private final m<PointF, PointF> oth;
    private final com.tb.airbnb.lottie.model.a.b otj;

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
        this.osp = type;
        this.otB = bVar;
        this.oth = mVar;
        this.otj = bVar2;
        this.otC = bVar3;
        this.otD = bVar4;
        this.otE = bVar5;
        this.otF = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type ehH() {
        return this.osp;
    }

    public com.tb.airbnb.lottie.model.a.b ehI() {
        return this.otB;
    }

    public m<PointF, PointF> eho() {
        return this.oth;
    }

    public com.tb.airbnb.lottie.model.a.b ehq() {
        return this.otj;
    }

    public com.tb.airbnb.lottie.model.a.b ehJ() {
        return this.otC;
    }

    public com.tb.airbnb.lottie.model.a.b ehK() {
        return this.otD;
    }

    public com.tb.airbnb.lottie.model.a.b ehL() {
        return this.otE;
    }

    public com.tb.airbnb.lottie.model.a.b ehM() {
        return this.otF;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
