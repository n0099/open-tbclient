package com.ksad.lottie.model.content;

import com.ksad.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f32135a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f32136b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32137c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32138d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32139e;

    /* loaded from: classes6.dex */
    public enum Type {
        Simultaneously,
        Individually;

        public static Type forId(int i2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return Individually;
                }
                throw new IllegalArgumentException("Unknown trim path type " + i2);
            }
            return Simultaneously;
        }
    }

    public ShapeTrimPath(String str, Type type, com.ksad.lottie.model.a.b bVar, com.ksad.lottie.model.a.b bVar2, com.ksad.lottie.model.a.b bVar3) {
        this.f32135a = str;
        this.f32136b = type;
        this.f32137c = bVar;
        this.f32138d = bVar2;
        this.f32139e = bVar3;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String a() {
        return this.f32135a;
    }

    public Type b() {
        return this.f32136b;
    }

    public com.ksad.lottie.model.a.b c() {
        return this.f32138d;
    }

    public com.ksad.lottie.model.a.b d() {
        return this.f32137c;
    }

    public com.ksad.lottie.model.a.b e() {
        return this.f32139e;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f32137c + ", end: " + this.f32138d + ", offset: " + this.f32139e + "}";
    }
}
