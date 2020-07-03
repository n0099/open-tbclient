package com.tb.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a<K, A> {
    private final List<? extends com.tb.airbnb.lottie.e.a<K>> CJ;
    @Nullable
    protected com.tb.airbnb.lottie.e.c<A> nFX;
    @Nullable
    private com.tb.airbnb.lottie.e.a<K> nFY;
    final List<InterfaceC0864a> listeners = new ArrayList();
    private boolean CI = false;
    private float progress = 0.0f;

    /* renamed from: com.tb.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0864a {
        void hq();
    }

    abstract A a(com.tb.airbnb.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.tb.airbnb.lottie.e.a<K>> list) {
        this.CJ = list;
    }

    public void hE() {
        this.CI = true;
    }

    public void b(InterfaceC0864a interfaceC0864a) {
        this.listeners.add(interfaceC0864a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < hI()) {
            f = hI();
        } else if (f > hJ()) {
            f = hJ();
        }
        if (f != this.progress) {
            this.progress = f;
            hm();
        }
    }

    public void hm() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).hq();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private com.tb.airbnb.lottie.e.a<K> dNw() {
        if (this.nFY != null && this.nFY.m(this.progress)) {
            return this.nFY;
        }
        com.tb.airbnb.lottie.e.a<K> aVar = this.CJ.get(this.CJ.size() - 1);
        if (this.progress < aVar.iY()) {
            for (int size = this.CJ.size() - 1; size >= 0; size--) {
                aVar = this.CJ.get(size);
                if (aVar.m(this.progress)) {
                    break;
                }
            }
        }
        this.nFY = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float hG() {
        if (this.CI) {
            return 0.0f;
        }
        com.tb.airbnb.lottie.e.a<K> dNw = dNw();
        if (dNw.jB()) {
            return 0.0f;
        }
        return (this.progress - dNw.iY()) / (dNw.hJ() - dNw.iY());
    }

    private float hH() {
        com.tb.airbnb.lottie.e.a<K> dNw = dNw();
        if (dNw.jB()) {
            return 0.0f;
        }
        return dNw.Gr.getInterpolation(hG());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float hI() {
        if (this.CJ.isEmpty()) {
            return 0.0f;
        }
        return this.CJ.get(0).iY();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    float hJ() {
        if (this.CJ.isEmpty()) {
            return 1.0f;
        }
        return this.CJ.get(this.CJ.size() - 1).hJ();
    }

    public A getValue() {
        return a(dNw(), hH());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.tb.airbnb.lottie.e.c<A> cVar) {
        if (this.nFX != null) {
            this.nFX.b(null);
        }
        this.nFX = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
