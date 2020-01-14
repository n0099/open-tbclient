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
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nqH;
    private final com.tb.airbnb.lottie.model.a.a nqb;
    private final com.tb.airbnb.lottie.model.a.d nqj;
    private final com.tb.airbnb.lottie.model.a.b nqt;
    private final LineCapType nqu;
    private final LineJoinType nqv;

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
        this.nqH = bVar;
        this.ii = list;
        this.nqb = aVar;
        this.nqj = dVar;
        this.nqt = bVar2;
        this.nqu = lineCapType;
        this.nqv = lineJoinType;
        this.ig = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a dGm() {
        return this.nqb;
    }

    public com.tb.airbnb.lottie.model.a.d dFM() {
        return this.nqj;
    }

    public com.tb.airbnb.lottie.model.a.b dFV() {
        return this.nqt;
    }

    public List<com.tb.airbnb.lottie.model.a.b> cG() {
        return this.ii;
    }

    public com.tb.airbnb.lottie.model.a.b dFY() {
        return this.nqH;
    }

    public LineCapType dFW() {
        return this.nqu;
    }

    public LineJoinType dFX() {
        return this.nqv;
    }

    public float cI() {
        return this.ig;
    }
}
