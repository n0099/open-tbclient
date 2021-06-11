package com.ksad.lottie.model.content;

import android.graphics.PointF;
import com.ksad.lottie.model.a.m;
/* loaded from: classes6.dex */
public class PolystarShape implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f32017a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f32018b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32019c;

    /* renamed from: d  reason: collision with root package name */
    public final m<PointF, PointF> f32020d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32021e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32022f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32023g;

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32024h;

    /* renamed from: i  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32025i;

    /* loaded from: classes6.dex */
    public enum Type {
        Star(1),
        Polygon(2);
        
        public final int value;

        Type(int i2) {
            this.value = i2;
        }

        public static Type forValue(int i2) {
            Type[] values;
            for (Type type : values()) {
                if (type.value == i2) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, com.ksad.lottie.model.a.b bVar, m<PointF, PointF> mVar, com.ksad.lottie.model.a.b bVar2, com.ksad.lottie.model.a.b bVar3, com.ksad.lottie.model.a.b bVar4, com.ksad.lottie.model.a.b bVar5, com.ksad.lottie.model.a.b bVar6) {
        this.f32017a = str;
        this.f32018b = type;
        this.f32019c = bVar;
        this.f32020d = mVar;
        this.f32021e = bVar2;
        this.f32022f = bVar3;
        this.f32023g = bVar4;
        this.f32024h = bVar5;
        this.f32025i = bVar6;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.m(fVar, aVar, this);
    }

    public String a() {
        return this.f32017a;
    }

    public Type b() {
        return this.f32018b;
    }

    public com.ksad.lottie.model.a.b c() {
        return this.f32019c;
    }

    public m<PointF, PointF> d() {
        return this.f32020d;
    }

    public com.ksad.lottie.model.a.b e() {
        return this.f32021e;
    }

    public com.ksad.lottie.model.a.b f() {
        return this.f32022f;
    }

    public com.ksad.lottie.model.a.b g() {
        return this.f32023g;
    }

    public com.ksad.lottie.model.a.b h() {
        return this.f32024h;
    }

    public com.ksad.lottie.model.a.b i() {
        return this.f32025i;
    }
}
