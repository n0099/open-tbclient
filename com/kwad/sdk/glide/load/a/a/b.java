package com.kwad.sdk.glide.load.a.a;

import android.net.Uri;
/* loaded from: classes5.dex */
public final class b {
    public static boolean a(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    public static boolean a(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean b(Uri uri) {
        return a(uri) && d(uri);
    }

    public static boolean c(Uri uri) {
        return a(uri) && !d(uri);
    }

    private static boolean d(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
