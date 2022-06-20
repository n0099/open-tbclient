package com.repackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gl9 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Context a;

    public gl9(jl9 jl9Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jl9Var, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String userAgentString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context context = this.a;
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    try {
                        Process.myPid();
                        if (context != null) {
                            try {
                                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                                    if (runningAppProcessInfo.pid == Process.myPid()) {
                                        str = runningAppProcessInfo.processName;
                                        break;
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                        str = null;
                        if (!TextUtils.equals(context.getPackageName(), str)) {
                            WebView.setDataDirectorySuffix(str);
                        }
                    } catch (Exception unused2) {
                    }
                }
                zn9.a = System.getProperty("http.agent");
                if (Build.VERSION.SDK_INT >= 17) {
                    userAgentString = WebSettings.getDefaultUserAgent(context);
                } else if (Looper.myLooper() != Looper.getMainLooper()) {
                    sn9.a.post(new vn9(context));
                    return;
                } else {
                    userAgentString = new WebView(context).getSettings().getUserAgentString();
                }
                zn9.a = userAgentString;
            } catch (Exception unused3) {
            }
        }
    }
}
