package com.caverock.androidsvg;
/* loaded from: classes12.dex */
public class PreserveAspectRatio {
    public static final PreserveAspectRatio lDj = new PreserveAspectRatio(null, null);
    public static final PreserveAspectRatio lDk = new PreserveAspectRatio(Alignment.None, null);
    public static final PreserveAspectRatio lDl = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Meet);
    public static final PreserveAspectRatio lDm = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Meet);
    public static final PreserveAspectRatio lDn = new PreserveAspectRatio(Alignment.XMaxYMax, Scale.Meet);
    public static final PreserveAspectRatio lDo = new PreserveAspectRatio(Alignment.XMidYMin, Scale.Meet);
    public static final PreserveAspectRatio lDp = new PreserveAspectRatio(Alignment.XMidYMax, Scale.Meet);
    public static final PreserveAspectRatio lDq = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Slice);
    public static final PreserveAspectRatio lDr = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Slice);
    private Alignment lDh;
    private Scale lDi;

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
        this.lDh = alignment;
        this.lDi = scale;
    }

    public Alignment diq() {
        return this.lDh;
    }

    public Scale dir() {
        return this.lDi;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
            return this.lDh == preserveAspectRatio.lDh && this.lDi == preserveAspectRatio.lDi;
        }
        return false;
    }
}
