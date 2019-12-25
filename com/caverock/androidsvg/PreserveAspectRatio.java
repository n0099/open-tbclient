package com.caverock.androidsvg;
/* loaded from: classes9.dex */
public class PreserveAspectRatio {
    public static final PreserveAspectRatio lyX = new PreserveAspectRatio(null, null);
    public static final PreserveAspectRatio lyY = new PreserveAspectRatio(Alignment.None, null);
    public static final PreserveAspectRatio lyZ = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Meet);
    public static final PreserveAspectRatio lza = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Meet);
    public static final PreserveAspectRatio lzb = new PreserveAspectRatio(Alignment.XMaxYMax, Scale.Meet);
    public static final PreserveAspectRatio lzc = new PreserveAspectRatio(Alignment.XMidYMin, Scale.Meet);
    public static final PreserveAspectRatio lzd = new PreserveAspectRatio(Alignment.XMidYMax, Scale.Meet);
    public static final PreserveAspectRatio lze = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Slice);
    public static final PreserveAspectRatio lzf = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Slice);
    private Alignment lyV;
    private Scale lyW;

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public enum Scale {
        Meet,
        Slice
    }

    public PreserveAspectRatio(Alignment alignment, Scale scale) {
        this.lyV = alignment;
        this.lyW = scale;
    }

    public Alignment dfW() {
        return this.lyV;
    }

    public Scale dfX() {
        return this.lyW;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
            return this.lyV == preserveAspectRatio.lyV && this.lyW == preserveAspectRatio.lyW;
        }
        return false;
    }
}
