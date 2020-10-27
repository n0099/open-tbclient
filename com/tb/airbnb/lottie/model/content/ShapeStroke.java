package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes16.dex */
public class ShapeStroke implements b {
    private final float Fo;
    private final List<com.tb.airbnb.lottie.model.a.b> Fp;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b pAh;
    private final LineCapType pAi;
    private final LineJoinType pAj;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pAv;
    private final com.tb.airbnb.lottie.model.a.a pzP;
    private final com.tb.airbnb.lottie.model.a.d pzX;

    /* loaded from: classes16.dex */
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

    /* loaded from: classes16.dex */
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
        this.pAv = bVar;
        this.Fp = list;
        this.pzP = aVar;
        this.pzX = dVar;
        this.pAh = bVar2;
        this.pAi = lineCapType;
        this.pAj = lineJoinType;
        this.Fo = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a evC() {
        return this.pzP;
    }

    public com.tb.airbnb.lottie.model.a.d evc() {
        return this.pzX;
    }

    public com.tb.airbnb.lottie.model.a.b evl() {
        return this.pAh;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jX() {
        return this.Fp;
    }

    public com.tb.airbnb.lottie.model.a.b evo() {
        return this.pAv;
    }

    public LineCapType evm() {
        return this.pAi;
    }

    public LineJoinType evn() {
        return this.pAj;
    }

    public float jZ() {
        return this.Fo;
    }
}
