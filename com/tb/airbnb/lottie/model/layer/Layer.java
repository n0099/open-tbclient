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
    private final com.tb.airbnb.lottie.e composition;
    private final l pJQ;
    private final LayerType pKb;
    @Nullable
    private final j pKc;
    @Nullable
    private final k pKd;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pKe;
    private final MatteType pKf;
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

    public Layer(List<com.tb.airbnb.lottie.model.content.b> list, com.tb.airbnb.lottie.e eVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.tb.airbnb.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.tb.airbnb.lottie.model.a.b bVar) {
        this.shapes = list;
        this.composition = eVar;
        this.Gl = str;
        this.Gm = j;
        this.pKb = layerType;
        this.Go = j2;
        this.Gp = str2;
        this.DV = list2;
        this.pJQ = lVar;
        this.Gq = i;
        this.Gr = i2;
        this.Gs = i3;
        this.Gt = f;
        this.Bo = f2;
        this.Gu = i4;
        this.Gv = i5;
        this.pKc = jVar;
        this.pKd = kVar;
        this.Gz = list3;
        this.pKf = matteType;
        this.pKe = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.tb.airbnb.lottie.e getComposition() {
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

    public LayerType ezw() {
        return this.pKb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType ezx() {
        return this.pKf;
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
    public l ezq() {
        return this.pJQ;
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
    public j ezy() {
        return this.pKc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k ezz() {
        return this.pKd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.tb.airbnb.lottie.model.a.b ezA() {
        return this.pKe;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer ic = this.composition.ic(kF());
        if (ic != null) {
            sb.append("\t\tParents: ").append(ic.getName());
            Layer ic2 = this.composition.ic(ic.kF());
            while (ic2 != null) {
                sb.append("->").append(ic2.getName());
                ic2 = this.composition.ic(ic2.kF());
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
