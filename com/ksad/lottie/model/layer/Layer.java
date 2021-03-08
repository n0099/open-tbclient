package com.ksad.lottie.model.layer;

import androidx.annotation.Nullable;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import com.ksad.lottie.model.a.j;
import com.ksad.lottie.model.a.k;
import com.ksad.lottie.model.a.l;
import com.ksad.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class Layer {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.ksad.lottie.model.content.b> f5399a;
    private final com.ksad.lottie.d b;
    private final String c;
    private final long d;
    private final LayerType e;
    private final long f;
    @Nullable
    private final String g;
    private final List<Mask> h;
    private final l i;
    private final int j;
    private final int k;
    private final int l;
    private final float m;
    private final float n;
    private final int o;
    private final int p;
    @Nullable
    private final j q;
    @Nullable
    private final k r;
    @Nullable
    private final com.ksad.lottie.model.a.b s;
    private final List<com.ksad.lottie.e.a<Float>> t;
    private final MatteType u;

    /* loaded from: classes3.dex */
    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    /* loaded from: classes3.dex */
    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<com.ksad.lottie.model.content.b> list, com.ksad.lottie.d dVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.ksad.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.ksad.lottie.model.a.b bVar) {
        this.f5399a = list;
        this.b = dVar;
        this.c = str;
        this.d = j;
        this.e = layerType;
        this.f = j2;
        this.g = str2;
        this.h = list2;
        this.i = lVar;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        this.n = f2;
        this.o = i4;
        this.p = i5;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = matteType;
        this.s = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.ksad.lottie.d a() {
        return this.b;
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(f()).append("\n");
        Layer a2 = this.b.a(m());
        if (a2 != null) {
            sb.append("\t\tParents: ").append(a2.f());
            Layer a3 = this.b.a(a2.m());
            while (a3 != null) {
                sb.append(PerfFrameTrackUIUtil.SEPERATOR_ARROR).append(a3.f());
                a3 = this.b.a(a3.m());
            }
            sb.append(str).append("\n");
        }
        if (!j().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(j().size()).append("\n");
        }
        if (r() != 0 && q() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(r()), Integer.valueOf(q()), Integer.valueOf(p())));
        }
        if (!this.f5399a.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            for (com.ksad.lottie.model.content.b bVar : this.f5399a) {
                sb.append(str).append("\t\t").append(bVar).append("\n");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.n / this.b.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.ksad.lottie.e.a<Float>> d() {
        return this.t;
    }

    public long e() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String g() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> j() {
        return this.h;
    }

    public LayerType k() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType l() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long m() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.ksad.lottie.model.content.b> n() {
        return this.f5399a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l o() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j s() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k t() {
        return this.r;
    }

    public String toString() {
        return a("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.ksad.lottie.model.a.b u() {
        return this.s;
    }
}
