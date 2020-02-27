package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes6.dex */
public class ShapeStroke implements b {
    private final float il;
    private final List<com.tb.airbnb.lottie.model.a.b> im;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.a nqD;
    private final com.tb.airbnb.lottie.model.a.d nqL;
    private final com.tb.airbnb.lottie.model.a.b nqV;
    private final LineCapType nqW;
    private final LineJoinType nqX;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nrj;

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
        this.nrj = bVar;
        this.im = list;
        this.nqD = aVar;
        this.nqL = dVar;
        this.nqV = bVar2;
        this.nqW = lineCapType;
        this.nqX = lineJoinType;
        this.il = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a dHt() {
        return this.nqD;
    }

    public com.tb.airbnb.lottie.model.a.d dGT() {
        return this.nqL;
    }

    public com.tb.airbnb.lottie.model.a.b dHc() {
        return this.nqV;
    }

    public List<com.tb.airbnb.lottie.model.a.b> cH() {
        return this.im;
    }

    public com.tb.airbnb.lottie.model.a.b dHf() {
        return this.nrj;
    }

    public LineCapType dHd() {
        return this.nqW;
    }

    public LineJoinType dHe() {
        return this.nqX;
    }

    public float cJ() {
        return this.il;
    }
}
