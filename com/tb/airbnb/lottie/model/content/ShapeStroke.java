package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes5.dex */
public class ShapeStroke implements b {
    private final float Er;
    private final List<com.tb.airbnb.lottie.model.a.b> Es;
    private final LineJoinType nPA;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nPM;
    private final com.tb.airbnb.lottie.model.a.a nPg;
    private final com.tb.airbnb.lottie.model.a.d nPo;
    private final com.tb.airbnb.lottie.model.a.b nPy;
    private final LineCapType nPz;
    private final String name;

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
        this.nPM = bVar;
        this.Es = list;
        this.nPg = aVar;
        this.nPo = dVar;
        this.nPy = bVar2;
        this.nPz = lineCapType;
        this.nPA = lineJoinType;
        this.Er = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a dRJ() {
        return this.nPg;
    }

    public com.tb.airbnb.lottie.model.a.d dRj() {
        return this.nPo;
    }

    public com.tb.airbnb.lottie.model.a.b dRs() {
        return this.nPy;
    }

    public List<com.tb.airbnb.lottie.model.a.b> iw() {
        return this.Es;
    }

    public com.tb.airbnb.lottie.model.a.b dRv() {
        return this.nPM;
    }

    public LineCapType dRt() {
        return this.nPz;
    }

    public LineJoinType dRu() {
        return this.nPA;
    }

    public float iy() {
        return this.Er;
    }
}
