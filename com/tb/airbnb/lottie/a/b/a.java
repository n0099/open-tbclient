package com.tb.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public abstract class a<K, A> {
    private final List<? extends com.tb.airbnb.lottie.e.a<K>> EF;
    @Nullable
    protected com.tb.airbnb.lottie.e.c<A> pBw;
    @Nullable
    private com.tb.airbnb.lottie.e.a<K> pBx;
    final List<InterfaceC1019a> listeners = new ArrayList();
    private boolean EE = false;
    private float progress = 0.0f;

    /* renamed from: com.tb.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC1019a {
        void iT();
    }

    abstract A a(com.tb.airbnb.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.tb.airbnb.lottie.e.a<K>> list) {
        this.EF = list;
    }

    public void jh() {
        this.EE = true;
    }

    public void b(InterfaceC1019a interfaceC1019a) {
        this.listeners.add(interfaceC1019a);
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

    private com.tb.airbnb.lottie.e.a<K> eBd() {
        if (this.pBx != null && this.pBx.l(this.progress)) {
            return this.pBx;
        }
        com.tb.airbnb.lottie.e.a<K> aVar = this.EF.get(this.EF.size() - 1);
        if (this.progress < aVar.kz()) {
            for (int size = this.EF.size() - 1; size >= 0; size--) {
                aVar = this.EF.get(size);
                if (aVar.l(this.progress)) {
                    break;
                }
            }
        }
        this.pBx = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float jj() {
        if (this.EE) {
            return 0.0f;
        }
        com.tb.airbnb.lottie.e.a<K> eBd = eBd();
        if (eBd.lc()) {
            return 0.0f;
        }
        return (this.progress - eBd.kz()) / (eBd.jm() - eBd.kz());
    }

    private float jk() {
        com.tb.airbnb.lottie.e.a<K> eBd = eBd();
        if (eBd.lc()) {
            return 0.0f;
        }
        return eBd.Ih.getInterpolation(jj());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float jl() {
        if (this.EF.isEmpty()) {
            return 0.0f;
        }
        return this.EF.get(0).kz();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    float jm() {
        if (this.EF.isEmpty()) {
            return 1.0f;
        }
        return this.EF.get(this.EF.size() - 1).jm();
    }

    public A getValue() {
        return a(eBd(), jk());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.tb.airbnb.lottie.e.c<A> cVar) {
        if (this.pBw != null) {
            this.pBw.b(null);
        }
        this.pBw = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
