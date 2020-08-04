package com.tb.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a<K, A> {
    private final List<? extends com.tb.airbnb.lottie.e.a<K>> CL;
    @Nullable
    protected com.tb.airbnb.lottie.e.c<A> nOK;
    @Nullable
    private com.tb.airbnb.lottie.e.a<K> nOL;
    final List<InterfaceC0874a> listeners = new ArrayList();
    private boolean CK = false;
    private float progress = 0.0f;

    /* renamed from: com.tb.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0874a {
        void hq();
    }

    abstract A a(com.tb.airbnb.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.tb.airbnb.lottie.e.a<K>> list) {
        this.CL = list;
    }

    public void hE() {
        this.CK = true;
    }

    public void b(InterfaceC0874a interfaceC0874a) {
        this.listeners.add(interfaceC0874a);
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

    private com.tb.airbnb.lottie.e.a<K> dQX() {
        if (this.nOL != null && this.nOL.m(this.progress)) {
            return this.nOL;
        }
        com.tb.airbnb.lottie.e.a<K> aVar = this.CL.get(this.CL.size() - 1);
        if (this.progress < aVar.iY()) {
            for (int size = this.CL.size() - 1; size >= 0; size--) {
                aVar = this.CL.get(size);
                if (aVar.m(this.progress)) {
                    break;
                }
            }
        }
        this.nOL = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float hG() {
        if (this.CK) {
            return 0.0f;
        }
        com.tb.airbnb.lottie.e.a<K> dQX = dQX();
        if (dQX.jB()) {
            return 0.0f;
        }
        return (this.progress - dQX.iY()) / (dQX.hJ() - dQX.iY());
    }

    private float hH() {
        com.tb.airbnb.lottie.e.a<K> dQX = dQX();
        if (dQX.jB()) {
            return 0.0f;
        }
        return dQX.Gr.getInterpolation(hG());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float hI() {
        if (this.CL.isEmpty()) {
            return 0.0f;
        }
        return this.CL.get(0).iY();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    float hJ() {
        if (this.CL.isEmpty()) {
            return 1.0f;
        }
        return this.CL.get(this.CL.size() - 1).hJ();
    }

    public A getValue() {
        return a(dQX(), hH());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.tb.airbnb.lottie.e.c<A> cVar) {
        if (this.nOK != null) {
            this.nOK.b(null);
        }
        this.nOK = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
