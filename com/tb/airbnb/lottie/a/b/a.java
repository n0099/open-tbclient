package com.tb.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a<K, A> {
    private final List<? extends com.tb.airbnb.lottie.a.a<K>> gD;
    @Nullable
    private com.tb.airbnb.lottie.a.a<K> mNv;
    final List<InterfaceC0687a> listeners = new ArrayList();
    private boolean gC = false;
    private float progress = 0.0f;

    /* renamed from: com.tb.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0687a {
        void bC();
    }

    abstract A a(com.tb.airbnb.lottie.a.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.tb.airbnb.lottie.a.a<K>> list) {
        this.gD = list;
    }

    public void bQ() {
        this.gC = true;
    }

    public void b(InterfaceC0687a interfaceC0687a) {
        this.listeners.add(interfaceC0687a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < bU()) {
            f = bU();
        } else if (f > bV()) {
            f = bV();
        }
        if (f != this.progress) {
            this.progress = f;
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
    }

    private com.tb.airbnb.lottie.a.a<K> dBl() {
        if (this.gD.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        }
        if (this.mNv != null && this.mNv.n(this.progress)) {
            return this.mNv;
        }
        com.tb.airbnb.lottie.a.a<K> aVar = this.gD.get(this.gD.size() - 1);
        if (this.progress < aVar.di()) {
            for (int size = this.gD.size() - 1; size >= 0; size--) {
                aVar = this.gD.get(size);
                if (aVar.n(this.progress)) {
                    break;
                }
            }
        }
        this.mNv = aVar;
        return aVar;
    }

    private float dBm() {
        if (this.gC) {
            return 0.0f;
        }
        com.tb.airbnb.lottie.a.a<K> dBl = dBl();
        if (dBl.dL()) {
            return 0.0f;
        }
        return dBl.kp.getInterpolation((this.progress - dBl.di()) / (dBl.bV() - dBl.di()));
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float bU() {
        if (this.gD.isEmpty()) {
            return 0.0f;
        }
        return this.gD.get(0).di();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float bV() {
        if (this.gD.isEmpty()) {
            return 1.0f;
        }
        return this.gD.get(this.gD.size() - 1).bV();
    }

    public A getValue() {
        return a(dBl(), dBm());
    }

    public float getProgress() {
        return this.progress;
    }
}
