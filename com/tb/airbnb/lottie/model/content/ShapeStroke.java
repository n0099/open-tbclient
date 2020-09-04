package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes7.dex */
public class ShapeStroke implements b {
    private final float EX;
    private final List<com.tb.airbnb.lottie.model.a.b> EY;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d ojA;
    private final com.tb.airbnb.lottie.model.a.b ojK;
    private final LineCapType ojL;
    private final LineJoinType ojM;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b ojY;
    private final com.tb.airbnb.lottie.model.a.a ojs;

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
        this.ojY = bVar;
        this.EY = list;
        this.ojs = aVar;
        this.ojA = dVar;
        this.ojK = bVar2;
        this.ojL = lineCapType;
        this.ojM = lineJoinType;
        this.EX = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a edU() {
        return this.ojs;
    }

    public com.tb.airbnb.lottie.model.a.d edu() {
        return this.ojA;
    }

    public com.tb.airbnb.lottie.model.a.b edD() {
        return this.ojK;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jV() {
        return this.EY;
    }

    public com.tb.airbnb.lottie.model.a.b edG() {
        return this.ojY;
    }

    public LineCapType edE() {
        return this.ojL;
    }

    public LineJoinType edF() {
        return this.ojM;
    }

    public float jX() {
        return this.EX;
    }
}
