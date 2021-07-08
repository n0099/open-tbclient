package com.tencent.mm.opensdk.diffdev;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.utils.Log;
/* loaded from: classes6.dex */
public class DiffDevOAuthFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_SUPPORTED_VERSION = 1;
    public static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
    public static final int VERSION_1 = 1;
    public static IDiffDevOAuth v1Instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1836906785, "Lcom/tencent/mm/opensdk/diffdev/DiffDevOAuthFactory;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1836906785, "Lcom/tencent/mm/opensdk/diffdev/DiffDevOAuthFactory;");
        }
    }

    public DiffDevOAuthFactory() {
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

    public static IDiffDevOAuth getDiffDevOAuth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? getDiffDevOAuth(1) : (IDiffDevOAuth) invokeV.objValue;
    }

    public static IDiffDevOAuth getDiffDevOAuth(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            Log.v(TAG, "getDiffDevOAuth, version = " + i2);
            if (i2 > 1) {
                Log.e(TAG, "getDiffDevOAuth fail, unsupported version = " + i2);
                return null;
            } else if (i2 != 1) {
                return null;
            } else {
                if (v1Instance == null) {
                    v1Instance = new a();
                }
                return v1Instance;
            }
        }
        return (IDiffDevOAuth) invokeI.objValue;
    }
}
