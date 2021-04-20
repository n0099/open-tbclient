package d.b.n.a;

import android.content.Context;
import com.baidu.crashpad.ZeusLogUploader;
import com.baidu.crashpad.ZwCrashpad;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import java.io.File;
/* loaded from: classes.dex */
public final class a {
    public static void a() {
        ZwCrashpad.setEnabled(true);
        File processCrashpadDir = LogPipelineSingleton.getInstance().getProcessCrashpadDir();
        Context appContext = AppRuntime.getAppContext();
        ZwCrashpad.doInit(appContext, new String[]{"0", "0", "0", "0", "0", "0", "0", "true", appContext.getFilesDir().getAbsolutePath(), "0.0.0.0", appContext.getApplicationInfo().nativeLibraryDir, appContext.getApplicationInfo().nativeLibraryDir, processCrashpadDir.getAbsolutePath()});
        ZeusLogUploader.setEnabled(false);
    }
}
