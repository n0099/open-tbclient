package com.tb.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a<K, A> {
    private final List<? extends com.tb.airbnb.lottie.e.a<K>> Ci;
    @Nullable
    protected com.tb.airbnb.lottie.e.c<A> mOQ;
    @Nullable
    private com.tb.airbnb.lottie.e.a<K> mOR;
    final List<InterfaceC0763a> listeners = new ArrayList();
    private boolean Ch = false;
    private float progress = 0.0f;

    /* renamed from: com.tb.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0763a {
        void ha();
    }

    abstract A a(com.tb.airbnb.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.tb.airbnb.lottie.e.a<K>> list) {
        this.Ci = list;
    }

    public void ho() {
        this.Ch = true;
    }

    public void b(InterfaceC0763a interfaceC0763a) {
        this.listeners.add(interfaceC0763a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < hs()) {
            f = hs();
        } else if (f > ht()) {
            f = ht();
        }
        if (f != this.progress) {
            this.progress = f;
            gW();
        }
    }

    public void gW() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).ha();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private com.tb.airbnb.lottie.e.a<K> dBm() {
        if (this.mOR != null && this.mOR.k(this.progress)) {
            return this.mOR;
        }
        com.tb.airbnb.lottie.e.a<K> aVar = this.Ci.get(this.Ci.size() - 1);
        if (this.progress < aVar.iI()) {
            for (int size = this.Ci.size() - 1; size >= 0; size--) {
                aVar = this.Ci.get(size);
                if (aVar.k(this.progress)) {
                    break;
                }
            }
        }
        this.mOR = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float hq() {
        if (this.Ch) {
            return 0.0f;
        }
        com.tb.airbnb.lottie.e.a<K> dBm = dBm();
        if (dBm.jl()) {
            return 0.0f;
        }
        return (this.progress - dBm.iI()) / (dBm.ht() - dBm.iI());
    }

    private float hr() {
        com.tb.airbnb.lottie.e.a<K> dBm = dBm();
        if (dBm.jl()) {
            return 0.0f;
        }
        return dBm.FN.getInterpolation(hq());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float hs() {
        if (this.Ci.isEmpty()) {
            return 0.0f;
        }
        return this.Ci.get(0).iI();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    float ht() {
        if (this.Ci.isEmpty()) {
            return 1.0f;
        }
        return this.Ci.get(this.Ci.size() - 1).ht();
    }

    public A getValue() {
        return a(dBm(), hr());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.tb.airbnb.lottie.e.c<A> cVar) {
        if (this.mOQ != null) {
            this.mOQ.b(null);
        }
        this.mOQ = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
