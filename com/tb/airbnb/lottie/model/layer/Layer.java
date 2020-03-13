package com.tb.airbnb.lottie.model.layer;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.a.j;
import com.tb.airbnb.lottie.model.a.k;
import com.tb.airbnb.lottie.model.a.l;
import com.tb.airbnb.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;
/* loaded from: classes6.dex */
public class Layer {
    private final com.tb.airbnb.lottie.d composition;
    private final float ed;
    private final List<Mask> gN;
    private final int jA;
    private final List<com.tb.airbnb.lottie.e.a<Float>> jE;
    private final String jq;
    private final long jr;
    private final long jt;
    @Nullable
    private final String ju;
    private final int jv;
    private final int jw;
    private final int jx;
    private final float jy;
    private final int jz;
    private final LayerType nrI;
    @Nullable
    private final j nrJ;
    @Nullable
    private final k nrK;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nrL;
    private final MatteType nrM;
    private final l nrx;
    private final List<com.tb.airbnb.lottie.model.content.b> shapes;

    /* loaded from: classes6.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* loaded from: classes6.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<com.tb.airbnb.lottie.model.content.b> list, com.tb.airbnb.lottie.d dVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.tb.airbnb.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.tb.airbnb.lottie.model.a.b bVar) {
        this.shapes = list;
        this.composition = dVar;
        this.jq = str;
        this.jr = j;
        this.nrI = layerType;
        this.jt = j2;
        this.ju = str2;
        this.gN = list2;
        this.nrx = lVar;
        this.jv = i;
        this.jw = i2;
        this.jx = i3;
        this.jy = f;
        this.ed = f2;
        this.jz = i4;
        this.jA = i5;
        this.nrJ = jVar;
        this.nrK = kVar;
        this.jE = list3;
        this.nrM = matteType;
        this.nrL = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.tb.airbnb.lottie.d getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float di() {
        return this.jy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float dj() {
        return this.ed / this.composition.bo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.e.a<Float>> dk() {
        return this.jE;
    }

    public long getId() {
        return this.jr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.jq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.ju;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dl() {
        return this.jz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dm() {
        return this.jA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> bX() {
        return this.gN;
    }

    public LayerType dHB() {
        return this.nrI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType dHC() {
        return this.nrM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dp() {
        return this.jt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.model.content.b> cj() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l dHv() {
        return this.nrx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.jx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dq() {
        return this.jw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dr() {
        return this.jv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j dHD() {
        return this.nrJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k dHE() {
        return this.nrK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.tb.airbnb.lottie.model.a.b dHF() {
        return this.nrL;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer ha = this.composition.ha(dp());
        if (ha != null) {
            sb.append("\t\tParents: ").append(ha.getName());
            Layer ha2 = this.composition.ha(ha.dp());
            while (ha2 != null) {
                sb.append("->").append(ha2.getName());
                ha2 = this.composition.ha(ha2.dp());
            }
            sb.append(str).append("\n");
        }
        if (!bX().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(bX().size()).append("\n");
        }
        if (dr() != 0 && dq() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(dr()), Integer.valueOf(dq()), Integer.valueOf(getSolidColor())));
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
