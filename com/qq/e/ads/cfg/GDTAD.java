package com.qq.e.ads.cfg;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes10.dex */
public class GDTAD {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f74741a;

    /* renamed from: b  reason: collision with root package name */
    public static InitListener f74742b;

    /* renamed from: c  reason: collision with root package name */
    public static PM.a.InterfaceC2039a f74743c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public interface InitListener {
        void onSuccess();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1464946582, "Lcom/qq/e/ads/cfg/GDTAD;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1464946582, "Lcom/qq/e/ads/cfg/GDTAD;");
                return;
            }
        }
        f74743c = new PM.a.InterfaceC2039a() { // from class: com.qq.e.ads.cfg.GDTAD.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.qq.e.comm.managers.plugin.PM.a.InterfaceC2039a
            public final void onLoadFail() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    GDTLogger.w("插件加载失败");
                }
            }

            @Override // com.qq.e.comm.managers.plugin.PM.a.InterfaceC2039a
            public final void onLoadSuccess() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    boolean unused = GDTAD.f74741a = true;
                    if (GDTAD.f74742b != null) {
                        GDTAD.f74742b.onSuccess();
                    }
                }
            }
        };
    }

    public GDTAD() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void initSDK(Context context, String str, InitListener initListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, initListener) == null) {
            if (f74741a) {
                GDTLogger.w("SDK已经被初始化过", null);
            } else if (context == null) {
                GDTLogger.e("Context参数不能为null");
            } else if (StringUtil.isEmpty(str)) {
                GDTLogger.e("AppId参数不能为空");
            } else {
                f74742b = initListener;
                GDTADManager gDTADManager = GDTADManager.getInstance();
                gDTADManager.setPluginLoadListener(f74743c);
                gDTADManager.initWith(context.getApplicationContext(), str);
            }
        }
    }
}
