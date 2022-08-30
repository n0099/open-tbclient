package com.fun.ad.sdk;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SimpleExpressInflater extends ExpressInflater {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleExpressInflater(FunNativeAd2 funNativeAd2) {
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

    @Override // com.fun.ad.sdk.NativeInflater
    public ViewGroup inflate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.b != null) {
                View expressView = getExpressView();
                ViewParent parent = expressView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(expressView);
                }
                this.b.removeAllViews();
                this.b.addView(expressView);
                return this.b;
            }
            throw new IllegalStateException("Call setContainer(ViewGroup) with a valid arg first");
        }
        return (ViewGroup) invokeV.objValue;
    }

    public void setContainer(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            this.b = viewGroup;
        }
    }
}
