package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes7.dex */
public class ShapeStroke implements b {
    private final float EX;
    private final List<com.tb.airbnb.lottie.model.a.b> EY;
    private final String name;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b ojG;
    private final com.tb.airbnb.lottie.model.a.a oja;
    private final com.tb.airbnb.lottie.model.a.d oji;
    private final com.tb.airbnb.lottie.model.a.b ojs;
    private final LineCapType ojt;
    private final LineJoinType oju;

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
        this.ojG = bVar;
        this.EY = list;
        this.oja = aVar;
        this.oji = dVar;
        this.ojs = bVar2;
        this.ojt = lineCapType;
        this.oju = lineJoinType;
        this.EX = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a edL() {
        return this.oja;
    }

    public com.tb.airbnb.lottie.model.a.d edl() {
        return this.oji;
    }

    public com.tb.airbnb.lottie.model.a.b edu() {
        return this.ojs;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jV() {
        return this.EY;
    }

    public com.tb.airbnb.lottie.model.a.b edx() {
        return this.ojG;
    }

    public LineCapType edv() {
        return this.ojt;
    }

    public LineJoinType edw() {
        return this.oju;
    }

    public float jX() {
        return this.EX;
    }
}
