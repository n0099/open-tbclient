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
    private final com.tb.airbnb.lottie.model.a.a nqF;
    private final com.tb.airbnb.lottie.model.a.d nqN;
    private final com.tb.airbnb.lottie.model.a.b nqX;
    private final LineCapType nqY;
    private final LineJoinType nqZ;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nrl;

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
        this.nrl = bVar;
        this.im = list;
        this.nqF = aVar;
        this.nqN = dVar;
        this.nqX = bVar2;
        this.nqY = lineCapType;
        this.nqZ = lineJoinType;
        this.il = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a dHv() {
        return this.nqF;
    }

    public com.tb.airbnb.lottie.model.a.d dGV() {
        return this.nqN;
    }

    public com.tb.airbnb.lottie.model.a.b dHe() {
        return this.nqX;
    }

    public List<com.tb.airbnb.lottie.model.a.b> cH() {
        return this.im;
    }

    public com.tb.airbnb.lottie.model.a.b dHh() {
        return this.nrl;
    }

    public LineCapType dHf() {
        return this.nqY;
    }

    public LineJoinType dHg() {
        return this.nqZ;
    }

    public float cJ() {
        return this.il;
    }
}
