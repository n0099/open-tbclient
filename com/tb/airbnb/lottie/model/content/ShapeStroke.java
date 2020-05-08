package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes6.dex */
public class ShapeStroke implements b {
    private final float DR;
    private final List<com.tb.airbnb.lottie.model.a.b> DS;
    private final com.tb.airbnb.lottie.model.a.b mPJ;
    private final LineCapType mPK;
    private final LineJoinType mPL;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b mPX;
    private final com.tb.airbnb.lottie.model.a.a mPr;
    private final com.tb.airbnb.lottie.model.a.d mPz;
    private final String name;

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
        this.mPX = bVar;
        this.DS = list;
        this.mPr = aVar;
        this.mPz = dVar;
        this.mPJ = bVar2;
        this.mPK = lineCapType;
        this.mPL = lineJoinType;
        this.DR = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a dBU() {
        return this.mPr;
    }

    public com.tb.airbnb.lottie.model.a.d dBu() {
        return this.mPz;
    }

    public com.tb.airbnb.lottie.model.a.b dBD() {
        return this.mPJ;
    }

    /* renamed from: if  reason: not valid java name */
    public List<com.tb.airbnb.lottie.model.a.b> m48if() {
        return this.DS;
    }

    public com.tb.airbnb.lottie.model.a.b dBG() {
        return this.mPX;
    }

    public LineCapType dBE() {
        return this.mPK;
    }

    public LineJoinType dBF() {
        return this.mPL;
    }

    public float ih() {
        return this.DR;
    }
}
