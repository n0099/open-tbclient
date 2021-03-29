package com.ksad.lottie.model.content;

import android.graphics.PointF;
import com.ksad.lottie.model.a.m;
/* loaded from: classes6.dex */
public class PolystarShape implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31484a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f31485b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31486c;

    /* renamed from: d  reason: collision with root package name */
    public final m<PointF, PointF> f31487d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31488e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31489f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31490g;

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31491h;
    public final com.ksad.lottie.model.a.b i;

    /* loaded from: classes6.dex */
    public enum Type {
        Star(1),
        Polygon(2);
        
        public final int value;

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
        this.f31484a = str;
        this.f31485b = type;
        this.f31486c = bVar;
        this.f31487d = mVar;
        this.f31488e = bVar2;
        this.f31489f = bVar3;
        this.f31490g = bVar4;
        this.f31491h = bVar5;
        this.i = bVar6;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.m(fVar, aVar, this);
    }

    public String a() {
        return this.f31484a;
    }

    public Type b() {
        return this.f31485b;
    }

    public com.ksad.lottie.model.a.b c() {
        return this.f31486c;
    }

    public m<PointF, PointF> d() {
        return this.f31487d;
    }

    public com.ksad.lottie.model.a.b e() {
        return this.f31488e;
    }

    public com.ksad.lottie.model.a.b f() {
        return this.f31489f;
    }

    public com.ksad.lottie.model.a.b g() {
        return this.f31490g;
    }

    public com.ksad.lottie.model.a.b h() {
        return this.f31491h;
    }

    public com.ksad.lottie.model.a.b i() {
        return this.i;
    }
}
