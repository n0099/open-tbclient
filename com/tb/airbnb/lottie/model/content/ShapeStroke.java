package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes17.dex */
public class ShapeStroke implements b {
    private final float EX;
    private final List<com.tb.airbnb.lottie.model.a.b> EY;
    private final String name;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b otI;
    private final com.tb.airbnb.lottie.model.a.a otc;
    private final com.tb.airbnb.lottie.model.a.d otk;
    private final com.tb.airbnb.lottie.model.a.b otu;
    private final LineCapType otv;
    private final LineJoinType otw;

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
        this.otI = bVar;
        this.EY = list;
        this.otc = aVar;
        this.otk = dVar;
        this.otu = bVar2;
        this.otv = lineCapType;
        this.otw = lineJoinType;
        this.EX = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a ehR() {
        return this.otc;
    }

    public com.tb.airbnb.lottie.model.a.d ehr() {
        return this.otk;
    }

    public com.tb.airbnb.lottie.model.a.b ehA() {
        return this.otu;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jW() {
        return this.EY;
    }

    public com.tb.airbnb.lottie.model.a.b ehD() {
        return this.otI;
    }

    public LineCapType ehB() {
        return this.otv;
    }

    public LineJoinType ehC() {
        return this.otw;
    }

    public float jY() {
        return this.EX;
    }
}
