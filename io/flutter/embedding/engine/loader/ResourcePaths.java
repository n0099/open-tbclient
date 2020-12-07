package io.flutter.embedding.engine.loader;

import android.content.Context;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.File;
import java.io.IOException;
/* loaded from: classes9.dex */
class ResourcePaths {
    public static final String TEMPORARY_RESOURCE_PREFIX = ".org.chromium.Chromium.";

    ResourcePaths() {
    }

    public static File createTempFile(Context context, String str) throws IOException {
        return File.createTempFile(TEMPORARY_RESOURCE_PREFIX, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, context.getCacheDir());
    }
}
