package com.tb.airbnb.lottie.model.layer;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.a.j;
import com.tb.airbnb.lottie.model.a.k;
import com.tb.airbnb.lottie.model.a.l;
import com.tb.airbnb.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;
/* loaded from: classes16.dex */
public class Layer {
    private final float Bo;
    private final List<Mask> DV;
    private final String Gl;
    private final long Gm;
    private final long Go;
    @Nullable
    private final String Gp;
    private final int Gq;
    private final int Gr;
    private final int Gs;
    private final float Gt;
    private final int Gu;
    private final int Gv;
    private final List<com.tb.airbnb.lottie.e.a<Float>> Gz;
    private final com.tb.airbnb.lottie.d composition;
    private final LayerType pAH;
    @Nullable
    private final j pAI;
    @Nullable
    private final k pAJ;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pAK;
    private final MatteType pAL;
    private final l pAw;
    private final List<com.tb.airbnb.lottie.model.content.b> shapes;

    /* loaded from: classes16.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* loaded from: classes16.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<com.tb.airbnb.lottie.model.content.b> list, com.tb.airbnb.lottie.d dVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.tb.airbnb.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.tb.airbnb.lottie.model.a.b bVar) {
        this.shapes = list;
        this.composition = dVar;
        this.Gl = str;
        this.Gm = j;
        this.pAH = layerType;
        this.Go = j2;
        this.Gp = str2;
        this.DV = list2;
        this.pAw = lVar;
        this.Gq = i;
        this.Gr = i2;
        this.Gs = i3;
        this.Gt = f;
        this.Bo = f2;
        this.Gu = i4;
        this.Gv = i5;
        this.pAI = jVar;
        this.pAJ = kVar;
        this.Gz = list3;
        this.pAL = matteType;
        this.pAK = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.tb.airbnb.lottie.d getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float ky() {
        return this.Gt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float kz() {
        return this.Bo / this.composition.iD();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.e.a<Float>> kA() {
        return this.Gz;
    }

    public long getId() {
        return this.Gm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.Gl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.Gp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kB() {
        return this.Gu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kC() {
        return this.Gv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> jn() {
        return this.DV;
    }

    public LayerType evH() {
        return this.pAH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType evI() {
        return this.pAL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long kF() {
        return this.Go;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.model.content.b> jz() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l evB() {
        return this.pAw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.Gs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kG() {
        return this.Gr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int kH() {
        return this.Gq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j evJ() {
        return this.pAI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k evK() {
        return this.pAJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.tb.airbnb.lottie.model.a.b evL() {
        return this.pAK;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer hG = this.composition.hG(kF());
        if (hG != null) {
            sb.append("\t\tParents: ").append(hG.getName());
            Layer hG2 = this.composition.hG(hG.kF());
            while (hG2 != null) {
                sb.append("->").append(hG2.getName());
                hG2 = this.composition.hG(hG2.kF());
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
