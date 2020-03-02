package com.tb.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a<K, A> {
    private final List<? extends com.tb.airbnb.lottie.e.a<K>> gH;
    @Nullable
    protected com.tb.airbnb.lottie.e.c<A> nqj;
    @Nullable
    private com.tb.airbnb.lottie.e.a<K> nqk;
    final List<InterfaceC0738a> listeners = new ArrayList();
    private boolean gG = false;
    private float progress = 0.0f;

    /* renamed from: com.tb.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0738a {
        void bD();
    }

    abstract A a(com.tb.airbnb.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.tb.airbnb.lottie.e.a<K>> list) {
        this.gH = list;
    }

    public void bR() {
        this.gG = true;
    }

    public void b(InterfaceC0738a interfaceC0738a) {
        this.listeners.add(interfaceC0738a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < bV()) {
            f = bV();
        } else if (f > bW()) {
            f = bW();
        }
        if (f != this.progress) {
            this.progress = f;
            bz();
        }
    }

    public void bz() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).bD();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private com.tb.airbnb.lottie.e.a<K> dGJ() {
        if (this.nqk != null && this.nqk.n(this.progress)) {
            return this.nqk;
        }
        com.tb.airbnb.lottie.e.a<K> aVar = this.gH.get(this.gH.size() - 1);
        if (this.progress < aVar.dj()) {
            for (int size = this.gH.size() - 1; size >= 0; size--) {
                aVar = this.gH.get(size);
                if (aVar.n(this.progress)) {
                    break;
                }
            }
        }
        this.nqk = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float bT() {
        if (this.gG) {
            return 0.0f;
        }
        com.tb.airbnb.lottie.e.a<K> dGJ = dGJ();
        if (dGJ.dM()) {
            return 0.0f;
        }
        return (this.progress - dGJ.dj()) / (dGJ.bW() - dGJ.dj());
    }

    private float bU() {
        com.tb.airbnb.lottie.e.a<K> dGJ = dGJ();
        if (dGJ.dM()) {
            return 0.0f;
        }
        return dGJ.ks.getInterpolation(bT());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float bV() {
        if (this.gH.isEmpty()) {
            return 0.0f;
        }
        return this.gH.get(0).dj();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    float bW() {
        if (this.gH.isEmpty()) {
            return 1.0f;
        }
        return this.gH.get(this.gH.size() - 1).bW();
    }

    public A getValue() {
        return a(dGJ(), bU());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.tb.airbnb.lottie.e.c<A> cVar) {
        if (this.nqj != null) {
            this.nqj.b(null);
        }
        this.nqj = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
