package io.flutter.embedding.engine.loader;

import android.content.Context;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public class ResourcePaths {
    public static final String TEMPORARY_RESOURCE_PREFIX = ".org.chromium.Chromium.";

    public static File createTempFile(Context context, String str) throws IOException {
        return File.createTempFile(TEMPORARY_RESOURCE_PREFIX, "_" + str, context.getCacheDir());
    }
}
