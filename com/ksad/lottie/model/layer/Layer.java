package com.ksad.lottie.model.layer;

import androidx.annotation.Nullable;
import com.ksad.lottie.model.a.j;
import com.ksad.lottie.model.a.k;
import com.ksad.lottie.model.a.l;
import com.ksad.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;
/* loaded from: classes6.dex */
public class Layer {

    /* renamed from: a  reason: collision with root package name */
    public final List<com.ksad.lottie.model.content.b> f31944a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.d f31945b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31946c;

    /* renamed from: d  reason: collision with root package name */
    public final long f31947d;

    /* renamed from: e  reason: collision with root package name */
    public final LayerType f31948e;

    /* renamed from: f  reason: collision with root package name */
    public final long f31949f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final String f31950g;

    /* renamed from: h  reason: collision with root package name */
    public final List<Mask> f31951h;
    public final l i;
    public final int j;
    public final int k;
    public final int l;
    public final float m;
    public final float n;
    public final int o;
    public final int p;
    @Nullable
    public final j q;
    @Nullable
    public final k r;
    @Nullable
    public final com.ksad.lottie.model.a.b s;
    public final List<com.ksad.lottie.e.a<Float>> t;
    public final MatteType u;

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

    public Layer(List<com.ksad.lottie.model.content.b> list, com.ksad.lottie.d dVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f2, float f3, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.ksad.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.ksad.lottie.model.a.b bVar) {
        this.f31944a = list;
        this.f31945b = dVar;
        this.f31946c = str;
        this.f31947d = j;
        this.f31948e = layerType;
        this.f31949f = j2;
        this.f31950g = str2;
        this.f31951h = list2;
        this.i = lVar;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f2;
        this.n = f3;
        this.o = i4;
        this.p = i5;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = matteType;
        this.s = bVar;
    }

    public com.ksad.lottie.d a() {
        return this.f31945b;
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(f());
        sb.append("\n");
        Layer a2 = this.f31945b.a(m());
        if (a2 != null) {
            String str2 = "\t\tParents: ";
            while (true) {
                sb.append(str2);
                sb.append(a2.f());
                a2 = this.f31945b.a(a2.m());
                if (a2 == null) {
                    break;
                }
                str2 = "->";
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!j().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(j().size());
            sb.append("\n");
        }
        if (r() != 0 && q() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(r()), Integer.valueOf(q()), Integer.valueOf(p())));
        }
        if (!this.f31944a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.ksad.lottie.model.content.b bVar : this.f31944a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(bVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public float b() {
        return this.m;
    }

    public float c() {
        return this.n / this.f31945b.k();
    }

    public List<com.ksad.lottie.e.a<Float>> d() {
        return this.t;
    }

    public long e() {
        return this.f31947d;
    }

    public String f() {
        return this.f31946c;
    }

    @Nullable
    public String g() {
        return this.f31950g;
    }

    public int h() {
        return this.o;
    }

    public int i() {
        return this.p;
    }

    public List<Mask> j() {
        return this.f31951h;
    }

    public LayerType k() {
        return this.f31948e;
    }

    public MatteType l() {
        return this.u;
    }

    public long m() {
        return this.f31949f;
    }

    public List<com.ksad.lottie.model.content.b> n() {
        return this.f31944a;
    }

    public l o() {
        return this.i;
    }

    public int p() {
        return this.l;
    }

    public int q() {
        return this.k;
    }

    public int r() {
        return this.j;
    }

    @Nullable
    public j s() {
        return this.q;
    }

    @Nullable
    public k t() {
        return this.r;
    }

    public String toString() {
        return a("");
    }

    @Nullable
    public com.ksad.lottie.model.a.b u() {
        return this.s;
    }
}
