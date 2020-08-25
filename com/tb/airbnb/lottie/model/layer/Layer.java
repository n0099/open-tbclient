package com.tb.airbnb.lottie.model.layer;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.a.j;
import com.tb.airbnb.lottie.model.a.k;
import com.tb.airbnb.lottie.model.a.l;
import com.tb.airbnb.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;
/* loaded from: classes7.dex */
public class Layer {
    private final float AX;
    private final List<Mask> DA;
    private final String FU;
    private final long FV;
    private final long FX;
    @Nullable
    private final String FY;
    private final int FZ;
    private final int Ga;
    private final int Gb;
    private final float Gc;
    private final int Gd;
    private final int Ge;
    private final List<com.tb.airbnb.lottie.e.a<Float>> Gi;
    private final com.tb.airbnb.lottie.d composition;
    private final l ojH;
    private final LayerType ojS;
    @Nullable
    private final j ojT;
    @Nullable
    private final k ojU;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b ojV;
    private final MatteType ojW;
    private final List<com.tb.airbnb.lottie.model.content.b> shapes;

    /* loaded from: classes7.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* loaded from: classes7.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<com.tb.airbnb.lottie.model.content.b> list, com.tb.airbnb.lottie.d dVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.tb.airbnb.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.tb.airbnb.lottie.model.a.b bVar) {
        this.shapes = list;
        this.composition = dVar;
        this.FU = str;
        this.FV = j;
        this.ojS = layerType;
        this.FX = j2;
        this.FY = str2;
        this.DA = list2;
        this.ojH = lVar;
        this.FZ = i;
        this.Ga = i2;
        this.Gb = i3;
        this.Gc = f;
        this.AX = f2;
        this.Gd = i4;
        this.Ge = i5;
        this.ojT = jVar;
        this.ojU = kVar;
        this.Gi = list3;
        this.ojW = matteType;
        this.ojV = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.tb.airbnb.lottie.d getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float kw() {
        return this.Gc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float kx() {
        return this.AX / this.composition.iC();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.e.a<Float>> ky() {
        return this.Gi;
    }

    public long getId() {
        return this.FV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.FU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.FY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kz() {
        return this.Gd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kA() {
        return this.Ge;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> jl() {
        return this.DA;
    }

    public LayerType edQ() {
        return this.ojS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType edR() {
        return this.ojW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long kD() {
        return this.FX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.model.content.b> jx() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l edK() {
        return this.ojH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.Gb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kE() {
        return this.Ga;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kF() {
        return this.FZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j edS() {
        return this.ojT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k edT() {
        return this.ojU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.tb.airbnb.lottie.model.a.b edU() {
        return this.ojV;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer gI = this.composition.gI(kD());
        if (gI != null) {
            sb.append("\t\tParents: ").append(gI.getName());
            Layer gI2 = this.composition.gI(gI.kD());
            while (gI2 != null) {
                sb.append("->").append(gI2.getName());
                gI2 = this.composition.gI(gI2.kD());
            }
            sb.append(str).append("\n");
        }
        if (!jl().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(jl().size()).append("\n");
        }
        if (kF() != 0 && kE() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(kF()), Integer.valueOf(kE()), Integer.valueOf(getSolidColor())));
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
