package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes5.dex */
public class ShapeStroke implements b {
    private final float ig;
    private final List<com.tb.airbnb.lottie.model.a.b> ii;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.a npW;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nqC;
    private final com.tb.airbnb.lottie.model.a.d nqe;
    private final com.tb.airbnb.lottie.model.a.b nqo;
    private final LineCapType nqp;
    private final LineJoinType nqq;

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
        this.nqC = bVar;
        this.ii = list;
        this.npW = aVar;
        this.nqe = dVar;
        this.nqo = bVar2;
        this.nqp = lineCapType;
        this.nqq = lineJoinType;
        this.ig = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a dGk() {
        return this.npW;
    }

    public com.tb.airbnb.lottie.model.a.d dFK() {
        return this.nqe;
    }

    public com.tb.airbnb.lottie.model.a.b dFT() {
        return this.nqo;
    }

    public List<com.tb.airbnb.lottie.model.a.b> cG() {
        return this.ii;
    }

    public com.tb.airbnb.lottie.model.a.b dFW() {
        return this.nqC;
    }

    public LineCapType dFU() {
        return this.nqp;
    }

    public LineJoinType dFV() {
        return this.nqq;
    }

    public float cI() {
        return this.ig;
    }
}
