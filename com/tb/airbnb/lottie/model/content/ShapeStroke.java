package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes6.dex */
public class ShapeStroke implements b {
    private final float Er;
    private final List<com.tb.airbnb.lottie.model.a.b> Es;
    private final com.tb.airbnb.lottie.model.a.d nGB;
    private final com.tb.airbnb.lottie.model.a.b nGL;
    private final LineCapType nGM;
    private final LineJoinType nGN;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nGZ;
    private final com.tb.airbnb.lottie.model.a.a nGt;
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
        this.nGZ = bVar;
        this.Es = list;
        this.nGt = aVar;
        this.nGB = dVar;
        this.nGL = bVar2;
        this.nGM = lineCapType;
        this.nGN = lineJoinType;
        this.Er = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a dOi() {
        return this.nGt;
    }

    public com.tb.airbnb.lottie.model.a.d dNI() {
        return this.nGB;
    }

    public com.tb.airbnb.lottie.model.a.b dNR() {
        return this.nGL;
    }

    public List<com.tb.airbnb.lottie.model.a.b> iw() {
        return this.Es;
    }

    public com.tb.airbnb.lottie.model.a.b dNU() {
        return this.nGZ;
    }

    public LineCapType dNS() {
        return this.nGM;
    }

    public LineJoinType dNT() {
        return this.nGN;
    }

    public float iy() {
        return this.Er;
    }
}
