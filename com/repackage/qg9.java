package com.repackage;

import android.app.Activity;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAd2Bridger;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.repackage.mg9;
/* loaded from: classes6.dex */
public class qg9 implements FunNativeAd2Bridger<TTNativeAd, com.fun.module.csj.f0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TTNativeAd.AdInteractionListener a;
    public final /* synthetic */ mg9 b;

    public qg9(mg9 mg9Var, TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mg9Var, tTNativeAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = mg9Var;
        this.a = new mg9.b(mg9Var, tTNativeAd);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.fun.module.csj.f0, android.view.View] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public com.fun.module.csj.f0 createExpressView(TTNativeAd tTNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tTNativeAd)) == null) ? ng9.a(tTNativeAd) : (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, TTNativeAd tTNativeAd, BaseNativeAd2<TTNativeAd, com.fun.module.csj.f0> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, tTNativeAd, baseNativeAd2, funAdInteractionListener}) == null) {
            this.b.c(activity, tTNativeAd, str, customInflater.inflate(), customInflater.getClickViews(), customInflater.getCreativeViews(), this.a, funAdInteractionListener);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, TTNativeAd tTNativeAd, BaseNativeAd2<TTNativeAd, com.fun.module.csj.f0> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, tTNativeAd, baseNativeAd2, funAdInteractionListener}) == null) {
            TTNativeAd tTNativeAd2 = tTNativeAd;
            mg9 mg9Var = this.b;
            FunNativeAdListenerHelper<TTNativeAd, TTNativeAd.AdInteractionListener> funNativeAdListenerHelper = mg9Var.j;
            pid = mg9Var.mPid;
            funNativeAdListenerHelper.startShow(tTNativeAd2, str, pid, this.a, funAdInteractionListener);
            mg9 mg9Var2 = this.b;
            mg9Var2.getClass();
            mg9Var2.b(activity, tTNativeAd2, expressInflater.inflate(), baseNativeAd2.getExpressView(), new og9(mg9Var2, funAdInteractionListener, str, tTNativeAd2));
        }
    }
}
