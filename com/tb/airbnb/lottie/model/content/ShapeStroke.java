package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes6.dex */
public class ShapeStroke implements b {
    private final float Er;
    private final List<com.tb.airbnb.lottie.model.a.b> Es;
    private final com.tb.airbnb.lottie.model.a.d nGE;
    private final com.tb.airbnb.lottie.model.a.b nGO;
    private final LineCapType nGP;
    private final LineJoinType nGQ;
    private final com.tb.airbnb.lottie.model.a.a nGw;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nHc;
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
        this.nHc = bVar;
        this.Es = list;
        this.nGw = aVar;
        this.nGE = dVar;
        this.nGO = bVar2;
        this.nGP = lineCapType;
        this.nGQ = lineJoinType;
        this.Er = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a dOm() {
        return this.nGw;
    }

    public com.tb.airbnb.lottie.model.a.d dNM() {
        return this.nGE;
    }

    public com.tb.airbnb.lottie.model.a.b dNV() {
        return this.nGO;
    }

    public List<com.tb.airbnb.lottie.model.a.b> iw() {
        return this.Es;
    }

    public com.tb.airbnb.lottie.model.a.b dNY() {
        return this.nHc;
    }

    public LineCapType dNW() {
        return this.nGP;
    }

    public LineJoinType dNX() {
        return this.nGQ;
    }

    public float iy() {
        return this.Er;
    }
}
