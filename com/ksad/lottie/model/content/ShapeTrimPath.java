package com.ksad.lottie.model.content;

import com.ksad.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31886a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f31887b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31888c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31889d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31890e;

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
        this.f31886a = str;
        this.f31887b = type;
        this.f31888c = bVar;
        this.f31889d = bVar2;
        this.f31890e = bVar3;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String a() {
        return this.f31886a;
    }

    public Type b() {
        return this.f31887b;
    }

    public com.ksad.lottie.model.a.b c() {
        return this.f31889d;
    }

    public com.ksad.lottie.model.a.b d() {
        return this.f31888c;
    }

    public com.ksad.lottie.model.a.b e() {
        return this.f31890e;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f31888c + ", end: " + this.f31889d + ", offset: " + this.f31890e + "}";
    }
}
