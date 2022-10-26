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
import com.fun.ad.sdk.internal.api.flavor.Flavors;
import com.fun.ad.sdk.internal.api.flavor.RCInterceptor;
/* loaded from: classes7.dex */
public class BaseNativeAd2 implements FunNativeAd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public final FunNativeAd2.NativeType b;
    public final FunNativeInfo c;
    public final FunNativeAd2Bridger d;
    public final Object mAd;

    public BaseNativeAd2(FunNativeAd2.NativeType nativeType, Object obj, FunNativeInfo funNativeInfo, FunNativeAd2Bridger funNativeAd2Bridger) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nativeType, obj, funNativeInfo, funNativeAd2Bridger};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = nativeType;
        this.mAd = obj;
        this.c = funNativeInfo;
        this.d = funNativeAd2Bridger;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseNativeAd2(FunNativeAd2.NativeType nativeType, Object obj, FunNativeAd2Bridger funNativeAd2Bridger) {
        this(nativeType, obj, null, funNativeAd2Bridger);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nativeType, obj, funNativeAd2Bridger};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((FunNativeAd2.NativeType) objArr2[0], objArr2[1], (FunNativeInfo) objArr2[2], (FunNativeAd2Bridger) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public View getExpressView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null) {
                this.a = this.d.createExpressView(this.mAd);
            }
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd2
    public FunNativeInfo getNativeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (FunNativeInfo) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd2
    public FunNativeAd2.NativeType getNativeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (FunNativeAd2.NativeType) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd2
    public String getPlatform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d.getLoader().getAdType().getPlatform() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd2
    public final void show(Activity activity, NativeInflater nativeInflater, String str, FunAdInteractionListener funAdInteractionListener) {
        RCInterceptor shouldIntercept;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, activity, nativeInflater, str, funAdInteractionListener) == null) {
            if (activity == null || nativeInflater == null || str == null || funAdInteractionListener == null) {
                throw new IllegalArgumentException("Null args is not allowed");
            }
            PidLoaderSession session = this.d.getSession(this.mAd);
            if (session != null && session.getShowSidSessionMeta(this.mAd) == null) {
                session.setShowSidSessionMeta(this.mAd, new SidSessionMeta(str, session.getLoadSidSessionMeta().sidVer));
            }
            ReporterPidLoader loader = this.d.getLoader();
            if (loader != null && (shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(loader.getPid().pid, loader.getAdType())) != null) {
                if (shouldIntercept.shouldInterceptShow(shouldIntercept.needRipper() ? loader.getRippedAdInternal(this.mAd) : null)) {
                    funAdInteractionListener.onAdError(str);
                    return;
                }
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
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, activity, customInflater, str, funAdInteractionListener) == null) {
            this.d.showCustom(activity, customInflater, str, this.mAd, this, funAdInteractionListener);
        }
    }

    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, activity, expressInflater, str, funAdInteractionListener) == null) {
            this.d.showExpress(activity, expressInflater, str, this.mAd, this, funAdInteractionListener);
        }
    }
}
