package com.caverock.androidsvg;
/* loaded from: classes12.dex */
public class PreserveAspectRatio {
    public static final PreserveAspectRatio lDh = new PreserveAspectRatio(null, null);
    public static final PreserveAspectRatio lDi = new PreserveAspectRatio(Alignment.None, null);
    public static final PreserveAspectRatio lDj = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Meet);
    public static final PreserveAspectRatio lDk = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Meet);
    public static final PreserveAspectRatio lDl = new PreserveAspectRatio(Alignment.XMaxYMax, Scale.Meet);
    public static final PreserveAspectRatio lDm = new PreserveAspectRatio(Alignment.XMidYMin, Scale.Meet);
    public static final PreserveAspectRatio lDn = new PreserveAspectRatio(Alignment.XMidYMax, Scale.Meet);
    public static final PreserveAspectRatio lDo = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Slice);
    public static final PreserveAspectRatio lDp = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Slice);
    private Alignment lDf;
    private Scale lDg;

    /* loaded from: classes12.dex */
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

    /* loaded from: classes12.dex */
    public enum Scale {
        Meet,
        Slice
    }

    public PreserveAspectRatio(Alignment alignment, Scale scale) {
        this.lDf = alignment;
        this.lDg = scale;
    }

    public Alignment dio() {
        return this.lDf;
    }

    public Scale dip() {
        return this.lDg;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
            return this.lDf == preserveAspectRatio.lDf && this.lDg == preserveAspectRatio.lDg;
        }
        return false;
    }
}
