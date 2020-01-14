package com.caverock.androidsvg;
/* loaded from: classes10.dex */
public class PreserveAspectRatio {
    public static final PreserveAspectRatio lCA = new PreserveAspectRatio(null, null);
    public static final PreserveAspectRatio lCB = new PreserveAspectRatio(Alignment.None, null);
    public static final PreserveAspectRatio lCC = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Meet);
    public static final PreserveAspectRatio lCD = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Meet);
    public static final PreserveAspectRatio lCE = new PreserveAspectRatio(Alignment.XMaxYMax, Scale.Meet);
    public static final PreserveAspectRatio lCF = new PreserveAspectRatio(Alignment.XMidYMin, Scale.Meet);
    public static final PreserveAspectRatio lCG = new PreserveAspectRatio(Alignment.XMidYMax, Scale.Meet);
    public static final PreserveAspectRatio lCH = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Slice);
    public static final PreserveAspectRatio lCI = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Slice);
    private Alignment lCy;
    private Scale lCz;

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public enum Scale {
        Meet,
        Slice
    }

    public PreserveAspectRatio(Alignment alignment, Scale scale) {
        this.lCy = alignment;
        this.lCz = scale;
    }

    public Alignment dha() {
        return this.lCy;
    }

    public Scale dhb() {
        return this.lCz;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
            return this.lCy == preserveAspectRatio.lCy && this.lCz == preserveAspectRatio.lCz;
        }
        return false;
    }
}
