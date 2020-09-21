package com.tb.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public abstract class a<K, A> {
    private final List<? extends com.tb.airbnb.lottie.e.a<K>> Du;
    @Nullable
    protected com.tb.airbnb.lottie.e.c<A> osG;
    @Nullable
    private com.tb.airbnb.lottie.e.a<K> osH;
    final List<InterfaceC0929a> listeners = new ArrayList();
    private boolean Dt = false;
    private float progress = 0.0f;

    /* renamed from: com.tb.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC0929a {
        void iS();
    }

    abstract A a(com.tb.airbnb.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.tb.airbnb.lottie.e.a<K>> list) {
        this.Du = list;
    }

    public void jg() {
        this.Dt = true;
    }

    public void b(InterfaceC0929a interfaceC0929a) {
        this.listeners.add(interfaceC0929a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < jk()) {
            f = jk();
        } else if (f > jl()) {
            f = jl();
        }
        if (f != this.progress) {
            this.progress = f;
            iO();
        }
    }

    public void iO() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).iS();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private com.tb.airbnb.lottie.e.a<K> ehf() {
        if (this.osH != null && this.osH.m(this.progress)) {
            return this.osH;
        }
        com.tb.airbnb.lottie.e.a<K> aVar = this.Du.get(this.Du.size() - 1);
        if (this.progress < aVar.ky()) {
            for (int size = this.Du.size() - 1; size >= 0; size--) {
                aVar = this.Du.get(size);
                if (aVar.m(this.progress)) {
                    break;
                }
            }
        }
        this.osH = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float ji() {
        if (this.Dt) {
            return 0.0f;
        }
        com.tb.airbnb.lottie.e.a<K> ehf = ehf();
        if (ehf.lb()) {
            return 0.0f;
        }
        return (this.progress - ehf.ky()) / (ehf.jl() - ehf.ky());
    }

    private float jj() {
        com.tb.airbnb.lottie.e.a<K> ehf = ehf();
        if (ehf.lb()) {
            return 0.0f;
        }
        return ehf.GZ.getInterpolation(ji());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float jk() {
        if (this.Du.isEmpty()) {
            return 0.0f;
        }
        return this.Du.get(0).ky();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    float jl() {
        if (this.Du.isEmpty()) {
            return 1.0f;
        }
        return this.Du.get(this.Du.size() - 1).jl();
    }

    public A getValue() {
        return a(ehf(), jj());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.tb.airbnb.lottie.e.c<A> cVar) {
        if (this.osG != null) {
            this.osG.b(null);
        }
        this.osG = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
