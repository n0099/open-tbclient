package com.ksad.lottie.a.b;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a<K, A> {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public com.ksad.lottie.e.c<A> f31673b;

    /* renamed from: d  reason: collision with root package name */
    public final List<? extends com.ksad.lottie.e.a<K>> f31675d;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.ksad.lottie.e.a<K> f31677f;

    /* renamed from: a  reason: collision with root package name */
    public final List<InterfaceC0369a> f31672a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f31674c = false;

    /* renamed from: e  reason: collision with root package name */
    public float f31676e = 0.0f;

    /* renamed from: com.ksad.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0369a {
        void a();
    }

    public a(List<? extends com.ksad.lottie.e.a<K>> list) {
        this.f31675d = list;
    }

    private com.ksad.lottie.e.a<K> g() {
        List<? extends com.ksad.lottie.e.a<K>> list;
        com.ksad.lottie.e.a<K> aVar = this.f31677f;
        if (aVar == null || !aVar.a(this.f31676e)) {
            com.ksad.lottie.e.a<K> aVar2 = this.f31675d.get(list.size() - 1);
            if (this.f31676e < aVar2.b()) {
                for (int size = this.f31675d.size() - 1; size >= 0; size--) {
                    aVar2 = this.f31675d.get(size);
                    if (aVar2.a(this.f31676e)) {
                        break;
                    }
                }
            }
            this.f31677f = aVar2;
            return aVar2;
        }
        return this.f31677f;
    }

    private float h() {
        com.ksad.lottie.e.a<K> g2 = g();
        if (g2.d()) {
            return 0.0f;
        }
        return g2.f31769c.getInterpolation(c());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float i() {
        if (this.f31675d.isEmpty()) {
            return 0.0f;
        }
        return this.f31675d.get(0).b();
    }

    public abstract A a(com.ksad.lottie.e.a<K> aVar, float f2);

    public void a() {
        this.f31674c = true;
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (f2 < i()) {
            f2 = i();
        } else if (f2 > d()) {
            f2 = d();
        }
        if (f2 == this.f31676e) {
            return;
        }
        this.f31676e = f2;
        b();
    }

    public void a(InterfaceC0369a interfaceC0369a) {
        this.f31672a.add(interfaceC0369a);
    }

    public void b() {
        for (int i = 0; i < this.f31672a.size(); i++) {
            this.f31672a.get(i).a();
        }
    }

    public float c() {
        if (this.f31674c) {
            return 0.0f;
        }
        com.ksad.lottie.e.a<K> g2 = g();
        if (g2.d()) {
            return 0.0f;
        }
        return (this.f31676e - g2.b()) / (g2.c() - g2.b());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float d() {
        if (this.f31675d.isEmpty()) {
            return 1.0f;
        }
        List<? extends com.ksad.lottie.e.a<K>> list = this.f31675d;
        return list.get(list.size() - 1).c();
    }

    public A e() {
        return a(g(), h());
    }

    public float f() {
        return this.f31676e;
    }
}
