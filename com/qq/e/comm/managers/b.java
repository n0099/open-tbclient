package com.qq.e.comm.managers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes10.dex */
public class b implements IGDTAdManager {
    public static /* synthetic */ Interceptable $ic;
    public static final ExecutorService g;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Boolean a;
    public volatile boolean b;
    public volatile Context c;
    public volatile PM d;
    public volatile DevTools e;
    public volatile String f;

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1460232161, "Lcom/qq/e/comm/managers/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1460232161, "Lcom/qq/e/comm/managers/b$a;");
                    return;
                }
            }
            a = new b(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2102075838, "Lcom/qq/e/comm/managers/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2102075838, "Lcom/qq/e/comm/managers/b;");
                return;
            }
        }
        g = Executors.newSingleThreadExecutor();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = Boolean.FALSE;
        this.b = false;
    }

    public /* synthetic */ b(com.qq.e.comm.managers.a aVar) {
        this();
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? a.a : (b) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public PM c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (PM) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == null || !this.a.booleanValue()) {
                GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.init() 初始化");
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getBuyerId(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            if (d()) {
                try {
                    return this.d.getPOFactory().getBuyerId(map);
                } catch (Exception e) {
                    GDTLogger.e("SDK 初始化异常", e);
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public DevTools getDevTools() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.e == null) {
                this.e = new DevTools();
            }
            return this.e;
        }
        return (DevTools) invokeV.objValue;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getSDKInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (d()) {
                try {
                    return this.d.getPOFactory().getSDKInfo(str);
                } catch (Exception e) {
                    GDTLogger.e("SDK 初始化异常", e);
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gDTAppDialogClickListener)) == null) {
            if (this.b) {
                try {
                    return this.d.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
                } catch (Exception e) {
                    GDTLogger.e("SDK 初始化异常", e);
                    return 0;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public synchronized boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            synchronized (this) {
                if (Build.VERSION.SDK_INT < 14) {
                    GDTLogger.e("GDTADManager初始化错误，SDK不支持Android 4.0以下版本");
                    return false;
                } else if (this.a.booleanValue()) {
                    return true;
                } else {
                    if (context != null && !TextUtils.isEmpty(str)) {
                        this.f = str;
                        this.c = context.getApplicationContext();
                        this.d = new PM(this.c, null);
                        g.submit(new com.qq.e.comm.managers.a(this));
                        this.a = Boolean.TRUE;
                        return true;
                    }
                    GDTLogger.e("GDTADManager初始化错误，context和appId不能为空");
                    return false;
                }
            }
        }
        return invokeLL.booleanValue;
    }
}
