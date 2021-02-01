package com.ksad.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.a.q;
import java.util.List;
/* loaded from: classes3.dex */
public class ShapeStroke implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f8061a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final com.ksad.lottie.model.a.b f8062b;
    private final List<com.ksad.lottie.model.a.b> c;
    private final com.ksad.lottie.model.a.a d;
    private final com.ksad.lottie.model.a.d e;
    private final com.ksad.lottie.model.a.b f;
    private final LineCapType g;
    private final LineJoinType h;
    private final float i;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    public ShapeStroke(String str, @Nullable com.ksad.lottie.model.a.b bVar, List<com.ksad.lottie.model.a.b> list, com.ksad.lottie.model.a.a aVar, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f) {
        this.f8061a = str;
        this.f8062b = bVar;
        this.c = list;
        this.d = aVar;
        this.e = dVar;
        this.f = bVar2;
        this.g = lineCapType;
        this.h = lineJoinType;
        this.i = f;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String a() {
        return this.f8061a;
    }

    public com.ksad.lottie.model.a.a b() {
        return this.d;
    }

    public com.ksad.lottie.model.a.d c() {
        return this.e;
    }

    public com.ksad.lottie.model.a.b d() {
        return this.f;
    }

    public List<com.ksad.lottie.model.a.b> e() {
        return this.c;
    }

    public com.ksad.lottie.model.a.b f() {
        return this.f8062b;
    }

    public LineCapType g() {
        return this.g;
    }

    public LineJoinType h() {
        return this.h;
    }

    public float i() {
        return this.i;
    }
}
