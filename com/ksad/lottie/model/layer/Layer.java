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
    public final List<com.ksad.lottie.model.content.b> f32097a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.d f32098b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32099c;

    /* renamed from: d  reason: collision with root package name */
    public final long f32100d;

    /* renamed from: e  reason: collision with root package name */
    public final LayerType f32101e;

    /* renamed from: f  reason: collision with root package name */
    public final long f32102f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final String f32103g;

    /* renamed from: h  reason: collision with root package name */
    public final List<Mask> f32104h;

    /* renamed from: i  reason: collision with root package name */
    public final l f32105i;
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

    public Layer(List<com.ksad.lottie.model.content.b> list, com.ksad.lottie.d dVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i2, int i3, int i4, float f2, float f3, int i5, int i6, @Nullable j jVar, @Nullable k kVar, List<com.ksad.lottie.e.a<Float>> list3, MatteType matteType, @Nullable com.ksad.lottie.model.a.b bVar) {
        this.f32097a = list;
        this.f32098b = dVar;
        this.f32099c = str;
        this.f32100d = j;
        this.f32101e = layerType;
        this.f32102f = j2;
        this.f32103g = str2;
        this.f32104h = list2;
        this.f32105i = lVar;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = f2;
        this.n = f3;
        this.o = i5;
        this.p = i6;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = matteType;
        this.s = bVar;
    }

    public com.ksad.lottie.d a() {
        return this.f32098b;
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(f());
        sb.append("\n");
        Layer a2 = this.f32098b.a(m());
        if (a2 != null) {
            String str2 = "\t\tParents: ";
            while (true) {
                sb.append(str2);
                sb.append(a2.f());
                a2 = this.f32098b.a(a2.m());
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
        if (!this.f32097a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.ksad.lottie.model.content.b bVar : this.f32097a) {
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
        return this.n / this.f32098b.k();
    }

    public List<com.ksad.lottie.e.a<Float>> d() {
        return this.t;
    }

    public long e() {
        return this.f32100d;
    }

    public String f() {
        return this.f32099c;
    }

    @Nullable
    public String g() {
        return this.f32103g;
    }

    public int h() {
        return this.o;
    }

    public int i() {
        return this.p;
    }

    public List<Mask> j() {
        return this.f32104h;
    }

    public LayerType k() {
        return this.f32101e;
    }

    public MatteType l() {
        return this.u;
    }

    public long m() {
        return this.f32102f;
    }

    public List<com.ksad.lottie.model.content.b> n() {
        return this.f32097a;
    }

    public l o() {
        return this.f32105i;
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
