package com.caverock.androidsvg;
/* loaded from: classes6.dex */
public class PreserveAspectRatio {

    /* renamed from: c  reason: collision with root package name */
    public static final PreserveAspectRatio f31156c = new PreserveAspectRatio(Alignment.None, null);

    /* renamed from: d  reason: collision with root package name */
    public static final PreserveAspectRatio f31157d = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Meet);

    /* renamed from: a  reason: collision with root package name */
    public Alignment f31158a;

    /* renamed from: b  reason: collision with root package name */
    public Scale f31159b;

    /* loaded from: classes6.dex */
    public enum Alignment {
        None,
        XMinYMin,
        XMidYMin,
        XMaxYMin,
        XMinYMid,
        XMidYMid,
        XMaxYMid,
        XMinYMax,
        XMidYMax,
        XMaxYMax
    }

    /* loaded from: classes6.dex */
    public enum Scale {
        Meet,
        Slice
    }

    static {
        Alignment alignment = Alignment.XMinYMin;
        Scale scale = Scale.Meet;
        Alignment alignment2 = Alignment.XMaxYMax;
        Scale scale2 = Scale.Meet;
        Alignment alignment3 = Alignment.XMidYMin;
        Scale scale3 = Scale.Meet;
        Alignment alignment4 = Alignment.XMidYMax;
        Scale scale4 = Scale.Meet;
        Alignment alignment5 = Alignment.XMidYMid;
        Scale scale5 = Scale.Slice;
        Alignment alignment6 = Alignment.XMinYMin;
        Scale scale6 = Scale.Slice;
    }

    public PreserveAspectRatio(Alignment alignment, Scale scale) {
        this.f31158a = alignment;
        this.f31159b = scale;
    }

    public Alignment a() {
        return this.f31158a;
    }

    public Scale b() {
        return this.f31159b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PreserveAspectRatio.class == obj.getClass()) {
            PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
            return this.f31158a == preserveAspectRatio.f31158a && this.f31159b == preserveAspectRatio.f31159b;
        }
        return false;
    }
}
