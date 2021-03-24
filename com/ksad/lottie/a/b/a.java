package com.ksad.lottie.a.b;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a<K, A> {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public com.ksad.lottie.e.c<A> f31288b;

    /* renamed from: d  reason: collision with root package name */
    public final List<? extends com.ksad.lottie.e.a<K>> f31290d;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.ksad.lottie.e.a<K> f31292f;

    /* renamed from: a  reason: collision with root package name */
    public final List<InterfaceC0351a> f31287a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f31289c = false;

    /* renamed from: e  reason: collision with root package name */
    public float f31291e = 0.0f;

    /* renamed from: com.ksad.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0351a {
        void a();
    }

    public a(List<? extends com.ksad.lottie.e.a<K>> list) {
        this.f31290d = list;
    }

    private com.ksad.lottie.e.a<K> g() {
        List<? extends com.ksad.lottie.e.a<K>> list;
        com.ksad.lottie.e.a<K> aVar = this.f31292f;
        if (aVar == null || !aVar.a(this.f31291e)) {
            com.ksad.lottie.e.a<K> aVar2 = this.f31290d.get(list.size() - 1);
            if (this.f31291e < aVar2.b()) {
                for (int size = this.f31290d.size() - 1; size >= 0; size--) {
                    aVar2 = this.f31290d.get(size);
                    if (aVar2.a(this.f31291e)) {
                        break;
                    }
                }
            }
            this.f31292f = aVar2;
            return aVar2;
        }
        return this.f31292f;
    }

    private float h() {
        com.ksad.lottie.e.a<K> g2 = g();
        if (g2.d()) {
            return 0.0f;
        }
        return g2.f31384c.getInterpolation(c());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float i() {
        if (this.f31290d.isEmpty()) {
            return 0.0f;
        }
        return this.f31290d.get(0).b();
    }

    public abstract A a(com.ksad.lottie.e.a<K> aVar, float f2);

    public void a() {
        this.f31289c = true;
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (f2 < i()) {
            f2 = i();
        } else if (f2 > d()) {
            f2 = d();
        }
        if (f2 == this.f31291e) {
            return;
        }
        this.f31291e = f2;
        b();
    }

    public void a(InterfaceC0351a interfaceC0351a) {
        this.f31287a.add(interfaceC0351a);
    }

    public void b() {
        for (int i = 0; i < this.f31287a.size(); i++) {
            this.f31287a.get(i).a();
        }
    }

    public float c() {
        if (this.f31289c) {
            return 0.0f;
        }
        com.ksad.lottie.e.a<K> g2 = g();
        if (g2.d()) {
            return 0.0f;
        }
        return (this.f31291e - g2.b()) / (g2.c() - g2.b());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float d() {
        if (this.f31290d.isEmpty()) {
            return 1.0f;
        }
        List<? extends com.ksad.lottie.e.a<K>> list = this.f31290d;
        return list.get(list.size() - 1).c();
    }

    public A e() {
        return a(g(), h());
    }

    public float f() {
        return this.f31291e;
    }
}
