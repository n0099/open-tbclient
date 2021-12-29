package com.dxmpay.wallet.utils;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.a;
import com.baidu.bankdetection.BuildConfig;
import com.baidu.mobstat.dxmpay.StatService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.wallet.core.beans.BeanConstants;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class MtjCrashHandler {
    public static /* synthetic */ Interceptable $ic;
    public static volatile AtomicBoolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1137481117, "Lcom/dxmpay/wallet/utils/MtjCrashHandler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1137481117, "Lcom/dxmpay/wallet/utils/MtjCrashHandler;");
                return;
            }
        }
        a = new AtomicBoolean(false);
    }

    public MtjCrashHandler() {
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

    public static List<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add("com.baidu.wallet");
            linkedList.add(BuildConfig.APPLICATION_ID);
            linkedList.add("com.baidu.android.pay");
            linkedList.add(a.f33395b);
            linkedList.add("com.baidu.android.minipay");
            linkedList.add(com.baidu.android.lbspay.BuildConfig.LIBRARY_PACKAGE_NAME);
            linkedList.add("com.dxm.face");
            linkedList.add("com.baidu.idl");
            linkedList.add("com.dxm.passport");
            linkedList.add("com.dxmpay.apollon");
            linkedList.add("com.dxmpay.wallet");
            linkedList.add("com.dxmpay.ocr");
            linkedList.add("com.dxmpay.nfc");
            linkedList.add("com.dxm.ai");
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                Class.forName("com.baidu.mobstat.dxmpay.StatService");
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) && a.compareAndSet(false, true) && b()) {
            try {
                StatService.setDebugOn(false);
                StatService.setOn(context, 16);
                StatService.setAppKey("881db0b268");
                StatService.setAppChannel(BeanConstants.CHANNEL_ID);
                StatService.setUserId(context, PhoneUtils.getCUID2(context));
                StatService.setAppVersionName(context, BeanConstants.VERSION_NO);
                StatService.setCrashExtraInfo(PhoneUtils.getAppVersionName(context));
                StatService.setFilterPackageList(a());
                StatService.crashEnableSendLog(true);
                StatService.start(context);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
