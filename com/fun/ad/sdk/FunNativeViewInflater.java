package com.fun.ad.sdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class FunNativeViewInflater extends CustomInflater {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FunNativeView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunNativeViewInflater(FunNativeAd2 funNativeAd2) {
        super(funNativeAd2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funNativeAd2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((FunNativeAd2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.fun.ad.sdk.NativeInflater
    public final FunNativeView inflate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FunNativeView funNativeView = this.b;
            if (funNativeView != null) {
                return funNativeView;
            }
            throw new IllegalStateException("Please call setFunNativeView(FunNativeView) with a valid FunNativeView");
        }
        return (FunNativeView) invokeV.objValue;
    }

    public void setFunNativeView(FunNativeView funNativeView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, funNativeView) == null) {
            this.b = funNativeView;
        }
    }
}
