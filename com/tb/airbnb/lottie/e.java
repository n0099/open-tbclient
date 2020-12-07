package com.tb.airbnb.lottie;

import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import com.tb.airbnb.lottie.model.layer.Layer;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* loaded from: classes20.dex */
public class e {
    private Map<String, List<Layer>> BZ;
    private Map<String, com.tb.airbnb.lottie.model.c> Ca;
    private SparseArrayCompat<com.tb.airbnb.lottie.model.d> Cb;
    private LongSparseArray<Layer> Cc;
    private List<Layer> Cd;
    private float Ce;
    private float Cf;
    private float Cg;
    private Rect bounds;
    private Map<String, h> images;
    private final o pAx = new o();
    private final HashSet<String> BY = new HashSet<>();

    public void a(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, h> map2, SparseArrayCompat<com.tb.airbnb.lottie.model.d> sparseArrayCompat, Map<String, com.tb.airbnb.lottie.model.c> map3) {
        this.bounds = rect;
        this.Ce = f;
        this.Cf = f2;
        this.Cg = f3;
        this.Cd = list;
        this.Cc = longSparseArray;
        this.BZ = map;
        this.images = map2;
        this.Cb = sparseArrayCompat;
        this.Ca = map3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void bf(String str) {
        Log.w("LOTTIE", str);
        this.BY.add(str);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.pAx.setEnabled(z);
    }

    public o getPerformanceTracker() {
        return this.pAx;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer iF(long j) {
        return this.Cc.get(j);
    }

    public Rect iu() {
        return this.bounds;
    }

    public float iv() {
        return (iD() / this.Cg) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float iw() {
        return this.Ce;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float ix() {
        return this.Cf;
    }

    public float iy() {
        return this.Cg;
    }

    public List<Layer> iz() {
        return this.Cd;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> bg(String str) {
        return this.BZ.get(str);
    }

    public SparseArrayCompat<com.tb.airbnb.lottie.model.d> iA() {
        return this.Cb;
    }

    public Map<String, com.tb.airbnb.lottie.model.c> iB() {
        return this.Ca;
    }

    public Map<String, h> iC() {
        return this.images;
    }

    public float iD() {
        return this.Cf - this.Ce;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.Cd) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }

    @Deprecated
    /* loaded from: classes20.dex */
    public static class a {
        @Deprecated
        public static com.tb.airbnb.lottie.a a(InputStream inputStream, n nVar) {
            C1020a c1020a = new C1020a(nVar);
            f.i(inputStream, null).a(c1020a);
            return c1020a;
        }

        /* renamed from: com.tb.airbnb.lottie.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        private static final class C1020a implements com.tb.airbnb.lottie.a, i<e> {
            private boolean cancelled;
            private final n pAy;

            private C1020a(n nVar) {
                this.cancelled = false;
                this.pAy = nVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.tb.airbnb.lottie.i
            public void onResult(e eVar) {
                if (!this.cancelled) {
                    this.pAy.a(eVar);
                }
            }
        }
    }
}
