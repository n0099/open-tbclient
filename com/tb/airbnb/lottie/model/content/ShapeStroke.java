package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes5.dex */
public class ShapeStroke implements b {
    private final float Er;
    private final List<com.tb.airbnb.lottie.model.a.b> Es;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nPK;
    private final com.tb.airbnb.lottie.model.a.a nPe;
    private final com.tb.airbnb.lottie.model.a.d nPm;
    private final com.tb.airbnb.lottie.model.a.b nPw;
    private final LineCapType nPx;
    private final LineJoinType nPy;
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
        this.nPK = bVar;
        this.Es = list;
        this.nPe = aVar;
        this.nPm = dVar;
        this.nPw = bVar2;
        this.nPx = lineCapType;
        this.nPy = lineJoinType;
        this.Er = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a dRI() {
        return this.nPe;
    }

    public com.tb.airbnb.lottie.model.a.d dRi() {
        return this.nPm;
    }

    public com.tb.airbnb.lottie.model.a.b dRr() {
        return this.nPw;
    }

    public List<com.tb.airbnb.lottie.model.a.b> iw() {
        return this.Es;
    }

    public com.tb.airbnb.lottie.model.a.b dRu() {
        return this.nPK;
    }

    public LineCapType dRs() {
        return this.nPx;
    }

    public LineJoinType dRt() {
        return this.nPy;
    }

    public float iy() {
        return this.Er;
    }
}
