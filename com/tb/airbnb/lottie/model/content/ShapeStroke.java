package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes20.dex */
public class ShapeStroke implements b {
    private final float Gg;
    private final List<com.tb.airbnb.lottie.model.a.b> Gh;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.a pBS;
    private final com.tb.airbnb.lottie.model.a.d pCa;
    private final com.tb.airbnb.lottie.model.a.b pCk;
    private final LineCapType pCl;
    private final LineJoinType pCm;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pCy;

    /* loaded from: classes20.dex */
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

    /* loaded from: classes20.dex */
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
        this.pCy = bVar;
        this.Gh = list;
        this.pBS = aVar;
        this.pCa = dVar;
        this.pCk = bVar2;
        this.pCl = lineCapType;
        this.pCm = lineJoinType;
        this.Gg = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a eBP() {
        return this.pBS;
    }

    public com.tb.airbnb.lottie.model.a.d eBp() {
        return this.pCa;
    }

    public com.tb.airbnb.lottie.model.a.b eBy() {
        return this.pCk;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jX() {
        return this.Gh;
    }

    public com.tb.airbnb.lottie.model.a.b eBB() {
        return this.pCy;
    }

    public LineCapType eBz() {
        return this.pCl;
    }

    public LineJoinType eBA() {
        return this.pCm;
    }

    public float jZ() {
        return this.Gg;
    }
}
