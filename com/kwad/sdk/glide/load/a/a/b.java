package com.kwad.sdk.glide.load.a.a;

import android.net.Uri;
import com.baidubce.services.vod.VodClient;
/* loaded from: classes7.dex */
public final class b {
    public static boolean a(int i2, int i3) {
        return i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && i2 <= 512 && i3 <= 384;
    }

    public static boolean a(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && VodClient.PATH_MEDIA.equals(uri.getAuthority());
    }

    public static boolean b(Uri uri) {
        return a(uri) && d(uri);
    }

    public static boolean c(Uri uri) {
        return a(uri) && !d(uri);
    }

    public static boolean d(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
