package org.acra.sender;

import org.acra.ReportField;
/* loaded from: classes.dex */
/* synthetic */ class c {
    static final /* synthetic */ int[] a = new int[ReportField.values().length];

    static {
        try {
            a[ReportField.APP_VERSION_NAME.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[ReportField.ANDROID_VERSION.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
