package com.fun.ad.sdk.internal.api;

import android.app.Activity;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeInfo;
import com.fun.ad.sdk.NativeInflater;
/* loaded from: classes7.dex */
public class BaseNativeAd2<A, B extends View> implements FunNativeAd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public B a;

    /* renamed from: b  reason: collision with root package name */
    public final FunNativeAd2.NativeType f52850b;

    /* renamed from: c  reason: collision with root package name */
    public final FunNativeInfo f52851c;

    /* renamed from: d  reason: collision with root package name */
    public final FunNativeAd2Bridger<A, B> f52852d;
    public final A mAd;

    public BaseNativeAd2(FunNativeAd2.NativeType nativeType, A a, FunNativeInfo funNativeInfo, FunNativeAd2Bridger<A, B> funNativeAd2Bridger) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nativeType, a, funNativeInfo, funNativeAd2Bridger};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52850b = nativeType;
        this.mAd = a;
        this.f52851c = funNativeInfo;
        this.f52852d = funNativeAd2Bridger;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseNativeAd2(FunNativeAd2.NativeType nativeType, A a, FunNativeAd2Bridger<A, B> funNativeAd2Bridger) {
        this(nativeType, a, null, funNativeAd2Bridger);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nativeType, a, funNativeAd2Bridger};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((FunNativeAd2.NativeType) objArr2[0], objArr2[1], (FunNativeInfo) objArr2[2], (FunNativeAd2Bridger) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public B getExpressView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null) {
                this.a = this.f52852d.createExpressView(this.mAd);
            }
            return this.a;
        }
        return (B) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd2
    public FunNativeInfo getNativeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52851c : (FunNativeInfo) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd2
    public FunNativeAd2.NativeType getNativeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f52850b : (FunNativeAd2.NativeType) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd2
    public final void show(Activity activity, NativeInflater nativeInflater, String str, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, nativeInflater, str, funAdInteractionListener) == null) {
            if (activity == null || nativeInflater == null || str == null || funAdInteractionListener == null) {
                throw new IllegalArgumentException("Null args is not allowed");
            }
            FunNativeAd2.NativeType nativeType = getNativeType();
            if (nativeInflater instanceof CustomInflater) {
                if (!nativeType.supportCustom()) {
                    throw new IllegalStateException("NativeType:%s not supportCustom with a CustomInflater passed");
                }
                showCustom(activity, (CustomInflater) nativeInflater, str, funAdInteractionListener);
            } else if (nativeInflater instanceof ExpressInflater) {
                if (!nativeType.supportExpress()) {
                    throw new IllegalStateException("NativeType:%s not supportExpress with a ExpressInflater passed");
                }
                showExpress(activity, (ExpressInflater) nativeInflater, str, funAdInteractionListener);
            }
        }
    }

    public void showCustom(Activity activity, CustomInflater customInflater, String str, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, activity, customInflater, str, funAdInteractionListener) == null) {
            this.f52852d.showCustom(activity, customInflater, str, this.mAd, this, funAdInteractionListener);
        }
    }

    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, activity, expressInflater, str, funAdInteractionListener) == null) {
            this.f52852d.showExpress(activity, expressInflater, str, this.mAd, this, funAdInteractionListener);
        }
    }
}
