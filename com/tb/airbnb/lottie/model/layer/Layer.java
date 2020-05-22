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
    private final List<Mask> Co;
    private final String EO;
    private final long EP;
    private final long ES;
    @Nullable
    private final String ET;
    private final int EU;
    private final int EV;
    private final int EW;
    private final float EX;
    private final int EY;
    private final int EZ;
    private final List<com.tb.airbnb.lottie.e.a<Float>> Fd;
    private final com.tb.airbnb.lottie.d composition;
    private final l nkb;
    private final LayerType nkm;
    @Nullable
    private final j nkn;
    @Nullable
    private final k nko;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nkp;
    private final MatteType nkq;
    private final List<com.tb.airbnb.lottie.model.content.b> shapes;
    private final float zN;

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
        this.EO = str;
        this.EP = j;
        this.nkm = layerType;
        this.ES = j2;
        this.ET = str2;
        this.Co = list2;
        this.nkb = lVar;
        this.EU = i;
        this.EV = i2;
        this.EW = i3;
        this.EX = f;
        this.zN = f2;
        this.EY = i4;
        this.EZ = i5;
        this.nkn = jVar;
        this.nko = kVar;
        this.Fd = list3;
        this.nkq = matteType;
        this.nkp = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.tb.airbnb.lottie.d getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float iH() {
        return this.EX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float iI() {
        return this.zN / this.composition.gL();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.e.a<Float>> iJ() {
        return this.Fd;
    }

    public long getId() {
        return this.EP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.EO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.ET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int iK() {
        return this.EY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int iL() {
        return this.EZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> hu() {
        return this.Co;
    }

    public LayerType dJt() {
        return this.nkm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType dJu() {
        return this.nkq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long iO() {
        return this.ES;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.model.content.b> hG() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l dJn() {
        return this.nkb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.EW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int iP() {
        return this.EV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int iQ() {
        return this.EU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j dJv() {
        return this.nkn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k dJw() {
        return this.nko;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.tb.airbnb.lottie.model.a.b dJx() {
        return this.nkp;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer gd = this.composition.gd(iO());
        if (gd != null) {
            sb.append("\t\tParents: ").append(gd.getName());
            Layer gd2 = this.composition.gd(gd.iO());
            while (gd2 != null) {
                sb.append("->").append(gd2.getName());
                gd2 = this.composition.gd(gd2.iO());
            }
            sb.append(str).append("\n");
        }
        if (!hu().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(hu().size()).append("\n");
        }
        if (iQ() != 0 && iP() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(iQ()), Integer.valueOf(iP()), Integer.valueOf(getSolidColor())));
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
