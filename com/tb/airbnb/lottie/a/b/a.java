package com.tb.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class a<K, A> {
    private final List<? extends com.tb.airbnb.lottie.e.a<K>> Du;
    @Nullable
    protected com.tb.airbnb.lottie.e.c<A> oiW;
    @Nullable
    private com.tb.airbnb.lottie.e.a<K> oiX;
    final List<InterfaceC0932a> listeners = new ArrayList();
    private boolean Dt = false;
    private float progress = 0.0f;

    /* renamed from: com.tb.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0932a {
        void iR();
    }

    abstract A a(com.tb.airbnb.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.tb.airbnb.lottie.e.a<K>> list) {
        this.Du = list;
    }

    public void jf() {
        this.Dt = true;
    }

    public void b(InterfaceC0932a interfaceC0932a) {
        this.listeners.add(interfaceC0932a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < jj()) {
            f = jj();
        } else if (f > jk()) {
            f = jk();
        }
        if (f != this.progress) {
            this.progress = f;
            iN();
        }
    }

    public void iN() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).iR();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private com.tb.airbnb.lottie.e.a<K> edi() {
        if (this.oiX != null && this.oiX.m(this.progress)) {
            return this.oiX;
        }
        com.tb.airbnb.lottie.e.a<K> aVar = this.Du.get(this.Du.size() - 1);
        if (this.progress < aVar.kx()) {
            for (int size = this.Du.size() - 1; size >= 0; size--) {
                aVar = this.Du.get(size);
                if (aVar.m(this.progress)) {
                    break;
                }
            }
        }
        this.oiX = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float jh() {
        if (this.Dt) {
            return 0.0f;
        }
        com.tb.airbnb.lottie.e.a<K> edi = edi();
        if (edi.la()) {
            return 0.0f;
        }
        return (this.progress - edi.kx()) / (edi.jk() - edi.kx());
    }

    private float ji() {
        com.tb.airbnb.lottie.e.a<K> edi = edi();
        if (edi.la()) {
            return 0.0f;
        }
        return edi.GZ.getInterpolation(jh());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float jj() {
        if (this.Du.isEmpty()) {
            return 0.0f;
        }
        return this.Du.get(0).kx();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    float jk() {
        if (this.Du.isEmpty()) {
            return 1.0f;
        }
        return this.Du.get(this.Du.size() - 1).jk();
    }

    public A getValue() {
        return a(edi(), ji());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.tb.airbnb.lottie.e.c<A> cVar) {
        if (this.oiW != null) {
            this.oiW.b(null);
        }
        this.oiW = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
