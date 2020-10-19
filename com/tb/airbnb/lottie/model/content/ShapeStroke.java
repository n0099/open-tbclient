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
    private final com.tb.airbnb.lottie.model.a.d oIA;
    private final com.tb.airbnb.lottie.model.a.b oIK;
    private final LineCapType oIL;
    private final LineJoinType oIM;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b oIY;
    private final com.tb.airbnb.lottie.model.a.a oIs;

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
        this.oIY = bVar;
        this.Fp = list;
        this.oIs = aVar;
        this.oIA = dVar;
        this.oIK = bVar2;
        this.oIL = lineCapType;
        this.oIM = lineJoinType;
        this.Fo = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a elC() {
        return this.oIs;
    }

    public com.tb.airbnb.lottie.model.a.d elc() {
        return this.oIA;
    }

    public com.tb.airbnb.lottie.model.a.b ell() {
        return this.oIK;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jX() {
        return this.Fp;
    }

    public com.tb.airbnb.lottie.model.a.b elo() {
        return this.oIY;
    }

    public LineCapType elm() {
        return this.oIL;
    }

    public LineJoinType eln() {
        return this.oIM;
    }

    public float jZ() {
        return this.Fo;
    }
}
