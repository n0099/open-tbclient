package com.ksad.lottie.model.content;

import android.graphics.PointF;
import com.ksad.lottie.model.a.m;
/* loaded from: classes5.dex */
public class PolystarShape implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f8356a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f8357b;
    private final com.ksad.lottie.model.a.b c;
    private final m<PointF, PointF> d;
    private final com.ksad.lottie.model.a.b e;
    private final com.ksad.lottie.model.a.b f;
    private final com.ksad.lottie.model.a.b g;
    private final com.ksad.lottie.model.a.b h;
    private final com.ksad.lottie.model.a.b i;

    /* loaded from: classes5.dex */
    public enum Type {
        Star(1),
        Polygon(2);
        
        private final int value;

        Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            Type[] values;
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, com.ksad.lottie.model.a.b bVar, m<PointF, PointF> mVar, com.ksad.lottie.model.a.b bVar2, com.ksad.lottie.model.a.b bVar3, com.ksad.lottie.model.a.b bVar4, com.ksad.lottie.model.a.b bVar5, com.ksad.lottie.model.a.b bVar6) {
        this.f8356a = str;
        this.f8357b = type;
        this.c = bVar;
        this.d = mVar;
        this.e = bVar2;
        this.f = bVar3;
        this.g = bVar4;
        this.h = bVar5;
        this.i = bVar6;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.m(fVar, aVar, this);
    }

    public String a() {
        return this.f8356a;
    }

    public Type b() {
        return this.f8357b;
    }

    public com.ksad.lottie.model.a.b c() {
        return this.c;
    }

    public m<PointF, PointF> d() {
        return this.d;
    }

    public com.ksad.lottie.model.a.b e() {
        return this.e;
    }

    public com.ksad.lottie.model.a.b f() {
        return this.f;
    }

    public com.ksad.lottie.model.a.b g() {
        return this.g;
    }

    public com.ksad.lottie.model.a.b h() {
        return this.h;
    }

    public com.ksad.lottie.model.a.b i() {
        return this.i;
    }
}
