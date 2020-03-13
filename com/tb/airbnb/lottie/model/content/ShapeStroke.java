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
    private final com.tb.airbnb.lottie.model.a.a nqQ;
    private final com.tb.airbnb.lottie.model.a.d nqY;
    private final com.tb.airbnb.lottie.model.a.b nri;
    private final LineCapType nrj;
    private final LineJoinType nrk;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nrw;

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
        this.nrw = bVar;
        this.im = list;
        this.nqQ = aVar;
        this.nqY = dVar;
        this.nri = bVar2;
        this.nrj = lineCapType;
        this.nrk = lineJoinType;
        this.il = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a dHw() {
        return this.nqQ;
    }

    public com.tb.airbnb.lottie.model.a.d dGW() {
        return this.nqY;
    }

    public com.tb.airbnb.lottie.model.a.b dHf() {
        return this.nri;
    }

    public List<com.tb.airbnb.lottie.model.a.b> cH() {
        return this.im;
    }

    public com.tb.airbnb.lottie.model.a.b dHi() {
        return this.nrw;
    }

    public LineCapType dHg() {
        return this.nrj;
    }

    public LineJoinType dHh() {
        return this.nrk;
    }

    public float cJ() {
        return this.il;
    }
}
