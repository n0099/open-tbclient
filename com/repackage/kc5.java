package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kc5 {
    public static /* synthetic */ Interceptable $ic;
    public static kc5 c;
    public transient /* synthetic */ FieldHolder $fh;
    public sw4 a;
    public ABTestExtraData b;

    public kc5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static kc5 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (kc5.class) {
                    if (c == null) {
                        c = new kc5();
                    }
                }
            }
            return c;
        }
        return (kc5) invokeV.objValue;
    }

    public final void a(sw4 sw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sw4Var) == null) {
            boolean z = sw4Var == null || this.a == null || sw4Var.a() != this.a.a();
            this.a = sw4Var;
            if (z) {
                b("zan_or_cai_smallflow");
            }
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b == null) {
                ABTestExtraData aBTestExtraData = new ABTestExtraData();
                this.b = aBTestExtraData;
                aBTestExtraData.parserABTestExtraFormSharedPref();
            }
            return this.b.getABTestResult();
        }
        return (String) invokeV.objValue;
    }

    public void e(sw4 sw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sw4Var) == null) {
            a(sw4Var);
        }
    }

    public void f(ABTestExtraData aBTestExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aBTestExtraData) == null) {
            this.b = aBTestExtraData;
        }
    }
}
