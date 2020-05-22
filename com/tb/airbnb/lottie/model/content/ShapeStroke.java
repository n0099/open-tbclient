package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes6.dex */
public class ShapeStroke implements b {
    private final float DR;
    private final List<com.tb.airbnb.lottie.model.a.b> DS;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d njC;
    private final com.tb.airbnb.lottie.model.a.b njM;
    private final LineCapType njN;
    private final LineJoinType njO;
    private final com.tb.airbnb.lottie.model.a.a nju;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nka;

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
        this.nka = bVar;
        this.DS = list;
        this.nju = aVar;
        this.njC = dVar;
        this.njM = bVar2;
        this.njN = lineCapType;
        this.njO = lineJoinType;
        this.DR = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a dJo() {
        return this.nju;
    }

    public com.tb.airbnb.lottie.model.a.d dIO() {
        return this.njC;
    }

    public com.tb.airbnb.lottie.model.a.b dIX() {
        return this.njM;
    }

    /* renamed from: if  reason: not valid java name */
    public List<com.tb.airbnb.lottie.model.a.b> m50if() {
        return this.DS;
    }

    public com.tb.airbnb.lottie.model.a.b dJa() {
        return this.nka;
    }

    public LineCapType dIY() {
        return this.njN;
    }

    public LineJoinType dIZ() {
        return this.njO;
    }

    public float ih() {
        return this.DR;
    }
}
