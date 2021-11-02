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
import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes2.dex */
public class GDTAD {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f67826a;

    /* renamed from: b  reason: collision with root package name */
    public static InitListener f67827b;

    /* renamed from: c  reason: collision with root package name */
    public static e f67828c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
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
        f67828c = new e() { // from class: com.qq.e.ads.cfg.GDTAD.1
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

            @Override // com.qq.e.comm.managers.plugin.e
            public void onLoadFail() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    GDTLogger.w("插件加载失败");
                }
            }

            @Override // com.qq.e.comm.managers.plugin.e
            public void onLoadSuccess() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    boolean unused = GDTAD.f67826a = true;
                    if (GDTAD.f67827b != null) {
                        GDTAD.f67827b.onSuccess();
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
            if (f67826a) {
                GDTLogger.w("SDK已经被初始化过", null);
            } else if (context == null) {
                GDTLogger.e("Context参数不能为null");
            } else if (StringUtil.isEmpty(str)) {
                GDTLogger.e("AppId参数不能为空");
            } else {
                f67827b = initListener;
                GDTADManager gDTADManager = GDTADManager.getInstance();
                gDTADManager.setPluginLoadListener(f67828c);
                gDTADManager.initWith(context.getApplicationContext(), str);
            }
        }
    }
}
