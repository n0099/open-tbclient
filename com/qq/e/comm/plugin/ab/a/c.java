package com.qq.e.comm.plugin.ab.a;
/* loaded from: classes4.dex */
public enum c {
    ADLoadSucc,
    ADLoadFail,
    ADReady,
    Exposured,
    Clicked,
    PopupDisplay,
    PopupClosed,
    ADSpecMeasured,
    ResourceLoadFail,
    ADClosed,
    ADLeftApplication,
    ADOpenOverlay,
    DownloadClosed,
    ConfirmDialogOpened,
    ConfirmDialogClosed;

    public static c a(String str) {
        c[] values;
        for (c cVar : values()) {
            if (cVar.name().equals(str)) {
                return cVar;
            }
        }
        return null;
    }
}
