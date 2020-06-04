package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes6.dex */
public class ShapeStroke implements b {
    private final float DR;
    private final List<com.tb.airbnb.lottie.model.a.b> DS;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.a nkE;
    private final com.tb.airbnb.lottie.model.a.d nkM;
    private final com.tb.airbnb.lottie.model.a.b nkW;
    private final LineCapType nkX;
    private final LineJoinType nkY;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nlk;

    /* loaded from: classes6.dex */
    public enum LineCapType {
        Butt,
        Round,
        Unknown;

        public Paint.Cap toPaintCap() {
            switch (this) {
                case Butt:
                    return Paint.Cap.BUTT;
                case Round:
                    return Paint.Cap.ROUND;
                default:
                    return Paint.Cap.SQUARE;
            }
        }
    }

    /* loaded from: classes6.dex */
    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public Paint.Join toPaintJoin() {
            switch (this) {
                case Bevel:
                    return Paint.Join.BEVEL;
                case Miter:
                    return Paint.Join.MITER;
                case Round:
                    return Paint.Join.ROUND;
                default:
                    return null;
            }
        }
    }

    public ShapeStroke(String str, @Nullable com.tb.airbnb.lottie.model.a.b bVar, List<com.tb.airbnb.lottie.model.a.b> list, com.tb.airbnb.lottie.model.a.a aVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f) {
        this.name = str;
        this.nlk = bVar;
        this.DS = list;
        this.nkE = aVar;
        this.nkM = dVar;
        this.nkW = bVar2;
        this.nkX = lineCapType;
        this.nkY = lineJoinType;
        this.DR = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a dJC() {
        return this.nkE;
    }

    public com.tb.airbnb.lottie.model.a.d dJc() {
        return this.nkM;
    }

    public com.tb.airbnb.lottie.model.a.b dJl() {
        return this.nkW;
    }

    /* renamed from: if  reason: not valid java name */
    public List<com.tb.airbnb.lottie.model.a.b> m49if() {
        return this.DS;
    }

    public com.tb.airbnb.lottie.model.a.b dJo() {
        return this.nlk;
    }

    public LineCapType dJm() {
        return this.nkX;
    }

    public LineJoinType dJn() {
        return this.nkY;
    }

    public float ih() {
        return this.DR;
    }
}
