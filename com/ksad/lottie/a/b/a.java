package com.ksad.lottie.a.b;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a<K, A> {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    protected com.ksad.lottie.e.c<A> f7960b;
    private final List<? extends com.ksad.lottie.e.a<K>> d;
    @Nullable
    private com.ksad.lottie.e.a<K> f;

    /* renamed from: a  reason: collision with root package name */
    final List<InterfaceC1067a> f7959a = new ArrayList();
    private boolean c = false;
    private float e = 0.0f;

    /* renamed from: com.ksad.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1067a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.ksad.lottie.e.a<K>> list) {
        this.d = list;
    }

    private com.ksad.lottie.e.a<K> g() {
        if (this.f == null || !this.f.a(this.e)) {
            com.ksad.lottie.e.a<K> aVar = this.d.get(this.d.size() - 1);
            if (this.e < aVar.b()) {
                for (int size = this.d.size() - 1; size >= 0; size--) {
                    aVar = this.d.get(size);
                    if (aVar.a(this.e)) {
                        break;
                    }
                }
            }
            this.f = aVar;
            return aVar;
        }
        return this.f;
    }

    private float h() {
        com.ksad.lottie.e.a<K> g = g();
        if (g.d()) {
            return 0.0f;
        }
        return g.c.getInterpolation(c());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float i() {
        if (this.d.isEmpty()) {
            return 0.0f;
        }
        return this.d.get(0).b();
    }

    abstract A a(com.ksad.lottie.e.a<K> aVar, float f);

    public void a() {
        this.c = true;
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < i()) {
            f = i();
        } else if (f > d()) {
            f = d();
        }
        if (f == this.e) {
            return;
        }
        this.e = f;
        b();
    }

    public void a(InterfaceC1067a interfaceC1067a) {
        this.f7959a.add(interfaceC1067a);
    }

    public void b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f7959a.size()) {
                return;
            }
            this.f7959a.get(i2).a();
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        if (this.c) {
            return 0.0f;
        }
        com.ksad.lottie.e.a<K> g = g();
        if (g.d()) {
            return 0.0f;
        }
        return (this.e - g.b()) / (g.c() - g.b());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    float d() {
        if (this.d.isEmpty()) {
            return 1.0f;
        }
        return this.d.get(this.d.size() - 1).c();
    }

    public A e() {
        return a(g(), h());
    }

    public float f() {
        return this.e;
    }
}
