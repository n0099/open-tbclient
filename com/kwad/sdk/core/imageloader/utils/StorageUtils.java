package com.kwad.sdk.core.imageloader.utils;

import android.content.Context;
import com.kwad.sdk.utils.ad;
import java.io.File;
/* loaded from: classes3.dex */
public final class StorageUtils {
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String INDIVIDUAL_DIR_NAME = "ksad-images";

    private StorageUtils() {
    }

    public static File getIndividualCacheDirectory(Context context) {
        return getIndividualCacheDirectory(context, INDIVIDUAL_DIR_NAME);
    }

    public static File getIndividualCacheDirectory(Context context, String str) {
        File b2 = ad.b(context);
        File file = new File(b2, str);
        return (file.exists() || file.mkdir()) ? file : b2;
    }
}
