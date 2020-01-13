package com.tb.airbnb.lottie.model.layer;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.a.j;
import com.tb.airbnb.lottie.model.a.k;
import com.tb.airbnb.lottie.model.a.l;
import com.tb.airbnb.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;
/* loaded from: classes5.dex */
public class Layer {
    private final com.tb.airbnb.lottie.d composition;
    private final float ec;
    private final List<Mask> gJ;
    private final List<com.tb.airbnb.lottie.e.a<Float>> jA;
    private final String jm;
    private final long jn;
    private final long jp;
    @Nullable
    private final String jq;
    private final int jr;
    private final int js;
    private final int jt;
    private final float ju;
    private final int jv;
    private final int jw;
    private final l nqD;
    private final LayerType nqO;
    @Nullable
    private final j nqP;
    @Nullable
    private final k nqQ;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nqR;
    private final MatteType nqS;
    private final List<com.tb.airbnb.lottie.model.content.b> shapes;

    /* loaded from: classes5.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* loaded from: classes5.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<com.tb.airbnb.lottie.model.content.b> list, com.tb.airbnb.lottie.d dVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.tb.airbnb.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.tb.airbnb.lottie.model.a.b bVar) {
        this.shapes = list;
        this.composition = dVar;
        this.jm = str;
        this.jn = j;
        this.nqO = layerType;
        this.jp = j2;
        this.jq = str2;
        this.gJ = list2;
        this.nqD = lVar;
        this.jr = i;
        this.js = i2;
        this.jt = i3;
        this.ju = f;
        this.ec = f2;
        this.jv = i4;
        this.jw = i5;
        this.nqP = jVar;
        this.nqQ = kVar;
        this.jA = list3;
        this.nqS = matteType;
        this.nqR = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.tb.airbnb.lottie.d getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float dh() {
        return this.ju;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float di() {
        return this.ec / this.composition.bn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.e.a<Float>> dj() {
        return this.jA;
    }

    public long getId() {
        return this.jn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.jm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.jq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dk() {
        return this.jv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dl() {
        return this.jw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> bW() {
        return this.gJ;
    }

    public LayerType dGp() {
        return this.nqO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType dGq() {
        return this.nqS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: do  reason: not valid java name */
    public long m41do() {
        return this.jp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.model.content.b> ci() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l dGj() {
        return this.nqD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.jt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dp() {
        return this.js;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dq() {
        return this.jr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j dGr() {
        return this.nqP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k dGs() {
        return this.nqQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.tb.airbnb.lottie.model.a.b dGt() {
        return this.nqR;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer hc = this.composition.hc(m41do());
        if (hc != null) {
            sb.append("\t\tParents: ").append(hc.getName());
            Layer hc2 = this.composition.hc(hc.m41do());
            while (hc2 != null) {
                sb.append("->").append(hc2.getName());
                hc2 = this.composition.hc(hc2.m41do());
            }
            sb.append(str).append("\n");
        }
        if (!bW().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(bW().size()).append("\n");
        }
        if (dq() != 0 && dp() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(dq()), Integer.valueOf(dp()), Integer.valueOf(getSolidColor())));
        }
        if (!this.shapes.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            for (com.tb.airbnb.lottie.model.content.b bVar : this.shapes) {
                sb.append(str).append("\t\t").append(bVar).append("\n");
            }
        }
        return sb.toString();
    }
}
