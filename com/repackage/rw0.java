package com.repackage;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.nadcore.player.remote.BDRemotePlayerService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes7.dex */
public class rw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@Nullable String str, boolean z, int i, Map<String, String> map, CyberPlayerManager.InstallListener installListener, @Nullable CyberPlayerManager.GetNetHandleListener getNetHandleListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i), map, installListener, getNetHandleListener}) == null) || CyberPlayerManager.isCoreLoaded(i)) {
            return;
        }
        Context b = jo0.b();
        ph0.c("DumediaUtils", "initCyber, pid = " + Process.myPid());
        try {
            if (TextUtils.isEmpty(str)) {
                str = xg0.a().b();
            }
            CyberPlayerManager.install(b, str, (String) null, i, z ? BDRemotePlayerService.class : null, map, installListener);
            if (getNetHandleListener != null) {
                CyberPlayerManager.setNetHandleListener(getNetHandleListener);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
