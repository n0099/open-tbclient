package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes6.dex */
public class ShapeStroke implements b {
    private final float ik;
    private final List<com.tb.airbnb.lottie.model.a.b> il;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.a nsD;
    private final com.tb.airbnb.lottie.model.a.d nsL;
    private final com.tb.airbnb.lottie.model.a.b nsV;
    private final LineCapType nsW;
    private final LineJoinType nsX;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b ntj;

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
        this.ntj = bVar;
        this.il = list;
        this.nsD = aVar;
        this.nsL = dVar;
        this.nsV = bVar2;
        this.nsW = lineCapType;
        this.nsX = lineJoinType;
        this.ik = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a dHW() {
        return this.nsD;
    }

    public com.tb.airbnb.lottie.model.a.d dHw() {
        return this.nsL;
    }

    public com.tb.airbnb.lottie.model.a.b dHF() {
        return this.nsV;
    }

    public List<com.tb.airbnb.lottie.model.a.b> cH() {
        return this.il;
    }

    public com.tb.airbnb.lottie.model.a.b dHI() {
        return this.ntj;
    }

    public LineCapType dHG() {
        return this.nsW;
    }

    public LineJoinType dHH() {
        return this.nsX;
    }

    public float cJ() {
        return this.ik;
    }
}
