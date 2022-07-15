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
/* loaded from: classes4.dex */
public abstract class FunNativeAd2Bridger<A, B extends View> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ReporterPidLoader<A> a;

    public FunNativeAd2Bridger(ReporterPidLoader<A> reporterPidLoader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reporterPidLoader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = reporterPidLoader;
    }

    public abstract B createExpressView(A a);

    public ReporterPidLoader<A> getLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (ReporterPidLoader) invokeV.objValue;
    }

    public final PidLoaderSession<A> getSession(A a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a)) == null) ? this.a.getSession(a) : (PidLoaderSession) invokeL.objValue;
    }

    public abstract void showCustom(Activity activity, CustomInflater customInflater, String str, A a, BaseNativeAd2<A, B> baseNativeAd2, FunAdInteractionListener funAdInteractionListener);

    public abstract void showExpress(Activity activity, ExpressInflater expressInflater, String str, A a, BaseNativeAd2<A, B> baseNativeAd2, FunAdInteractionListener funAdInteractionListener);
}
