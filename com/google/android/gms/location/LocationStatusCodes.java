package com.google.android.gms.location;
/* loaded from: classes.dex */
public final class LocationStatusCodes {
    private LocationStatusCodes() {
    }

    public static int a(int i) {
        if (i < 0 || i > 1) {
            if (1000 > i || i > 1002) {
                return 1;
            }
            return i;
        }
        return i;
    }
}
