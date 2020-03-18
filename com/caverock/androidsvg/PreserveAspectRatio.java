package com.caverock.androidsvg;
/* loaded from: classes12.dex */
public class PreserveAspectRatio {
    public static final PreserveAspectRatio lEY = new PreserveAspectRatio(null, null);
    public static final PreserveAspectRatio lEZ = new PreserveAspectRatio(Alignment.None, null);
    public static final PreserveAspectRatio lFa = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Meet);
    public static final PreserveAspectRatio lFb = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Meet);
    public static final PreserveAspectRatio lFc = new PreserveAspectRatio(Alignment.XMaxYMax, Scale.Meet);
    public static final PreserveAspectRatio lFd = new PreserveAspectRatio(Alignment.XMidYMin, Scale.Meet);
    public static final PreserveAspectRatio lFe = new PreserveAspectRatio(Alignment.XMidYMax, Scale.Meet);
    public static final PreserveAspectRatio lFf = new PreserveAspectRatio(Alignment.XMidYMid, Scale.Slice);
    public static final PreserveAspectRatio lFg = new PreserveAspectRatio(Alignment.XMinYMin, Scale.Slice);
    private Alignment lEW;
    private Scale lEX;

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
        this.lEW = alignment;
        this.lEX = scale;
    }

    public Alignment diO() {
        return this.lEW;
    }

    public Scale diP() {
        return this.lEX;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
            return this.lEW == preserveAspectRatio.lEW && this.lEX == preserveAspectRatio.lEX;
        }
        return false;
    }
}
