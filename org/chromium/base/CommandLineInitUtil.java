package org.chromium.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import java.io.File;
import org.chromium.base.supplier.Supplier;
/* loaded from: classes2.dex */
public final class CommandLineInitUtil {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String COMMAND_LINE_FILE_PATH = "/data/local";
    public static final String COMMAND_LINE_FILE_PATH_DEBUG_APP = "/data/local/tmp";

    @SuppressLint({"NewApi"})
    public static String getDebugAppJBMR1(Context context) {
        boolean z = false;
        if (Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) == 1) {
            z = true;
        }
        if (z) {
            return Settings.Global.getString(context.getContentResolver(), "debug_app");
        }
        return null;
    }

    public static String getDebugAppPreJBMR1(Context context) {
        boolean z = false;
        if (Settings.System.getInt(context.getContentResolver(), "adb_enabled", 0) == 1) {
            z = true;
        }
        if (z) {
            return ApiReplaceUtil.getString(context.getContentResolver(), "debug_app");
        }
        return null;
    }

    public static void initCommandLine(String str) {
        initCommandLine(str, null);
    }

    public static void initCommandLine(String str, @Nullable Supplier<Boolean> supplier) {
        File file = new File(COMMAND_LINE_FILE_PATH_DEBUG_APP, str);
        if (!file.exists() || !shouldUseDebugCommandLine(supplier)) {
            file = new File(COMMAND_LINE_FILE_PATH, str);
        }
        CommandLine.initFromFile(file.getPath());
    }

    public static boolean shouldUseDebugCommandLine(@Nullable Supplier<Boolean> supplier) {
        String debugAppJBMR1;
        if (supplier != null && supplier.get().booleanValue()) {
            return true;
        }
        Context applicationContext = ContextUtils.getApplicationContext();
        if (Build.VERSION.SDK_INT < 17) {
            debugAppJBMR1 = getDebugAppPreJBMR1(applicationContext);
        } else {
            debugAppJBMR1 = getDebugAppJBMR1(applicationContext);
        }
        if (applicationContext.getPackageName().equals(debugAppJBMR1) || BuildInfo.isDebugAndroid()) {
            return true;
        }
        return false;
    }
}
