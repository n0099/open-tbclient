package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes17.dex */
public class ShapeStroke implements b {
    private final float Fo;
    private final List<com.tb.airbnb.lottie.model.a.b> Fp;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.a pKM;
    private final com.tb.airbnb.lottie.model.a.d pKU;
    private final com.tb.airbnb.lottie.model.a.b pLe;
    private final LineCapType pLf;
    private final LineJoinType pLg;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pLs;

    /* loaded from: classes17.dex */
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

    /* loaded from: classes17.dex */
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
        this.pLs = bVar;
        this.Fp = list;
        this.pKM = aVar;
        this.pKU = dVar;
        this.pLe = bVar2;
        this.pLf = lineCapType;
        this.pLg = lineJoinType;
        this.Fo = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a ezs() {
        return this.pKM;
    }

    public com.tb.airbnb.lottie.model.a.d eyS() {
        return this.pKU;
    }

    public com.tb.airbnb.lottie.model.a.b ezb() {
        return this.pLe;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jX() {
        return this.Fp;
    }

    public com.tb.airbnb.lottie.model.a.b eze() {
        return this.pLs;
    }

    public LineCapType ezc() {
        return this.pLf;
    }

    public LineJoinType ezd() {
        return this.pLg;
    }

    public float jZ() {
        return this.Fo;
    }
}
