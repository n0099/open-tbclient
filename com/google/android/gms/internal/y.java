package com.google.android.gms.internal;

import android.net.Uri;
/* loaded from: classes.dex */
public final class y {
    private static final Uri a = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("drawable").build();

    public static Uri a(String str) {
        x.a(str, "Resource name must not be null.");
        return a.buildUpon().appendPath(str).build();
    }
}
