package org.acra;
/* loaded from: classes.dex */
/* synthetic */ class c {
    static final /* synthetic */ int[] a = new int[ReportingInteractionMode.values().length];

    static {
        try {
            a[ReportingInteractionMode.TOAST.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[ReportingInteractionMode.NOTIFICATION.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[ReportingInteractionMode.DIALOG.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
