package com.ksad.lottie.model.content;

import com.ksad.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f32037a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f32038b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32039c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32040d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32041e;

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
        this.f32037a = str;
        this.f32038b = type;
        this.f32039c = bVar;
        this.f32040d = bVar2;
        this.f32041e = bVar3;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String a() {
        return this.f32037a;
    }

    public Type b() {
        return this.f32038b;
    }

    public com.ksad.lottie.model.a.b c() {
        return this.f32040d;
    }

    public com.ksad.lottie.model.a.b d() {
        return this.f32039c;
    }

    public com.ksad.lottie.model.a.b e() {
        return this.f32041e;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f32039c + ", end: " + this.f32040d + ", offset: " + this.f32041e + "}";
    }
}
