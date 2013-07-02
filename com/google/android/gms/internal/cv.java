package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class cv {
    private cv() {
    }

    public static void a(Bundle bundle, String str, Parcelable parcelable) {
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(cv.class.getClassLoader());
        bundle2.putParcelable(str, parcelable);
        bundle.putBundle("map_state", bundle2);
    }
}
