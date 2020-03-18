package com.tb.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a<K, A> {
    private final List<? extends com.tb.airbnb.lottie.e.a<K>> gG;
    @Nullable
    protected com.tb.airbnb.lottie.e.c<A> nsh;
    @Nullable
    private com.tb.airbnb.lottie.e.a<K> nsi;
    final List<InterfaceC0739a> listeners = new ArrayList();
    private boolean gF = false;
    private float progress = 0.0f;

    /* renamed from: com.tb.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0739a {
        void bD();
    }

    abstract A a(com.tb.airbnb.lottie.e.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.tb.airbnb.lottie.e.a<K>> list) {
        this.gG = list;
    }

    public void bR() {
        this.gF = true;
    }

    public void b(InterfaceC0739a interfaceC0739a) {
        this.listeners.add(interfaceC0739a);
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

    private com.tb.airbnb.lottie.e.a<K> dHk() {
        if (this.nsi != null && this.nsi.n(this.progress)) {
            return this.nsi;
        }
        com.tb.airbnb.lottie.e.a<K> aVar = this.gG.get(this.gG.size() - 1);
        if (this.progress < aVar.dj()) {
            for (int size = this.gG.size() - 1; size >= 0; size--) {
                aVar = this.gG.get(size);
                if (aVar.n(this.progress)) {
                    break;
                }
            }
        }
        this.nsi = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float bT() {
        if (this.gF) {
            return 0.0f;
        }
        com.tb.airbnb.lottie.e.a<K> dHk = dHk();
        if (dHk.dM()) {
            return 0.0f;
        }
        return (this.progress - dHk.dj()) / (dHk.bW() - dHk.dj());
    }

    private float bU() {
        com.tb.airbnb.lottie.e.a<K> dHk = dHk();
        if (dHk.dM()) {
            return 0.0f;
        }
        return dHk.kr.getInterpolation(bT());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float bV() {
        if (this.gG.isEmpty()) {
            return 0.0f;
        }
        return this.gG.get(0).dj();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    float bW() {
        if (this.gG.isEmpty()) {
            return 1.0f;
        }
        return this.gG.get(this.gG.size() - 1).bW();
    }

    public A getValue() {
        return a(dHk(), bU());
    }

    public float getProgress() {
        return this.progress;
    }

    public void a(@Nullable com.tb.airbnb.lottie.e.c<A> cVar) {
        if (this.nsh != null) {
            this.nsh.b(null);
        }
        this.nsh = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
