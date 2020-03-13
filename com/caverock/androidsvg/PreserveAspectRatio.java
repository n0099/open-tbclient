package com.caverock.androidsvg;
/* loaded from: classes12.dex */
public class PreserveAspectRatio {
    private Alignment lDs;
    private Scale lDt;
    public static final PreserveAspectRatio lDu = new PreserveAspectRatio(null, null);
    public static final PreserveAspectRatio lDv = new PreserveAspectRatio(Alignment.None, null);
    public static final PreserveAspectRatio lDw = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Meet);
    public static final PreserveAspectRatio lDx = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Meet);
    public static final PreserveAspectRatio lDy = new PreserveAspectRatio(Alignment.XMaxYMax, Scale.Meet);
    public static final PreserveAspectRatio lDz = new PreserveAspectRatio(Alignment.XMidYMin, Scale.Meet);
    public static final PreserveAspectRatio lDA = new PreserveAspectRatio(Alignment.XMidYMax, Scale.Meet);
    public static final PreserveAspectRatio lDB = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Slice);
    public static final PreserveAspectRatio lDC = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Slice);

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
        this.lDs = alignment;
        this.lDt = scale;
    }

    public Alignment dir() {
        return this.lDs;
    }

    public Scale dis() {
        return this.lDt;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
            return this.lDs == preserveAspectRatio.lDs && this.lDt == preserveAspectRatio.lDt;
        }
        return false;
    }
}
