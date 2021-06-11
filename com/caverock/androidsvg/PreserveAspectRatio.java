package com.caverock.androidsvg;
/* loaded from: classes6.dex */
public class PreserveAspectRatio {

    /* renamed from: c  reason: collision with root package name */
    public static final PreserveAspectRatio f30433c = new PreserveAspectRatio(Alignment.None, null);

    /* renamed from: d  reason: collision with root package name */
    public static final PreserveAspectRatio f30434d = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Meet);

    /* renamed from: a  reason: collision with root package name */
    public Alignment f30435a;

    /* renamed from: b  reason: collision with root package name */
    public Scale f30436b;

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
        this.f30435a = alignment;
        this.f30436b = scale;
    }

    public Alignment a() {
        return this.f30435a;
    }

    public Scale b() {
        return this.f30436b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PreserveAspectRatio.class == obj.getClass()) {
            PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
            return this.f30435a == preserveAspectRatio.f30435a && this.f30436b == preserveAspectRatio.f30436b;
        }
        return false;
    }
}
