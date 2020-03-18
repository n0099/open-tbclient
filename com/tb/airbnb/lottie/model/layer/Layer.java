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
    private final float ec;
    private final List<Mask> gM;
    private final List<com.tb.airbnb.lottie.e.a<Float>> jD;
    private final String jp;
    private final long jq;
    private final long js;
    @Nullable
    private final String jt;
    private final int ju;
    private final int jv;
    private final int jw;
    private final float jx;
    private final int jy;
    private final int jz;
    private final l ntk;
    private final LayerType ntv;
    @Nullable
    private final j ntw;
    @Nullable
    private final k ntx;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nty;
    private final MatteType ntz;
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
        this.jp = str;
        this.jq = j;
        this.ntv = layerType;
        this.js = j2;
        this.jt = str2;
        this.gM = list2;
        this.ntk = lVar;
        this.ju = i;
        this.jv = i2;
        this.jw = i3;
        this.jx = f;
        this.ec = f2;
        this.jy = i4;
        this.jz = i5;
        this.ntw = jVar;
        this.ntx = kVar;
        this.jD = list3;
        this.ntz = matteType;
        this.nty = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.tb.airbnb.lottie.d getComposition() {
        return this.composition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float di() {
        return this.jx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float dj() {
        return this.ec / this.composition.bo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.e.a<Float>> dk() {
        return this.jD;
    }

    public long getId() {
        return this.jq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getName() {
        return this.jp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String getRefId() {
        return this.jt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dl() {
        return this.jy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dm() {
        return this.jz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> bX() {
        return this.gM;
    }

    public LayerType dIb() {
        return this.ntv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType dIc() {
        return this.ntz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long dp() {
        return this.js;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tb.airbnb.lottie.model.content.b> cj() {
        return this.shapes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l dHV() {
        return this.ntk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSolidColor() {
        return this.jw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dq() {
        return this.jv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dr() {
        return this.ju;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j dId() {
        return this.ntw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k dIe() {
        return this.ntx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.tb.airbnb.lottie.model.a.b dIf() {
        return this.nty;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append("\n");
        Layer hb = this.composition.hb(dp());
        if (hb != null) {
            sb.append("\t\tParents: ").append(hb.getName());
            Layer hb2 = this.composition.hb(hb.dp());
            while (hb2 != null) {
                sb.append("->").append(hb2.getName());
                hb2 = this.composition.hb(hb2.dp());
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
