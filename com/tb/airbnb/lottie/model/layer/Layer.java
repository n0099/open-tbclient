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
    private final float Aq;
    private final List<Mask> CW;
    private final List<com.tb.airbnb.lottie.e.a<Float>> FD;
    private final String Fp;
    private final long Fq;
    private final long Fs;
    @Nullable
    private final String Ft;
    private final int Fu;
    private final int Fv;
    private final int Fw;
    private final float Fx;
    private final int Fy;
    private final int Fz;
    private final com.tb.airbnb.lottie.d composition;
    private final l nPN;
    private final LayerType nPY;
    @Nullable
    private final j nPZ;
    @Nullable
    private final k nQa;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nQb;
    private final MatteType nQc;
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
        this.Fp = str;
        this.Fq = j;
        this.nPY = layerType;
        this.Fs = j2;
        this.Ft = str2;
        this.CW = list2;
        this.nPN = lVar;
        this.Fu = i;
        this.Fv = i2;
        this.Fw = i3;
        this.Fx = f;
        this.Aq = f2;
        this.Fy = i4;
        this.Fz = i5;
        this.nPZ = jVar;
        this.nQa = kVar;
        this.FD = list3;
        this.nQc = matteType;
        this.nQb = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.tb.airbnb.lottie.d getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float iX() {
        return this.Fx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float iY() {
        return this.Aq / this.composition.hb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.e.a<Float>> iZ() {
        return this.FD;
    }

    public long getId() {
        return this.Fq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.Fp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.Ft;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ja() {
        return this.Fy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int jb() {
        return this.Fz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> hK() {
        return this.CW;
    }

    public LayerType dRO() {
        return this.nPY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType dRP() {
        return this.nQc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long je() {
        return this.Fs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.model.content.b> hW() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l dRI() {
        return this.nPN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.Fw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int jf() {
        return this.Fv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int jg() {
        return this.Fu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j dRQ() {
        return this.nPZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k dRR() {
        return this.nQa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.tb.airbnb.lottie.model.a.b dRS() {
        return this.nQb;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer gv = this.composition.gv(je());
        if (gv != null) {
            sb.append("\t\tParents: ").append(gv.getName());
            Layer gv2 = this.composition.gv(gv.je());
            while (gv2 != null) {
                sb.append("->").append(gv2.getName());
                gv2 = this.composition.gv(gv2.je());
            }
            sb.append(str).append("\n");
        }
        if (!hK().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(hK().size()).append("\n");
        }
        if (jg() != 0 && jf() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(jg()), Integer.valueOf(jf()), Integer.valueOf(getSolidColor())));
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
