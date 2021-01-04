package com.ksad.lottie.model.content;

import com.ksad.lottie.a.a.r;
/* loaded from: classes5.dex */
public class ShapeTrimPath implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f8362a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f8363b;
    private final com.ksad.lottie.model.a.b c;
    private final com.ksad.lottie.model.a.b d;
    private final com.ksad.lottie.model.a.b e;

    /* loaded from: classes5.dex */
    public enum Type {
        Simultaneously,
        Individually;

        public static Type forId(int i) {
            switch (i) {
                case 1:
                    return Simultaneously;
                case 2:
                    return Individually;
                default:
                    throw new IllegalArgumentException("Unknown trim path type " + i);
            }
        }
    }

    public ShapeTrimPath(String str, Type type, com.ksad.lottie.model.a.b bVar, com.ksad.lottie.model.a.b bVar2, com.ksad.lottie.model.a.b bVar3) {
        this.f8362a = str;
        this.f8363b = type;
        this.c = bVar;
        this.d = bVar2;
        this.e = bVar3;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String a() {
        return this.f8362a;
    }

    public Type b() {
        return this.f8363b;
    }

    public com.ksad.lottie.model.a.b c() {
        return this.d;
    }

    public com.ksad.lottie.model.a.b d() {
        return this.c;
    }

    public com.ksad.lottie.model.a.b e() {
        return this.e;
    }

    public String toString() {
        return "Trim Path: {start: " + this.c + ", end: " + this.d + ", offset: " + this.e + "}";
    }
}
