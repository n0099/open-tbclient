package com.tb.airbnb.lottie.model.layer;

import android.support.annotation.Nullable;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import com.tb.airbnb.lottie.model.a.j;
import com.tb.airbnb.lottie.model.a.k;
import com.tb.airbnb.lottie.model.a.l;
import com.tb.airbnb.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;
/* loaded from: classes20.dex */
public class Layer {
    private final float Ce;
    private final List<Mask> EL;
    private final String Hg;
    private final long Hh;
    private final long Hj;
    @Nullable
    private final String Hk;
    private final int Hl;
    private final int Hm;
    private final int Hn;
    private final float Ho;
    private final int Hp;
    private final int Hq;
    private final List<com.tb.airbnb.lottie.e.a<Float>> Hu;
    private final com.tb.airbnb.lottie.e composition;
    private final LayerType pCI;
    @Nullable
    private final j pCJ;
    @Nullable
    private final k pCK;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pCL;
    private final MatteType pCM;
    private final l pCx;
    private final List<com.tb.airbnb.lottie.model.content.b> shapes;

    /* loaded from: classes20.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* loaded from: classes20.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<com.tb.airbnb.lottie.model.content.b> list, com.tb.airbnb.lottie.e eVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.tb.airbnb.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.tb.airbnb.lottie.model.a.b bVar) {
        this.shapes = list;
        this.composition = eVar;
        this.Hg = str;
        this.Hh = j;
        this.pCI = layerType;
        this.Hj = j2;
        this.Hk = str2;
        this.EL = list2;
        this.pCx = lVar;
        this.Hl = i;
        this.Hm = i2;
        this.Hn = i3;
        this.Ho = f;
        this.Ce = f2;
        this.Hp = i4;
        this.Hq = i5;
        this.pCJ = jVar;
        this.pCK = kVar;
        this.Hu = list3;
        this.pCM = matteType;
        this.pCL = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.tb.airbnb.lottie.e getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float ky() {
        return this.Ho;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float kz() {
        return this.Ce / this.composition.iD();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.e.a<Float>> kA() {
        return this.Hu;
    }

    public long getId() {
        return this.Hh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.Hg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.Hk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kB() {
        return this.Hp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kC() {
        return this.Hq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> jn() {
        return this.EL;
    }

    public LayerType eBT() {
        return this.pCI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType eBU() {
        return this.pCM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long kF() {
        return this.Hj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.model.content.b> jz() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l eBN() {
        return this.pCx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.Hn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kG() {
        return this.Hm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kH() {
        return this.Hl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j eBV() {
        return this.pCJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k eBW() {
        return this.pCK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.tb.airbnb.lottie.model.a.b eBX() {
        return this.pCL;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer iF = this.composition.iF(kF());
        if (iF != null) {
            sb.append("\t\tParents: ").append(iF.getName());
            Layer iF2 = this.composition.iF(iF.kF());
            while (iF2 != null) {
                sb.append(PerfFrameTrackUIUtil.SEPERATOR_ARROR).append(iF2.getName());
                iF2 = this.composition.iF(iF2.kF());
            }
            sb.append(str).append("\n");
        }
        if (!jn().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(jn().size()).append("\n");
        }
        if (kH() != 0 && kG() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(kH()), Integer.valueOf(kG()), Integer.valueOf(getSolidColor())));
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
