package com.tb.airbnb.lottie.model.content;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.q;
import java.util.List;
/* loaded from: classes6.dex */
public class ShapeStroke implements b {
    private final float DN;
    private final List<com.tb.airbnb.lottie.model.a.b> DO;
    private final com.tb.airbnb.lottie.model.a.b mPG;
    private final LineCapType mPH;
    private final LineJoinType mPI;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b mPU;
    private final com.tb.airbnb.lottie.model.a.a mPo;
    private final com.tb.airbnb.lottie.model.a.d mPw;
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
        this.mPU = bVar;
        this.DO = list;
        this.mPo = aVar;
        this.mPw = dVar;
        this.mPG = bVar2;
        this.mPH = lineCapType;
        this.mPI = lineJoinType;
        this.DN = f;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.a dBY() {
        return this.mPo;
    }

    public com.tb.airbnb.lottie.model.a.d dBy() {
        return this.mPw;
    }

    public com.tb.airbnb.lottie.model.a.b dBH() {
        return this.mPG;
    }

    /* renamed from: if  reason: not valid java name */
    public List<com.tb.airbnb.lottie.model.a.b> m48if() {
        return this.DO;
    }

    public com.tb.airbnb.lottie.model.a.b dBK() {
        return this.mPU;
    }

    public LineCapType dBI() {
        return this.mPH;
    }

    public LineJoinType dBJ() {
        return this.mPI;
    }

    public float ih() {
        return this.DN;
    }
}
