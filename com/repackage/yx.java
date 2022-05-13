package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
/* loaded from: classes7.dex */
public class yx implements WebKitFactory.WebkitInstallListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String c = "yx";
    public transient /* synthetic */ FieldHolder $fh;
    public byte a;
    public long b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964021562, "Lcom/repackage/yx;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964021562, "Lcom/repackage/yx;");
        }
    }

    public yx() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void c(LoadErrorCode loadErrorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, loadErrorCode) == null) {
            BdSailorPlatform.getStatic().b("init-webkit", "Err = " + loadErrorCode.getInt() + loadErrorCode.getString());
        }
    }

    public final void a(LoadErrorCode loadErrorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, loadErrorCode) == null) {
            WebKitFactory.setEngine(0);
            BdSailorPlatform.getWebkitManager().onInstallZeusPluginFailed(this.a, loadErrorCode);
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || str == null) {
            return;
        }
        this.a = (byte) 0;
        if (!str.startsWith("file://")) {
            str = "file://".concat(String.valueOf(str));
        }
        BdZeusUtil.printKernellog("install plugin from download");
        WebKitFactory.installAsync(str, this);
        this.b = System.currentTimeMillis();
        Log.i(c, "full update started!");
    }

    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
    public void onInstallFinish(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            System.currentTimeMillis();
            Log.i("soar", "the return value of installing kernal is: ".concat(String.valueOf(i)));
            BdZeusUtil.printKernellog("oninstalled: " + i + " targetpath: " + str);
            if (i == 0) {
                Log.d(c, "install success!");
                BdSailorPlatform.getWebkitManager().onInstallZeusPluginSuccess(BdSailorPlatform.getInstance().getAppContext(), str, this.a);
            } else {
                Log.d(c, "install failed!");
                BdSailorPlatform.getWebkitManager().onInstallZeusPluginFailed(this.a, WebKitFactory.getLoadErrorCode());
            }
            BdSailorPlatform.getWebkitManager().enableBdWebkit();
            long currentTimeMillis = System.currentTimeMillis() - this.b;
            String str2 = c;
            Log.i(str2, "total timecost: " + String.valueOf(currentTimeMillis));
        }
    }

    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
    public void onInstallStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }
}
