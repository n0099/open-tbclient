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
/* loaded from: classes3.dex */
public class SimpleExpressInflater extends ExpressInflater {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f56212b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleExpressInflater(FunNativeAd2 funNativeAd2) {
        super(funNativeAd2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funNativeAd2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            if (this.f56212b != null) {
                View expressView = getExpressView();
                ViewParent parent = expressView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(expressView);
                }
                this.f56212b.removeAllViews();
                this.f56212b.addView(expressView);
                return this.f56212b;
            }
            throw new IllegalStateException("Call setContainer(ViewGroup) with a valid arg first");
        }
        return (ViewGroup) invokeV.objValue;
    }

    public void setContainer(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            this.f56212b = viewGroup;
        }
    }
}
