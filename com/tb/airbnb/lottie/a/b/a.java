package com.tb.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a<K, A> {
    private final List<? extends com.tb.airbnb.lottie.e.a<K>> gD;
    @Nullable
    protected com.tb.airbnb.lottie.e.c<A> npF;
    @Nullable
    private com.tb.airbnb.lottie.e.a<K> npG;
    final List<InterfaceC0730a> listeners = new ArrayList();
    private boolean gC = false;
    private float progress = 0.0f;

    /* renamed from: com.tb.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0730a {
        void bC();
    }

    abstract A a(com.tb.airbnb.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.tb.airbnb.lottie.e.a<K>> list) {
        this.gD = list;
    }

    public void bQ() {
        this.gC = true;
    }

    public void b(InterfaceC0730a interfaceC0730a) {
        this.listeners.add(interfaceC0730a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < bU()) {
            f = bU();
        } else if (f > bV()) {
            f = bV();
        }
        if (f != this.progress) {
            this.progress = f;
            by();
        }
    }

    public void by() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).bC();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private com.tb.airbnb.lottie.e.a<K> dFA() {
        if (this.npG != null && this.npG.n(this.progress)) {
            return this.npG;
        }
        com.tb.airbnb.lottie.e.a<K> aVar = this.gD.get(this.gD.size() - 1);
        if (this.progress < aVar.di()) {
            for (int size = this.gD.size() - 1; size >= 0; size--) {
                aVar = this.gD.get(size);
                if (aVar.n(this.progress)) {
                    break;
                }
            }
        }
        this.npG = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float bS() {
        if (this.gC) {
            return 0.0f;
        }
        com.tb.airbnb.lottie.e.a<K> dFA = dFA();
        if (dFA.dL()) {
            return 0.0f;
        }
        return (this.progress - dFA.di()) / (dFA.bV() - dFA.di());
    }

    private float bT() {
        com.tb.airbnb.lottie.e.a<K> dFA = dFA();
        if (dFA.dL()) {
            return 0.0f;
        }
        return dFA.ko.getInterpolation(bS());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float bU() {
        if (this.gD.isEmpty()) {
            return 0.0f;
        }
        return this.gD.get(0).di();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    float bV() {
        if (this.gD.isEmpty()) {
            return 1.0f;
        }
        return this.gD.get(this.gD.size() - 1).bV();
    }

    public A getValue() {
        return a(dFA(), bT());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.tb.airbnb.lottie.e.c<A> cVar) {
        if (this.npF != null) {
            this.npF.b(null);
        }
        this.npF = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
