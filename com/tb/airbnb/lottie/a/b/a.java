package com.tb.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public abstract class a<K, A> {
    private final List<? extends com.tb.airbnb.lottie.e.a<K>> DO;
    @Nullable
    protected com.tb.airbnb.lottie.e.c<A> oHW;
    @Nullable
    private com.tb.airbnb.lottie.e.a<K> oHX;
    final List<InterfaceC0947a> listeners = new ArrayList();
    private boolean DN = false;
    private float progress = 0.0f;

    /* renamed from: com.tb.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0947a {
        void iT();
    }

    abstract A a(com.tb.airbnb.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.tb.airbnb.lottie.e.a<K>> list) {
        this.DO = list;
    }

    public void jh() {
        this.DN = true;
    }

    public void b(InterfaceC0947a interfaceC0947a) {
        this.listeners.add(interfaceC0947a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < jl()) {
            f = jl();
        } else if (f > jm()) {
            f = jm();
        }
        if (f != this.progress) {
            this.progress = f;
            iP();
        }
    }

    public void iP() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).iT();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private com.tb.airbnb.lottie.e.a<K> ekQ() {
        if (this.oHX != null && this.oHX.m(this.progress)) {
            return this.oHX;
        }
        com.tb.airbnb.lottie.e.a<K> aVar = this.DO.get(this.DO.size() - 1);
        if (this.progress < aVar.kz()) {
            for (int size = this.DO.size() - 1; size >= 0; size--) {
                aVar = this.DO.get(size);
                if (aVar.m(this.progress)) {
                    break;
                }
            }
        }
        this.oHX = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float jj() {
        if (this.DN) {
            return 0.0f;
        }
        com.tb.airbnb.lottie.e.a<K> ekQ = ekQ();
        if (ekQ.lc()) {
            return 0.0f;
        }
        return (this.progress - ekQ.kz()) / (ekQ.jm() - ekQ.kz());
    }

    private float jk() {
        com.tb.airbnb.lottie.e.a<K> ekQ = ekQ();
        if (ekQ.lc()) {
            return 0.0f;
        }
        return ekQ.Hp.getInterpolation(jj());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float jl() {
        if (this.DO.isEmpty()) {
            return 0.0f;
        }
        return this.DO.get(0).kz();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    float jm() {
        if (this.DO.isEmpty()) {
            return 1.0f;
        }
        return this.DO.get(this.DO.size() - 1).jm();
    }

    public A getValue() {
        return a(ekQ(), jk());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.tb.airbnb.lottie.e.c<A> cVar) {
        if (this.oHW != null) {
            this.oHW.b(null);
        }
        this.oHW = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
