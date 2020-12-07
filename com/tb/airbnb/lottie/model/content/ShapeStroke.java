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
    private final com.tb.airbnb.lottie.model.a.a pBQ;
    private final com.tb.airbnb.lottie.model.a.d pBY;
    private final com.tb.airbnb.lottie.model.a.b pCi;
    private final LineCapType pCj;
    private final LineJoinType pCk;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pCw;

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
        this.pCw = bVar;
        this.Gh = list;
        this.pBQ = aVar;
        this.pBY = dVar;
        this.pCi = bVar2;
        this.pCj = lineCapType;
        this.pCk = lineJoinType;
        this.Gg = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a eBO() {
        return this.pBQ;
    }

    public com.tb.airbnb.lottie.model.a.d eBo() {
        return this.pBY;
    }

    public com.tb.airbnb.lottie.model.a.b eBx() {
        return this.pCi;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jX() {
        return this.Gh;
    }

    public com.tb.airbnb.lottie.model.a.b eBA() {
        return this.pCw;
    }

    public LineCapType eBy() {
        return this.pCj;
    }

    public LineJoinType eBz() {
        return this.pCk;
    }

    public float jZ() {
        return this.Gg;
    }
}
