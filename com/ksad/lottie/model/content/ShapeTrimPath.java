package com.ksad.lottie.model.content;

import com.ksad.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31502a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f31503b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31504c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31505d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31506e;

    /* loaded from: classes6.dex */
    public enum Type {
        Simultaneously,
        Individually;

        public static Type forId(int i) {
            if (i != 1) {
                if (i == 2) {
                    return Individually;
                }
                throw new IllegalArgumentException("Unknown trim path type " + i);
            }
            return Simultaneously;
        }
    }

    public ShapeTrimPath(String str, Type type, com.ksad.lottie.model.a.b bVar, com.ksad.lottie.model.a.b bVar2, com.ksad.lottie.model.a.b bVar3) {
        this.f31502a = str;
        this.f31503b = type;
        this.f31504c = bVar;
        this.f31505d = bVar2;
        this.f31506e = bVar3;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String a() {
        return this.f31502a;
    }

    public Type b() {
        return this.f31503b;
    }

    public com.ksad.lottie.model.a.b c() {
        return this.f31505d;
    }

    public com.ksad.lottie.model.a.b d() {
        return this.f31504c;
    }

    public com.ksad.lottie.model.a.b e() {
        return this.f31506e;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f31504c + ", end: " + this.f31505d + ", offset: " + this.f31506e + "}";
    }
}
