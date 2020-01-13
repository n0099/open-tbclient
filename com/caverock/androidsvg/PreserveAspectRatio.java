package com.caverock.androidsvg;
/* loaded from: classes10.dex */
public class PreserveAspectRatio {
    private Alignment lCt;
    private Scale lCu;
    public static final PreserveAspectRatio lCv = new PreserveAspectRatio(null, null);
    public static final PreserveAspectRatio lCw = new PreserveAspectRatio(Alignment.None, null);
    public static final PreserveAspectRatio lCx = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Meet);
    public static final PreserveAspectRatio lCy = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Meet);
    public static final PreserveAspectRatio lCz = new PreserveAspectRatio(Alignment.XMaxYMax, Scale.Meet);
    public static final PreserveAspectRatio lCA = new PreserveAspectRatio(Alignment.XMidYMin, Scale.Meet);
    public static final PreserveAspectRatio lCB = new PreserveAspectRatio(Alignment.XMidYMax, Scale.Meet);
    public static final PreserveAspectRatio lCC = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Slice);
    public static final PreserveAspectRatio lCD = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Slice);

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
        this.lCt = alignment;
        this.lCu = scale;
    }

    public Alignment dgY() {
        return this.lCt;
    }

    public Scale dgZ() {
        return this.lCu;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
            return this.lCt == preserveAspectRatio.lCt && this.lCu == preserveAspectRatio.lCu;
        }
        return false;
    }
}
