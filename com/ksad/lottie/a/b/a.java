package com.ksad.lottie.a.b;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a<K, A> {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public com.ksad.lottie.e.c<A> f31915b;

    /* renamed from: d  reason: collision with root package name */
    public final List<? extends com.ksad.lottie.e.a<K>> f31917d;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.ksad.lottie.e.a<K> f31919f;

    /* renamed from: a  reason: collision with root package name */
    public final List<InterfaceC0355a> f31914a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f31916c = false;

    /* renamed from: e  reason: collision with root package name */
    public float f31918e = 0.0f;

    /* renamed from: com.ksad.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0355a {
        void a();
    }

    public a(List<? extends com.ksad.lottie.e.a<K>> list) {
        this.f31917d = list;
    }

    private com.ksad.lottie.e.a<K> g() {
        List<? extends com.ksad.lottie.e.a<K>> list;
        com.ksad.lottie.e.a<K> aVar = this.f31919f;
        if (aVar == null || !aVar.a(this.f31918e)) {
            com.ksad.lottie.e.a<K> aVar2 = this.f31917d.get(list.size() - 1);
            if (this.f31918e < aVar2.b()) {
                for (int size = this.f31917d.size() - 1; size >= 0; size--) {
                    aVar2 = this.f31917d.get(size);
                    if (aVar2.a(this.f31918e)) {
                        break;
                    }
                }
            }
            this.f31919f = aVar2;
            return aVar2;
        }
        return this.f31919f;
    }

    private float h() {
        com.ksad.lottie.e.a<K> g2 = g();
        if (g2.d()) {
            return 0.0f;
        }
        return g2.f32013c.getInterpolation(c());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float i() {
        if (this.f31917d.isEmpty()) {
            return 0.0f;
        }
        return this.f31917d.get(0).b();
    }

    public abstract A a(com.ksad.lottie.e.a<K> aVar, float f2);

    public void a() {
        this.f31916c = true;
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (f2 < i()) {
            f2 = i();
        } else if (f2 > d()) {
            f2 = d();
        }
        if (f2 == this.f31918e) {
            return;
        }
        this.f31918e = f2;
        b();
    }

    public void a(InterfaceC0355a interfaceC0355a) {
        this.f31914a.add(interfaceC0355a);
    }

    public void b() {
        for (int i2 = 0; i2 < this.f31914a.size(); i2++) {
            this.f31914a.get(i2).a();
        }
    }

    public float c() {
        if (this.f31916c) {
            return 0.0f;
        }
        com.ksad.lottie.e.a<K> g2 = g();
        if (g2.d()) {
            return 0.0f;
        }
        return (this.f31918e - g2.b()) / (g2.c() - g2.b());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float d() {
        if (this.f31917d.isEmpty()) {
            return 1.0f;
        }
        List<? extends com.ksad.lottie.e.a<K>> list = this.f31917d;
        return list.get(list.size() - 1).c();
    }

    public A e() {
        return a(g(), h());
    }

    public float f() {
        return this.f31918e;
    }
}
