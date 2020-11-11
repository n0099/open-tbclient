package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes16.dex */
public class ShapeStroke implements b {
    private final float Fo;
    private final List<com.tb.airbnb.lottie.model.a.b> Fp;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b pJB;
    private final LineCapType pJC;
    private final LineJoinType pJD;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pJP;
    private final com.tb.airbnb.lottie.model.a.a pJj;
    private final com.tb.airbnb.lottie.model.a.d pJr;

    /* loaded from: classes16.dex */
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

    /* loaded from: classes16.dex */
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
        this.pJP = bVar;
        this.Fp = list;
        this.pJj = aVar;
        this.pJr = dVar;
        this.pJB = bVar2;
        this.pJC = lineCapType;
        this.pJD = lineJoinType;
        this.Fo = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a ezr() {
        return this.pJj;
    }

    public com.tb.airbnb.lottie.model.a.d eyR() {
        return this.pJr;
    }

    public com.tb.airbnb.lottie.model.a.b eza() {
        return this.pJB;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jX() {
        return this.Fp;
    }

    public com.tb.airbnb.lottie.model.a.b ezd() {
        return this.pJP;
    }

    public LineCapType ezb() {
        return this.pJC;
    }

    public LineJoinType ezc() {
        return this.pJD;
    }

    public float jZ() {
        return this.Fo;
    }
}
