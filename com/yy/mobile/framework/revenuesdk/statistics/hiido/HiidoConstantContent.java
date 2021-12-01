package com.yy.mobile.framework.revenuesdk.statistics.hiido;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class HiidoConstantContent {
    public static /* synthetic */ Interceptable $ic = null;
    public static String ACT_LPF_REVENUE_PAY_ORIGINAL = "lpfrevenuepayoriginal";
    public static String mAppKey = "aa065bf52c62a7834472a56e06c40b58";
    public static String mClientVer = "";
    public static String mDevice = "";
    public static String mMBOS = "";
    public static String mOpenId = "";
    public static String mPackage = "";
    public static String mSYS = "2";
    public static String mSdkVer = "";
    public static String mUserType = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(507993113, "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/HiidoConstantContent;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(507993113, "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/HiidoConstantContent;");
        }
    }

    public HiidoConstantContent() {
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
}
