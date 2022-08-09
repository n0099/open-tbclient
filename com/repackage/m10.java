package com.repackage;

import android.content.Context;
import com.baidu.crashpad.ZeusLogUploader;
import com.baidu.crashpad.ZwCrashpad;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class m10 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            ZwCrashpad.setEnabled(true);
            File processCrashpadDir = LogPipelineSingleton.getInstance().getProcessCrashpadDir();
            Context appContext = AppRuntime.getAppContext();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("clientDir", appContext.getApplicationInfo().nativeLibraryDir);
                jSONObject.put("handlerDir", appContext.getApplicationInfo().nativeLibraryDir);
                jSONObject.put("dumpCopyDir", processCrashpadDir.getAbsolutePath());
            } catch (JSONException unused) {
            }
            if (jSONObject.length() == 0) {
                return;
            }
            ZwCrashpad.doInitGeneric(appContext, jSONObject.toString());
            ZeusLogUploader.setEnabled(false);
        }
    }
}
